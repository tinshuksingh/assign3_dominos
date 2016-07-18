package com.bitwise.dominos.vo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tinshuk
 *
 */
public class Pizza {

	private String name;
	private String size;
	private Crust crust;
	private double price;
	private List<String> extraTopping = new ArrayList<String>();
	private List<String> removeDefaultTopping = new ArrayList<String>();
	private ArrayList<Topping> defaultToppipng;
	
	
	public Pizza(String name,String size){
		this.name=name;
		this.size=size;
	}
	
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
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

	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
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
	public List<String> getRemoveDefaultTopping() {
		return removeDefaultTopping;
	}
	public void setRemoveDefaultTopping(List<String> removedDefaultTopping) {
		this.removeDefaultTopping = removedDefaultTopping;
	}
	
	@Override
	public String toString() {
		return "Pizza Details [name=" + name + ", size=" + size + ", crust=" + crust
				+ ", price=" + price + ", extraTopping=" + extraTopping
				+ ", removeDefaultTopping=" + removeDefaultTopping
				+ ", defaultToppipng=" + defaultToppipng + "]";
	}
	
}
