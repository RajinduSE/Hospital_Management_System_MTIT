package labproducer;

import java.sql.SQLException;

public interface LabServiceProducer {
	
	public void saveReport(String name, int age, String value, String type) throws SQLException;
	public void showAllReports() throws SQLException;
	public void getReportByID(int id) throws SQLException;
	public void getReportByName(String name) throws SQLException;
	public void deleteReportByID(int id) throws SQLException;
}
