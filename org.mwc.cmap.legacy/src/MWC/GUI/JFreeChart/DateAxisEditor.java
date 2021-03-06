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
package MWC.GUI.JFreeChart;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import org.jfree.chart.axis.DateTickUnit;
import org.jfree.chart.axis.DateTickUnitType;
import org.jfree.chart.axis.TickUnits;

import MWC.GUI.Properties.AbstractPropertyEditor;

public class DateAxisEditor extends AbstractPropertyEditor
{

	public static class OptimisedDateTickUnit extends DateTickUnit
	{

		public OptimisedDateTickUnit(final DateTickUnitType unitType, final int multiple)
		{
			super(unitType, multiple);
		}

		public OptimisedDateTickUnit(final DateTickUnitType unitType, final int multiple,
				final DateFormat formatter)
		{
			super(unitType, multiple, formatter);
		}

		public OptimisedDateTickUnit(final DateTickUnitType unitType, final int multiple,
				final DateTickUnitType rollUnitType, final int rollMultiple, final DateFormat formatter)
		{
			super(unitType, multiple, rollUnitType, rollMultiple, formatter);
		}

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		/**
		 * static calendar instance, to reduce object allocation
		 * 
		 */
		private static Calendar _myCal = null;
		
		/**
		 * Overrides parent implementation, in order that we can use static Calendar
		 * instance rather than creating it lots of times.
		 */
		@SuppressWarnings("deprecation")
		public Date addToDate(final Date base, final TimeZone zone)
		{
			
			// do we have a calenar already?
			if (_myCal == null)
				_myCal = Calendar.getInstance(zone);

			_myCal.setTime(base);
			_myCal.add(this.getUnitType().getCalendarField(), this.getCount());
			return _myCal.getTime();

		}
	}

	// ////////////////////////////////////////////////
	// member variables
	// ////////////////////////////////////////////////

	/**
	 * the string format used to denote a relative time description
	 */
	public static final String RELATIVE_DTG_FORMAT = "T+SSS";

	/**
	 * a list of strings representing the tick units
	 */
	private static String[] _theTags = null;

	/**
	 * the actual tick units in use
	 */
	private static MWCDateTickUnitWrapper[] _theData = null;

	// ////////////////////////////////////////////////
	// member methods
	// ////////////////////////////////////////////////

	public MWCDateTickUnitWrapper getDateTickUnit()
	{
		final Integer index = (Integer) this.getValue();
		final MWCDateTickUnitWrapper theUnit = _theData[index.intValue()];
		return theUnit;
	}

	protected synchronized void checkCreated()
	{
		// have they been created?
		if (_theData == null)
		{
			// create them
			final ArrayList<MWCDateTickUnitWrapper> theList = createStandardDateTickUnitsAsArrayList();

			// _theDates = new TickUnits();

			_theTags = new String[theList.size()];

			_theData = new MWCDateTickUnitWrapper[theList.size()];

			// work through the list
			for (int i = 0; i < theList.size(); i++)
			{
				final MWCDateTickUnitWrapper unit = (MWCDateTickUnitWrapper) theList.get(i);

				_theData[i] = unit;

				// and create the strings
				_theTags[i] = unit.toString();
			}
		}
	}

	/**
	 * retrieve the list of tags we display
	 * 
	 * @return the list of options
	 */
	public String[] getTags()
	{

		// check we're ready
		checkCreated();

		return _theTags;
	}

	/**
	 * select this vlaue
	 * 
	 * @param p1
	 */
	public void setValue(final Object p1)
	{
		// check we have the data
		checkCreated();

		if (p1 instanceof MWCDateTickUnitWrapper)
		{
			// pass through to match
			for (int i = 0; i < _theData.length; i++)
			{
				final MWCDateTickUnitWrapper unit = _theData[i];
				if (unit.equals(p1))
				{
					this.setValue(new Integer(i));
				}
			}
		}
		else
			super.setValue(p1);
	}

