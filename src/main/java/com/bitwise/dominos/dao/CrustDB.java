package com.bitwise.dominos.dao;

import java.util.HashMap;

import com.bitwise.pizzaShop.pizza.Crust;

public class CrustDB {
private static HashMap<String, Crust> pizzaCrustsMap;
	
	static{
		pizzaCrustsMap = new HashMap<String, Crust>();
		pizzaCrustsMap.put("Pan Pizza", new Crust("Pan Pizza", 100));
		pizzaCrustsMap.put("Thin Crust", new Crust("Thin Crust", 150));
		pizzaCrustsMap.put("Regular", new Crust("Regular", 0));
		pizzaCrustsMap.put("Cheese Burst", new Crust("Cheese Burst", 200));
	}
	
	public static HashMap<String, Crust> getPizzaCrustsMap() {
		return pizzaCrustsMap;
	}

	public static void setPizzaCrustsMap(HashMap<String, Crust> pizzaCrustsMap) {
		CrustDB.pizzaCrustsMap = pizzaCrustsMap;
	}
}
