package fr.m2i.formation.dto;

public class Commercial extends User{
	
	

	public Commercial() {
		super();
		
	}

	public Commercial(String firstName, String lastName, String userLogin, String password) {
		super(firstName, lastName, userLogin, password);
		
	}
	
	public String getRole() {
		return "Commercial";
	}
}
