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

	@Test(expected = InvalidOrderException.class)
	public void shouldThrowExceptionIfPizzaListIsNull() throws InvalidOrderException, InvalidCrustException, InvalidToppingException{
		OrderPizza order = new OrderPizza();
		order.addPizza(null);
	}
	
	@Test(expected = InvalidOrderException.class)
	public void shouldThrowExceptionIfPizzaListIsEmpty() throws InvalidOrderException, InvalidCrustException, InvalidToppingException{
		OrderPizza order = new OrderPizza();
		Pizza pizza= new Pizza("","");
		order.addPizza(pizza);
	}
	
	@Test(expected = InvalidToppingException.class)
	public void shouldReturnInvalidToppingException() throws InvalidCrustException, InvalidOrderException, InvalidToppingException {
		Pizza pizza = new Pizza("Chicken Maxicana","Medium");
		List<String> extraTopping= new ArrayList<String>();
		extraTopping.add("Chicken Sausage_1");
		extraTopping.add("Chicken Salami_1");
		pizza.setExtraTopping(extraTopping);
		OrderPizza order= new OrderPizza();
		order.addPizza(pizza);
	}
	
	@Test
	public void shouldBeAbleToReturnPizzaPrice() throws InvalidOrderException, InvalidCrustException, InvalidToppingException {
		Pizza pizza = new Pizza("Margherita","Medium");
		OrderPizza order= new OrderPizza();
		order.addPizza(pizza);
		order.calculateTotalPrice();
		assertEquals(187.5,order.getTotalAmount(),0);
	}
	
	@Test
	public void shouldBeAbleToCalculatePizzaPriceWithTopping() throws InvalidCrustException, InvalidOrderException, InvalidToppingException {
		Pizza pizza = new Pizza("Chicken Maxicana","Medium");
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
		Pizza pizza = new Pizza("Chicken Maxicana","Medium");
		order.addPizza(pizza);
		pizza = new Pizza("Veggie Paradise","Medium");
		order.addPizza(pizza);
		pizza = new Pizza("Zesty Chicken","Medium");
		order.addPizza(pizza);
		order.calculateTotalPrice();
		
		System.out.println(order.toString());
		assertEquals(1012.5,order.getTotalAmount(),2);
		
	}
	
	//order2
		@Test
		public void shouldReturnMultiplePizzaPriceWithTaxAndAddExtraToppingAndCrust() throws InvalidOrderException, InvalidCrustException, InvalidToppingException {
			OrderPizza order = new OrderPizza();
			Pizza pizza = new Pizza("Hawaiian Delight Veg","Medium");
			pizza.getExtraTopping().add("Cheese");//20
			pizza.getExtraTopping().add("Olives");//15
			pizza.setExtraTopping(pizza.getExtraTopping());
			Crust crust= new Crust("Pan Pizza",0);//100
			pizza.setCrust(crust);
			order.addPizza(pizza);
			
			pizza = new Pizza("Hawaiian Delight NonVeg","Medium");
			pizza.getExtraTopping().add("Barbeque Chicken");//100
			crust= new Crust("Cheese Burst",0);//200
			pizza.setCrust(crust);
			order.addPizza(pizza);
			
			order.calculateTotalPrice();
			double totalPrice=order.getTotalAmount();
			assertEquals(1068.75,totalPrice,2);
			
		}

		
		//order 3
		@Test
		public void shouldReturnMultiplePizzaPriceWithTaxAndAddExtraToppingAndCrustAndRemoveSomeToppings() 
				throws InvalidOrderException, InvalidCrustException, InvalidToppingException {
			OrderPizza order = new OrderPizza();
			
			Pizza pizza = new Pizza("Peppy Paneer","Medium");
			Crust crust= new Crust("Thin Crust",0);//
			pizza.setCrust(crust);
			pizza.getRemovedDefaultTopping().add("Capsicum");
			pizza.getExtraTopping().add("Olives");
			pizza.getExtraTopping().add("Baby Corn");
			order.addPizza(pizza);
			
			pizza = new Pizza("Peppy Paneer","Medium");
			crust= new Crust("Thin Crust",0);//
			pizza.setCrust(crust);
			pizza.getRemovedDefaultTopping().add("Capsicum");
			pizza.getExtraTopping().add("Olives");
			pizza.getExtraTopping().add("Baby Corn");
			order.addPizza(pizza);
			
			pizza = new Pizza("Peppy Paneer","Medium");
			crust= new Crust("Thin Crust",0);//
			pizza.setCrust(crust);
			pizza.getExtraTopping().add("Cheese");
			order.addPizza(pizza);
			
			pizza = new Pizza("Peppy Paneer","Medium");
			crust= new Crust("Thin Crust",0);//
			pizza.setCrust(crust);
			pizza.getExtraTopping().add("Cheese");
			order.addPizza(pizza);
			
			pizza = new Pizza("Margherita","Medium");
			order.addPizza(pizza);
			
			pizza = new Pizza("Hawaiian Delight Veg","Medium");
			order.addPizza(pizza);
			
			pizza = new Pizza("Zesty Chicken","Medium");
			crust= new Crust("Cheese Burst",0);//
			pizza.setCrust(crust);
			pizza.getRemovedDefaultTopping().add("Paprika");
			pizza.getExtraTopping().add("Olives");
			pizza.getExtraTopping().add("Baby Corn");
			pizza.getExtraTopping().add("Onion");
			System.out.println("order : "+ order);
			order.addPizza(pizza);
			
			order.calculateTotalPrice();
			double totalPrice=order.getTotalAmount();
			assertEquals(3093.75,totalPrice,2);
			
		}
		
		@Test
		public void order4() throws InvalidOrderException, InvalidCrustException, InvalidToppingException {
			OrderPizza order = new OrderPizza();
			Pizza pizza = new Pizza("Zesty Chicken","Medium");//
			Crust crust= new Crust("Cheese Burst",0);//
			pizza.setCrust(crust);
			pizza.getRemovedDefaultTopping().add("Paprika");
			pizza.getExtraTopping().add("Baby Corn");
			pizza.getExtraTopping().add("Olives");
			pizza.getExtraTopping().add("Onion");
			order.addPizza(pizza);
			
			pizza = new Pizza("Hawaiian Delight Veg","Small");
			order.addPizza(pizza);
			
			pizza = new Pizza("Seventh Heaven","Large");
			pizza.getExtraTopping().add("Smoked Chicken");
			pizza.getExtraTopping().add("Cheese");
			order.addPizza(pizza);
			
			
			pizza = new Pizza("Cloud9","Medium");
			crust= new Crust("Thin Crust",0);//
			pizza.setCrust(crust);
			pizza.getRemovedDefaultTopping().add("Capsicum");
			pizza.getExtraTopping().add("Baby Corn");
			pizza.getExtraTopping().add("Olives");
			order.addPizza(pizza);
			
			pizza = new Pizza("Cloud9","Medium");
			crust= new Crust("Thin Crust",0);//
			pizza.setCrust(crust);
			pizza.getRemovedDefaultTopping().add("Capsicum");
			pizza.getExtraTopping().add("Baby Corn");
			pizza.getExtraTopping().add("Olives");
			order.addPizza(pizza);
			
			pizza = new Pizza("Cloud9","Small");
			order.addPizza(pizza);
			
			pizza = new Pizza("Cloud9","Large");
			order.addPizza(pizza);
			pizza.getExtraTopping().add("Cheese");
			
			order.calculateTotalPrice();
			double totalPrice=order.getTotalAmount();
			assertEquals(3418.75,totalPrice,2);
		}

}
