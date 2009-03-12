// Copyright MWC 1999, Generated by Together
// @Author : Ian Mayo
// @Project: Debrief 3
// @File   : FormatRNDateTime.java

package MWC.Utilities.TextFormatting;

import MWC.GenericData.HiResDate;

import java.text.*;
import java.util.Date;
import java.util.TimeZone;

public class DebriefFormatDateTime
{
  private static DateFormat _dfMillis = null;
  private static DateFormat _df = null;
  private static NumberFormat _micros = null;
  private static NumberFormat _millis = null;
  private static final DateFormat FOUR_DIGIT_YEAR_FORMAT = new SimpleDateFormat("yyyyMMdd HHmmss");
  private static final DateFormat TWO_DIGIT_YEAR_FORMAT = new SimpleDateFormat("yyMMdd HHmmss");

  /** the string which in the past could appear, when the intention of the software
   * was to store a null string
   */
  private static final String NULL_DATE_STRING = "691231 235959.999";

  /** there are also some instances where invalid dates have crept in, possibly related to Debrief storing 0 and
   * trying to write this to disk.  Problem probably occured during Hi-Res times transition.
   */
  private static final String INVALID_DATE_STRING = "700101 000000";

  /** we use static instances of patterns.  just initialise them once
   * 
   */
  private static void initialisePatterns()
  {
    if (_dfMillis == null)
    {
      FOUR_DIGIT_YEAR_FORMAT.setTimeZone(TimeZone.getTimeZone("GMT"));
      TWO_DIGIT_YEAR_FORMAT.setTimeZone(TimeZone.getTimeZone("GMT"));

      _dfMillis = new SimpleDateFormat("yyMMdd HHmmss.SSS");
      _df = new SimpleDateFormat("yyMMdd HHmmss");
      _df.setTimeZone(TimeZone.getTimeZone("GMT"));
      _dfMillis.setTimeZone(TimeZone.getTimeZone("GMT"));

      // and the microsecond bits
      _micros = new DecimalFormat("000000");
      _millis = new DecimalFormat("000");
    }
  }

  static public String toString(long theVal)
  {
    initialisePatterns();

    java.util.Date theTime = new java.util.Date(theVal);
    String res;

    // first determine which pattern to use.
    DateFormat selectedFormat;
    if (theVal % 1000 > 0)
    {
      // ok, it contains milliseconds - include them in the output
      selectedFormat = _dfMillis;
    }
    else
    {
      selectedFormat = _df;
    }


    res = selectedFormat.format(theTime);

    return res;
  }


  /**
   * formatting method which just exports the micro-seconds within a DTG
   *
   * @param dtg
   * @return
   */
  public static String formatMicros(HiResDate dtg)
  {
    // check our declarations
    initialisePatterns();
    return _micros.format(dtg.getMicros() % 1000000);
  }

  /**
   * output the hi-res date as a formatted string, supplying micro-second and milli-second decimal
   * places as required.
   *
   * @param time - can't imagine.  What-ever could this parameter be called for?
   * @return formatted string
   */
  public static String toStringHiRes(HiResDate time, String formatStr)
  {
  	String res;
  	
  	// hmm, see if we are actually working in micros
  	long micros = time.getMicros();
  	if(micros % 1000 > 0)
  	{
  		res = toStringHiRes(time);
  	}
  	else
  	{
  		DateFormat myDF = new SimpleDateFormat(formatStr);
  		myDF.setTimeZone(TimeZone.getTimeZone("GMT"));
  		res = myDF.format(time.getDate());
  	}
  	
  	// cool, all finished
  	return res;
  }
  
  
  /**
   * output the hi-res date as a formatted string, supplying micro-second and milli-second decimal
   * places as required.
   *
   * @param time - can't imagine.  What-ever could this parameter be called for?
   * @return formatted string
   */
  public static String toStringHiRes(HiResDate time)
  {
    // check our declarations
    initialisePatterns();

    // so, have a look at the data
    long micros = time.getMicros();

    long wholeSeconds = micros / 1000000;

    StringBuffer res = new StringBuffer();
    res.append(toString(wholeSeconds * 1000));

    // do we have micros?
    if (micros % 1000 > 0)
    {
      // yes
      res.append(".");
      res.append(_micros.format(micros % 1000000));
    }
    else
    {
      // do we have millis?
      if (micros % 1000000 > 0)
      {
        // yes, convert the value to millis

        long millis = micros = (micros % 1000000) / 1000;

        res.append(".");
        res.append(_millis.format(millis));
      }
      else
      {
        // just use the normal output
      }
    }

    return res.toString();

  }

