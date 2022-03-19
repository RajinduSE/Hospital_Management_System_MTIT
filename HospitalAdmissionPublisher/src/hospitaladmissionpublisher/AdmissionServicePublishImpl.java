package hospitaladmissionpublisher;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import hospitaldb.HospitalDatabase;
import hospitaldb.HospitalDatabaseImpl;

public class AdmissionServicePublishImpl implements AdmissionServicePublish {
	// database connection
	private Connection conn = null;
	private Statement stmt = null;
	private HospitalDatabase db;
	private ResultSet rs;
	
	Scanner sc = new Scanner(System.in);
	
	public AdmissionServicePublishImpl() {
		super();
		db = new HospitalDatabaseImpl();
		conn = db.getDatabaseConnection();
	}
	
	//method to admit a patient
	@Override
	public void insertAdmission() {
		Admission admission = new Admission();
		System.out.println("------------------- Care Plus Hospital : Admission -------------------");
		
		System.out.print("Ënter Patient Name : ");
		admission.setPatientName(sc.nextLine().trim());
		
		System.out.print("Enter Patient address : ");
		admission.setAddress(sc.nextLine().trim());
		
		System.out.print("Enter Patient Phone Number : ");
		admission.setPhone(sc.nextLine().trim());
		
		System.out.print("Enter Admission Date (dd/mm/yyyy) : ");
		admission.setAdmissionDate(sc.nextLine().trim());
		
		System.out.print("Enter 1 for paying wards and 0 for normal wards : ");
		int type = Integer.parseInt(sc.nextLine().trim());

		if(type == 1) {
			admission.setAdmissionType(1);
		}else {
			admission.setAdmissionType(0);
		}
		
		String query = "INSERT INTO admissions(patientName, address, phone, admissionDate, admissionType) "
				+ "VALUES('"+ admission.getPatientName() +"', '"+ admission.getAddress() +"', '"+ admission.getPhone() +"', '"+ admission.getAdmissionDate() + "', '"+ admission.getAdmissionType() + "')";
		
		try {
			stmt = conn.createStatement();
			stmt.executeUpdate(query);
			System.out.println("Patient Admitted ...");
		} catch (SQLException exc) {
			System.out.println("Error in Patient Admission");
			System.out.println(exc.getMessage());
		}
	}
	
