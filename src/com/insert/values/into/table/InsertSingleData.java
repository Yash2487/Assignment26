package com.insert.values.into.table;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.connection.ConnectionMain;

public class InsertSingleData {
	PreparedStatement ps = null;
	Connection connection = null;

	private void insertStudentData(String fName, String lName, String city, String mobNo) throws SQLException {
		try {
			// call connection
			ConnectionMain connectionMain = new ConnectionMain();
			connection = connectionMain.getConnection();

			// create prepared statement
			ps = connection
					.prepareStatement("insert into user(firstName, lastName, city, mobileNumber)values(?,?,?,?)");

			ps.setString(1, fName);
			ps.setString(2, lName);
			ps.setString(3, city);
			ps.setString(4, mobNo);

			ResultSet rs = ps.executeQuery();
			System.out.println("Data Inserted Succesfully..." + rs);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ps.close();
			connection.close();
		}
	}

	public static void main(String[] args) {
		// take Input From User

	}

}
