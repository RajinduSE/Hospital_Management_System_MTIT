package hospitaladmissionpublisher;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {

	private ServiceRegistration serviceRegistration; 
	
	public void start(BundleContext bundleContext) throws Exception {
		System.out.println("Hospital Admission service started");
		AdmissionServicePublish admissionServicePublish = new AdmissionServicePublishImpl();
		serviceRegistration = bundleContext.registerService(AdmissionServicePublish.class.getName(), admissionServicePublish, null);
	}

	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("Hospital Admission service stopped");
		serviceRegistration.unregister();
	}

}
