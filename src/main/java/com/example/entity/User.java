package com.example.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity                  
@Table(name = "user")
public class User {
	
	@Id                                   
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	long id;
	
	@Column(name = "name", 
            nullable = false, 
            length = 50)
	String Name;
	
	@Column(name="email", length = 50)
	String email;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	
	public void setEmail(String email)
	{
		this.email=email;
	}
	
	public String getEmail()
	{
		return email;
	}
	
	public User(long id, String name) {
		super();
		this.id = id;
		Name = name;
		email=email;
	}
	
	
	
	public User() {
		
	}

}
