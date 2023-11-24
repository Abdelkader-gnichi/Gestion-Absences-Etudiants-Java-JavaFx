package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataBaseAccess {
	public static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			conn = DriverManager.getConnection("jdbc:mysql://localhost/gestionabsencesetudiant", "demo", "1234");
			System.out.println("Connected");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
}
