package doctorpublisher;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class ServiceActivator implements BundleActivator {

	ServiceRegistration doctorServiceRegistration;
	
	public void start(BundleContext context) throws Exception {
		    System.out.println("Publisher Service Started");
            DoctorPublisher doctorPublisher = new DoctorPublishImpl();
            doctorServiceRegistration = context.registerService(DoctorPublisher.class.getName(), doctorPublisher, null);		
	}

	public void stop(BundleContext Context) throws Exception {
		   System.out.println("Publisher Service Stopped");
		  // doctorServiceRegistration.unregister();
		
	}

}
