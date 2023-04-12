package com.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionMain {

	// create a method which returns connection
	public Connection getConnection() {
		Connection connection = null;
		try {
			// step1- loading Driver class
			Class.forName("com.mysql.jdbc.Driver");

			// step2- establishing connection
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/assignment26", "root",
					"Yash_Mate@#2487");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}
}
