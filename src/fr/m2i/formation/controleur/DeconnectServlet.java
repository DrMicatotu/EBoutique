package fr.m2i.formation.controleur;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.m2i.formation.dto.Product;
import fr.m2i.formation.dto.User;
import fr.m2i.formation.service.impl.ProductManager;
import fr.m2i.formation.service.impl.UserManager;

public class DeconnectServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		

		
		try {
			HttpSession session = request.getSession();
			session.invalidate();
			request.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(request, response);
		} catch (ServletException e) {

			e.printStackTrace();
		}
	}
	

}
