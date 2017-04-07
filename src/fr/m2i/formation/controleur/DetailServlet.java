package fr.m2i.formation.controleur;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.m2i.formation.dto.Product;
import fr.m2i.formation.service.impl.ProductManager;

public class DetailServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

		String str = request.getParameter("id").replaceAll("/", "");
		int id = Integer.parseInt(str);

		ProductManager manager = new ProductManager();

		List<String> info = manager.getInfo(id);
		//Product produit = manager.getProduct(id);

		//request.setAttribute("produit", produit);
		request.setAttribute("info", info);

		try {
			request.getRequestDispatcher("/WEB-INF/view/details.jsp").forward(request, response);
		} catch (ServletException e) {

			e.printStackTrace();
		}

	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

		HttpSession session = request.getSession();

		try {
			if (session.getAttribute("identification").equals("Commercial")) {

				request.getRequestDispatcher("/WEB-INF/view/AcceuilAdmin.jsp").forward(request, response);

			} else if (session.getAttribute("identification").equals("Internaute")) {

				request.getRequestDispatcher("/WEB-INF/view/AcceuilUser.jsp").forward(request, response);

			} else {
				request.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(request, response);
			}

		} catch (ServletException e) {
			e.printStackTrace();
		}
	}
}
