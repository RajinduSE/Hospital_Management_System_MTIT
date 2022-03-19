package hospitaladmissionconsumer;

import hospitaladmissionpublisher.AdmissionServicePublish;

public class Admin {
	AdmissionServicePublish admissionServicePublish;
	
	public Admin(AdmissionServicePublish admissionServicePublish) {
		super();
		this.admissionServicePublish = admissionServicePublish;
	}
	
	public void admit() {
		admissionServicePublish.insertAdmission();
	}
	
	public void getAllAdmissions() {
		admissionServicePublish.getAllAdmissions();
	}
	
	public void getAdmissionByPatientName() {
		admissionServicePublish.getAdmissionByPatientName();
	}
	
	public void deleteAdmission() {
		admissionServicePublish.deleteAdmission();
	}
	
	public void getPayingNormal() {
		admissionServicePublish.getPayingNormal();
	}
}
