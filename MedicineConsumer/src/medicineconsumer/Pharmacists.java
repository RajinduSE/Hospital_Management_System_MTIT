package medicineconsumer;

import medicinepublisher.MedicinePublisher;

public class Pharmacists {
	MedicinePublisher medicinePublisher;
	
	public Pharmacists(MedicinePublisher medicinePublisher) {
		super();
		this.medicinePublisher = medicinePublisher;
	}
	
	public void insertMedicine() {
		medicinePublisher.insertMedicine();
	}
	

	public void deleteMedicine() {
		medicinePublisher.deleteMedicine();
	}
	
}