package com.example.demo.dto;

public class RegisterDto {
   String name;
   String email;
   String password;
   
   
   public String getPassword() {
	return password;
}
   public void setPassword(String password) {
	this.password = password;
   }
   public String getName() {
	return name;
   }
   public void setName(String name) {
	this.name = name;
   }
   public String getEmail() {
	return email;
   }
   public void setEmail(String email) {
	this.email = email;
   }
   
}
