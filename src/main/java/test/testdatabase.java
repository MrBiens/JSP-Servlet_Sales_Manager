package test;

import java.sql.Connection;

import DAO.JDBCUtil;

public class testdatabase {
	public static void main(String[] args) {
		Connection connection=JDBCUtil.getConnection();
		System.out.println(connection);
		
	}
}
