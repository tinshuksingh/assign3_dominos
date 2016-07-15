package com.bitwise.dominos;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.bitwise.dominos.exception.InvalidCrustException;
import com.bitwise.dominos.exception.InvalidOrderException;
import com.bitwise.dominos.exception.InvalidToppingException;
import com.bitwise.dominos.home.Order;
import com.bitwise.dominos.vo.Pizza;

public class OrderTest {

	@Test
	public void shouldBeAbleToReturnPizzaPrice() throws InvalidOrderException, InvalidCrustException, InvalidToppingException {
		Pizza pizza = new Pizza();
		pizza.setName("Margherita");
		Order order= new Order();
		order.addPizza(pizza);
		order.calculateTotalPrice();
		assertEquals(150,order.getTotalAmount(),0);
	}
	
	@Test
	public void shouldBeAbleToCalculatePizzaPriceWithTopping() throws InvalidCrustException, InvalidOrderException, InvalidToppingException {
		Pizza pizza = new Pizza();
		pizza.setName("Chicken Maxicana");
		List<String> extraTopping= new ArrayList<String>();
		extraTopping.add("Chicken Sausage");
		extraTopping.add("Chicken Salami");
		extraTopping.add("Tomato");
		
		pizza.setExtraTopping(extraTopping);
		
		Order order= new Order();
		order.addPizza(pizza);
		order.calculateTotalPrice();
		
		assertEquals(515,order.getTotalAmount(),0);
		
	}
	
	/*//order1
	@Test
	public void shouldReturnMultiplePizzaPriceWithTax() throws InvalidOrderException, InvalidCrustException {
		Order order = new Order();
		order.setVat(10);
		order.setServiceTax(15);
		Pizza pizza = new Pizza("Chicken Maxicana");
		order.getPizzaList().add(pizza);
		pizza = new Pizza("Veggie Paradise");
		order.getPizzaList().add(pizza);
		pizza = new Pizza("Zesty Chicken");
		order.getPizzaList().add(pizza);
		
		float totalPrice=order.getTotalAmount();
		System.out.println(order.toString());
		assertEquals(1012.5,totalPrice,2);
		
	}
	
	//order2
	@Test
	public void shouldReturnMultiplePizzaPriceWithTaxAndAddExtraToppingAndCrust() throws InvalidOrderException, InvalidCrustException {
		Order order = new Order();
		order.setVat(10);
		order.setServiceTax(15);
		Pizza pizza = new Pizza("Hawaiian Delight Veg","Pan Pizza");
		pizza.getExtraTopping().add("Cheese");
		pizza.getExtraTopping().add("Olives");
		order.getPizzaList().add(pizza);
		pizza = new Pizza("Hawaiian Delight NonVeg", "Cheese Burst");
		pizza.getExtraTopping().add("Barbeque Chicken");
		order.getPizzaList().add(pizza);
		
		
		float totalPrice=order.getTotalAmount();
		assertEquals(1068.75,totalPrice,2);
		
	}
	
	//order 3
	@Test
	public void shouldReturnMultiplePizzaPriceWithTaxAndAddExtraToppingAndCrustAndRemoveSomeToppings() throws InvalidOrderException, InvalidCrustException {
		Order order = new Order();
		order.setVat(10);
		order.setServiceTax(15);
		
		Pizza pizza = new Pizza("Peppy Paneer","Thin Crust");
		pizza.getRemovedDefaultTopping().add("Capsicum");
		pizza.getExtraTopping().add("Olives");
		pizza.getExtraTopping().add("Baby Corn");
		//pizza1 added
		order.getPizzaList().add(pizza);
		
		pizza = new Pizza("Peppy Paneer","Thin Crust");
		pizza.getRemovedDefaultTopping().add("Capsicum");
		pizza.getExtraTopping().add("Olives");
		pizza.getExtraTopping().add("Baby Corn");
		// pizza2 added
		order.getPizzaList().add(pizza);
		
		pizza = new Pizza("Peppy Paneer","Thin Crust");
		pizza.getExtraTopping().add("Cheese");
		//pizza3 added
		order.getPizzaList().add(pizza);
		
		pizza = new Pizza("Peppy Paneer","Thin Crust");
		pizza.getExtraTopping().add("Cheese");
		//pizza4 added
		order.getPizzaList().add(pizza);
		
		pizza = new Pizza("Margherita");
		//pizza5 added
		order.getPizzaList().add(pizza);
		
		pizza = new Pizza("Hawaiian Delight Veg");
		//pizza6 added
		order.getPizzaList().add(pizza);
		
		pizza = new Pizza("Zesty Chicken","Cheese Burst");
		pizza.getRemovedDefaultTopping().add("Paprika");
		pizza.getExtraTopping().add("Olives");
		pizza.getExtraTopping().add("Baby Corn");
		pizza.getExtraTopping().add("Onion");
		System.out.println("order : "+ order);
		order.getPizzaList().add(pizza);
		
		
		float totalPrice=order.getTotalAmount();
		assertEquals(3093.75,totalPrice,2);
		
	}

	@Test
	public void order4() throws InvalidOrderException, InvalidCrustException {
		Order order = new Order();
		order.setVat(10);
		order.setServiceTax(15);
		Pizza pizza = new Pizza("Zesty Chicken","Cheese Burst");
		pizza.getRemovedDefaultTopping().add("Paprika");
		pizza.getExtraTopping().add("Baby Corn");
		pizza.getExtraTopping().add("Olives");
		pizza.getExtraTopping().add("Onion");
		order.getPizzaList().add(pizza);
		
		pizza = new Pizza("Hawaiian Delight Veg",null,"Small");
		order.getPizzaList().add(pizza);
		
		pizza = new Pizza("Seventh Heaven",null,"Large");
		pizza.getExtraTopping().add("Smoked Chicken");
		pizza.getExtraTopping().add("Cheese");
		order.getPizzaList().add(pizza);
		
		
		pizza = new Pizza("Cloud9","Thin Crust");
		pizza.getRemovedDefaultTopping().add("Capsicum");
		pizza.getExtraTopping().add("Baby Corn");
		pizza.getExtraTopping().add("Olives");
		order.getPizzaList().add(pizza);
		
		pizza = new Pizza("Cloud9","Thin Crust");
		pizza.getRemovedDefaultTopping().add("Capsicum");
		pizza.getExtraTopping().add("Baby Corn");
		pizza.getExtraTopping().add("Olives");
		order.getPizzaList().add(pizza);
		
		pizza = new Pizza("Cloud9",null,"Small");
		order.getPizzaList().add(pizza);
		
		pizza = new Pizza("Cloud9",null,"Large");
		pizza.getExtraTopping().add("Cheese");
		order.getPizzaList().add(pizza);
		
		float totalPrice=order.getTotalAmount();
		assertEquals(3418.75,totalPrice,2);
	}

	@Test(expected = InvalidOrderException.class)
	public void shouldThrowExceptionIfPizzaListIsNull() throws InvalidOrderException, InvalidCrustException
	{
		Order order = new Order();
		order.setPizzaList(null);
		order.getTotalAmount();
	}
	
	@Test(expected = InvalidOrderException.class)
	public void shouldThrowExceptionIfPizzaListIsEmpty() throws InvalidOrderException, InvalidCrustException
	{
		Order order = new Order();
		order.getTotalAmount();
	}*/

}
