package fr.m2i.formation.dto;

public class Internaute extends User{
	
	

	public Internaute() {
		super();
		
	}

	public Internaute(String firstName, String lastName, String userLogin, String password) {
		super(firstName, lastName, userLogin, password);
		
	}
	
	public String getRole() {
		return "Internaute";
	}
}
