package labsubscriber;

import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;

import labproducer.LabServiceProducer;
import labproducer.LabServiceProducerImpl;

public class Activator implements BundleActivator {

	private ServiceRegistration<?> serviceRegistration;
	private ServiceReference<?> serviceReference;

	public void start(BundleContext bundleContext) throws Exception {
		// get lab service
		serviceReference = bundleContext.getServiceReference(LabServiceProducer.class.getName());
		LabServiceProducer labService = (LabServiceProducer) bundleContext.getService(serviceReference);

		int option;
		Scanner sc = new Scanner(System.in);

		System.out.println(" ---------------");
		System.out.println("|  Lab Reports  |");
		System.out.println(" ---------------");

		do {
			System.out.println("\nSelect an option");
			System.out.println("|- 1 - Save Blood Pressure");
			System.out.println("|- 2 - Save Blood Sugar");
			System.out.println("|- 3 - View All Reports");
			System.out.println("|- 4 - View Report by ID");
			System.out.println("|- 5 - View Report by Name");
			System.out.println("|- 6 - Delete Report by ID");
			System.out.println("|- (-1) - Exit \n");
			System.out.print(">>> ");

			option = sc.nextInt();
			sc.nextLine();

			switch (option) {
			case 1: {
				System.out.print("Enter Patient Name: ");
				String name = sc.nextLine();

				System.out.print("Enter Patient Age: ");
				int age = sc.nextInt();
				sc.nextLine();

				System.out.print("Enter Blood Pressure (mm/Hg): ");
				String pressure = sc.nextLine();

				labService.saveReport(name, age, pressure + " (mm/Hg)", "Blood Pressure");

				break;
			}

			case 2: {
				System.out.print("Enter Patient Name: ");
				String name = sc.nextLine();

				System.out.print("Enter Patient Age: ");
				int age = sc.nextInt();
				sc.nextLine();

				System.out.print("Enter Blood Sugar Level (mg/dl): ");
				String sugar = sc.nextLine();

				labService.saveReport(name, age, sugar + " (mg/dl)", "Blood Sugar");

				break;
			}

			case 3: {
				labService.showAllReports();
				break;
			}

			case 4: {
				System.out.print("Enter Report ID: ");
				int id = sc.nextInt();
				sc.nextLine();

				labService.getReportByID(id);
				break;
			}

			case 5: {
				System.out.print("Enter Patient Name: ");
				String name = sc.nextLine();

				labService.getReportByName(name);
				break;
			}

			case 6: {
				System.out.print("Enter report ID: ");
				int id = sc.nextInt();
				sc.nextLine();

				labService.deleteReportByID(id);
				break;
			}

			case -1: {
				System.out.println("Exiting...");
				break;
			}
			default:
				System.out.println("Invalid Option");
			}

			System.out.println("\nPress ENTER key to continue...");
			sc.nextLine();

		} while (option != -1);
	}

	public void stop(BundleContext bundleContext) throws Exception {
		serviceRegistration.unregister();
	}

}
