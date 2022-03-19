package medicinepublisher;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import hospitaldb.HospitalDatabase;
import hospitaldb.HospitalDatabaseImpl;

public class MedicinePublisherImpl implements MedicinePublisher {
	// database connection
	private Connection conn = null;
	private Statement stmt = null;
	private HospitalDatabase db;
	private ResultSet rs;
		
	Scanner sc = new Scanner(System.in);
	
	public MedicinePublisherImpl() {
		super();
		db = new HospitalDatabaseImpl();
		conn = db.getDatabaseConnection();
	}
	
	@Override
	public void insertMedicine() {
		Medicine medicine = new Medicine();
		System.out.println("------------------- Care Plus Hospital : Medicine -------------------");
		
		System.out.print("Ënter Medicine Name : ");
		medicine.setName(sc.nextLine().trim());;
		
		System.out.print("Enter Medicine Brand : ");
		medicine.setBrand(sc.nextLine().trim());
		
		System.out.print("Enter Medicine Color : ");
		medicine.setColor(sc.nextLine().trim());
		
		System.out.print("Enter Medcine Weight: ");
		medicine.setWeight(sc.nextLine().trim());
		
		String query = "INSERT INTO medicine(name, brand, color, weight) "
				+ "VALUES('"+ medicine.getName() +"', '"+ medicine.getBrand() +"', '"+ medicine.getColor() +"', '"+ medicine.getWeight() + "')";
		
		try {
			stmt = conn.createStatement();
			stmt.executeUpdate(query);
			System.out.println("Medicine Added ...");
		} catch (SQLException exc) {
			System.out.println("Error in Medicine");
			System.out.println(exc.getMessage());
		}
		
	}

	@Override
	public void deleteMedicine() {
String name;
		
		System.out.print("Enter medicine name : ");
		name = sc.nextLine().trim();
		
		try {
			
			stmt = conn.createStatement();
			stmt.executeUpdate("delete from medicine where name='"+name+"'");
			System.out.println("Successfully deleted medicine\n");

		} catch (SQLException exc) {
			System.out.println("Error with deleting medicine");
			System.out.println(exc.getMessage());
		}
		
	}

}
