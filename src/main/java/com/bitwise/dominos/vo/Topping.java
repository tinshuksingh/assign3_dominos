package com.bitwise.dominos.vo;

import java.util.HashMap;
import java.util.Map;

public class Topping {
	private String name;
	private float price;
	private float totalPrice;
	private static Map<String,Integer> toppingList= new HashMap<String, Integer>();
	
	public Topping(String name, float price) {
		this.name=name;
		this.price=price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
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
