package com.bitwise.dominos;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.bitwise.dominos.exception.InvalidCrustException;
import com.bitwise.dominos.exception.InvalidOrderException;
import com.bitwise.dominos.exception.InvalidToppingException;
import com.bitwise.dominos.home.OrderPizza;
import com.bitwise.dominos.vo.Crust;
import com.bitwise.dominos.vo.Pizza;

public class OrderTest {

	
	@Test(expected = InvalidToppingException.class)
	public void shouldReturnInvalidToppingException() throws InvalidCrustException, InvalidOrderException, InvalidToppingException {
		Pizza pizza = new Pizza();
		pizza.setName("Chicken Maxicana");
		List<String> extraTopping= new ArrayList<String>();
		extraTopping.add("Chicken Sausage_1");
		extraTopping.add("Chicken Salami_1");
		pizza.setExtraTopping(extraTopping);
		OrderPizza order= new OrderPizza();
		order.addPizza(pizza);
	}
	
	@Test
	public void shouldBeAbleToReturnPizzaPrice() throws InvalidOrderException, InvalidCrustException, InvalidToppingException {
		Pizza pizza = new Pizza();
		pizza.setName("Margherita");
		OrderPizza order= new OrderPizza();
		order.addPizza(pizza);
		order.calculateTotalPrice();
		assertEquals(187.5,order.getTotalAmount(),0);
	}
	
	@Test
	public void shouldBeAbleToCalculatePizzaPriceWithTopping() throws InvalidCrustException, InvalidOrderException, InvalidToppingException {
		Pizza pizza = new Pizza();
		pizza.setName("Chicken Maxicana");//300
		List<String> extraTopping= new ArrayList<String>();
		extraTopping.add("Chicken Sausage");//110
		extraTopping.add("Chicken Salami");//95
		extraTopping.add("Tomato");//10
		pizza.setExtraTopping(extraTopping);
		OrderPizza order= new OrderPizza();
		order.addPizza(pizza);
		order.calculateTotalPrice();
		assertEquals(643.75,order.getTotalAmount(),0);
	}
	
	//order1
	@Test
	public void shouldReturnMultiplePizzaPriceWithTax() throws InvalidOrderException, InvalidCrustException, InvalidToppingException {
		OrderPizza order = new OrderPizza();
		Pizza pizza = new Pizza();
		pizza.setName("Chicken Maxicana"); //300
		order.addPizza(pizza);
		pizza = new Pizza();
		pizza.setName("Veggie Paradise");//230
		order.addPizza(pizza);
		pizza = new Pizza();
		pizza.setName("Zesty Chicken");//280
		order.addPizza(pizza);
		order.calculateTotalPrice();
		
		System.out.println(order.toString());
		assertEquals(1012.5,order.getTotalAmount(),2);
		
	}
	
	//order2
		@Test
		public void shouldReturnMultiplePizzaPriceWithTaxAndAddExtraToppingAndCrust() throws InvalidOrderException, InvalidCrustException, InvalidToppingException {
			OrderPizza order = new OrderPizza();
			Pizza pizza = new Pizza();
			pizza.setName("Hawaiian Delight Veg");//200
			pizza.getExtraTopping().add("Cheese");//20
			pizza.getExtraTopping().add("Olives");//15
			pizza.setExtraTopping(pizza.getExtraTopping());
			Crust crust= new Crust("Pan Pizza",0);//100
			pizza.setCrust(crust);
			order.addPizza(pizza);
			
			pizza = new Pizza();
			pizza.setName("Hawaiian Delight NonVeg"); //220
			pizza.getExtraTopping().add("Barbeque Chicken");//100
			crust= new Crust("Cheese Burst",0);//200
			pizza.setCrust(crust);
			order.addPizza(pizza);
			
			order.calculateTotalPrice();
			
			double totalPrice=order.getTotalAmount();
			assertEquals(1068.75,totalPrice,2);
			
		}

}
