package com.fssa.spartansmt.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {

	public static Connection getConnection() throws SQLException {
		
		Connection con = null;
		String url = "jdbc:mysql://localhost:3306/spartans_mt";
        String userName = "root";
        String passWord = "123456";
        
        try {
        	con = DriverManager.getConnection(url, userName, passWord);
        } catch(SQLException ex) {
        	ex.printStackTrace();
        	throw new RuntimeException("Unable to connect to the database");
        }
        return con;

	}
	
}
