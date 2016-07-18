package com.bitwise.dominos.home;

import java.util.ArrayList;
import java.util.List;

import com.bitwise.dominos.dao.CrustDB;
import com.bitwise.dominos.dao.PizzaDB;
import com.bitwise.dominos.dao.PizzaPriceDB;
import com.bitwise.dominos.dao.ToppingDB;
import com.bitwise.dominos.exception.InvalidCrustException;
import com.bitwise.dominos.exception.InvalidOrderException;
import com.bitwise.dominos.exception.InvalidToppingException;
import com.bitwise.dominos.util.OrderValidator;
import com.bitwise.dominos.vo.Pizza;
import com.bitwise.dominos.vo.Topping;

/**
 * @author tinshuk
 *
 */
public class OrderPizza {

	static final double vat=0.1;
	static final double serviceTax=0.15;
	
	private List<Pizza> pizzaList;
	private double totalAmount;
	
	public List<Pizza> getPizzaList() {
		if(pizzaList == null){
			pizzaList =  new ArrayList<Pizza>();
		}
		return pizzaList;
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
				
				//remove default topping from pizza if selected
				removeDefaultTopping(pizza);
				
				//Get price of pizza from DB		
				totalAmount=totalAmount+PizzaPriceDB.getPizzaPrice(pizza.getName()).get(pizza.getSize());
				
				//Include price of topping if any added
				getExtraToppingPrice(pizza);
				
				//Add Crust price if any
				if(pizza.getCrust() != null){
					totalAmount=totalAmount+CrustDB.getPizzaCrustsMap().get(pizza.getCrust().getCrustType()).getCrustPrice();
				}
				
			}
		}
		totalAmount=totalAmount+(totalAmount*vat)+(totalAmount*serviceTax);
	}
	/**
	 * @param pizza
	 */
	private void getExtraToppingPrice(Pizza pizza) {
		if(pizza.getExtraTopping() != null && pizza.getExtraTopping().size()>0){
			for(String topping:pizza.getExtraTopping()){
				Topping top= ToppingDB.getPizzaToppingsMap().get(topping);
				totalAmount=totalAmount+top.getPrice();
			}
		}
	}
	
	/**
	 * @param pizza
	 */
	private void removeDefaultTopping(Pizza pizza) {
		if(pizza.getRemoveDefaultTopping()!= null && pizza.getRemoveDefaultTopping().size()>0){
			for(String removeTopping:pizza.getRemoveDefaultTopping()){
				ArrayList<Topping> existingTopping=PizzaDB.getAllPizzaMap().get(pizza.getName()).getDefaultToppipng();
				if(existingTopping != null && existingTopping.size()>0){
					for(int i=0;i<existingTopping.size();i++){
						if(existingTopping.get(i).getName().equals(removeTopping)){
							existingTopping.remove(i);
						}
					}
				}
			}
		}
	}
	

	@Override
	public String toString() {
		return "Order [pizzaList=" + pizzaList + ", vat=" + vat
				+ ", serviceTax=" + serviceTax + ", totalAmount=" + totalAmount
				+ "]";
	}

}
