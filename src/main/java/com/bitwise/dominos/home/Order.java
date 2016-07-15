package com.bitwise.dominos.home;

import java.util.ArrayList;
import java.util.List;

import com.bitwise.dominos.dao.PizzaDB;
import com.bitwise.dominos.dao.ToppingDB;
import com.bitwise.dominos.exception.InvalidCrustException;
import com.bitwise.dominos.exception.InvalidOrderException;
import com.bitwise.dominos.exception.InvalidToppingException;
import com.bitwise.dominos.util.OrderValidator;
import com.bitwise.dominos.vo.Pizza;
import com.bitwise.dominos.vo.Topping;

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
		if(pizzaList == null){
			pizzaList =  new ArrayList<Pizza>();
		}
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
	
	public void addPizza(Pizza pizza) throws InvalidOrderException, InvalidCrustException, InvalidToppingException {
		OrderValidator.validateOrder(pizza);
		getPizzaList().add(pizza);
	}
	
	public void calculateTotalPrice() throws InvalidCrustException {
		List<Pizza> pizzas=getPizzaList();
		if(pizzas != null && pizzas.size()>0){
			for(Pizza pizza: pizzas){
				totalAmount=totalAmount+PizzaDB.getAllPizzaMap().get(pizza.getName()).getPrice();
				if(pizza.getExtraTopping() != null && pizza.getExtraTopping().size()>0){
					for(String topping:pizza.getExtraTopping()){
						Topping top= ToppingDB.getPizzaToppingsMap().get(topping);
						totalAmount=totalAmount+top.getPrice();
					}
					
				}
			}
		}
		
		
	}

}
