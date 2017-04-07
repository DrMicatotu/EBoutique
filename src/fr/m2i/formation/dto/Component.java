package fr.m2i.formation.dto;

import java.util.ArrayList;


public class Component {
	
	private int id;
	private String name;
	private String supplier;
	private ArrayList<Product> products;
	
	public Component(int id, String name, String supplier) {
		this.id=id;
		this.name = name;
		this.supplier = supplier;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSupplier() {
		return supplier;
	}

	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}

	public ArrayList<Product> getProducts() {
		return products;
	}

	public void setProducts(ArrayList<Product> products) {
		this.products = products;
	}
	
	public void addProduct(Product product) {
		products.add(product);
	}
	
	
	
		
}
