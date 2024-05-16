package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.DatabaseMetaData;

public class JDBCUtil{
	public static Connection getConnection() {
		Connection connection=null;
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			String urlString="jdbc:mySQL://localhost:3306/myweb";
			String usernameString="root";
			String passwordString="";
			connection=DriverManager.getConnection(urlString, usernameString, passwordString);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return connection;
		
	}
	
	public static void printInfo(Connection connection) {
		try {
			if(connection!=null) {
				DatabaseMetaData mtdt = connection.getMetaData();
				System.out.println(mtdt.getUserName()+mtdt.getDatabaseProductVersion()+mtdt.getDatabaseProductName());
			}
		} catch (SQLException e) {
				e.printStackTrace();
		}
	}
	
	public static void closeConnection(Connection connection) {
		if(connection!=null) {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
