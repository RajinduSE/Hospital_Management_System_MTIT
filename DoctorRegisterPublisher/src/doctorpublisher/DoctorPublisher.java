package doctorpublisher;
import java.util.List;

import org.omg.CORBA.PUBLIC_MEMBER;

public interface DoctorPublisher {
	
	public String addDoctor(String doctor_ID, String fname, String lname, String contact_no, String specializing, String experience_years);
	public List <Doctor> getAllDoctors();
	public void deleteDoctor(String doctor_ID);
}
