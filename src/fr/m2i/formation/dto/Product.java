package fr.m2i.formation.dto;

import java.util.ArrayList;

public class Product {
	
	private int id;
	private String name;
	private double sellingPrice;
	private ArrayList<Component> components;
	
	public Product() {
		
		super();
	}
	
	public Product(int id, String name, double sellingPrice) {
		
		this.id = id;
		this.name = name;
		this.sellingPrice = sellingPrice;
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

	public double getSellingPrice() {
		return sellingPrice;
	}

	public void setSellingPrice(double sellingPrice) {
		this.sellingPrice = sellingPrice;
	}

	public ArrayList<Component> getComponents() {
		return components;
	}

	public void setComponentsList(ArrayList<Component> components) {
		this.components = components;
	}
	
	public void addComponents(Component component) {
		components.add(component);
	}

	
	
	

}
