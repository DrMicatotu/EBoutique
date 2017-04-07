package fr.m2i.formation.controleur;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.m2i.formation.dto.Catalogue;
import fr.m2i.formation.dto.Product;
import fr.m2i.formation.service.impl.ProductManager;

public class DeleteProductServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

		int id = -1;
		id = Integer.parseInt(request.getParameter("id"));

		if (id == -1) {
			response.sendError(HttpServletResponse.SC_NOT_FOUND, "Empty name");
			return;
		}

		ProductManager manager = new ProductManager();
		manager.deleteProduct(id);
		List<Product> cataList = manager.getProducts();

		request.setAttribute("cataList", cataList);

		try {
			request.getRequestDispatcher("/WEB-INF/view/catalogue.jsp").forward(request, response);
		} catch (ServletException e) {

			e.printStackTrace();
		}

	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

		HttpSession session = request.getSession();

		try {
			if (session.getAttribute("identification").equals("Commercial")) {

				request.getRequestDispatcher("/WEB-INF/view/AcceuilAdmin.jsp").forward(request, response);

			

			} else {
				request.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(request, response);
			}

		} catch (ServletException e) {
			e.printStackTrace();
		}
	}

}
