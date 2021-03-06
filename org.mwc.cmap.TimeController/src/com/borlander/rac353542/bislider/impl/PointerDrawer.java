/*
 *    Debrief - the Open Source Maritime Analysis Application
 *    http://debrief.info
 *
 *    (C) 2000-2014, PlanetMayo Ltd
 *
 *    This library is free software; you can redistribute it and/or
 *    modify it under the terms of the Eclipse Public License v1.0
 *    (http://www.eclipse.org/legal/epl-v10.html)
 *
 *    This library is distributed in the hope that it will be useful,
 *    but WITHOUT ANY WARRANTY; without even the implied warranty of
 *    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. 
 */
package com.borlander.rac353542.bislider.impl;

import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Point;

/**
 * Instances of this class are responsible for drawing of the picture which
 * somehow "shows" (or "points to") the specified screen point.
 * <p>
 * Each of the painters should be able to draw the "pointer" below or above the
 * specified screen point.
 */
interface PointerDrawer extends Disposable {

    public void setBelowThePoint(boolean belowNotAbove);

    /**
     * Message sent to Drawer with request to draw pointer which points to the
     * given screen pont.
     * 
     * @param x
     *            horizontal coordinate of the screen point the result pointer
     *            should point to in coordinate system of the given GC.
     * @param y
     *            vertical coordinate of the screen point the result pointer
     *            should point to in coordinate system of the given GC.
     * 
     * @param optionalLabel
     *            optional label which should be drawn near the pointer or
     *            <code>null</code> if no.
     */
    public void paintPointer(GC gc, int x, int y, String optionalLabel);

    /**
     * Convenience method. Fully equivalent to
     * <code>paintPointer(gc, p.x, p.y, null)</code>
     */
    public void paintPointer(GC gc, Point p);

    /**
     * Convenience method. Fully equivalent to
     * <code>paintPointer(gc, p.x, p.y, optionalLabel)</code>
     */
    public void paintPointer(GC gc, Point p, String optionalLabel);

    /**
     * @return AreaGate which may be used to distinguish area used to draw
     *         pointer. This gate is updated after any repaint.
     */
    public AreaGate getAreaGate();
}
