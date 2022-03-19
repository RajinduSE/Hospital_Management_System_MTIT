package labproducer;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;

import com.mysql.jdbc.Connection;

import hospitaldb.HospitalDatabase;


public class Activator implements BundleActivator {

	private ServiceRegistration<?> serviceRegistration;
	private ServiceReference<?> serviceReference;

	public void start(BundleContext bundleContext) throws Exception {
		System.out.println("Lab Producer Started");
		
		// get db service
		serviceReference = bundleContext.getServiceReference(HospitalDatabase.class.getName());
		HospitalDatabase hospitalDb = (HospitalDatabase) bundleContext.getService(serviceReference);
		
		Connection conn = (Connection) hospitalDb.getDatabaseConnection();
		
		// register service
		LabServiceProducer producer = new LabServiceProducerImpl(conn);
		serviceRegistration = bundleContext.registerService(LabServiceProducer.class.getName(), producer, null);
		
		
	}

	public void stop(BundleContext bundleContext) throws Exception {
		serviceRegistration.unregister();
	}

}
