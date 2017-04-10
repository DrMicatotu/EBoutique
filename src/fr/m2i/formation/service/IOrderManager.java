package fr.m2i.formation.service;

import fr.m2i.formation.dto.Product;

import java.util.List;

import fr.m2i.formation.dto.Catalogue;

public interface IOrderManager {

	public int createOrder(String user, double prix);
	
	public void createOrderRow(int idOrder, int idProduct, double prixU, int quantity, String user);
	
	public List<?> getOrders();
	
	public List<?> getOrderRow();
		
}
