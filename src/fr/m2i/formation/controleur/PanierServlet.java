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

	/*
	 * public void doPost(HttpServletRequest request, HttpServletResponse
	 * response) throws IOException {
	 * 
	 * String str = request.getParameter("id").replaceAll("/", ""); int id =
	 * Integer.parseInt(str); ProductManager manager = new ProductManager();
	 * 
	 * Product prdPanier = manager.getProduct(id);
	 * request.setAttribute("prdPanier", prdPanier);
	 * 
	 * try {
	 * request.getRequestDispatcher("/WEB-INF/view/panier.jsp").forward(request,
	 * response); } catch (ServletException e) {
	 * 
	 * e.printStackTrace(); }
	 * 
	 * }
	 */

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		

		/*
		 * Cookie[] cookies = request.getCookies();
		 * 
		 * for (int i = 0; i < cookies.length; i++) { Cookie MonCookie =
		 * cookies[i]; if (MonCookie.getName().equals("Cart")) {
		 * 
		 * String Valeur = cookies[i].getValue();
		 * 
		 * System.out.println(Valeur);
		 * 
		 * 
		 * try {
		 * 
		 * JSONObject obj = new JSONObject(Valeur); System.out.println(obj);
		 * 
		 * } catch (JSONException e) {
		 * 
		 * e.printStackTrace(); } }
		 * 
		 * }
		 */

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
