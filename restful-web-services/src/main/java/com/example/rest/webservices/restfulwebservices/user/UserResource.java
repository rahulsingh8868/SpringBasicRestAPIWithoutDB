package com.example.rest.webservices.restfulwebservices.user;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;



@RestController
public class UserResource {
	
	@Autowired
	private UserDaoService service;
	
	@GetMapping(path="/Users")
	public List<User> retrieveAllUsers(){
		return service.findAll();
	}
	
	@GetMapping(path="/Users/{id}")
	public User retrieveUser(@PathVariable int id) {
		User user = service.findOne(id);
		if(user==null) {
			throw new UserNotFoundException("id-"+id);
		}
		return user;
	}
	
	@PostMapping("/Users")
	public User CreateUser(@RequestBody User user) {
		User savedUser = service.save(user);
		return savedUser;
	}
	
	@DeleteMapping("/Users/{id}")
	public User deleteUser(@PathVariable int id) {
		User deletedUser = service.deleteOne(id);
		if(deletedUser==null) {
			throw new UserNotFoundException("id-"+id);
		}
		return deletedUser;
	}
	
	@PutMapping("/Users")
	public User updateUserData(@RequestBody User user) {
		User updatedData = service.updateOne(user);
		if(updatedData==null) {
			throw new UserNotFoundException("id-"+user.getId());
		}
		return updatedData;
	}
}
