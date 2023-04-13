package com.insert.single.value.into.table;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.connection.ConnectionMain;

public class InsertSingleData {
	Connection con = null;
	PreparedStatement pre = null;

	public void insertSingleData(String fName, String lName, String city, String mobNum) throws SQLException {
		try {
			// step1- calling connection
			ConnectionMain connectionMain = new ConnectionMain();
			con = connectionMain.getConnection();

			// step2- create prepare statement
			pre = con.prepareStatement("insert into user(firstName, lastName, city, mobileNumber)values(?,?,?,?)");

			pre.setString(1, fName);
			pre.setString(2, lName);
			pre.setString(3, city);
			pre.setString(4, mobNum);

			// step3- executing prepared statement
			int a = pre.executeUpdate();
			System.out.println("Data inserted succesfully..." + a);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.close();
			pre.close();
		}
	}

	public static void main(String[] args) throws SQLException {
		// getting input from user
		System.out.println("Enter First Name>>");
		Scanner scanner = new Scanner(System.in);
		String fName = scanner.next();
		System.out.println("Enter Second Name>>");
		String lName = scanner.next();
		System.out.println("Enter The City>>");
		String city = scanner.next();
		System.out.println("Enter The Mobile Number>>");
		String mobNum = scanner.next();

		InsertSingleData insertSingleData = new InsertSingleData();
		// calling method to insert the data which is entered by user
		insertSingleData.insertSingleData(fName, lName, city, mobNum);

	}

}
