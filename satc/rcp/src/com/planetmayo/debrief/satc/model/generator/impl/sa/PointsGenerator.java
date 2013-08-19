package com.planetmayo.debrief.satc.model.generator.impl.sa;

import java.util.Random;

import com.planetmayo.debrief.satc.util.GeoSupport;
import com.planetmayo.debrief.satc.util.MathUtils;
import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.geom.Point;

public class PointsGenerator
{
	private final Random rnd;
	private final Geometry geometry;
	private final Geometry envelope;

	public PointsGenerator(Geometry geometry, Random random)
	{
		this.rnd = random;
		this.geometry = geometry;
		this.envelope = geometry.getEnvelope();
	}

	public Point startPoint()
	{
		return envelope.getCentroid();
	}

	public Point toPoint(Coordinate coord)
	{
		return GeoSupport.getFactory().createPoint(coord);
	}

	public Point newPoint(Point p, double T)
	{
		Coordinate border1 = envelope.getCoordinates()[rnd.nextInt(envelope
				.getNumPoints())];
		Coordinate border2;
		do
		{
			border2 = envelope.getCoordinates()[rnd.nextInt(envelope.getNumPoints())];
		}
		while (border1 == border2);

		Point p1 = MathUtils.calculateBezier(Math.pow(rnd.nextDouble(), 5 - T), p,
				toPoint(border1), null);
		Point p2 = MathUtils.calculateBezier(Math.pow(rnd.nextDouble(), 5 - T), p,
				toPoint(border2), null);
		return MathUtils.calculateBezier(rnd.nextDouble(), p1, p2, null);
	}

	public double getArea()
	{
		return geometry.getArea();
	}
}
