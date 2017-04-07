package fr.m2i.formation.service;

import fr.m2i.formation.dto.Product;

import java.util.List;

import fr.m2i.formation.dto.Catalogue;

public interface IProductManager {

	public void createProduct(Catalogue catalogue,String name, double price); 
	//Cr�ation d'un produit avec ajout du produit � la classe Catalogue Java
	
	public void deleteProduct (int id);
	//Suppression du produit de la classe Catalogue et de la BDD
	//retour l'id du produit supprim�
	
	public void updateProduct(int id, double Price);
	//r�cup�re le produit de la base de donn�e, modifie son prix et le r�ins�re dans la base
	
	public List<Product> getProducts();
	//retourne une liste des produits dispo dans la BDD
	
	public Product getProduct(int id);
	
	public List<?> getInfo(int id);
	
}
