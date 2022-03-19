package doctorconsumer;

import java.util.List;
import java.util.Scanner;
import doctorpublisher.Doctor;
import doctorpublisher.DoctorPublisher;

public class DoctorServiceImpl implements DoctorService {
	
	String input;
	String doctor_ID;
	String fname;
	String lname;
	String contact_no;
	String specializing;
	String experience_years;
	Scanner sc = new Scanner(System.in);

	public static final String ADD ="add";
	public static final String All ="all";
	public static final String DELETE ="delete";
	
	@Override
	public void getService(DoctorPublisher doctorpublisher) {
	      System.out.println("=========== Welcome to the Hospital Management Admin Portal ============");
	      System.out.println();
	      System.out.println("Select the service you want. ");
	      System.out.println();
	      
	      while(true) {
	    	  input = getInput();
	    	  
	    	  if(input.equalsIgnoreCase(ADD)) {
	    		  addRecord(doctorpublisher);
	    	  }
	    	  else if (input.equalsIgnoreCase(All)) {
	    		  getAllRecords(doctorpublisher);
	    	  }
	    	  else if (input.equalsIgnoreCase(DELETE)) {
	    		  deleteRecord(doctorpublisher);
	    	  }
	    	  else {
	    		  System.out.println("Invalid");
	    	  }
	      }
		
	}

public String getInput() {
	   System.out.println("To Insert a record to the portal : Type Add");
	   System.out.println("To View records from the portal : Type All");
	   System.out.println("To Delete a record from the portal : Type Delete");
	   System.out.println();
	   String input =sc.nextLine();
	   return input;
	   
   }
   
   public void addRecord(DoctorPublisher doctorpublisher) {
	   System.out.println("Enter Doctor ID:");
	   doctor_ID = sc.nextLine();
	   
	   System.out.println("Enter Doctor's First Name:");
	   fname = sc.nextLine();
	   
	   System.out.println("Enter Doctor's Last Name");
	   lname = sc.nextLine();
	   
	   System.out.println("Enter Contact Number:");
	   contact_no = sc.nextLine();
	   
	   System.out.println("Enter Specialization Field:");
	   specializing = sc.nextLine();
	   
	   System.out.println("Enter Years of Experiences ");
	   experience_years = sc.nextLine();
	   
	   String temp = doctorpublisher.addDoctor(doctor_ID, fname, lname, contact_no, specializing, experience_years);
	   System.out.println(temp);
	   System.out.println();
   }
   
   public void getAllRecords(DoctorPublisher doctorpublisher) {
	   List<Doctor> doctors = doctorpublisher.getAllDoctors();
	   
	   System.out.println("Displaying all Doctors Registered ");
	   System.out.println();
	   
	   System.out.println("ID \t Full Name");
	   for(Doctor doctor : doctors ) {
		   
		   System.out.println(doctor.getDoctor_ID());
		   System.out.println("\t" +  doctor.getFname() + " " + doctor.getLname());
		   
		   System.out.println();
	   }
	   
	   System.out.println();
   }
   

   private void deleteRecord(DoctorPublisher doctorpublisher) {
		String doc_id;
		
		System.out.println("Enter Doctor's ID to be deleted: ");
		doc_id = sc.nextLine();
		doctorpublisher.deleteDoctor(doc_id);
		System.out.println();
	}
   
	

}