	/**
	 * return the currently selected string
	 * 
	 * @return
	 */
	public Object getValue()
	{
		// check we have the data
		checkCreated();

		final Integer theIndex = (Integer) super.getValue();
		return _theData[theIndex.intValue()];
	}

	public static TickUnits createStandardDateTickUnitsAsTickUnits()
	{
		final TickUnits units = new TickUnits();

		// milliseconds
		units.add(new OptimisedDateTickUnit(DateTickUnitType.MILLISECOND, 500,
				new RNFormatter("HH:mm:ss.SSS")));

		// seconds
		units.add(new OptimisedDateTickUnit(DateTickUnitType.SECOND, 1,
				new RNFormatter("HH:mm:ss")));
		units.add(new OptimisedDateTickUnit(DateTickUnitType.SECOND, 5,
				new RNFormatter("HH:mm:ss")));
		units.add(new OptimisedDateTickUnit(DateTickUnitType.SECOND, 10,
				new RNFormatter("HH:mm:ss")));
		units.add(new OptimisedDateTickUnit(DateTickUnitType.SECOND, 30,
				new RNFormatter("HH:mm:ss")));

		// minutes
		units.add(new OptimisedDateTickUnit(DateTickUnitType.MINUTE, 1,
				new RNFormatter("HH:mm")));
		units.add(new OptimisedDateTickUnit(DateTickUnitType.MINUTE, 2,
				new RNFormatter("HH:mm")));
		units.add(new OptimisedDateTickUnit(DateTickUnitType.MINUTE, 5,
				new RNFormatter("HH:mm")));
		units.add(new OptimisedDateTickUnit(DateTickUnitType.MINUTE, 10,
				new RNFormatter("HH:mm")));
		units.add(new OptimisedDateTickUnit(DateTickUnitType.MINUTE, 15,
				new RNFormatter("HH:mm")));
		units.add(new OptimisedDateTickUnit(DateTickUnitType.MINUTE, 20,
				new RNFormatter("HH:mm")));
		units.add(new OptimisedDateTickUnit(DateTickUnitType.MINUTE, 30,
				new RNFormatter("HH:mm")));

		// hours
		units.add(new OptimisedDateTickUnit(DateTickUnitType.HOUR, 1,
				new RNFormatter("HH:mm")));
		units.add(new OptimisedDateTickUnit(DateTickUnitType.HOUR, 2,
				new RNFormatter("HH:mm")));
		units.add(new OptimisedDateTickUnit(DateTickUnitType.HOUR, 4,
				new RNFormatter("HH:mm")));
		units.add(new OptimisedDateTickUnit(DateTickUnitType.HOUR, 6,
				new RNFormatter("ddHHmm")));
		units.add(new OptimisedDateTickUnit(DateTickUnitType.HOUR, 12,
				new RNFormatter("ddHHmm")));

		// days
		units.add(new OptimisedDateTickUnit(DateTickUnitType.DAY, 1,
				new RNFormatter("d-MMM")));

		return units;
	}

