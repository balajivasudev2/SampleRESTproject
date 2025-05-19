package com.example.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.example.entity.User;

import com.example.exception.UserDataValidationException;
import com.example.exception.UserNotFoundException;
import com.example.repository.UserRepository;

import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityNotFoundException;

@Service
public class UserService {
	
	
	@Autowired
	UserRepository repo;
	
	public User create(User u)
	{
		return repo.save(u);
	}
	
	public Optional<User> findDetailsById(long id)
	{
		return repo.findDetails(id);
	}
	
	public User updateDetailsById(long id,User user)
	{
		User details=repo.findById(id).orElseThrow(() -> new EntityNotFoundException("Employee not found with id " + id));
		details.setName(user.getName());
		
		return repo.save(details);
		
	}

}
