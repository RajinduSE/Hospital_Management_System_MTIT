package labproducer;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class LabServiceProducerImpl implements LabServiceProducer {
	Connection conn;

	private static final String SQL_INSERT = "INSERT INTO reports(name, age, value, type) VALUES (?, ?, ?, ?)";
	private static final String SQL_SHOW_ALL = "SELECT * FROM reports";
	private static final String SQL_GET_BY_ID = "SELECT * FROM reports WHERE id=?";
	private static final String SQL_DELETE_BY_ID = "DELETE FROM reports WHERE id=?";
	private static final String SQL_GET_BY_NAME = "SELECT * FROM reports WHERE name=?";

	public LabServiceProducerImpl(Connection dbconn) {
		this.conn = dbconn;
	}

	@Override
	public void saveReport(String name, int age, String value, String type) throws SQLException {
		PreparedStatement stmt = (PreparedStatement) conn.prepareStatement(SQL_INSERT);

		stmt.setString(1, name);
		stmt.setInt(2, age);
		stmt.setString(3, value);
		stmt.setString(4, type);

		int row = stmt.executeUpdate();

		if (row == 1)
			System.out.println("Report added succesfully!");
	}

	@Override
	public void showAllReports() throws SQLException {
		Statement stmt = (Statement) conn.createStatement();

		ResultSet rs = stmt.executeQuery(SQL_SHOW_ALL);

		if (rs.next()) {
			System.out.println("ID\t|\tName\t\t|\tAge\t|\tValue");
			do {
				System.out.println(rs.getString(1) + "\t|\t" + rs.getString(2) + "\t\t|\t" + rs.getString(3) + "\t|\t"
						+ rs.getString(4) + " [" + rs.getString(5) + "]");
			} while (rs.next());
		} else {
			System.out.println("No records");
		}
	}

	@Override
	public void getReportByID(int id) throws SQLException {
		PreparedStatement stmt = (PreparedStatement) conn.prepareStatement(SQL_GET_BY_ID);

		stmt.setInt(1, id);

		ResultSet rs = stmt.executeQuery();

		if (rs.next()) {
			System.out.println("ID\t|\tName\t\t|\tAge\t|\tValue");
			do {
				System.out.println(rs.getString(1) + "\t|\t" + rs.getString(2) + "\t\t|\t" + rs.getString(3) + "\t|\t"
						+ rs.getString(4) + " [" + rs.getString(5) + "]");
			} while (rs.next());
		} else {
			System.out.println("No records");
		}

	}

	@Override
	public void getReportByName(String name) throws SQLException {
		PreparedStatement stmt = (PreparedStatement) conn.prepareStatement(SQL_GET_BY_NAME);

		stmt.setString(1, name);

		ResultSet rs = stmt.executeQuery();

		if (rs.next()) {
			System.out.println("ID\t|\tName\t\t|\tAge\t|\tValue");
			do {
				System.out.println(rs.getString(1) + "\t|\t" + rs.getString(2) + "\t\t|\t" + rs.getString(3) + "\t|\t"
						+ rs.getString(4) + " [" + rs.getString(5) + "]");
			} while (rs.next());
		} else {
			System.out.println("No records");
		}
	}

	@Override
	public void deleteReportByID(int id) throws SQLException {
		PreparedStatement stmt = (PreparedStatement) conn.prepareStatement(SQL_DELETE_BY_ID);

		stmt.setInt(1, id);

		int rows = stmt.executeUpdate();

		if(rows == 1) {
			System.out.println("Report deleted sucessfully!");
		}

	}

}
