package doctorconsumer;

import doctorpublisher.DoctorPublisher;

import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

public class ServiceActivator implements BundleActivator {

      ServiceReference serviceReference;
      Scanner sc = new Scanner(System.in);

	public void start(BundleContext context) throws Exception {
			System.out.println("Started Subscriber service");
			serviceReference = context.getServiceReference(DoctorPublisher.class.getName());
			
			DoctorPublisher doctorPublisher = (DoctorPublisher)context.getService(serviceReference);
		     DoctorService doctorService = new DoctorServiceImpl();
		     doctorService.getService(doctorPublisher);      
	}

	public void stop(BundleContext context) throws Exception {
		System.out.println("Stoped Subscriber Service");
	
	}

}
