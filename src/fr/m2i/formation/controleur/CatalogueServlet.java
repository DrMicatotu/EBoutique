package fr.m2i.formation.controleur;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import fr.m2i.formation.dto.Product;
import fr.m2i.formation.service.impl.ProductManager;

public class CatalogueServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
	

	ProductManager manager = new ProductManager();
	
	
	List<Product> cataList = manager.getProducts();
	request.setAttribute("cataList", cataList);
	
	try {
		request.getRequestDispatcher("/WEB-INF/view/catalogue.jsp").forward(request,response);
	} catch (ServletException e) {
		
		e.printStackTrace();
	}
	
	
}

}


