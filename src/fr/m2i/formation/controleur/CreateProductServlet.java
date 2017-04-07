package fr.m2i.formation.controleur;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.m2i.formation.dto.Catalogue;
import fr.m2i.formation.dto.Product;
import fr.m2i.formation.service.impl.ProductManager;

public class CreateProductServlet extends HttpServlet {

	private static final long serialVersionUID = -8621074983373669026L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

		String name = request.getParameter("nom");
		String priceS = request.getParameter("price");
		double price = Double.parseDouble(priceS);
		if ((name == null) || (name.trim().equals(""))) {
			response.sendError(HttpServletResponse.SC_NOT_FOUND, "Empty name");
			return;
		}
		
		Catalogue cataTest = new Catalogue();
		ProductManager manager = new ProductManager();
		manager.createProduct(cataTest, name, price);
		//
		List<Product> cataList = manager.getProducts();
		request.setAttribute("cataList", cataList);
		//
		try {
			request.getRequestDispatcher("/WEB-INF/view/catalogue.jsp").forward(request,response);
		} catch (ServletException e) {
			
			e.printStackTrace();
		}
		
		
	}

}
