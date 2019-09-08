package com.example.genesys.genesysservices.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class UserDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;

	@Size(min = 3, max = 60, message = "name minimum should contain 3 char or maximum 20 chars")
	@NotNull(message = "name cannot be empty")
	private String name;

	@Size(min = 3, max = 60, message = "password minimum should contain 3 char or maximum 20 chars")
	@NotNull(message = "password cannot be empty")
	private String password;

	@Pattern(regexp = ".+@.+\\.[a-z]+")
	@Size(min = 3, max = 60, message = "email minimum should contain 3 char or maximum 20 chars")
	@NotNull(message = "email cannot be empty")
	private String email;

	private int roleId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

}
