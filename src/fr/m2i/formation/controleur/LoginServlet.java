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

public class LoginServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

		UserManager userManager = new UserManager();

		String login = request.getParameter("login");
		String password = request.getParameter("password");
		String admin = "Commercial"; //

		User user = userManager.authenticate(login, password);

		if (user == null) {

			try {
				boolean error = true;
				request.setAttribute("error", error);
				request.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(request, response);
			} catch (ServletException e) {

				e.printStackTrace();
			}
		} else {
			/*
			 * String[] dispatchUser =
			 * {"/WEB-INF/view/AcceuilAdmin.jsp","/WEB-INF/view/AcceuilUser.jsp"};
			 * String strMap = ("Commercial".equals(user.getRole())) ? dispatchUser[0] : dispatchUser[1];
			 */

			Map<String, String> mapUser = new HashMap<>();
			mapUser.put("Commercial", "/WEB-INF/view/AcceuilAdmin.jsp");
			mapUser.put("Internaute", "/WEB-INF/view/AcceuilUser.jsp");

			try {
				HttpSession session = request.getSession();
				session.setAttribute("identification", user.getRole());
				session.setAttribute("login", login);
				request.getRequestDispatcher(mapUser.get(user.getRole())).forward(request, response);
			} catch (ServletException e) {

				e.printStackTrace();
			}
		}
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		HttpSession session = request.getSession();
		
		try {
			if(session.getAttribute("identification").equals("Commercial")){
				
				request.getRequestDispatcher("/WEB-INF/view/AcceuilAdmin.jsp").forward(request, response);
				
			} else if(session.getAttribute("identification").equals("Internaute")){
				
				request.getRequestDispatcher("/WEB-INF/view/AcceuilUser.jsp").forward(request, response);
				
			} else {
				request.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(request, response);
			}
			
			
			
		} catch (ServletException e) {
			e.printStackTrace();
		}
	}

}
