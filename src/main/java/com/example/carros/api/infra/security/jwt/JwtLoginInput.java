package com.example.carros.api.infra.security.jwt;

import lombok.Data;

@Data
public class JwtLoginInput {
	
    private String username;
    private String password;
    
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
    
    

}
