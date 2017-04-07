package fr.m2i.formation.dto;
import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.HashMap;


public abstract class User {

		protected String firstName;
		protected String lastName;
		protected String userLogin;
		protected String password;
		
		
		
		
		public User() {
			
			this.firstName = "new";
			this.lastName = "new";
			this.userLogin = "new";
			this.password = "new";
			
		}

		public User(String firstName, String lastName, String userLogin, String password) {
			
			this.firstName = firstName;
			lastName = lastName;
			this.userLogin = userLogin;
			this.password = password;
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			lastName = lastName;
		}

		public String getUserLogin() {
			return userLogin;
		}

		public void setUserLogin(String userLogin) {
			this.userLogin = userLogin;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}
		
		public abstract String getRole();
}


