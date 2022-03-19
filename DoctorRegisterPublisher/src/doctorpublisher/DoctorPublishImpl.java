package doctorpublisher;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import doctorpublisher.Doctor;
import doctorpublisher.DoctorPublisher;

public class DoctorPublishImpl implements DoctorPublisher {
	
	public List<Doctor> doctors = new ArrayList<Doctor>();

	//adding a new record 
	@Override
	public String addDoctor(String doctor_ID, String fname, String lname, String contact_no, String specializing, String experience_years) {
          Doctor doctor = new Doctor (doctor_ID, fname,lname,contact_no,specializing,experience_years);
          doctors.add(doctor);
          return "New Record: " + doctor.getFname() + " " + doctor.getLname() + " " + "added successfully to the portal";
     
	}

	//Get all records 
	@Override
	public List <Doctor> getAllDoctors() {
		return doctors;
			
	}

	//Delete Record
	@Override
	public void deleteDoctor(String doctor_ID) {
	    for(Doctor doctor : doctors) {
	    	if(doctor.getDoctor_ID().equalsIgnoreCase(doctor_ID)) {
	    		int id =doctors.indexOf(doctor);
	    		doctors.remove(id);
	    		System.out.println("Delete Doctor Record" + id + "Successfully");
	    		return ;
	    	}
	    }
		
	}
	
	
	
}
