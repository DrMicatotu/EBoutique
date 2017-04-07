package fr.m2i.formation.service;

import fr.m2i.formation.dto.User;

public interface IUserManager {
	
	public User authenticate (String login,String password);
	
	

}
