package medicineconsumer;

import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import medicinepublisher.MedicinePublisher;

public class Activator implements BundleActivator {

	ServiceReference serviceReference; 

	public void start(BundleContext bundleContext) throws Exception {
		System.out.println("Stat Medicine Consumer Service");
		serviceReference = bundleContext.getServiceReference(MedicinePublisher.class.getName());
		@SuppressWarnings("unchecked")
		MedicinePublisher medicinePublisher = (MedicinePublisher) bundleContext.getService(serviceReference);
		showMedicineMenu(medicinePublisher);
	}

	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("Stop Hospital Consumer Service");
		bundleContext.ungetService(serviceReference);
	}

	public void showMedicineMenu(MedicinePublisher medicinePublisher) {
		int option;
		String choose = "y";
		
		Scanner sc = new Scanner(System.in);
		System.out.println("------------------- Care Plus Hospital : Medicine -------------------");
		Pharmacists p = new Pharmacists(medicinePublisher);
		
		System.out.println("1 - Insert a medicine");
		System.out.println("2 - Delete a medicine");
		
		System.out.println("Choose an option : ");
		
		option = Integer.parseInt(sc.nextLine().trim());
		
		switch(option) {
			case 1 : 
				while(choose.equals("y")) {
					System.out.println("\n\nDo you want to Add Another Medicine(y/n)");
					choose = sc.nextLine().trim();
		
					if(choose.equals("y")) {
						p.insertMedicine();
					}
				}
				showMedicineMenu(medicinePublisher);
				break;
			case 2 :
				p.deleteMedicine();
				showMedicineMenu(medicinePublisher);
				break;
			default :
				System.out.println("Incorrect Input...");
				showMedicineMenu(medicinePublisher);
		
		}
		
	}
}
