package com.fssa.spartansmt.util;

import java.sql.Connection;
import java.sql.DriverManager;

import com.fssa.spartansmt.logger.Logger;

import io.github.cdimascio.dotenv.Dotenv;

public class ConnectionUtil {
	
	// Default Constructor
	public ConnectionUtil() {
		// TODO Auto-generated constructor stub
	}

	public static Connection getConnection() {
		Connection con = null;

		String url;
		String username;
		String password;

		if (System.getenv("CI") != null) {
			url = System.getenv("DATABASE_HOST");
			username = System.getenv("DATABASE_USERNAME");
			password = System.getenv("DATABASE_PASSWORD");
		} else {
			Dotenv env = Dotenv.load();
			url = env.get("DATABASE_HOST");
			username = env.get("DATABASE_USERNAME");
			password = env.get("DATABASE_PASSWORD");
		}

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

}
