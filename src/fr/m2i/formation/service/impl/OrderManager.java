package fr.m2i.formation.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.mysql.jdbc.Statement;

import fr.m2i.formation.dto.Catalogue;
import fr.m2i.formation.dto.Product;
import fr.m2i.formation.jdbc.JDBCFunctionalization;
import fr.m2i.formation.service.IOrderManager;
import fr.m2i.formation.service.IProductManager;

public class OrderManager implements IOrderManager {

	Connection connection = null;
	Context initContext;
	
	@Override
	public int createOrder(String user, double prix) {
		
		try {
			initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:comp/env");
			DataSource ds = (DataSource) envContext.lookup("jdbc/eboutiqueDb");
			connection = ds.getConnection();
			
			String sql = "INSERT INTO orders (user_login,prix_tot) VALUES(?,?)";
			PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			
			statement.setString(1, user);
			statement.setDouble(2, prix);
			int nbLignes = statement.executeUpdate();
			
			int id = 0;
			if (nbLignes != 0) {

				ResultSet rs = statement.getGeneratedKeys();
				while (rs.next()) {
					id = rs.getInt(1);
				}
			}
			connection.close();
			return id;
			
		} catch (SQLException | NamingException e) {

			e.printStackTrace();
		}
		return 0;

	}
		
		
	
	@Override
	public void createOrderRow(int idOrder, int idProduct,String nomProduct, double prixU, int quantity, String user) {
		
		try {
			initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:comp/env");
			DataSource ds = (DataSource) envContext.lookup("jdbc/eboutiqueDb");
			connection = ds.getConnection();
			
			String sql = "INSERT INTO orders_item (id_orders,id_product,nom_product,prix_unit,quantity) VALUES(?,?,?,?,?)";
			PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			
			statement.setInt(1, idOrder);
			statement.setInt(2, idProduct);
			statement.setString(3, nomProduct);
			statement.setDouble(4, prixU);
			statement.setInt(5, quantity);
			
			int nbLignes = statement.executeUpdate();
			
			
			connection.close();
			
			
		} catch (SQLException | NamingException e) {

			e.printStackTrace();
		}

	}
		
	
	@Override
	public List<?> getOrders() {
		
		return null;
	}
	@Override
	public List<?> getOrderRow() {
		
		return null;
	}

	

}
