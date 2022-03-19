package hospitaladmissionpublisher;

public class Admission {
	private int admissionID;
	private String patientName;
	private String address;
	private String phone;
	private String admissionDate;
	private int admissionType;
	
	public Admission() {
		super();
	}

	public Admission(int admissionID, String patientName, String address, String phone, String admissionDate, int admissionType) {
		super();
		this.admissionID = admissionID;
		this.patientName = patientName;
		this.address = address;
		this.phone = phone;
		this.admissionDate = admissionDate;
		this.admissionType = admissionType;
	}

	public int getAdmissionID() {
		return admissionID;
	}

	public void setAdmissionID(int admissionID) {
		this.admissionID = admissionID;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAdmissionDate() {
		return admissionDate;
	}

	public void setAdmissionDate(String admissionDate) {
		this.admissionDate = admissionDate;
	}

	public int getAdmissionType() {
		return admissionType;
	}

	public void setAdmissionType(int admissionType) {
		this.admissionType = admissionType;
	}
}
