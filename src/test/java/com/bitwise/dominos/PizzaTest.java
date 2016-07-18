package com.bitwise.dominos;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.bitwise.dominos.exception.InvalidCrustException;
import com.bitwise.dominos.exception.InvalidOrderException;
import com.bitwise.dominos.exception.InvalidToppingException;
import com.bitwise.dominos.util.OrderValidator;
import com.bitwise.dominos.vo.Crust;
import com.bitwise.dominos.vo.Pizza;

public class PizzaTest {

	
	@Test(expected = InvalidOrderException.class)
	public void shouldReturnInvalidOrderException() throws InvalidOrderException{
		Pizza pizza = new Pizza("","");
		OrderValidator.validatePizza(pizza);
		/*pizza.setName("MyPizza");
		OrderValidator.validatePizza(pizza);*/
	}
	
	@Test(expected = InvalidToppingException.class)
	public void shouldReturnInvalidToppingException() throws InvalidToppingException{
		Pizza pizza = new Pizza("Margherita","Medium");
		//pizza.setName("Margherita");
		List<String> extraTopping= new ArrayList<String>();
		extraTopping.add("Pineapple1");
		pizza.setExtraTopping(extraTopping);
		OrderValidator.validateToppings(pizza);
	}
	
	@Test(expected = InvalidCrustException.class)
	public void shouldReturnInvalidCrustException() throws InvalidCrustException {
		Pizza pizza = new Pizza("Margherita","Medium");
		//pizza.setName("Margherita");
		List<String> extraTopping= new ArrayList<String>();
		extraTopping.add("Pineapple1");
		pizza.setExtraTopping(extraTopping);
		Crust crust= new Crust("Thin");
		pizza.setCrust(crust);
		OrderValidator.validateCrust(pizza);
	}
	
	@Test
	public void addValidPizza() throws InvalidOrderException{
		Pizza pizza = new Pizza("Margherita","Medium");
		//pizza.setName("Margherita");
		OrderValidator.validatePizza(pizza);
	}
	
	@Test
	public void addPizzaWithValidCrustAndTopping() throws InvalidCrustException, InvalidToppingException {
		Pizza pizza = new Pizza("Margherita","Medium");
		//pizza.setName("Margherita");
		List<String> extraTopping= new ArrayList<String>();
		extraTopping.add("Pineapple");
		OrderValidator.validateToppings(pizza);
		pizza.setExtraTopping(extraTopping);
		Crust crust= new Crust("Thin Crust");
		pizza.setCrust(crust);
		OrderValidator.validateCrust(pizza);
	}
}
