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
package org.mwc.asset.scenariocontroller2.views;

public class SingleScenarioView
/*
 * extends ViewPart implements ISelectionProvider, TimeManager.LiveScenario,
 * SingleDisplay
 */
{
	//
	// private static final String PAUSE_SCENARIO = "Stop";
	// private static final String RUN_SCENARIO = " Run ";
	// private static final String CONTROL_FILE_INDEX = "CONTROL_FILE";
	// private static final String SCENARIO_FILE_INDEX = "SCENARIO_FILE";
	//
	// /**
	// * ui bits
	// *
	// */
	// private Action _viewInPlotter;
	// private Action _actionReloadDatafiles;
	// private DropTarget target;
	// private UISkeleton _myUI;
	//
	// /**
	// * tactical data
	// *
	// */
	// private Vector<ScenarioObserver> _myObservers = new
	// Vector<ScenarioObserver>(
	// 0, 1);
	//
	// /**
	// * watchable parts
	// *
	// */
	// Vector<ISelectionChangedListener> _selectionListeners;
	//
	// /**
	// * wrap the scenario so it can be shown in the layer manager
	// *
	// */
	// private ScenarioWrapper _scenarioWrapper;
	// private Vector<ScenarioObserver> _theObservers;
	// private WrappingSteppableTime _timeManager;
	// private MultiScenarioCore _myMultiScenario;
	// private String[] _myPendingFilenames;
	// private TimeControlPreferences _myTimeControlProps;
	//
	// /**
	// * support for anybody that wants to know how we're getting on
	// *
	// */
	// private PropertyChangeSupport _scenStopSupport;
	// private SimulationTable _simTable;
	// private ISelection _currentSelection;
	// private ResultsContainer _scenarioController;
	// private NewScenarioListener _newScenarioListener;
	// private ScenarioSteppedListener _stepListener;
	// private Duration _myPendingStepSize;
	// final private SingleScenarioPresenter _myPresenter;
	//
	// /**
	// * The constructor.
	// */
	// public SingleScenarioView()
	// {
	// _myPresenter = new SingleScenarioPresenter(this, new CoreScenario());
	// _scenarioWrapper = new ScenarioWrapper(_myPresenter);
	//
	// _timeManager = new WrappingSteppableTime();
	//
	//
	// _newScenarioListener = new NewScenarioListener()
	// {
	// public void newScenario(ScenarioType oldScenario, ScenarioType newScenario)
	// {
	// _timeManager.setCurrentScenario(newScenario);
	//
	// if (oldScenario != null)
	// {
	// oldScenario.removeScenarioSteppedListener(_stepListener);
	// }
	// newScenario.addScenarioSteppedListener(_stepListener);
	// }
	// };
	//
	// // listen to the scenario
	// ScenarioRunningListener _scenarioRunningListener = new
	// ScenarioRunningListener()
	// {
	// public void finished(long elapsedTime, String reason)
	// {
	// // communicate what's happened to the time controller, if there is one.
	// if (_scenStopSupport != null)
	// _scenStopSupport.firePropertyChange(
	// TimeManager.LiveScenario.FINISHED, null, this);
	//
	// // update our own status indicator(s)
	// setScenarioStatus(_myScenario, reason);
	//
	// // tell the observers that it's all over
	// tearDownObservers(_myScenario);
	//
	// refreshWorkspace();
	//
	// }
	//
	// public void newScenarioStepTime(int val)
	// {
	// }
	//
	// public void newStepTime(int val)
	// {
	// }
	//
	// public void paused()
	// {
	// }
	//
	// public void started()
	// {
	// }
	//
	// public void restart(ScenarioType scenario)
	// {
	// }
	// };
	// _myScenario.addScenarioRunningListener(_scenarioRunningListener);
	//
	// }
	//
	// /**
	// * This is a callback that will allow us to create the viewer and initialize
	// * it.
	// */
	// public void createPartControl(Composite parent)
	// {
	// // create our UI
	// _myUI = new UISkeleton(parent, SWT.FILL);
	// // _myUI.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
	//
	// _myUI.getMultiTableHolder().setLayoutData(
	// new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
	//
	// _myUI.getScenarioTabs().addSelectionListener(new SelectionListener()
	// {
	//
	// public void widgetDefaultSelected(SelectionEvent e)
	// {
	// }
	//
	// public void widgetSelected(SelectionEvent e)
	// {
	// if (_myUI.getScenarioTabs().getSelectionIndex() == 0)
	// {
	// EditableWrapper ew = new EditableWrapper(_scenarioWrapper);
	// StructuredSelection sel = new StructuredSelection(ew);
	// setSelection(sel);
	// }
	// else
	// {
	// setSelection(null);
	// }
	//
	// }
	// });
	//
	// _simTable = new SimulationTable(_myUI.getMultiTableHolder(), this);
	// _simTable.getControl().setLayoutData(
	// new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1));
	//
	// // multiUI = new SimControllerUI(_myUI.getMultiTableHolder());
	// // multiUI.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1,
	// // 1));
	// // multiUI.pack();
	//
	// // let us accept dropped files
	// configureFileDropSupport(_myUI);
	//
	// // fille in the menu bar(s)
	// makeActions();
	// contributeToActionBars();
	//
	// // declare fact that we can provide selections (and let our scenario table
	// // know we do it aswell)
	// getSite().setSelectionProvider(this);
	// _simTable.setSelectionProvider(this);
	//
	// // now listen to the UI buttons
	// _myUI.getDoGenerateButton().addSelectionListener(new SelectionListener()
	// {
	// public void widgetDefaultSelected(SelectionEvent e)
	// {
	// }
	//
	// public void widgetSelected(SelectionEvent e)
	// {
	// // ok, do the gen
	// doMultiGenerateOperation();
	// }
	// });
	//
	// _myUI.getRunBtn().addSelectionListener(new SelectionListener()
	// {
	//
	// public void widgetDefaultSelected(SelectionEvent e)
	// {
	// }
	//
	// public void widgetSelected(SelectionEvent e)
	// {
	// doMultiRunOperation();
	// }
	// });
	//
	// // if we have any pending filenames, get them dropped
	// if (_myPendingFilenames != null)
	// filesDropped(_myPendingFilenames);
	//
	// // listen out for the single scenario being run
	// _myUI.getSingleRunBtn().addSelectionListener(new SelectionListener()
	// {
	// public void widgetDefaultSelected(SelectionEvent e)
	// {
	// }
	//
	// public void widgetSelected(SelectionEvent e)
	// {
	// String currLabel = _myUI.getSingleRunBtn().getText().trim();
	// if (currLabel.equals(RUN_SCENARIO.trim()))
	// {
	// _newScenarioListener.newScenario(null, _myScenario);
	//
	// // tell it we're running
	// _myUI.getSingleRunBtn().setText(PAUSE_SCENARIO);
	//
	// // ok, run the scenario
	// _myScenario.start();
	// }
	// else
	// {
	// // tell it we're running
	// _myUI.getSingleRunBtn().setText(RUN_SCENARIO);
	//
	// _myScenario.pause();
	// }
	//
	// }
	// });
	//
	// }
	//
	// protected static class WrappedProgressMonitor implements
	// ASSETProgressMonitor
	// {
	// final IProgressMonitor monitor;
	//
	// public WrappedProgressMonitor(IProgressMonitor val)
	// {
	// monitor = val;
	//
	// }
	//
	// public void beginTask(String name, int totalWork)
	// {
	// monitor.beginTask(name, totalWork);
	// }
	//
	// public void worked(int work)
	// {
	// monitor.worked(work);
	// }
	// }
	//
	// private void refreshWorkspace()
	// {
	// // it's stopped running, refresh the workspace
	// IProject theProj = getAProject();
	// try
	// {
	// theProj.refreshLocal(2, null);
	// }
	// catch (CoreException e)
	// {
	// ASSETPlugin.logError(Status.ERROR,
	// "Had trouble refreshing project folder", e);
	// e.printStackTrace();
	// }
	// }
	//
	// protected void doMultiGenerateOperation()
	// {
	// // disable the genny button, until it's done.
	// _myUI.getDoGenerateButton().setEnabled(false);
	//
	// Job job = new Job("Prepare multiple scenarios")
	// {
	// @Override
	// protected IStatus run(IProgressMonitor monitor)
	// {
	// try
	// {
	//
	// ASSETProgressMonitor pMon = new WrappedProgressMonitor(monitor);
	//
	// if (_myMultiScenario == null)
	// {
	// // create a new, fresh multi scenario generator
	// _myMultiScenario = new MultiScenarioCore();
	// }
	//
	// // and let it create some files
	// _myMultiScenario.prepareFiles(_controlFileName, _scenarioFileName,
	// System.out, System.err, System.in, pMon,
	// _scenarioController.outputDirectory);
	//
	// // and sort out the observers
	// _myMultiScenario.prepareControllers(_scenarioController, pMon,
	// _newScenarioListener);
	//
	// // ok, now give the scenarios to the multi scenario table (in the UI
	// // thread
	// Display.getDefault().asyncExec(new Runnable()
	// {
	// public void run()
	// {
	// _simTable.setInput(_myMultiScenario);
	// // and make the run button live
	// _myUI.getRunBtn().setEnabled(true);
	// _myUI.getDoGenerateButton().setEnabled(true);
	// }
	// });
	// }
	// catch (Exception e)
	// {
	// CorePlugin.logError(Status.ERROR, "Failed in scenario generation", e);
	// e.printStackTrace();
	// }
	//
	// return Status.OK_STATUS;
	// }
	// };
	//
	// job.addJobChangeListener(new JobChangeAdapter()
	// {
	// public void done(IJobChangeEvent event)
	// {
	// if (event.getResult().isOK())
	// System.out.println("Job completed successfully");
	// else
	// System.err.println("Job did not complete successfully");
	// }
	// });
	// job.setUser(true);
	// job.schedule(); // start as soon as possible
	// }
	//
	// protected void doMultiRunOperation()
	// {
	// System.out.println("doing run");
	//
	// Thread doRun = new Thread()
	// {
	//
	// @Override
	// public void run()
	// {
	// // tell them to go for it
	// _myMultiScenario.nowRun(System.out, System.err, System.in,
	// _newScenarioListener);
	//
	// // ok, better refresh the workspace
	// refreshWorkspace();
	// }
	// };
	// doRun.start();
	//
	// }
	//
	// @SuppressWarnings("rawtypes")
	// public Object getAdapter(Class adapter)
	// {
	// Object res = null;
	//
	// if (adapter == Layers.class)
	// {
	// // only return the scenario if we're in a single scenario mode
	// if (inSingleScenarioRun())
	// res = _scenarioWrapper;
	// }
	// if (adapter == ScenarioType.class)
	// {
	// // only return the scenario if we're in a single scenario mode
	// if (inSingleScenarioRun())
	// res = _myScenario;
	// }
	// else if (adapter == TimeProvider.class)
	// {
	// res = _timeManager;
	// }
	// else if (adapter == TimeControlPreferences.class)
	// {
	// if (_myTimeControlProps == null)
	// {
	// _myTimeControlProps = new TimeControlProperties();
	// _myTimeControlProps.setAutoInterval(_myPendingStepSize);
	// }
	//
	// res = _myTimeControlProps;
	// }
	// else if (adapter == TimeManager.LiveScenario.class)
	// {
	// // aah, are we in single or multi mode?
	// if (inSingleScenarioRun())
	// return this;
	// else
	// {
	// // return the current selected item
	// StructuredSelection sel = (StructuredSelection) _currentSelection;
	// if (sel != null)
	// {
	// EditableWrapper obj = (EditableWrapper) sel.getFirstElement();
	// if (obj instanceof EditableWrapper)
	// {
	// Editable ed = obj.getEditable();
	// if (ed instanceof LiveScenario)
	// return ed;
	// }
	// }
	// }
	// }
	// else if (adapter == SteppableTime.class)
	// {
	// return _timeManager;
	// }
	//
	// if (res == null)
	// {
	// res = super.getAdapter(adapter);
	// }
	// return res;
	// }
	//
	// public Vector<ScenarioObserver> getObservers()
	// {
	// return _theObservers;
	// }
	//
	// public ScenarioType getScenario()
	// {
	// return _myScenario;
	// }
	//
	// /**
	// * sort out the file-drop target
	// */
	// private void configureFileDropSupport(Control _pusher)
	// {
	// int dropOperation = DND.DROP_COPY;
	// Transfer[] dropTypes =
	// { FileTransfer.getInstance() };
	//
	// target = new DropTarget(_pusher, dropOperation);
	// target.setTransfer(dropTypes);
	// target.addDropListener(new DropTargetListener()
	// {
	// public void dragEnter(DropTargetEvent event)
	// {
	// if (FileTransfer.getInstance().isSupportedType(event.currentDataType))
	// {
	// if (event.detail != DND.DROP_COPY)
	// {
	// event.detail = DND.DROP_COPY;
	// }
	// }
	// }
	//
	// public void dragLeave(DropTargetEvent event)
	// {
	// }
	//
	// public void dragOperationChanged(DropTargetEvent event)
	// {
	// }
	//
	// public void dragOver(DropTargetEvent event)
	// {
	// }
	//
	// public void dropAccept(DropTargetEvent event)
	// {
	// }
	//
	// public void drop(DropTargetEvent event)
	// {
	// String[] fileNames = null;
	// if (FileTransfer.getInstance().isSupportedType(event.currentDataType))
	// {
	// fileNames = (String[]) event.data;
	// }
	// if (fileNames != null)
	// {
	// filesDropped(fileNames);
	// }
	// }
	//
	// });
	//
	// }
	//
	// public void filesDropped(String[] fileNames)
	// {
	// // ok, loop through the files
	// for (int i = 0; i < fileNames.length; i++)
	// {
	// final String thisName = fileNames[i];
	//
	// if (thisName != null)
	// {
	//
	// // ok, examine this file
	// String firstNode = getFirstNodeName(thisName);
	//
	// if (firstNode != null)
	// {
	// if (firstNode.equals("Scenario"))
	// {
	// // remember it
	// _scenarioFileName = thisName;
	//
	// // set the filename
	// _myUI.getScenarioVal().setText(new File(thisName).getName());
	//
	// IWorkbench wb = PlatformUI.getWorkbench();
	// IProgressService ps = wb.getProgressService();
	// try
	// {
	// ps.busyCursorWhile(new IRunnableWithProgress()
	// {
	// public void run(IProgressMonitor pm)
	// {
	// scenarioAssigned(thisName);
	// }
	// });
	// }
	// catch (Exception e)
	// {
	// e.printStackTrace();
	// }
	//
	// }
	// else if (firstNode.equals("ScenarioController"))
	// {
	// // remember it
	// _controlFileName = thisName;
	//
	// // show it
	// _myUI.getControlVal().setText(new File(thisName).getName());
	//
	// IWorkbench wb = PlatformUI.getWorkbench();
	// IProgressService ps = wb.getProgressService();
	// try
	// {
	// ps.busyCursorWhile(new IRunnableWithProgress()
	// {
	// public void run(IProgressMonitor pm)
	// {
	// controllerAssigned(thisName);
	// }
	// });
	// }
	// catch (Exception e)
	// {
	// e.printStackTrace();
	// }
	// }
	// }
	// }
	// }
	//
	// // lastly, select me - so our listeners get informed.
	// // - note, we do it in a runnable because things can get a little recursive
	// // if we're trying to show a view whilst its still being defined.
	// Runnable doIt = new Runnable()
	// {
	// public void run()
	// {
	// activateMe();
	// }
	// };
	// Display.getCurrent().asyncExec(doIt);
	// }
	//
	// private void scenarioAssigned(String thisName)
	// {
	// // now load the data
	// try
	// {
	// // ditch any existing participants
	// _myScenario.emptyParticipants();
	//
	// // and ditch any layers
	// _scenarioWrapper.ditchChartFeatures();
	//
	// // now load the new ones
	// String scenarioStr = thisName;
	// File theFile = new File(scenarioStr);
	// // final SampleDataPlugin thePlugin = SampleDataPlugin.getDefault();
	// InputStream theStream = new FileInputStream(theFile);//
	// // thePlugin.getResource(thePath);
	// ASSETReaderWriter.importThis(_myScenario, _scenarioWrapper, scenarioStr,
	// theStream);
	//
	// fireScenarioChanged();
	// }
	// catch (IOException e)
	// {
	// e.printStackTrace();
	// ASSETPlugin.logError(Status.ERROR, "Failed to load sample data", e);
	// }
	// catch (NullPointerException e)
	// {
	// e.printStackTrace();
	// ASSETPlugin.logError(Status.ERROR, "The sample-data plugin isn't loaded",
	// e);
	// }
	//
	// }
	//
	// private void controllerAssigned(String controlFile)
	// {
	// // ok, forget any existing observers
	// ditchObservers();
	//
	// try
	// {
	// // hmm, check what type of control file it is
	// String controlType = getFirstNodeName(controlFile);
	//
	// if (controlType == StandaloneObserverListHandler.type)
	// {
	// _theObservers = ASSETReaderWriter.importThisObserverList(controlFile,
	// new java.io.FileInputStream(controlFile));
	// }
	// else if (controlType == ScenarioControllerHandler.type)
	// {
	//
	// _scenarioController = ASSETReaderWriter.importThisControlFile(
	// controlFile, new java.io.FileInputStream(controlFile));
	//
	// _theObservers = _scenarioController.observerList;
	//
	// // since we have a results container - we have enough information to set
	// // the output files
	// File tgtDir = _scenarioController.outputDirectory;
	//
	// // if the tgt dir is a relative reference, make it relative to
	// // our first project, not the user's login directory
	// if (isRelativePath(tgtDir))
	// {
	// // prepend the target directory with the root of the current project
	// IProject someProject = getAProject();
	// if (someProject != null)
	// {
	// // get the file-system path to this folder
	// IPath filePath = someProject.getLocation();
	//
	// // ok, now stick the output folder in this parent
	// tgtDir = new File(filePath.toOSString() + File.separator
	// + tgtDir.getPath());
	//
	// // and store the new location
	// _scenarioController.outputDirectory = tgtDir;
	// }
	// }
	//
	// Enumeration<ScenarioObserver> numer = _theObservers.elements();
	// while (numer.hasMoreElements())
	// {
	// ScenarioObserver thisS = numer.nextElement();
	// // does this worry about the output file?
	// if (thisS instanceof RecordToFileObserverType)
	// {
	// // yup, better store it...
	// RecordToFileObserverType rs = (RecordToFileObserverType) thisS;
	// rs.setDirectory(tgtDir);
	// }
	// }
	//
	// }
	//
	// // check if it's multi scenario..
	// final boolean isMulti = CommandLine
	// .checkIfGenerationRequired(controlFile);
	//
	// // setup the listeners if we're just in a single scenario run
	// if (!isMulti)
	// {
	// if (_theObservers != null)
	// {
	// loadThisObserverList(controlFile, _theObservers);
	// }
	// }
	//
	// // what's the index of the multi-run scenario tab?
	// final int tgtIndex = (isMulti) ? 1 : 0;
	//
	// // ui update, put it in an async operation
	// // updating the text items has to be done in the UI thread. make it
	// // so
	// Display.getDefault().asyncExec(new Runnable()
	// {
	// public void run()
	// {
	// // show the correct tab
	// _myUI.getScenarioTabs().setSelection(tgtIndex);
	//
	// if (isMulti)
	// {
	// // ok, enable the relevant elements
	// updateMultiTab();
	//
	// // set the selection object to nothing
	// setSelection(null);
	// }
	// else
	// {
	// // and enable the relevant elements
	// updateSingleTab();
	//
	// // ok, now wrap it as an editable
	// EditableWrapper ew = new EditableWrapper(_scenarioWrapper);
	//
	// // and as a selection
	// StructuredSelection strSel = new StructuredSelection(ew);
	// setSelection(strSel);
	// }
	//
	// // and tell everybody
	// fireControllerChanged();
	// }
	// });
	//
	// }
	// catch (Exception e)
	// {
	// e.printStackTrace();
	// }
	// }
	//
	// /**
	// * tell the observers to stop listening to the subject scenario, and then
	// * ditch them
	// *
	// */
	// private void ditchObservers()
	// {
	// // and ditch any existing observers
	// if (_myObservers != null)
	// {
	// // are we in a multi-core run
	// if (_myMultiScenario == null)
	// {
	// // tell them all we're closing
	// if (_myScenario != null)
	// {
	// for (Iterator<ScenarioObserver> iterator = _myObservers.iterator();
	// iterator
	// .hasNext();)
	// {
	// ScenarioObserver thisO = iterator.next();
	// thisO.tearDown(_myScenario);
	// }
	// }
	// }
	// // and ditch the list
	// _myObservers.removeAllElements();
	// }
	// }
	//
	// private void updateSingleTab()
	// {
	// if (_myScenario != null)
	// _myUI.getSingleRunBtn().setEnabled(true);
	//
	// // clear the multi core scenario, just to be sure
	// _myMultiScenario = null;
	//
	// }
	//
	// /**
	// * convenience method for determining if we're in a single or multiple
	// * scenario run
	// *
	// * @return
	// */
	// private boolean inSingleScenarioRun()
	// {
	// return (_myMultiScenario == null);
	// }
	//
	// private void updateMultiTab()
	// {
	// // and disable the single run button
	// _myUI.getSingleRunBtn().setEnabled(false);
	// _myUI.getSingleScenarioStatus().setText("Pending");
	//
	// // ok, disable the run button,
	// _myUI.getRunBtn().setEnabled(false);
	//
	// // and now enable the genny button
	// _myUI.getDoGenerateButton().setEnabled(true);
	// }
	//
	// private IProject getAProject()
	// {
	// IProject res = null;
	// IProject[] projects = ResourcesPlugin.getWorkspace().getRoot()
	// .getProjects();
	// if (projects != null)
	// {
	// if (projects.length > 0)
	// res = projects[0];
	// }
	// return res;
	// }
	//
	// private static boolean isRelativePath(File tgtDir)
	// {
	// boolean res = true;
	//
	// String thePath = tgtDir.getPath();
	//
	// // use series of tests to check whether this is a relative path
	// if (thePath.length() == 0)
	// res = true;
	// else
	// {
	// if (thePath.contains(":"))
	// res = false;
	// if (thePath.contains("\\\\"))
	// res = false;
	// if (thePath.charAt(0) == '\\')
	// res = false;
	// if (thePath.contains("//"))
	// res = false;
	// if (thePath.charAt(0) == '/')
	// res = false;
	// }
	//
	// return res;
	// }
	//
	// private void loadThisObserverList(String controlFile,
	// Vector<ScenarioObserver> theObservers) throws FileNotFoundException
	// {
	// // add these observers to our scenario
	// for (int i = 0; i < theObservers.size(); i++)
	// {
	// // get the next observer
	// ScenarioObserver observer = theObservers.elementAt(i);
	//
	// // and add it to our list
	// _myObservers.add(observer);
	//
	// }
	//
	// setupObservers(_myScenario);
	//
	// }
	//
	// /**
	// * right - store ourselves into the supplied memento object
	// *
	// * @param memento
	// */
	// public void saveState(IMemento memento)
	// {
	// // let our parent go for it first
	// super.saveState(memento);
	//
	// if (_scenarioFileName != null)
	// memento.putString(SCENARIO_FILE_INDEX, _scenarioFileName);
	// if (_controlFileName != null)
	// memento.putString(CONTROL_FILE_INDEX, _controlFileName);
	//
	// if (_myTimeControlProps != null)
	// {
	// Duration stepSize = _myTimeControlProps.getAutoInterval();
	// String stepSizeStr = "" + stepSize.getValueIn(Duration.MILLISECONDS);
	// memento.putString("StepInterval", stepSizeStr);
	// }
	// }
	//
	// /*
	// * (non-Javadoc)
	// *
	// * @see org.eclipse.ui.part.ViewPart#init(org.eclipse.ui.IViewSite,
	// * org.eclipse.ui.IMemento)
	// */
	// public void init(IViewSite site, IMemento memento) throws PartInitException
	// {
	// // let the parent do its bits
	// super.init(site, memento);
	//
	// Vector<String> pendingFilenames = new Vector<String>();
	//
	// // are we showing the units column?
	// if (memento != null)
	// {
	// String scenFile = memento.getString(SCENARIO_FILE_INDEX);
	// if (scenFile != null)
	// {
	// pendingFilenames.add(scenFile);
	// }
	// String contFile = memento.getString(CONTROL_FILE_INDEX);
	// if (contFile != null)
	// {
	// pendingFilenames.add(contFile);
	// }
	//
	// // also, see if we have an auto-step size property
	// String stepSizeStr = memento.getString("StepInterval");
	// if (stepSizeStr != null)
	// {
	// // and store it.
	// Double duration = Double.valueOf(stepSizeStr);
	// _myPendingStepSize = new Duration(duration, Duration.MILLISECONDS);
	// }
	//
	// }
	//
	// // did we receive any?
	// if (pendingFilenames.size() > 0)
	// _myPendingFilenames = pendingFilenames.toArray(new String[]
	// {});
	//
	// }
	//
	// private void setupObservers(ScenarioType theScenario)
	// {
	// // and actually setup the observers
	// for (Iterator<ScenarioObserver> iterator = _myObservers.iterator();
	// iterator
	// .hasNext();)
	// {
	// ScenarioObserver thisO = iterator.next();
	// thisO.setup(theScenario);
	// }
	// }
	//
	// private void tearDownObservers(ScenarioType theScenario)
	// {
	// // and actually setup the observers
	// for (Iterator<ScenarioObserver> iterator = _myObservers.iterator();
	// iterator
	// .hasNext();)
	// {
	// ScenarioObserver thisO = iterator.next();
	// thisO.tearDown(theScenario);
	// }
	// }
	//
	// /**
	// * a scenario has been loaded, tell our listeners
	// *
	// */
	// private void fireScenarioChanged()
	// {
	// // do we know our controller?
	// if (inSingleScenarioRun())
	// {
	// _scenarioWrapper.fireNewScenario();
	//
	// // ok, change the time aswell
	// long time = _myScenario.getTime();
	// if (time != -1)
	// {
	// // tell the time managemr what we're looking at
	// _timeManager.setCurrentScenario(_myScenario);
	// _timeManager.setTime(this, new HiResDate(time), true);
	// }
	//
	// // also, re-initialise the observers
	// setupObservers(_myScenario);
	//
	// // and show the loaded status in the ui
	// setScenarioStatus(_myScenario, "Loaded");
	// }
	// }
	//
	// /**
	// * update the status in the UI
	// *
	// * @param scen
	// * the scenario we're updating
	// * @param text
	// * the text to display
	// */
	// private void setScenarioStatus(final ScenarioType scen, final String text)
	// {
	// // ui update, put it in an async operation
	// // updating the text items has to be done in the UI thread. make it
	// // so
	// Display.getDefault().asyncExec(new Runnable()
	// {
	// public void run()
	// {
	// if (scen == _myScenario)
	// {
	// if (!_myUI.getSingleScenarioStatus().isDisposed())
	// _myUI.getSingleScenarioStatus().setText(text);
	// }
	// }
	// });
	//
	// }
	//
	// /**
	// * a scenario controller has been loaded, tell our listeners
	// *
	// */
	// private void fireControllerChanged()
	// {
	// _scenarioWrapper.fireNewController();
	// }
	//
	// private String getFirstNodeName(String SourceXMLFilePath)
	// {
	// /* Check whether file is XML or not */
	// DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	// factory.setValidating(false);
	// factory.setNamespaceAware(true);
	// try
	// {
	// DocumentBuilder builder = factory.newDocumentBuilder();
	// Document document = builder.parse(SourceXMLFilePath);
	//
	// NodeList nl = document.getElementsByTagName("*");
	// return nl.item(0).getNodeName();
	// }
	// catch (IOException ioe)
	// {
	// // ioe.printStackTrace();
	// return null;
	// // return "Not Valid XML File";
	// }
	// catch (Exception sxe)
	// {
	// // Exception x = sxe;
	// return null;
	// // x.printStackTrace();
	// // return "Not Valid XML File";
	// }
	//
	// }
	//
	// private void contributeToActionBars()
	// {
	// IActionBars bars = getViewSite().getActionBars();
	// fillLocalPullDown(bars.getMenuManager());
	// fillLocalToolBar(bars.getToolBarManager());
	// }
	//
	// private void fillLocalPullDown(IMenuManager manager)
	// {
	// manager.add(_viewInPlotter);
	// manager.add(new Separator());
	// manager.add(_actionReloadDatafiles);
	// }
	//
	// private void fillLocalToolBar(IToolBarManager manager)
	// {
	// manager.add(_viewInPlotter);
	// manager.add(_actionReloadDatafiles);
	// }
	//
	// private void makeActions()
	// {
	// _viewInPlotter = new Action()
	// {
	// public void run()
	// {
	// openPlotter();
	// }
	// };
	// _viewInPlotter.setText("View in LPD");
	// _viewInPlotter.setToolTipText("View 2D overview of scenario");
	// _viewInPlotter.setImageDescriptor(CorePlugin
	// .getImageDescriptor("icons/overview.gif"));
	//
	// _actionReloadDatafiles = new Action()
	// {
	// public void run()
	// {
	// reloadDataFiles();
	// }
	// };
	// _actionReloadDatafiles.setText("Reload");
	// _actionReloadDatafiles.setToolTipText("Reload data files");
	// ImageDescriptor desc = CorePlugin.getImageDescriptor("icons/repaint.gif");
	// _actionReloadDatafiles.setImageDescriptor(desc);
	// }
	//
	// protected void openPlotter()
	// {
	// IWorkbenchPage page = this.getViewSite().getPage();
	// IEditorInput ie = new IEditorInput()
	// {
	// public boolean exists()
	// {
	// return true;
	// }
	//
	// public ImageDescriptor getImageDescriptor()
	// {
	// return ImageDescriptor.getMissingImageDescriptor();
	// }
	//
	// public String getName()
	// {
	// return "Pending";
	// }
	//
	// public IPersistableElement getPersistable()
	// {
	// return null;
	// }
	//
	// public String getToolTipText()
	// {
	// return "Pending plot";
	// }
	//
	// @SuppressWarnings("rawtypes")
	// public Object getAdapter(Class adapter)
	// {
	// return null;
	// }
	// };
	// try
	// {
	// // first, open the editor
	// page.openEditor(ie, "org.mwc.asset.ASSETPlotEditor");
	//
	// // now fire ourselves as active
	// activateMe();
	// }
	// catch (PartInitException e)
	// {
	// ASSETPlugin.logError(Status.ERROR, "trouble opening ScenarioPlotter", e);
	// e.printStackTrace();
	// }
	// }
	//
	// private void activateMe()
	// {
	// try
	// {
	// // just check we're alive - just in case we've been called before
	// // the init is complete
	// IWorkbenchPartSite site = getSite();
	// IWorkbenchWindow window = site.getWorkbenchWindow();
	// IWorkbenchPage page = window.getActivePage();
	// if (page != null)
	// {
	// // try to find our view first
	// IViewPart theView = page.findView(site.getId());
	// if (theView != null)
	// {
	// // cool, show it then
	// page.showView(site.getId());
	// }
	// }
	// }
	// catch (PartInitException e)
	// {
	// // demote this error, it happens quite frequently when we're still opening
	// ASSETPlugin
	// .logError(
	// Status.WARNING,
	// "failed to activate scenario controller - possible because trying to activing during init",
	// null);
	// }
	// }
	//
	// protected void reloadDataFiles()
	// {
	// // ok, force the data-files to be reloaded
	// if (_scenarioFileName != null)
	// filesDropped(new String[]
	// { _scenarioFileName });
	// if (_controlFileName != null)
	// filesDropped(new String[]
	// { _controlFileName });
	//
	// // re-initialise any scenarios
	// // do we know our controller?
	// if (inSingleScenarioRun())
	// {
	// // also, re-initialise the observers
	// setupObservers(_myScenario);
	//
	// // also, tell the scenario to restart itself
	// _myScenario.restart();
	//
	// // reset the start button
	// _myUI.getSingleRunBtn().setText(RUN_SCENARIO);
	// }
	//
	// // and clear the scenario table
	// _simTable.setInput(null);
	// }
	//
	// /**
	// * Passing the focus request to the viewer's control.
	// */
	// public void setFocus()
	// {
	// // viewer.getControl().setFocus();
	// }
	//
	// public void addSelectionChangedListener(ISelectionChangedListener listener)
	// {
	// if (_selectionListeners == null)
	// _selectionListeners = new Vector<ISelectionChangedListener>(0, 1);
	//
	// // see if we don't already contain it..
	// if (!_selectionListeners.contains(listener))
	// _selectionListeners.add(listener);
	// }
	//
	// public ISelection getSelection()
	// {
	// return _currentSelection;
	// }
	//
	// public void removeSelectionChangedListener(ISelectionChangedListener
	// listener)
	// {
	// _selectionListeners.remove(listener);
	// }
	//
	// public void setSelection(ISelection selection)
	// {
	// _currentSelection = selection;
	//
	// // and tell everybody about it
	// if (_selectionListeners != null)
	// {
	// // is there something there?
	// if (selection != null)
	// {
	// SelectionChangedEvent event = new SelectionChangedEvent(this,
	// _currentSelection);
	// for (ISelectionChangedListener thisL : _selectionListeners)
	// {
	// thisL.selectionChanged(event);
	// }
	// }
	// }
	// }
	//
	// //
	// ////////////////////////////////////////////////////////////////////////////////////////////////
	// // testing for this class
	// //
	// ////////////////////////////////////////////////////////////////////////////////////////////////
	// static public final class testMe extends junit.framework.TestCase
	// {
	// static public final String TEST_ALL_TEST_TYPE = "UNIT";
	//
	// public testMe(final String val)
	// {
	// super(val);
	// }
	//
	// @SuppressWarnings("synthetic-access")
	// public final void testRelativePathMethod()
	// {
	// super.assertEquals("failed to recognise drive", false,
	// isRelativePath(new File("c:\\test.rep")));
	// super.assertEquals("failed to root designator", false,
	// isRelativePath(new File("\\test.rep")));
	// super.assertEquals("failed to root designator", false,
	// isRelativePath(new File("\\\\test.rep")));
	// super.assertEquals("failed to root designator", false,
	// isRelativePath(new File("//test.rep")));
	// super.assertEquals("failed to root designator", false,
	// isRelativePath(new File("////test.rep")));
	// super.assertEquals("failed to recognise absolute ref", true,
	// isRelativePath(new File("test.rep")));
	// super.assertEquals("failed to recognise relative ref", true,
	// isRelativePath(new File("./test.rep")));
	// super.assertEquals("failed to recognise parent ref", true,
	// isRelativePath(new File("../test.rep")));
	// }
	// }
	//
	// public void addStoppedListener(PropertyChangeListener listener)
	// {
	// if (_scenStopSupport == null)
	// _scenStopSupport = new PropertyChangeSupport(listener);
	// _scenStopSupport.addPropertyChangeListener(listener);
	// }
	//
	// public void removeStoppedListener(PropertyChangeListener listener)
	// {
	// if (_scenStopSupport != null)
	// _scenStopSupport.removePropertyChangeListener(listener);
	// }
}