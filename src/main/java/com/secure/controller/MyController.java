package com.secure.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.secure.model.User;
import com.secure.service.UserService;

@RestController
@RequestMapping("/user")
public class MyController 
{
	@Autowired
	private UserService service;
	
	@GetMapping("/")
	public List<User> getAllUserHandler()
	{
		return this.service.getAllUser();
	}
	
	@GetMapping("/{username}")
	public User getUserHandler(@PathVariable("username") String username)
	{
		return this.service.getUser(username);
	}
	
	@PostMapping("/add")
	public ResponseEntity<User> addUserHandler(@RequestBody User user)
	{
		User u =  this.service.addUser(user);
		return ResponseEntity.of(Optional.of(u));
	}
	
	@DeleteMapping("/delete/{username}")
	public List<User> deleteUserHandler (@PathVariable("username") String username)
	{
		return this.service.deleteUser(username);
	}

}
