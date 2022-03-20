package com.org.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.entity.User;
import com.org.entity.UserRepo;

@Service
public class UserService {

	@Autowired
	UserRepo urepo;
	
	public User addUser(User user)
	{
		return urepo.save(user);
	}
	
	public List<User> getAllUser()
	{
		return urepo.findAll();
	}
	
	public User getUserById(int uid)
	{
		return urepo.getById(uid);
	}
}