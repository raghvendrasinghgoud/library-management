package com.nagarro.library.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.library.entities.User;
import com.nagarro.library.exception.InvalidCredentialsException;
import com.nagarro.library.services.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService serv;
	
	@GetMapping("/user/{username}/{password}")
	public String userLogin(@PathVariable("username") String username,@PathVariable("password") String password) {
		try {
			if(serv.login(username, password)) {
				return "loggedin";
			}
		} catch (InvalidCredentialsException e) {
			return e.getMessage();
		}
		return null;
	}
	
	@GetMapping("/user/{username}")
	public Optional<User> getUserByusername(@PathVariable("username") String username){
		return serv.getUserById(username);
	}
	
	@GetMapping("/users")
	public List<User> getAllUsers(){
		return serv.getUsers();
	}
	
	@PostMapping("/user")
	public User saveUser(@RequestBody User User) {
		return serv.addUser(User);		
	}
	@PutMapping("/user")
	public User updateUser(@RequestBody User User) {
		return serv.addUser(User);		
	}
	
	@DeleteMapping("/user/{username}")
	public String deleteUser(@PathVariable String username) {
		serv.deleteUserById(username);
		
		return "deleted";
	}
}
