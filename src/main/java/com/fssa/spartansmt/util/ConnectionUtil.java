package com.fssa.spartansmt.util;

import java.sql.Connection;
import java.sql.DriverManager;

import com.fssa.spartansmt.logger.Logger;

public class ConnectionUtil {

	private ConnectionUtil() {
		// Default Constructor
	}

	public static Connection getConnection() {
		Connection con = null;

		String url;
		String username;
		String password;

		url = System.getenv("DATABASE_HOST");
		username = System.getenv("DATABASE_USERNAME");
		password = System.getenv("DATABASE_PASSWORD");


		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, username, password);
			Logger.info("Connected");
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Unable to connect to the database");
		}
		return con;
	}

	public static void main(String[] args) {
		ConnectionUtil.getConnection();
	}
	
}
