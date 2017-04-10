package fr.m2i.formation.controleur;

import java.io.IOException;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONException;
import org.json.JSONObject;

import fr.m2i.formation.service.impl.*;

public class OrderServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		HttpSession session = request.getSession();
		String user = (String) session.getAttribute("login");
		boolean success = false;
		
		if (user == null) {
			try {
				request.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(request, response);
			} catch (ServletException e) {
				e.printStackTrace();
			}
		}
		
		
		try {
			
			OrderManager manager = new OrderManager();
			
			JSONObject jObj = new JSONObject(request.getParameter("cart"));
			Iterator it = jObj.keys(); //gets all the keys
			
			
			double prixTot = 0;
			double prixCart = 0;
			int quantityCart = 0;
			
			while(it.hasNext()) {
				
				Object key = it.next(); // get key
			 	JSONObject o = (JSONObject) jObj.get(key.toString()); // get value
			 	prixCart = Double.parseDouble(o.get("prixCart").toString());
			 	quantityCart = (int) o.get("quantityCart");
			 	prixTot += prixCart * quantityCart;
			 	
			 	
			}
			
			int idOrder = manager.createOrder(user, prixTot);
			
			
			
			it = jObj.keys();
			
			int idProduct = 0 ;
			String nomProduct = "";
			double prixU = 0 ;
			int quantity = 0 ;
			
			
			
			while(it.hasNext()) {
				
				Object key = it.next();
			    JSONObject o = (JSONObject) jObj.get(key.toString());
			    
			    idProduct = Integer.parseInt(key.toString());
			    nomProduct = (String) o.get("nameCart");
				prixU = Double.parseDouble(o.get("prixCart").toString());
				quantity = (int)o.get("quantityCart");
				
				manager.createOrderRow(idOrder, idProduct,nomProduct ,prixU, quantity, user);
			    
			}
			
			success = true;
			
		} catch (JSONException e) {
			
			e.printStackTrace();
		}
		
		if (success = true) {
		
			
		}
		
	}
	
	/*
	while(it.hasNext())
	{
	    Object key = it.next(); // get key
	    JSONObject o = (JSONObject) jObj.get(key.toString()); // get value
	    System.out.println(key + " : " +  o); // print the key and value
	    System.out.println(key);
	    System.out.println(o.get("nameCart"));
	    System.out.println(o.get("prixCart"));
	    System.out.println(o.get("quantityCart")); 
	}			
*/

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
