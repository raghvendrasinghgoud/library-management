package com.nagarro.library.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.library.dao.UserDao;
import com.nagarro.library.entities.User;
import com.nagarro.library.exception.InvalidCredentialsException;

@Service
public class UserService {

	@Autowired
	private UserDao ud;
	
	public boolean login(String username,String password) throws InvalidCredentialsException {
		
		if(ud.existsById(username)) {
			User user=ud.findById(username).get();
			if(user.getPassword().equals(password)) {
				return true;
			}
			
			throw new InvalidCredentialsException("wrong password");
		}		
			throw new InvalidCredentialsException("wrong username");
		
	}
	
	public User addUser(User User) {
		ud.save(User);
		return User;
	}
	
	public Optional<User> getUserById(String username) {
		return ud.findById(username);
	}
	
	public List<User> getUsers() {
		return ud.findAll();
	}
	
	public void deleteUserById(String username) {
		ud.deleteById(username);
	}
}
