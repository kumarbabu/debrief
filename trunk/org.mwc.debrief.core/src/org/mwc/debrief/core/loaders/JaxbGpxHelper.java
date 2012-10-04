package org.mwc.debrief.core.loaders;

import java.io.File;
import java.io.InputStream;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.JAXBIntrospector;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.util.StreamReaderDelegate;

import org.eclipse.core.runtime.Status;
import org.mwc.cmap.core.CorePlugin;
import org.mwc.debrief.core.gpx.mappers.TrackMapper;

import Debrief.Wrappers.TrackWrapper;
import MWC.GUI.Layers;

import com.topografix.gpx.v11.GpxType;

/**
 * JAXB based implementation for marhsalling and unmarshalling. EclipseLink is
 * used as the MOXy implementation. Refer to {@link TODO -link my blog post} on
 * how to install and configure JAXB for eclipse.
 * 
 * @author Aravind R. Yarram <yaravind@gmail.com>
 * @date August 21, 2012
 * @category gpx
 * 
 */
public class JaxbGpxHelper implements GpxHelper
{
	private static JAXBContext GPX_JAXB_CTX;
	private static JAXBContext DEBRIEF_EXTENSIONS_JAXB_CTX;

	private final TrackMapper trackMapper = new TrackMapper();
	private final XMLInputFactory xif = XMLInputFactory.newInstance();;

	static
	{
		try
		{
			GPX_JAXB_CTX = JAXBContext.newInstance("com.topografix.gpx.v11");
			DEBRIEF_EXTENSIONS_JAXB_CTX = JAXBContext.newInstance("org.mwc.debrief.core.gpx");
		}
		catch (JAXBException e)
		{
			e.printStackTrace();
		}
	}

	public JaxbGpxHelper()
	{
		trackMapper.setJaxbContext(DEBRIEF_EXTENSIONS_JAXB_CTX);
	}

	@Override
	public Layers unmarshall(InputStream gpxStream, Layers theLayers)
	{
		if (theLayers == null)
		{
			theLayers = new Layers();
		}
		try
		{

			XMLStreamReader xsr = xif.createXMLStreamReader(gpxStream);
			xsr = new GpxNamespaceTransposingStreamReaderDelegate(xsr);

			Unmarshaller unmarshaller = GPX_JAXB_CTX.createUnmarshaller();

			GpxType gpxType = (GpxType) JAXBIntrospector.getValue(unmarshaller.unmarshal(xsr));

			/*
			 * For our first trial I'm happy for the unmarshall method to return a
			 * Layers object. It is expect that in our trial this object will have a
			 * Track and a Layer containing a couple of shapes
			 */
			List<TrackWrapper> tracks = trackMapper.fromGpx(gpxType);

			for (TrackWrapper track : tracks)
			{
				theLayers.addThisLayer(track);
			}
		}
		catch (JAXBException e)
		{
			CorePlugin.logError(Status.ERROR, "Error while unmarshalling GPX", e);
			return null;
		}
		catch (XMLStreamException e)
		{
			CorePlugin.logError(Status.ERROR, "Error while unmarshalling GPX. The issue happened while creating the stax classes", e);
			return null;
		}

		return theLayers;
	}

	@Override
	public void marshall(Layers from, File saveToGpx)
	{
		// TODO Auto-generated method stub

	}

	public boolean isValid(InputStream gpxStream)
	{
		return true;
	}

	/**
	 * JAXB requires binding code to be generated for every version of the GPX
	 * schema. This is because of the way versioning is implemented by the GPX;
	 * GPX changes the namespaces with every new version becuase the version is
	 * part of the namespace. For example,
	 * <ol>
	 * <li>GPX 1.0: http://www.topografix.com/GPX/1/0</li>
	 * <li>GPX 1.1: http://www.topografix.com/GPX/1/1</li>
	 * </ol>
	 * 
	 * <p>
	 * Hoping that new versions are backward compatible with older versions
	 * (except the <code>version</code> attribute and the namespace change), we
	 * just treat all of them as 1.1 versions thus reusing the binding code
	 * generated for 1.1 version.
	 * </p>
	 * 
	 * <b>NOTE: The <code>version</code> attribute of <code>gpx</code> element is
	 * considered insignificant for the unmarshalling process and hence being
	 * ignored. </b>
	 * 
	 * <p>
	 * The implementation tip is from <a href=
	 * "http://blog.bdoughan.com/2010/12/case-insensitive-unmarshalling.html"
	 * >here</a>
	 * </p>
	 */
	public static class GpxNamespaceTransposingStreamReaderDelegate extends StreamReaderDelegate
	{
		public GpxNamespaceTransposingStreamReaderDelegate(XMLStreamReader xsr)
		{
			super(xsr);
		}

		@Override
		public String getNamespaceURI()
		{
			if (super.getNamespaceURI().toLowerCase().contains("gpx"))
			{
				return "http://www.topografix.com/GPX/1/1";
			}
			else
			{
				return super.getNamespaceURI();
			}
		}
	}
}