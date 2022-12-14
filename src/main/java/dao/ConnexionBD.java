package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnexionBD {
	private static String url = "jdbc:mysql://localhost:3306/chatapp";
	private static String user = "root";
	private static String passwd = "root";
	private static Connection cn = null;

	public ConnexionBD() {
		try {
			cn = DriverManager.getConnection(url, user, passwd);
			System.out.println("c est bon connecta");
		} catch (Exception e) {
			System.out.println("maconectech");
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {
		if (cn == null) {
			System.out.println("y7b yconnecti");
			new ConnexionBD();
		}
		return cn;
	}

	public static void Fermer() {
		if (cn != null) {
			try {
				cn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}