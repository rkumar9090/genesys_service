package com.example.genesys.genesysservices.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.genesys.genesysservices.model.User;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {

	public User findByUserName(String userName);

}
