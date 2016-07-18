package com.bitwise.dominos.vo;

/**
 * @author tinshuk
 *
 */
public class Topping {
	private String name;
	private float price;
	
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

	@Override
	public String toString() {
		return "Topping [name=" + name + ", price=" + price + "]";
	}


	
}
