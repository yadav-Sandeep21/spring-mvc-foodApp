package com.ty.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ty.dao.MenuDao;
import com.ty.dto.Menu;

@Component
public class MenuService {

	@Autowired
	MenuDao menuDao;

	public Menu saveMenu(Menu menu) {
		return menuDao.saveMenu(menu);
	}

	// get all menu
	public List<Menu> getAllMenus() {
		return menuDao.getAllMenus();
	}
	
	 public Menu getMenuById(int id) {
      return menuDao.getMenuById(id);
	 }
}
