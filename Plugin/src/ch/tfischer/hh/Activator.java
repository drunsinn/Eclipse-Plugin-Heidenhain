package ch.tfischer.hh;

import java.util.Optional;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ResourceLocator;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "ch.tfischer.hh"; //$NON-NLS-1$
	// The shared instance
	private static Activator plugin;
     	
	
	//private static ToolbarSelectionListener ToolbarSelectionListener;
	
	/**
	 * The constructor
	 */
	public Activator() {
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
	    IWorkbench iwb = PlatformUI.getWorkbench();
	    WBListener wbl = new WBListener();
	    iwb.addWorkbenchListener(wbl);
	    super.start(context);
		plugin = this;
		//ToolbarSelectionListener = new ToolbarSelectionListener();
		//ToolbarSelectionListener.hookOnViewer(View.ID);		
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static Activator getDefault() {
		return plugin;
	}

	/**
	 * Returns an image descriptor for the image file at the given
	 * plug-in relative path
	 *
	 * @param path the path
	 * @return the image descriptor
	 */
	public static Optional<ImageDescriptor> getImageDescriptor(String path) {
		return ResourceLocator.imageDescriptorFromBundle(PLUGIN_ID, path);
		//return imageDescriptorFromPlugin(PLUGIN_ID, path);
	}
}
