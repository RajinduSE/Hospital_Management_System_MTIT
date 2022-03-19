package hospitaldb;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {

	private ServiceRegistration serviceRegistration;

	public void start(BundleContext bundleContext) throws Exception {
		System.out.println("Hospital DB started");
		HospitalDatabase database = new HospitalDatabaseImpl();
		serviceRegistration = bundleContext.registerService(HospitalDatabase.class.getName(), database, null);
	}

	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("Hospital DB stopped");
		serviceRegistration.unregister();
	}

}
