package com.ty.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
//import javax.persistence.Persistence;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ty.dto.Menu;

@Component
public class MenuDao {

	@Autowired
	EntityManagerFactory entityManagerFactory;

	// save Menu
	public Menu saveMenu(Menu menu) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		if (menu != null) {
			entityTransaction.begin();
			entityManager.persist(menu);
			entityTransaction.commit();
			System.out.println("Menu of particular row added");
		} else {
			System.out.println("Not added");
		}
		return null;
	}

	// get all menu
	public List<Menu> getAllMenus() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		String sql = "SELECT m FROM Menu m";
		Query query = entityManager.createQuery(sql);

		return query.getResultList();
	}

	public Menu getMenuById(int id) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Menu menu2 = entityManager.find(Menu.class, id);
		return menu2;
	}
}
