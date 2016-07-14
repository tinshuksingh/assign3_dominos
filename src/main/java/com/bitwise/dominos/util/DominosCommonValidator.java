package com.bitwise.dominos.util;


import java.util.List;

import com.bitwise.dominos.dao.CrustDB;
import com.bitwise.dominos.dao.PizzaDB;
import com.bitwise.dominos.dao.ToppingDB;
import com.bitwise.dominos.exceptions.InvalidOrderException;
import com.bitwise.dominos.vo.Pizza;

public class DominosCommonValidator {

	
	public static void validatePizza(Pizza pizza) throws InvalidOrderException {
		
		if (pizza.getName() == null || pizza.getName().trim().length() == 0){
			System.out.println("Provide correct pizza name.");
			throw new InvalidOrderException();
		}
		if (PizzaDB.getAllPizzaMap().get(pizza.getName()) == null){
			System.out.println("Pizza not available : " + pizza.getName());
			throw new InvalidOrderException();
		}
		if (pizza.getExtraTopping() != null && pizza.getExtraTopping().size()>0){
			List<String> extraToppings=pizza.getExtraTopping();
			for(String topping: extraToppings){
				if(ToppingDB.getPizzaToppingsMap().get(topping) == null){
					System.out.println("Invalid Topping selected : " + topping);
					throw new InvalidOrderException();
				}
			}
		}
		if (pizza.getCrust() != null && CrustDB.getPizzaCrustsMap().get(pizza.getCrust()) == null){
				System.out.println("Invalid Crust selected : " + pizza.getCrust());
				throw new InvalidOrderException();
			}
		}
}
