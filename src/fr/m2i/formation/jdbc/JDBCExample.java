package fr.m2i.formation.jdbc;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class JDBCExample {

  public static void main(String[] argv) {

	System.out.println("-------- MySQL JDBC Connection Testing ------------");

	try {
		Class.forName("com.mysql.jdbc.Driver");
	} catch (ClassNotFoundException e) {
		System.out.println("Where is your MySQL JDBC Driver?");
		e.printStackTrace();
		return;
	}

	System.out.println("MySQL JDBC Driver Registered!");
	Connection connection = null;

	try {
		connection = DriverManager
		.getConnection("jdbc:mysql://localhost:3306/database","root", "Pass1234");

	} catch (SQLException e) {
		System.out.println("Connection Failed! Check output console");
		e.printStackTrace();
		return;
	}

	if (connection != null) {
		System.out.println("You made it, take control your database now!");
		
		// selectSQL = "SELECT USER_ID, USERNAME FROM DBUSER WHERE USER_ID = ?";
		//PreparedStatement preparedStatement = dbConnection.prepareStatement(selectSQL);
		//preparedStatement.setInt(1, 1001);
		//ResultSet rs = preparedStatement.executeQuery();
		//while (rs.next()) {
		//String userid = rs.getString("USER_ID");
		//String username = rs.getString("USERNAME");
	
		
	} else {
		System.out.println("Failed to make connection!");
	}
  }
}