	/**
	 * Returns a collection of standard date tick units. This collection will be
	 * used by default, but you are free to create your own collection if you want
	 * to (see the setStandardTickUnits(...) method inherited from the ValueAxis
	 * class).
	 * 
	 * @return a collection of standard date tick units.
	 */
	public static ArrayList<MWCDateTickUnitWrapper> createStandardDateTickUnitsAsArrayList()
	{

		final ArrayList<MWCDateTickUnitWrapper> units = new ArrayList<MWCDateTickUnitWrapper>();

		units.add(MWCDateTickUnitWrapper.getAutoScale());

		// //////////////////////////////////////////////////////

		// milliseconds
		units.add(new MWCDateTickUnitWrapper(DateTickUnitType.MILLISECOND, 500,
				"HH:mm:ss.SSS"));

		// seconds
		units
				.add(new MWCDateTickUnitWrapper(DateTickUnitType.SECOND, 1, "HH:mm:ss"));
		units
				.add(new MWCDateTickUnitWrapper(DateTickUnitType.SECOND, 5, "HH:mm:ss"));
		units.add(new MWCDateTickUnitWrapper(DateTickUnitType.SECOND, 10,
				"HH:mm:ss"));
		units.add(new MWCDateTickUnitWrapper(DateTickUnitType.SECOND, 30,
				"HH:mm:ss"));

		// minutes
		units.add(new MWCDateTickUnitWrapper(DateTickUnitType.MINUTE, 1, "HH:mm"));
		units.add(new MWCDateTickUnitWrapper(DateTickUnitType.MINUTE, 2, "HH:mm"));
		units.add(new MWCDateTickUnitWrapper(DateTickUnitType.MINUTE, 5, "HH:mm"));
		units.add(new MWCDateTickUnitWrapper(DateTickUnitType.MINUTE, 10, "HH:mm"));
		units.add(new MWCDateTickUnitWrapper(DateTickUnitType.MINUTE, 15, "HH:mm"));
		units.add(new MWCDateTickUnitWrapper(DateTickUnitType.MINUTE, 20, "HH:mm"));
		units.add(new MWCDateTickUnitWrapper(DateTickUnitType.MINUTE, 30, "HH:mm"));

		// hours
		units.add(new MWCDateTickUnitWrapper(DateTickUnitType.HOUR, 1, "HH:mm"));
		units.add(new MWCDateTickUnitWrapper(DateTickUnitType.HOUR, 2, "HH:mm"));
		units.add(new MWCDateTickUnitWrapper(DateTickUnitType.HOUR, 4, "HH:mm"));
		units.add(new MWCDateTickUnitWrapper(DateTickUnitType.HOUR, 6, "ddHHmm"));
		units.add(new MWCDateTickUnitWrapper(DateTickUnitType.HOUR, 12, "ddHHmm"));

		// days
		units.add(new MWCDateTickUnitWrapper(DateTickUnitType.DAY, 1, "d-MMM"));

		// /////////////////////////////////////////////////////

		// // milliseconds
		// units.add(new MWCDateTickUnitWrapper(DateTickUnitType.MILLISECOND,
		// 500, "HH:mm:ss.SSS"));
		//
		// // seconds
		// units.add(new MWCDateTickUnitWrapper(DateTickUnitType.SECOND, 1,
		// "HH:mm:ss"));
		// units.add(new MWCDateTickUnitWrapper(DateTickUnitType.SECOND, 5,
		// "HH:mm:ss"));
		// units.add(new MWCDateTickUnitWrapper(DateTickUnitType.SECOND, 10,
		// "HH:mm:ss"));
		// units.add(new MWCDateTickUnitWrapper(DateTickUnitType.SECOND, 30,
		// "HH:mm:ss"));
		//
		// // minutes
		// units.add(new MWCDateTickUnitWrapper(DateTickUnitType.MINUTE, 1,
		// "HH:mm"));
		// units.add(new MWCDateTickUnitWrapper(DateTickUnitType.MINUTE, 2,
		// "HH:mm"));
		// units.add(new MWCDateTickUnitWrapper(DateTickUnitType.MINUTE, 5,
		// "HH:mm"));
		// units.add(new MWCDateTickUnitWrapper(DateTickUnitType.MINUTE, 10,
		// "HH:mm"));
		// units.add(new MWCDateTickUnitWrapper(DateTickUnitType.MINUTE, 15,
		// "HH:mm"));
		// units.add(new MWCDateTickUnitWrapper(DateTickUnitType.MINUTE, 20,
		// "HH:mm"));
		// units.add(new MWCDateTickUnitWrapper(DateTickUnitType.MINUTE, 30,
		// "HH:mm"));
		//
		// // hours
		// units.add(new MWCDateTickUnitWrapper(DateTickUnitType.HOUR, 1,
		// "HH:mm"));
		// units.add(new MWCDateTickUnitWrapper(DateTickUnitType.HOUR, 2,
		// "HH:mm"));
		// units.add(new MWCDateTickUnitWrapper(DateTickUnitType.HOUR, 4,
		// "HH:mm"));
		// units.add(new MWCDateTickUnitWrapper(DateTickUnitType.HOUR, 6,
		// "HH:mm"));
		// units.add(new MWCDateTickUnitWrapper(DateTickUnitType.HOUR, 12,
		// "d-MMM, HH:mm"));
		//
		// // days
		// units.add(new MWCDateTickUnitWrapper(DateTickUnitType.DAY, 1,
		// "d-MMM"));

		// absolute seconds
		units.add(new MWCDateTickUnitWrapper(DateTickUnitType.SECOND, 1,
				RELATIVE_DTG_FORMAT));
		units.add(new MWCDateTickUnitWrapper(DateTickUnitType.SECOND, 5,
				RELATIVE_DTG_FORMAT));
		units.add(new MWCDateTickUnitWrapper(DateTickUnitType.SECOND, 10,
				RELATIVE_DTG_FORMAT));
		units.add(new MWCDateTickUnitWrapper(DateTickUnitType.SECOND, 30,
				RELATIVE_DTG_FORMAT));
		units.add(new MWCDateTickUnitWrapper(DateTickUnitType.SECOND, 60,
				RELATIVE_DTG_FORMAT));

		return units;

	}

