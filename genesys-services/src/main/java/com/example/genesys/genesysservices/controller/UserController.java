package com.example.genesys.genesysservices.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.genesys.genesysservices.dto.UserDto;
import com.example.genesys.genesysservices.model.User;
import com.example.genesys.genesysservices.service.UserService;

@RestController()
@RequestMapping("/api/user")
public class UserController {

	@Autowired
	UserService userService;

	/**
	 * This Api will return list of users from our application
	 * 
	 * @Method: GET
	 * @Content-type: application/json
	 * 
	 * @return List<User>
	 */
	@RequestMapping(method = RequestMethod.GET)
	public List<User> getUsers() {
		return userService.getAllUser();
	}

	/**
	 * Based on id we will retrive and send user details
	 * 
	 * @Method: GET
	 * @Content-type: application/json
	 * @Mandatory: ID
	 * @param id
	 * @return User
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public User getUser(@PathVariable int id) {
		return userService.getUser(id);
	}

	/**
	 * This API will create a user in our application
	 * 
	 * @Method: POST
	 * @content-type: application/json
	 * @Mandatory: name,password,email
	 * @Body : { "name": "Rajesh", "email": "rkumar9090@hotmail.com", "password":
	 *       "Durairaj90" }
	 * 
	 * @param user
	 * @return HttpStatus.CREATED
	 */
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<String> addUser(@Valid @RequestBody UserDto user) {
		userService.addUser(user);
		return new ResponseEntity<String>("User Created Successfully", HttpStatus.CREATED);

	}

	/**
	 * @Method: PUT
	 * @Content-type: application/json
	 * @Mandatory: name,password,email,id
	 * @Body : {"id",3, "name": "Rajesh", "email": "rkumar9090@hotmail.com",
	 *       "password": "Durairaj90" }
	 * 
	 * @param user
	 * @return HttpStatus.NO_CONTENT
	 */
	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<String> updateUser(@Valid @RequestBody UserDto user) {
		userService.update(user);
		return new ResponseEntity<String>("User Updated Sucessfully ", HttpStatus.NO_CONTENT);

	}

	/**
	 * @Method: DELETE
	 * @Content-type: application/json
	 * 
	 * @param id
	 * @return HttpStatus.NO_CONTENT
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteUser(@PathVariable int id) {
		userService.getUser(id);
		return new ResponseEntity<String>("User deleted ", HttpStatus.NO_CONTENT);
	}

}