package com.fssa.spartansmt.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import io.github.cdimascio.dotenv.Dotenv;

public class ConnectionUtil {

	public static Connection getConnection() throws SQLException {

		Connection con = null;

		Dotenv env = Dotenv.load();
		String host = env.get("DATABASE_HOST");
		String username = env.get("DATABASE_USERNAME");
		String password = env.get("DATABASE_PASSWORD");

		try {
			con = DriverManager.getConnection(host, username, password);
			System.out.println("Connection successfull");
		} catch (SQLException ex) {
			ex.printStackTrace();
			throw new RuntimeException("Unable to connect to the database");
		}
		return con;

	}

	public static void main(String[] args) {

		try {
			Connection con = getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
