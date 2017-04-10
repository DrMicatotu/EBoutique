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
		
		try {
			
			String login = "test"; //TODO get from session
			
			OrderManager manager = new OrderManager();
			
			manager.createOrder()
			
			
			JSONObject jObj = new JSONObject(request.getParameter("cart"));
			
			Iterator it = jObj.keys(); //gets all the keys
			
			
			
			
			
			
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
		} catch (JSONException e) {
			
			e.printStackTrace();
		}
	}

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
