package com.bitwise.dominos.vo;

import java.util.HashMap;
import java.util.Map;

public class Topping {
	private String name;
	private int totalPrice;
	private static Map<String,Integer> toppingList= new HashMap<String, Integer>();
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public static Map<String, Integer> getToppingList() {
		return toppingList;
	}

	public static void setToppingList(Map<String, Integer> toppingList) {
		Topping.toppingList = toppingList;
	}

	@Override
	public String toString() {
		return "Topping [name=" + name + ", totalPrice=" + totalPrice + "]";
	}
	
}
