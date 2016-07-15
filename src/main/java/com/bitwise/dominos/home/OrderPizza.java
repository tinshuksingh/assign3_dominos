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

public class OrderPizza {

	private final double vat=0.1;
	private final double serviceTax=0.15;
	private List<Pizza> pizzaList;
	private double totalAmount;
	
	public List<Pizza> getPizzaList() {
		if(pizzaList == null){
			pizzaList =  new ArrayList<Pizza>();
		}
		return pizzaList;
	}
	public void setPizzaList(List<Pizza> pizzaList) {
		this.pizzaList = pizzaList;
	}
	
	public double getTotalAmount() {
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
		
		System.out.println("totalAmmount :"+totalAmount);
		System.out.println("Vat"+(totalAmount*vat));
		System.out.println("serviceTax"+(totalAmount*serviceTax));
		totalAmount=totalAmount+(totalAmount*vat)+(totalAmount*serviceTax);
		
		
	}
	

	@Override
	public String toString() {
		return "Order [pizzaList=" + pizzaList + ", vat=" + vat
				+ ", serviceTax=" + serviceTax + ", totalAmount=" + totalAmount
				+ "]";
	}

}
