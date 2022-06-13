package com.ty.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ty.dto.FoodOrder;
import com.ty.dto.Item;
import com.ty.dto.Menu;
import com.ty.dto.User;
import com.ty.service.FoodOrderService;
import com.ty.service.MenuService;
import com.ty.service.UserService;

@Controller
public class FoodController {
	@Autowired
	MenuService menuService;

	@Autowired
	FoodOrderService foodOrderService;

	@Autowired
	UserService userService;

	@RequestMapping("/openHotel")
	public ModelAndView loadMe() {
		System.out.println("All good");
		ModelAndView modelAndView = new ModelAndView("myhotel.jsp");
		modelAndView.addObject("myMsg", "Admin Login");
		return modelAndView;

	}

	@RequestMapping("/user")
	public ModelAndView saveUser() {
		System.out.println("Reaching");
		ModelAndView modelAndView = new ModelAndView("saveuser.jsp");
		modelAndView.addObject("myUser", new User());
		return modelAndView;
	}

	@RequestMapping("/usersaved")
	public ModelAndView displayUser(@ModelAttribute User user) {
		System.out.println("user added");
		userService.saveUser(user);
		ModelAndView modelAndView = new ModelAndView("displaymenus.jsp");
		return modelAndView;
	}

	@RequestMapping("/admin")
	public ModelAndView adminLogin() {
		System.out.println("Menu adding");
		ModelAndView modelAndView = new ModelAndView("createmenu.jsp");
		modelAndView.addObject("menus", new Menu());
		return modelAndView;
	}

	@RequestMapping("/menusaved")
	public ModelAndView displayMenu(@ModelAttribute Menu menu) {
		menuService.saveMenu(menu);
		System.out.println("Menu added");

		ModelAndView modelAndView = new ModelAndView("displaymenus.jsp");
		ArrayList<Menu> menus = new ArrayList();
		menus.add(menu);
		modelAndView.addObject("menusaved", menus);
		return modelAndView;
	}

	@RequestMapping("/placeorder")
	public ModelAndView placeFoodOrder(@ModelAttribute Menu menu) {
		List<Menu> menus = menuService.getAllMenus();
		System.out.println("Menu added");
		ModelAndView modelAndView = new ModelAndView("displaymenus.jsp");
		modelAndView.addObject("menusaved", menus);
		System.out.println("All Good");
		return modelAndView;
	}

	@RequestMapping("/item")
	public ModelAndView itemAdd(HttpServletRequest request) {
		HttpSession httpSession = request.getSession();
		int id = Integer.parseInt((String) httpSession.getAttribute("menuid"));
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		int userID = Integer.parseInt(request.getParameter("userId"));

		User user = userService.getUserById(userID);

		Menu menu = menuService.getMenuById(id);

		Item item = new Item();
		item.setName(menu.getName());
		item.setQuantity(quantity);
		item.setCost(menu.getCost());

		List<Item> items = new ArrayList();
		items.add(item);

		FoodOrder foodOrder = new FoodOrder();
		foodOrder.setName(user.getName());
		foodOrder.setPhone(user.getPhone());
		foodOrder.setCost(menu.getCost() * item.getQuantity());
		foodOrder.setUser(user);

		HttpSession session = request.getSession();
		session.setAttribute("s1", foodOrder.getId());

		List<FoodOrder> foodOrders = new ArrayList();
		foodOrders.add(foodOrder);

		foodOrder.setItem(items);

		item.setFoodOrder(foodOrder);

		user.setFoodOrder(foodOrders);

		foodOrderService.saveFoodOrder(foodOrder);
		System.out.println("Order Placed");

		ModelAndView modelAndView2 = new ModelAndView("quantity.jsp");
		return modelAndView2;

	}

	@RequestMapping("/addmore")
	public ModelAndView addMoreItems(@ModelAttribute Menu menu) {
		List<Menu> menus = menuService.getAllMenus();
		System.out.println("Menu added");
		ModelAndView modelAndView = new ModelAndView("displaymenus.jsp");
		modelAndView.addObject("menusaved", menus);
		System.out.println("All Good");
		return modelAndView;
	}

}
