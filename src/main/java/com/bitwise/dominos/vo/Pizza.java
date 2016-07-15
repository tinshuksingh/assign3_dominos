package com.bitwise.dominos.vo;

import java.util.ArrayList;
import java.util.List;

public class Pizza {

	private String name;
	private float price;
	private String size;
	private List<String> toppingList;
	private Crust crust;
	private List<String> extraTopping = new ArrayList<String>();
	private List<String> removedDefaultTopping = new ArrayList<String>();
	private ArrayList<Topping> defaultToppipng;
	
	public ArrayList<Topping> getDefaultToppipng() {
		return defaultToppipng;
	}
	public void setDefaultToppipng(ArrayList<Topping> defaultToppipng) {
		this.defaultToppipng = defaultToppipng;
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
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public List<String> getToppingList() {
		return toppingList;
	}
	public void setToppingList(List<String> toppingList) {
		this.toppingList = toppingList;
	}
	public Crust getCrust() {
		return crust;
	}
	public void setCrust(Crust crust) {
		this.crust = crust;
	}
	public List<String> getExtraTopping() {
		return extraTopping;
	}
	public void setExtraTopping(List<String> extraTopping) {
		this.extraTopping = extraTopping;
	}
	public List<String> getRemovedDefaultTopping() {
		return removedDefaultTopping;
	}
	public void setRemovedDefaultTopping(List<String> removedDefaultTopping) {
		this.removedDefaultTopping = removedDefaultTopping;
	}
	
}