	@Override
	public void getAllAdmissions() {
		//Admission admission = new Admission();
		String query = "SELECT * FROM admissions";
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
	    	  System.out.printf("---------------------------------------------------------------------------------------------------------------------------------\n");	
	    	  System.out.printf("\n%20s %20s %20s %20s %20s %20s\n","Admission ID","Patient Name","Address","Phone number","Admission date","Admission Type");
	    	  System.out.printf("---------------------------------------------------------------------------------------------------------------------------------\n");	
		      while (rs.next()) {  
		    	  System.out.printf("%20d %20s %20s %20s %20s %20d\n",rs.getInt("admissionID"),rs.getString("patientName"),rs.getString("address"),rs.getString("phone"),rs.getString("admissionDate"),rs.getInt("admissionType"));		    

		      }
		} catch (SQLException exc) {
			System.out.println("Error getting admissions");
			System.out.println(exc.getMessage());
		}
	}
	
	@Override
	public void getAdmissionByPatientName() {
		String patientName;
		
		System.out.print("Enter patient name : ");
		patientName = sc.nextLine().trim();
		
		String query = "SELECT * FROM admissions WHERE patientName = '"+ patientName +"'";
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			System.out.printf("---------------------------------------------------------------------------------------------------------------------------------\n");	
	    	  System.out.printf("\n%20s %20s %20s %20s %20s %20s\n","Admission ID","Patient Name","Address","Phone number","Admission date","Admission Type");
	    	  System.out.printf("---------------------------------------------------------------------------------------------------------------------------------\n");	
		    while (rs.next()) {    	  
		    	  System.out.printf("%20d %20s %20s %20s %20s %20d\n",rs.getInt("admissionID"),rs.getString("patientName"),rs.getString("address"),rs.getString("phone"),rs.getString("admissionDate"),rs.getInt("admissionType"));		    	
		    }
		      
		} catch (SQLException exc) {
			System.out.println("Error getting admission");
			System.out.println(exc.getMessage());
		}
		
	}
	@Override
	public void deleteAdmission() {
		String patientName, admissionDate;
		
		System.out.print("Enter patient name : ");
		patientName = sc.nextLine().trim();
		
		System.out.print("Enter admission date ( dd/mm/yyyy ): ");
		admissionDate = sc.nextLine().trim();
		
		try {
			
			stmt = conn.createStatement();
			stmt.executeUpdate("delete from admissions where patientName='"+patientName+"' and admissionDate='"+admissionDate+"'");
			System.out.println("Successfully deleted admission\n");

		} catch (SQLException exc) {
			System.out.println("Error with deleting admission");
			System.out.println(exc.getMessage());
		}
		
	}
	
	@Override
	public void getPayingNormal() {
		List<Admission> normalAdmission = new ArrayList<>();
		List<Admission> payingAdmission = new ArrayList<>();
		
		String query = "SELECT * FROM admissions";

		try {
			 stmt = conn.createStatement();
			 rs = stmt.executeQuery(query);
			 
		      while (rs.next()) {
		    	  Admission admission = new Admission();
		    	  admission.setAdmissionID(rs.getInt("admissionID"));
		    	  admission.setPatientName(rs.getString("patientName"));
		    	  admission.setAddress(rs.getString("address"));
		    	  admission.setPhone(rs.getString("phone"));
		    	  admission.setAdmissionDate(rs.getString("admissionDate"));
		    	  admission.setAdmissionType(rs.getInt("admissionType"));
		    	  
		    	  
		    	  
		    	  if(rs.getString("admissionType").equals("1")) {
		    		  payingAdmission.add(admission);
		    	  }
		    	  else if(rs.getString("admissionType").equals("0")) {
		    		  normalAdmission.add(admission);
		    	  }
		    	  
		    	   		  	    		  
		      }   
		      
		      System.out.println("\n\n Enter (1) to get the paying admission list and (0) to get the normal admission list");
		      int input = sc.nextInt();
		      if(input == 1) {
		    	  if(payingAdmission.size() > 0) {
		    		  System.out.printf("---------------------------------------------------------------------------------------------------------------------------------\n");	
			    	  System.out.printf("%20s %20s %20s %20s %20s %20s\n","Admission ID","Patient Name","Address","Phone number","Admission date","Admission Type");
			    	  System.out.printf("---------------------------------------------------------------------------------------------------------------------------------\n");	
				      for(Admission a: payingAdmission){
				    	  System.out.printf("\n%20d %20s %20s %20s %20s %20d\n", a.getAdmissionID(), a.getPatientName(), a.getAddress(), a.getPhone(), a.getAdmissionDate(), a.getAdmissionType());

				      } 
			      }else {
			    	  System.out.println("\t\tNo patients for paying wards\n\n");
			      }
		      }else if(input == 0) {
		    	  if(normalAdmission.size() > 0) {
		    		  System.out.printf("---------------------------------------------------------------------------------------------------------------------------------\n");	
			    	  System.out.printf("%20s %20s %20s %20s %20s %20s\n","Admission ID","Patient Name","Address","Phone number","Admission date","Admission Type");
			    	  System.out.printf("---------------------------------------------------------------------------------------------------------------------------------\n");	
				      for(Admission a: normalAdmission){
				    	  System.out.printf("\n%20d %20s %20s %20s %20s %20d\n",a.getAdmissionID(), a.getPatientName(), a.getAddress(), a.getPhone(), a.getAdmissionDate(), a.getAdmissionType());   	

				      } 
			      }else {
			    	  System.out.println("\t\tNo patients for normal wards\n\n");
			      }
		      }
		} catch (SQLException exc) {
			System.out.println("Error ");
			System.out.println(exc.getMessage());
		}
		
	}

}
