package doctorpublisher;

public class Doctor {

	private String doctor_ID;
	private String fname;
	private String lname;
	private String contact_no;
	private String specializing;
	private String experience_years;
	
	public Doctor(String doctor_ID, String fname, String lname, String contact_no, String specializing, String experience_years) {
		super();
		this.doctor_ID = doctor_ID;
		this.fname = fname;
		this.lname = lname;
		this.contact_no = contact_no;
		this.specializing = specializing;
		this.experience_years = experience_years;
	}
	
	//Getters 
	
	public String getDoctor_ID() {
		return doctor_ID;
	}
	public String getFname() {
		return fname;
	}
	public String getLname() {
		return lname;
	}
	public String getContact_no() {
		return contact_no;
	}
	public String getSpecializing() {
		return specializing;
	}
	public String getExperience_years() {
		return experience_years;
	}
	
	//Setters
	
	public void setDoctor_ID(String doctor_ID) {
		this.doctor_ID = doctor_ID;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public void setContact_no(String contact_no) {
		this.contact_no = contact_no;
	}
	public void setSpecializing(String specializing) {
		this.specializing = specializing;
	}
	public void setExperience_years(String experience_years) {
		this.experience_years = experience_years;
	}
	
	


	


}