	public static class RNFormatter extends SimpleDateFormat
	{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		/**
		 * Construct a SimpleDateFormat using the given pattern in the default
		 * locale. <b>Note:</b> Not all locales support SimpleDateFormat; for full
		 * generality, use the factory methods in the DateFormat class.
		 */
		public RNFormatter(final String pattern)
		{
			super(pattern);
			this.setTimeZone(TimeZone.getTimeZone("GMT"));
		}
	}

	/*****************************************************************************
	 * class to store components of tick unit in accessible form
	 ****************************************************************************/
	public static class MWCDateTickUnitWrapper
	{
		// ////////////////////////////////////////////////
		// member variables
		// ////////////////////////////////////////////////
		/**
		 * components of DateTickUnit
		 */
		protected DateTickUnitType _unit;

		protected int _count;

		protected String _formatter;

		public MWCDateTickUnitWrapper(final DateTickUnitType unit, final int count,
				final String formatter)
		{
			_unit = unit;
			_count = count;
			_formatter = formatter;
		}

		public DateTickUnit getUnit()
		{
			DateTickUnit res = null;

			if (_formatter != DateAxisEditor.RELATIVE_DTG_FORMAT)
			{
				final SimpleDateFormat sdf = new SimpleDateFormat(_formatter);
				sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

				res = new OptimisedDateTickUnit(_unit, _count, sdf);

			}
			else
			{
				final SimpleDateFormat sdf = new SimpleDateFormat(_formatter);
				sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

				res = new OptimisedDateTickUnit(_unit, _count, sdf)
				{
					/**
					 * 
					 */
					private static final long serialVersionUID = 1L;

					/**
					 * Formats a date.
					 * 
					 * @param date
					 *          the date.
					 * @return the formatted date.
					 */
					public String dateToString(final Date date)
					{
						String res1 = null;
						// how many secs?
						final long secs = date.getTime() / 1000;
						res1 = secs + "s";
						return res1;
					}
				};

			}

			return res;

		}

		public String toString()
		{
			String res = null;

			if (_formatter == null)
			{
				res = "Auto-scale";
			}
			else
			{
				res = _count + " " + getUnitLabel() + " " + _formatter;
			}

			return res;
		}

		public static MWCDateTickUnitWrapper getAutoScale()
		{
			return new MWCDateTickUnitWrapper(DateTickUnitType.SECOND, 0, null);
		}

		public boolean isAutoScale()
		{
			return (_formatter == null);
		}

		private String getUnitLabel()
		{
			switch (_unit.getCalendarField())
			{
			case (Calendar.YEAR):
				return "Year";
			case (Calendar.MONTH):
				return "Month";
			case (Calendar.DAY_OF_MONTH):
				return "Day";
			case (Calendar.HOUR):
				return "Hour";
			case (Calendar.MINUTE):
				return "Min";
			case (Calendar.SECOND):
				return "Sec";
			default:
				return "Milli";
			}
		}
	}

}
