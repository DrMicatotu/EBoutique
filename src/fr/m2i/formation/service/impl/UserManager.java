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

import fr.m2i.formation.dto.Product;
import fr.m2i.formation.dto.User;
import fr.m2i.formation.dto.Internaute;
import fr.m2i.formation.dto.Commercial;
import fr.m2i.formation.service.IUserManager;

public class UserManager implements IUserManager {

	Connection connection = null;
	Context initContext;

	@Override
	public User authenticate(String login, String password) {

		try {
			Context initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:comp/env");
			DataSource ds = (DataSource) envContext.lookup("jdbc/eboutiqueDb");
			connection = ds.getConnection();

			if (connection != null) {
				PreparedStatement prep;
				String sql = "select g.group_id FROM user_has_group as g inner join  emarket_user as u on g.login = u.login where u.login=? and u.password=?";
				PreparedStatement statement = connection.prepareStatement(sql);
				statement.setString(1, login);
				statement.setString(2, password);
				ResultSet rs = statement.executeQuery();

				if (rs.next()) {
					String group = rs.getString("group_id");
					if (group.equals("Commerciaux")) {
						return (new Commercial());
					} else {
						return (new Internaute());
					}
				}
				return null;

			}

		} catch (SQLException | NamingException e) {

			e.printStackTrace();
		}

		return null;
	}

}
