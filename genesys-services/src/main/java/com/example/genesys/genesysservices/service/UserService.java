package com.example.genesys.genesysservices.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import com.example.genesys.genesysservices.dao.UserDao;
import com.example.genesys.genesysservices.dto.UserDto;
import com.example.genesys.genesysservices.model.User;

@Component
public class UserService {

	@Autowired
	private UserDao userDao;

	public List<User> getAllUser() {
		return userDao.findAll();
	}

	public User getUser(int id) {
		User user = userDao.findOne(id);
		if (user != null) {
			return user;
		} else {
			return null;
			// throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not exists");
		}
	}

	public void deleteUser(int id) {
		userDao.delete(id);
	}

	public void addUser(UserDto userDto) {
		User userExists = userDao.findByUserName(userDto.getName());
		if (null == userExists) {
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			User user = new User();
			user.setUserName(userDto.getName());
			user.setPassword(encoder.encode(userDto.getPassword()));
			user.setEmail(userDto.getEmail());
			user.setRoleId(userDto.getRoleId());
			userDao.save(user);
		} else {
			// throw new ResponseStatusException(HttpStatus.ALREADY_REPORTED, "Username
			// already exists");
		}
	}

	public void update(UserDto userDto) {
		if (userDto.getId() > 0) {
			User userValue = userDao.findOne(userDto.getId());
			if (userValue != null) {
				userValue.setUserName(userDto.getName());
				userValue.setPassword(userDto.getPassword());
				userValue.setEmail(userDto.getEmail());
				userDao.save(userValue);
			} else {
				// throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not exists");
			}
		} else {
			// throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Id is not valid");
		}

	}

}