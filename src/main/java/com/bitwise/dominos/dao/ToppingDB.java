package com.bitwise.dominos.dao;

import java.util.HashMap;

import com.bitwise.dominos.vo.Topping;

public class ToppingDB {

	private static HashMap<String, Topping> pizzaToppingsMap;

	static{
		pizzaToppingsMap = new HashMap<String, Topping>();
		pizzaToppingsMap.put("Tomato", new Topping("Tomato", 10));
		pizzaToppingsMap.put("Baby Corn", new Topping("Baby Corn", 10));
		pizzaToppingsMap.put("Pineapple", new Topping("Pineapple", 20));
		pizzaToppingsMap.put("Jalapeno", new Topping("Jalapeno", 15));
		pizzaToppingsMap.put("Onion", new Topping("Onion", 10));
		pizzaToppingsMap.put("Olives", new Topping("Olives", 15));
		pizzaToppingsMap.put("Capsicum", new Topping("Capsicum", 10));
		pizzaToppingsMap.put("Paprika", new Topping("Paprika", 30));
		pizzaToppingsMap.put("Panner", new Topping("Panner", 80));
		pizzaToppingsMap.put("Cheese", new Topping("Cheese", 20));
		pizzaToppingsMap.put("Chicken Salami", new Topping("Chicken Salami", 95));
		pizzaToppingsMap.put("Chicken Sausage", new Topping("Chicken Sausage", 110));
		pizzaToppingsMap.put("Smoked Chicken", new Topping("Smoked Chicken", 150));
		pizzaToppingsMap.put("Barbeque Chicken", new Topping("Barbeque Chicken", 100));
		pizzaToppingsMap.put("Spicy Chicken", new Topping("Spicy Chicken", 90));
	}
	
	public static HashMap<String, Topping> getPizzaToppingsMap() {
		return pizzaToppingsMap;
	}

	public static void setPizzaToppingsMap(HashMap<String, Topping> pizzaToppingsMap) {
		ToppingDB.pizzaToppingsMap = pizzaToppingsMap;
	}
	
}
