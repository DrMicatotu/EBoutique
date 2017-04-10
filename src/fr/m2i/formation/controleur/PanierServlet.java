package fr.m2i.formation.controleur;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONException;
import org.json.JSONObject;

import fr.m2i.formation.dto.Product;
import fr.m2i.formation.service.impl.ProductManager;

public class PanierServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

		HttpSession session = request.getSession();
		try {
			if (session.getAttribute("identification") != null) {

				request.getRequestDispatcher("/WEB-INF/view/panier.jsp").forward(request, response);
			} else {
				request.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(request, response);
			}
		} catch (ServletException e) {

			e.printStackTrace();
		}
	}

}