  /**
   * parse a date string using our format
   */
  public static HiResDate parseThis(String rawText)
  {
    // make sure our two and four-digit date bits are initialised
    initialisePatterns();

    Date date = null;
    HiResDate res = null;

    // right, start off by trimming spaces off the date
    rawText = rawText.trim();

    // right.  Special check to see if this is an incorrectly represented null date (-1)
    if (rawText.equals(NULL_DATE_STRING) || rawText.equals(INVALID_DATE_STRING))
    {
      MWC.Utilities.Errors.Trace.trace("Invalid date read from xml file: " + rawText, false);
      res = null;
    }
    else
    {

      String secondPart = rawText;
      String subSecondPart = null;

      // start off by seeing if we have sub-millisecond date
      int subSecondIndex = rawText.indexOf('.');
      if (subSecondIndex > 0)
      {
        // so, there is a separator - extract the text before the separator
        secondPart = rawText.substring(0, subSecondIndex);

        // just check that the '.' isn't the last character
        if (subSecondIndex < rawText.length() - 1)
        {
          // yes, we do have digits after the separator
          subSecondPart = rawText.substring(subSecondIndex + 1);
        }
      }

      // next determine if we have a 4-figure year value (in which case the space will be in column 9
      int spaceIndex = secondPart.indexOf(" ");

      try
      {
        if (spaceIndex > 6)
        {
          date = FOUR_DIGIT_YEAR_FORMAT.parse(secondPart);
        }
        else
        {
          date = TWO_DIGIT_YEAR_FORMAT.parse(secondPart);
        }
      }
      catch (ParseException e1)
      {
        MWC.Utilities.Errors.Trace.trace(e1, "Whilst reading this date:" + secondPart);
      }

      int micros = 0;

      // do we have a sub-second part?
      if (subSecondPart != null)
      {
        // get the value
        micros = Integer.parseInt(subSecondPart);

        int subSecLen = subSecondPart.length();

        // are we within the acceptable data resolution?
        if (subSecLen <= 6)
        {
          micros = micros * (int) (Math.pow(10, 6 - subSecLen));
        }
        else
        {
          MWC.Utilities.Errors.Trace.trace("Debrief is only capable of reading data to microsecond resolution (dtg:" + rawText + ")", false);
          micros = 0;
        }
      }

      res = new HiResDate(date.getTime(), micros);
    }

    return res;
  }

  //////////////////////////////////////////////////
  // testing code...
  //////////////////////////////////////////////////
  static public class DebriefFormatTest extends junit.framework.TestCase
  {
    static public final String TEST_ALL_TEST_TYPE = "CONV";

    public DebriefFormatTest(String val)
    {
      super(val);
    }

    public void testValues()
    {
      Date newDTG = new Date(1000);
      String res = DebriefFormatDateTime.toString(newDTG.getTime());
      assertEquals("matches", "700101 000001", res);

      newDTG = new Date(1);
      res = DebriefFormatDateTime.toString(newDTG.getTime());
      assertEquals("matches", "700101 000000.001", res);

      HiResDate hi = new HiResDate(1000);
      res = DebriefFormatDateTime.toStringHiRes(hi);
      assertEquals("matches", "700101 000001", res);

      hi = new HiResDate(1);
      res = DebriefFormatDateTime.toStringHiRes(hi);
      assertEquals("matches", "700101 000000.001", res);

      hi = new HiResDate(0, 1000);
      res = DebriefFormatDateTime.toStringHiRes(hi);
      assertEquals("matches", "700101 000000.001", res);

      hi = new HiResDate(2, 1000);
      res = DebriefFormatDateTime.toStringHiRes(hi);
      assertEquals("matches", "700101 000000.003", res);

      hi = new HiResDate(0, 11);
      res = DebriefFormatDateTime.toStringHiRes(hi);
      assertEquals("matches", "700101 000000.000011", res);


    }
  }

}

