package Debrief.ReaderWriter.XML.Shapes;

import MWC.GenericData.WorldDistance;
import MWC.Utilities.ReaderWriter.XML.PlottableExporter;
import MWC.Utilities.ReaderWriter.XML.Util.LocationHandler;
import MWC.Utilities.ReaderWriter.XML.Util.WorldDistanceHandler;

abstract public class VectorHandler extends ShapeHandler implements
		PlottableExporter
{

	private static final String DISTANCE = "Distance";
	private static final String BEARING = "Bearing";
	private static final String TL = "tl";
	private final static String ARROW_AT_END = "ArrowAtEnd";

	MWC.GenericData.WorldLocation _start;
	double _bearing;
	WorldDistance _distance = null;

	protected boolean _arrowAtEnd = false;

	public VectorHandler()
	{
		// inform our parent what type of class we are
		super("vector");

		addHandler(new LocationHandler(TL)
		{
			public void setLocation(MWC.GenericData.WorldLocation res)
			{
				_start = res;
			}
		});
		addAttributeHandler(new HandleAttribute(BEARING)
		{
			public void setValue(String name, String val)
			{
				_bearing = Double.valueOf(val);
			}
		});
		addAttributeHandler(new HandleBooleanAttribute(ARROW_AT_END)
		{
			public void setValue(String name, boolean value)
			{
				_arrowAtEnd = value;
			}
		});
		addHandler(new WorldDistanceHandler(DISTANCE)
		{
			
			@Override
			public void setWorldDistance(WorldDistance res)
			{
				_distance = res;
			}
		});
	}

	public final MWC.GUI.Shapes.PlainShape getShape()
	{
		MWC.GUI.Shapes.LineShape ls = new MWC.GUI.Shapes.VectorShape(_start,
				_bearing, _distance);
		ls.setArrowAtEnd(_arrowAtEnd);
		return ls;
	}

	public final void elementClosed()
	{
		super.elementClosed();

		// reset the local parameters
		_start = null;
		_distance = null;
		_bearing = 0;
		_arrowAtEnd = false;
	}

	public final void exportThisPlottable(MWC.GUI.Plottable plottable,
			org.w3c.dom.Element parent, org.w3c.dom.Document doc)
	{
		// output the shape related stuff first
		org.w3c.dom.Element ePlottable = doc.createElement(_myType);

		// export the common attributes
		super.exportThisPlottable(plottable, ePlottable, doc);

		// and the vector bits
		Debrief.Wrappers.ShapeWrapper sw = (Debrief.Wrappers.ShapeWrapper) plottable;
		MWC.GUI.Shapes.PlainShape ps = sw.getShape();
		if (ps instanceof MWC.GUI.Shapes.VectorShape)
		{
			// export the attributes
			MWC.GUI.Shapes.VectorShape cs = (MWC.GUI.Shapes.VectorShape) ps;
			MWC.Utilities.ReaderWriter.XML.Util.LocationHandler.exportLocation(
					cs.getLine_Start(), TL, ePlottable, doc);
			WorldDistanceHandler.exportDistance(DISTANCE, cs.getDistance(), ePlottable, doc);
			ePlottable.setAttribute(BEARING, writeThis(cs.getBearing()));
			ePlottable.setAttribute(ARROW_AT_END, writeThis(cs.getArrowAtEnd()));
		}
		else
		{
			throw new java.lang.RuntimeException(
					"wrong shape passed to line exporter");
		}

		// add ourselves to the output
		parent.appendChild(ePlottable);
	}

}
