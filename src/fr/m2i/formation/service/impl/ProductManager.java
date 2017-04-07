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
import fr.m2i.formation.service.IProductManager;

public class ProductManager implements IProductManager {

	Connection connection = null;
	Context initContext;

	@Override
	public void deleteProduct(int id) {

		try {
			initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:comp/env");
			DataSource ds = (DataSource) envContext.lookup("jdbc/eboutiqueDb");
			connection = ds.getConnection();

			String sql = "DELETE FROM product WHERE id=?";
			PreparedStatement statement = connection.prepareStatement(sql);

			statement.setInt(1, id);

			int nbLignes = statement.executeUpdate();

			connection.close();

		} catch (SQLException | NamingException e) {

			e.printStackTrace();
		}

	}

	@Override
	public void updateProduct(int id, double price) {
		try {
			initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:comp/env");
			DataSource ds = (DataSource) envContext.lookup("jdbc/eboutiqueDb");
			connection = ds.getConnection();

			String sql = "update product set selling_price=? where id=?";
			PreparedStatement statement = connection.prepareStatement(sql);

			statement.setDouble(1, price);
			statement.setInt(2, id);

			int nbLignes = statement.executeUpdate();

			connection.close();

		} catch (SQLException | NamingException e) {

			e.printStackTrace();
		}

	}

	@Override
	public void createProduct(Catalogue catalogue, String name, double price) {

		try {
			initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:comp/env");
			DataSource ds = (DataSource) envContext.lookup("jdbc/eboutiqueDb");
			connection = ds.getConnection();
			// Connection connection = JDBCFunctionalization.getConnection();
			// //connexion via jdbc mais mot de passe visible dans le code

			String sql = "INSERT INTO Product (name,selling_price) VALUES(?,?)";
			PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			// spécifier le SQL CIBLE
			statement.setString(1, name);
			statement.setDouble(2, price);
			int nbLignes = statement.executeUpdate(); // retourne nombre de
														// lignes
			int id = 0;
			if (nbLignes != 0) {

				ResultSet rs = statement.getGeneratedKeys();
				while (rs.next()) {
					id = rs.getInt(1);
				}
			}
			connection.close();
			Product prod = new Product(id, name, price);

			// objet catalogue

			catalogue.getList().add(prod);

		} catch (SQLException | NamingException e) {

			e.printStackTrace();
		}

	}

	@Override
	public List<Product> getProducts() {

		try {
			List<Product> listProd = new ArrayList<Product>();
			// Connection connection = JDBCFunctionalization.getConnection();
			Context initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:comp/env");
			DataSource ds = (DataSource) envContext.lookup("jdbc/eboutiqueDb");
			connection = ds.getConnection();

			if (connection != null) {
				PreparedStatement prep;

				prep = (PreparedStatement) connection.prepareStatement("SELECT * FROM Product");
				ResultSet rs = prep.executeQuery();

				while (rs.next()) {
					int idProduct = rs.getInt("id");
					String name = rs.getString("name");
					Double price = rs.getDouble("selling_price");
					listProd.add(new Product(idProduct, name, price));

				}
				connection.close();
				return listProd;
				
			}
		} catch (SQLException | NamingException e) {

			e.printStackTrace();
		}
		return null;

	}

	@Override
	public Product getProduct(int id) {

		Product prod = null;

		try {

			Context initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:comp/env");
			DataSource ds = (DataSource) envContext.lookup("jdbc/eboutiqueDb");
			connection = ds.getConnection();

			if (connection != null) {
				PreparedStatement prep;

				String sql = "select * FROM product where id=?";
				PreparedStatement statement = connection.prepareStatement(sql);
				statement.setInt(1, id);
				ResultSet rs = statement.executeQuery();

				while (rs.next()) {
					int idProduct = rs.getInt("id");
					String name = rs.getString("name");
					double price = rs.getDouble("selling_price");
					prod = new Product(idProduct, name, price);

				}
				connection.close();
			}
		} catch (SQLException | NamingException e) {

			e.printStackTrace();
		}

		return prod;

	}

	@Override
	public List<String> getInfo(int id) {
		List<String> info = new ArrayList<String>();
		info.add("");
		info.add("");
		info.add("");
		info.add("");

		try {

			Context initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:comp/env");
			DataSource ds = (DataSource) envContext.lookup("jdbc/eboutiqueDb");
			connection = ds.getConnection();

			if (connection != null) {
				PreparedStatement prep;

				String sql = "select p.description , c.name as name_component , pc.quantity, p.name as name_product, p.selling_price FROM product as p inner join  product_has_component as pc on (p.id=pc.product_id)  inner join component as c on (c.id=pc.component_id) where p.id=?";
				PreparedStatement statement = connection.prepareStatement(sql);
				statement.setInt(1, id);

				ResultSet rs = statement.executeQuery();

				while (rs.next()) {
					
					info.set(0, Integer.toString(id));
					info.set(1, rs.getString("name_product"));
					info.set(2, Integer.toString(rs.getInt("selling_price")));
					info.set(3, rs.getString("description"));
					

					info.add(rs.getString("name_component"));
					info.add(Integer.toString(rs.getInt("quantity")));

				}
				connection.close();
				return info;
				
			}
		} catch (SQLException | NamingException e) {

			e.printStackTrace();
		}
		return null;
	}

}
