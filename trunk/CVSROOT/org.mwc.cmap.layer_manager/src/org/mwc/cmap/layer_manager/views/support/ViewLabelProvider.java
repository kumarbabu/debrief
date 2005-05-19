/**
 * 
 */
package org.mwc.cmap.layer_manager.views.support;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;

import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.mwc.cmap.core.property_support.PlottableWrapper;
import org.mwc.cmap.layer_manager.views.LayerManagerView;

import Debrief.Wrappers.FixWrapper;
import Debrief.Wrappers.ShapeWrapper;
import Debrief.Wrappers.TrackWrapper;
import MWC.GUI.Layer;
import MWC.GUI.Plottable;
import MWC.GUI.Chart.Painters.CoastPainter;
import MWC.GUI.Chart.Painters.GridPainter;
import MWC.GUI.Chart.Painters.ScalePainter;
import MWC.GUI.VPF.FeaturePainter;

public class ViewLabelProvider extends LabelProvider implements ITableLabelProvider
{

	/**
	 * 
	 */
	private final LayerManagerView _myLabelProvider;

	/**
	 * @param manager
	 */
	public ViewLabelProvider(LayerManagerView manager)
	{
		_myLabelProvider = manager;
	}

	public String getText(Object obj)
	{
		PlottableWrapper pw = (PlottableWrapper) obj;
		return pw.getPlottable().toString();
	}

	private static String getImageFor(Plottable theObject)
	{
		String res = null;
		
		if(theObject instanceof TrackWrapper)
			res = ISharedImages.IMG_OBJ_FILE; // "track";
		else if(theObject instanceof Layer)
			res = ISharedImages.IMG_OBJS_INFO_TSK; // "layer";
		else if(theObject instanceof FixWrapper)
			res = ISharedImages.IMG_OBJS_WARN_TSK ; // "fix";
		else if(theObject instanceof ShapeWrapper)
			res = ISharedImages.IMG_OBJS_ERROR_TSK; // "shape";
		else if(theObject instanceof GridPainter)
			res = ISharedImages.IMG_DEF_VIEW; // "grid";
		else if(theObject instanceof ScalePainter)
			res = ISharedImages.IMG_TOOL_NEW_WIZARD ; // "scale";
		else if(theObject instanceof CoastPainter)
			res = ISharedImages.IMG_TOOL_UP_DISABLED ; // "coast";
		else if(theObject instanceof FeaturePainter)
			res = ISharedImages.IMG_OBJ_FILE; // "vpf";
		else
			res = ISharedImages.IMG_OBJ_ELEMENT;
		
		return res;
	}
	
	public Image getImage(Object obj)
	{
		String imageKey = ISharedImages.IMG_OBJ_ELEMENT;
		if (obj instanceof TreeParent)
			imageKey = ISharedImages.IMG_OBJ_FOLDER;
		return PlatformUI.getWorkbench().getSharedImages().getImage(imageKey);
	}

	public Image getColumnImage(Object element, int columnIndex)
	{
		Image res;
		if (columnIndex == 0)
			res = getImage(element);
		else
			res = null;

		return res;
	}

	public String getColumnText(Object element, int columnIndex)
	{
		String res;
		if (columnIndex == 0)
			res = getText(element);
		else
		{
			// sort out the visibility
			PlottableWrapper pw = (PlottableWrapper) element;
			Plottable pl = pw.getPlottable();
			if(pl.getVisible())
			  res = "y";
			else
				res = "n";
		}

		return res;
	}

	public boolean isLabelProperty(Object element, String property)
	{
		boolean res = true;
		
		return res;
	}
	
	
	
}