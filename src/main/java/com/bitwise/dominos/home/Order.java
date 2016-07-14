package com.bitwise.dominos.home;

import java.util.List;

import com.bitwise.dominos.exceptions.InvalidOrderException;
import com.bitwise.dominos.util.DominosCommonValidator;
import com.bitwise.dominos.vo.Pizza;

public class Order {

	@Override
	public String toString() {
		return "Order [pizzaList=" + pizzaList + ", vat=" + vat
				+ ", serviceTax=" + serviceTax + ", totalAmount=" + totalAmount
				+ "]";
	}

	private List<Pizza> pizzaList;
	private float vat;
	private float serviceTax;
	private float totalAmount;
	
	public List<Pizza> getPizzaList() {
		return pizzaList;
	}
	public void setPizzaList(List<Pizza> pizzaList) {
		this.pizzaList = pizzaList;
	}
	public float getVat() {
		return vat;
	}
	public void setVat(float vat) {
		this.vat = vat;
	}
	public float getServiceTax() {
		return serviceTax;
	}
	public void setServiceTax(float serviceTax) {
		this.serviceTax = serviceTax;
	}
	public float getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(float totalAmount) {
		this.totalAmount = totalAmount;
	}
	
	public void addPizza(Pizza pizza) throws InvalidOrderException {
		DominosCommonValidator.validatePizza(pizza);
		getPizzaList().add(pizza);
	}
	

}
