package com.ty.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ty.dao.UserDao;
import com.ty.dto.User;

@Component
public class UserService {
 @Autowired
 UserDao userDao;
	public User saveUser(User user) {
		return userDao.saveUser(user);
	}
	public User getUserById(int id) {

      return userDao.getUserById(id);
		}


}
