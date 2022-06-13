package com.ty.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ty.dao.FoodOrderDao;
import com.ty.dto.FoodOrder;

@Component
public class FoodOrderService {
@Autowired
FoodOrderDao foodOrderDao;

public FoodOrder saveFoodOrder(FoodOrder foodOrder) {
	return foodOrderDao.saveOrder(foodOrder);
}
}
