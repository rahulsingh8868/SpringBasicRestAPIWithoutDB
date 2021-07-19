package com.example.rest.webservices.restfulwebservices.user;

import java.util.*;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
	private static List<User> users = new ArrayList<>();
	
	private static int usersCount =4;
	static {
		users.add(new User(1,"Rahul",new Date()));
		users.add(new User(2,"Adam",new Date()));
		users.add(new User(3,"Eve",new Date()));
		users.add(new User(4,"Jack",new Date()));
	}
	
	public List<User> findAll(){
		return users;
	}
	
	public User save(User user){
		if(user.getId()==null) {
			user.setId(++usersCount);
		}
		users.add(user);
		return user;
	}
	
	public User findOne(int id){
		for(User user:users) {
			if(user.getId()==id) {
				return user;
			}
		}
		return null;
	}
	
	public User deleteOne(int id){
		Iterator<User> iterator = users.iterator();
		while(iterator.hasNext()) {
			User user = iterator.next();
			if(user.getId()==id) {
				iterator.remove();
				usersCount--;
				return user;
			}
		}
		return null;
	}
	
	public User updateOne(User user){
		Iterator<User> iterator = users.iterator();
		while(iterator.hasNext()) {
			User userToBeUpdated = iterator.next();
			if(userToBeUpdated.getId()==user.getId()) {
				userToBeUpdated.setBirthdDate(user.getBirthdDate());
				userToBeUpdated.setName(user.getName());
				return userToBeUpdated;
			}
		}
		return null;
	}
}
