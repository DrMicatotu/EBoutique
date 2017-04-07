package fr.m2i.formation.jdbc;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.mysql.jdbc.PreparedStatement;

import fr.m2i.formation.dto.Catalogue;
import fr.m2i.formation.dto.Product;

public class JDBCFunctionalization {

	static Connection connection = null;

  public static Connection getConnection() throws ClassNotFoundException, SQLException{
	  
		Class.forName("com.mysql.jdbc.Driver");
	
	  connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/eboutique","root", "mehdi");
	  
	  return connection;
  }
  /*
  public static void getDB(Catalogue catalogue) throws ClassNotFoundException, SQLException {
	  
	  getConnection();
	  
	  if (connection != null) {
		  PreparedStatement prep;
		  try {
			prep = (PreparedStatement) connection.prepareStatement("SELECT * FROM Product");
			ResultSet rs = prep.executeQuery();
			rs.first();
			while (rs.next()) {
				int idProduct = rs.getInt("id");
				String name = rs.getString("name");
				Double price = rs.getDouble("selling_price");
				catalogue.getList().add(new Product(idProduct, name, price));
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	  }
  
  }
  */
//	System.out.println("-------- MySQL JDBC Connection Testing ------------");

	//try {
	//	Class.forName("com.mysql.jdbc.Driver");
	//} catch (ClassNotFoundException e) {
	//	System.out.println("Where is your MySQL JDBC Driver?");
	//	e.printStackTrace();
	//	return;
	//}

	//System.out.println("MySQL JDBC Driver Registered!");
	//Connection connection = null;

	//try {
	//	connection = DriverManager
	//	.getConnection("jdbc:mysql://localhost:3306/database","root", "password");

	//} catch (SQLException e) {
	//	System.out.println("Connection Failed! Check output console");
	//	e.printStackTrace();
	//	return;
	//}

	//if (connection != null) {
	//	System.out.println("You made it, take control your database now!");
		
		// selectSQL = "SELECT USER_ID, USERNAME FROM DBUSER WHERE USER_ID = ?";
		//PreparedStatement preparedStatement = dbConnection.prepareStatement(selectSQL);
		//preparedStatement.setInt(1, 1001);
		//ResultSet rs = preparedStatement.executeQuery();
		//while (rs.next()) {
		//String userid = rs.getString("USER_ID");
		//String username = rs.getString("USERNAME");
	//}
		
	//} else {
	//	System.out.println("Failed to make connection!");
	//}
}