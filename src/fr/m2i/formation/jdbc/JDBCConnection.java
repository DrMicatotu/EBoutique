//package fr.m2i.formation.jdbc;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//import com.mysql.jdbc.PreparedStatement;
//
//public class JDBCConnection {
//
//	public static void main(String[] argv) {
//
//		System.out.println("-------- MySQL JDBC Connection Testing ------------");
//
//		try {
//			Class.forName("com.mysql.jdbc.Driver");
//		} catch (ClassNotFoundException e) {
//			System.out.println("Where is your MySQL JDBC Driver?");
//			e.printStackTrace();
//			return;
//		}
//
//		System.out.println("MySQL JDBC Driver Registered!");
//		Connection connection = null;
//
//		try {
//			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/eboutique", "root", "Pass1234");
//
//		} catch (SQLException e) {
//			System.out.println("Connection Failed! Check output console");
//			e.printStackTrace();
//			return;
//		}
//
//		if (connection != null) {
//			System.out.println("You made it, take control of your database now!");
//			PreparedStatement prep;
//			try {
//				prep = (PreparedStatement) connection.prepareStatement("SELECT * FROM Product");
//				System.out.println();
//				ResultSet rs = prep.executeQuery();
//				while (rs.next()) {
//					int idProduct = rs.getInt("id");
//					String name = rs.getString("name");
//					Double price = rs.getDouble("selling_price");
//					System.out.println(idProduct + " | " + name + " - " + price + " €");
//				}
//			} catch (SQLException e) {
//				
//				e.printStackTrace();
//				
//			}
//
//			// Product product = new Product();
//			// product.setName(name);
//
//			// selectSQL = "SELECT USER_ID, USERNAME FROM DBUSER WHERE USER_ID =
//			// ?";
//			// PreparedStatement preparedStatement =
//			// dbConnection.prepareStatement(selectSQL);
//			// preparedStatement.setInt(1, 1001);
//			// ResultSet rs = preparedStatement.executeQuery();
//			// while (rs.next()) {
//			// String userid = rs.getString("USER_ID");
//			// String username = rs.getString("USERNAME");
//
//		} else {
//			System.out.println("Failed to make connection!");
//		}
//	}
//}
