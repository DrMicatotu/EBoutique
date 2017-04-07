package fr.m2i.formation.dto;

public class Panier {

	private int id;
	private String userLogin;
	private int idProduct;
	private int quantity;
	
	public Panier(int id, String userLogin, int idProduct, int quantity) {
		super();
		this.id = id;
		this.userLogin = userLogin;
		this.idProduct = idProduct;
		this.quantity = quantity;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserLogin() {
		return userLogin;
	}
	public void setUserLogin(String userLogin) {
		this.userLogin = userLogin;
	}
	public int getIdProduct() {
		return idProduct;
	}
	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
}
