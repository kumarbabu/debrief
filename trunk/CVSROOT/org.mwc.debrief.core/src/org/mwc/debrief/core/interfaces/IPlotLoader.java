/**
 * 
 */
package org.mwc.debrief.core.interfaces;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Status;
import org.eclipse.ui.IEditorInput;
import org.mwc.cmap.core.interfaces.INamedItem;
import org.mwc.cmap.plotViewer.editors.PlotEditor;
import org.mwc.debrief.core.CorePlugin;

/** Interface for classes which are capable of populating a plot from a file
 * 
 * @author ian.mayo
 *
 */
public interface IPlotLoader extends INamedItem
{
	/** load the supplied editor input into the plot
	 * 
	 * @param thePlot the plot destination
	 * @param input the file source
	 */
	public void loadFile(PlotEditor thePlot, IEditorInput input);

	
	/** test whether this loader can load the suppled input source
	 * 
	 * @param fileName the input file to check
	 * @return yes/no
	 */
	public boolean canLoad(String fileName);
	
	/** utility method to initialise this loader - we need to do
	 * this since when we use these objects as plugins Eclipse has to 
	 * call the zero-argument constructor (and we supply the data with these methods)
	 * 
	 * @param name
	 * @param icon
	 * @param fileTypes
	 */
	public void init(String name, String icon, String fileTypes);
	
	abstract public static class BaseLoader implements IPlotLoader
	{
		String _myName;
		String _icon;
		String _fileTypes;
		
		public void init(final String name,  final String icon, final String fileTypes)
		{
			_myName = name;
			_icon = icon;
			_fileTypes = fileTypes;
		}
		
		public final String getName()
		{
			return _myName;
		}
		
		public String getFileName(IEditorInput input)
		{
			String res = null;

			res = "c:\\boat1.rep";
			
			return res;
		}

		
		/** test whether this loader can load the suppled input source
		 * 
		 * @param fileName the input file to check
		 * @return yes/no
		 */
		public boolean canLoad(String fileName)
		{
			return (fileName.toUpperCase().indexOf(_fileTypes.toUpperCase()) > 0);
		}
		
	
		
	}
	
	public static class DeferredPlotLoader extends BaseLoader
	{
		final IConfigurationElement _config;
		
		BaseLoader _myLoader = null;
		
		/** constructor - stores the information necessary to load the data
		 * 
		 * @param configElement
		 * @param name
		 * @param icon
		 * @param fileTypes
		 */
		public DeferredPlotLoader(IConfigurationElement configElement,
				String name,  String icon, String fileTypes)
		{
			_config = configElement;
			init(name, icon, fileTypes);
		}
		

		public void loadFile(PlotEditor thePlot, IEditorInput input)
		{
			if(_myLoader == null)
			{
				try
				{
					System.out.println("About to load new loader for:" + getName());

					// and create the loader
					_myLoader = (BaseLoader) _config.createExecutableExtension("class");

					// hey, stick the data in
					_myLoader.init(_myName, _icon, _fileTypes);					
						
				}
				catch (CoreException e)
				{			
					CorePlugin.logError(Status.ERROR, "Failed to create instance of loader:"
							+ _config, e);
					
				}
			}

			if(_myLoader != null)
			{
				// we either had it already, or we're trying to load it now. go for it
				_myLoader.loadFile(thePlot, input);
			}
			else
			{
				CorePlugin.logError(Status.ERROR, "Unable to load file. Loader unavailable for:"
						+ _config, null);
				
			}
			
		}

		
	}
}
