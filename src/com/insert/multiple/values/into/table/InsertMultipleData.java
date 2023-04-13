package com.insert.multiple.values.into.table;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.connection.ConnectionMain;

public class InsertMultipleData { 
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

			int rs = ps.executeUpdate();
			System.out.println("Data Inserted Succesfully..." + rs);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ps.close();
			connection.close();
		}
	}

	public static void main(String[] args) throws SQLException {
		// take Input From User
		for (int i = 0; i <= 5; i++) {
			System.out.println("Enter The First Name>>");
			@SuppressWarnings("resource")
			Scanner scanner = new Scanner(System.in);
			String firName = scanner.next();
			System.out.println("Enter Last Name>>");
			String lasName = scanner.next();
			System.out.println("Enter City>>");
			String city = scanner.next();
			System.out.println("Enter Mobile Number>>");
			String mobNum = scanner.next();

			// creating object of class to access the method
			InsertMultipleData isd = new InsertMultipleData();
			// passing values taken by user to the method
			isd.insertStudentData(firName, lasName, city, mobNum);
		}

	}

}
