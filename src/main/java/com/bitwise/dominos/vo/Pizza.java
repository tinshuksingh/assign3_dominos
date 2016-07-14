package com.bitwise.dominos.vo;

import java.util.ArrayList;
import java.util.List;

public class Pizza {

	private String name;
	private String price;
	private String size;
	private List<String> toppingList;
	private String crust = "Regular";
	private List<String> extraTopping = new ArrayList<String>();
	private List<String> removedDefaultTopping = new ArrayList<String>();
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
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
	public String getCrust() {
		return crust;
	}
	public void setCrust(String crust) {
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
