package hospitaldb;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class HospitalDatabaseImpl implements HospitalDatabase{
	
	private Connection conn;
	private final String driverName;
	private String databaseConnLink;
	private String user;
	private String password;
	
	public HospitalDatabaseImpl() {
		this.driverName = "com.mysql.jdbc.Driver";
		this.databaseConnLink = "jdbc:mysql://localhost:3306/hospital_db?characterEncoding=latin1&useConfigs=maxPerformance";
		this.user = "root";
		this.password = null;
	}

	@SuppressWarnings("finally")
	@Override
	public Connection getDatabaseConnection() {
		try {
			Class.forName(driverName);
			conn = (Connection) DriverManager.getConnection(databaseConnLink, user, password);
			System.out.println("Successfully connected to hospital DB");
		} catch (ClassNotFoundException exc) {
			System.out.println("Class not found");
			System.out.println(exc.getMessage());
		} catch (SQLException exc) {
			System.out.println("SQL Error");
			System.out.println(exc.getMessage());
		} finally {
			return conn;
		}
	}
}
