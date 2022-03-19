package medicinepublisher;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {

	private ServiceRegistration serviceRegistration; 
	
	public void start(BundleContext bundleContext) throws Exception {
		System.out.println("Medicine Service Started");
		MedicinePublisher medicine = new MedicinePublisherImpl();
		serviceRegistration = bundleContext.registerService(MedicinePublisher.class.getName(), medicine, null);
	}

	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("Medicine service stopped");
		serviceRegistration.unregister();
	}

}
