package hospitaladmissionconsumer;

import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import hospitaladmissionpublisher.AdmissionServicePublish;


public class Activator implements BundleActivator {

	ServiceReference serviceReference; 

	public void start(BundleContext bundleContext) throws Exception {
		System.out.println("Stat Hospital Consumer Service");
		serviceReference = bundleContext.getServiceReference(AdmissionServicePublish.class.getName());
		@SuppressWarnings("unchecked")
		AdmissionServicePublish admissionServicePublish = (AdmissionServicePublish) bundleContext.getService(serviceReference);
		showHospitalMenu(admissionServicePublish);
	}

	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("Stop Hospital Consumer Service");
		bundleContext.ungetService(serviceReference);
	}

	public void showHospitalMenu(AdmissionServicePublish admissionServicePublish) {
		String wardType;
		int option;
		String choose = "y";
		
		Scanner sc = new Scanner(System.in);
		System.out.println("------------------- Care Plus Hospital : Admission -------------------");
		Admin admin = new Admin(admissionServicePublish);
		
		System.out.println("1 - Admit a patient");
		System.out.println("2 - Get all admissions");
		System.out.println("3 - Get admission by patient name");
		System.out.println("4 - Discharge a patient");
		System.out.println("5 - Get Paying/Normal admissions");
		
		System.out.println("Choose an option : ");
		
		option = Integer.parseInt(sc.nextLine().trim());
		
		switch(option) {
			case 1 : 
				while(choose.equals("y")) {
					System.out.println("\n\nDo you want to Add Another Patient(y/n)");
					choose = sc.nextLine().trim();
		
					if(choose.equals("y")) {
						admin.admit();
					}
				}
				showHospitalMenu(admissionServicePublish);
				break;
			case 2 :
				admin.getAllAdmissions();
				showHospitalMenu(admissionServicePublish);
				break;
			case 3 :
				admin.getAdmissionByPatientName();
				showHospitalMenu(admissionServicePublish);
				break;
			case 4 :
				admin.deleteAdmission();
				showHospitalMenu(admissionServicePublish);
				break;
			case 5 :
				admin.getPayingNormal();
				showHospitalMenu(admissionServicePublish);
				break;
			default :
				System.out.println("Incorrect Input...");
				showHospitalMenu(admissionServicePublish);
		
		}
		
	}
}
