package com.bitwise.dominos.util;


import java.util.List;

import com.bitwise.dominos.dao.CrustDB;
import com.bitwise.dominos.dao.PizzaDB;
import com.bitwise.dominos.dao.ToppingDB;
import com.bitwise.dominos.exception.InvalidCrustException;
import com.bitwise.dominos.exception.InvalidOrderException;
import com.bitwise.dominos.exception.InvalidToppingException;
import com.bitwise.dominos.vo.Pizza;

public class OrderValidator {

	
	public static void validateOrder(Pizza pizza) throws InvalidCrustException, InvalidToppingException, InvalidOrderException {
		validatePizza(pizza);
		validateToppings(pizza);
		validateCrust(pizza);
		}

	/**
	 * @param pizza
	 * @throws InvalidCrustException
	 */
	public static void validateCrust(Pizza pizza) throws InvalidCrustException {
		if (pizza.getCrust() != null && CrustDB.getPizzaCrustsMap().get(pizza.getCrust().getCrustType()) == null){
				System.out.println("Invalid Crust selected : " + pizza.getCrust());
				throw new InvalidCrustException();
			}
	}

	/**
	 * @param pizza
	 * @throws InvalidToppingException 
	 */
	public static void validateToppings(Pizza pizza)
			throws InvalidToppingException {
		if (pizza.getExtraTopping() != null && pizza.getExtraTopping().size()>0){
			List<String> extraToppings=pizza.getExtraTopping();
			for(String topping: extraToppings){
				if(ToppingDB.getPizzaToppingsMap().get(topping) == null){
					System.out.println("Invalid Topping selected : " + topping);
					throw new InvalidToppingException();
				}
			}
		}
	}

	/**
	 * @param pizza
	 * @throws InvalidOrderException
	 */
	public static void validatePizza(Pizza pizza) throws InvalidOrderException {
		
		if(pizza == null){
			throw new InvalidOrderException();
		}
		
		if (pizza.getName() == null || pizza.getName().trim().length() == 0){
			System.out.println("Provide correct pizza name.");
			throw new InvalidOrderException();
		}
		if (PizzaDB.getAllPizzaMap().get(pizza.getName()) == null){
			System.out.println("Pizza not available : " + pizza.getName());
			throw new InvalidOrderException();
		}
	}
}
