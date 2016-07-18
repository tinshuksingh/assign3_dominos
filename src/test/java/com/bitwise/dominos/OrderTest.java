package com.bitwise.dominos;

import static org.junit.Assert.*;


import org.junit.Test;

import com.bitwise.dominos.exception.InvalidCrustException;
import com.bitwise.dominos.exception.InvalidOrderException;
import com.bitwise.dominos.exception.InvalidToppingException;
import com.bitwise.dominos.home.OrderPizza;
import com.bitwise.dominos.vo.Crust;
import com.bitwise.dominos.vo.Pizza;

/**
 * @author tinshuk
 *
 */
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
	public void shouldReturnInvalidToppingException() throws InvalidCrustException, 
	InvalidOrderException, InvalidToppingException {
		Pizza pizza = new Pizza("Chicken Maxicana","Medium");
		pizza.getExtraTopping().add("Chicken Sausage_1");
		pizza.getExtraTopping().add("Chicken Salami_1");
		OrderPizza order= new OrderPizza();
		order.addPizza(pizza);
	}
	
	@Test
	public void shouldBeAbleToReturnPizzaPrice() throws InvalidOrderException, InvalidCrustException, InvalidToppingException {
		OrderPizza order= new OrderPizza();
		order.addPizza(new Pizza("Margherita","Medium"));
		order.calculateTotalPrice();
		assertEquals(187.5,order.getTotalAmount(),0);
	}
	
	@Test
	public void shouldBeAbleToCalculatePizzaPriceWithTopping() throws InvalidCrustException, InvalidOrderException, InvalidToppingException {
		Pizza pizza = new Pizza("Chicken Maxicana","Medium");
		pizza.getExtraTopping().add("Chicken Sausage");//110
		pizza.getExtraTopping().add("Chicken Salami");//95
		pizza.getExtraTopping().add("Tomato");//10
		OrderPizza order= new OrderPizza();
		order.addPizza(pizza);
		order.calculateTotalPrice();
		assertEquals(643.75,order.getTotalAmount(),0);
	}
	
	//order1
	@Test
	public void shouldReturnMultiplePizzaPriceWithTax() throws InvalidOrderException, InvalidCrustException, InvalidToppingException {
		OrderPizza order = new OrderPizza();
		order.addPizza(new Pizza("Chicken Maxicana","Medium"));
		order.addPizza(new Pizza("Veggie Paradise","Medium"));
		order.addPizza(new Pizza("Zesty Chicken","Medium"));
		order.calculateTotalPrice();
		assertEquals(1012.5,order.getTotalAmount(),2);
		
	}
	
	//order2
		@Test
		public void shouldReturnMultiplePizzaPriceWithTaxAndAddExtraToppingAndCrust() throws InvalidOrderException, InvalidCrustException, InvalidToppingException {
			OrderPizza order = new OrderPizza();
			Pizza pizza = new Pizza("Hawaiian Delight Veg","Medium");
			pizza.getExtraTopping().add("Cheese");//20
			pizza.getExtraTopping().add("Olives");//15
			pizza.setCrust(new Crust("Pan Pizza"));
			order.addPizza(pizza);
			
			pizza = new Pizza("Hawaiian Delight NonVeg","Medium");
			pizza.getExtraTopping().add("Barbeque Chicken");//100
			pizza.setCrust(new Crust("Cheese Burst"));
			order.addPizza(pizza);
			
			order.calculateTotalPrice();
			double totalPrice=order.getTotalAmount();
			assertEquals(1068.75,totalPrice,2);
		}

		
		//order 3
		@Test
		public void shouldReturnMulPizzaPriceWithTaxExtraToppingCrustRemoveSomeToppings() 
				throws InvalidOrderException, InvalidCrustException, InvalidToppingException {
			OrderPizza order = new OrderPizza();
			Pizza pizza = new Pizza("Peppy Paneer","Medium");
			pizza.setCrust(new Crust("Thin Crust"));
			pizza.getRemoveDefaultTopping().add("Capsicum");
			pizza.getExtraTopping().add("Olives");
			pizza.getExtraTopping().add("Baby Corn");
			order.addPizza(pizza);
			
			pizza = new Pizza("Peppy Paneer","Medium");
			pizza.setCrust(new Crust("Thin Crust"));
			pizza.getRemoveDefaultTopping().add("Capsicum");
			pizza.getExtraTopping().add("Olives");
			pizza.getExtraTopping().add("Baby Corn");
			order.addPizza(pizza);
			
			pizza = new Pizza("Peppy Paneer","Medium");
			pizza.setCrust(new Crust("Thin Crust"));
			pizza.getExtraTopping().add("Cheese");
			order.addPizza(pizza);
			
			pizza = new Pizza("Peppy Paneer","Medium");
			pizza.setCrust(new Crust("Thin Crust"));
			pizza.getExtraTopping().add("Cheese");
			order.addPizza(pizza);
			
			pizza = new Pizza("Margherita","Medium");
			order.addPizza(pizza);
			
			pizza = new Pizza("Hawaiian Delight Veg","Medium");
			order.addPizza(pizza);
			
			pizza = new Pizza("Zesty Chicken","Medium");
			pizza.setCrust(new Crust("Cheese Burst"));
			pizza.getRemoveDefaultTopping().add("Paprika");
			pizza.getExtraTopping().add("Olives");
			pizza.getExtraTopping().add("Baby Corn");
			pizza.getExtraTopping().add("Onion");
			order.addPizza(pizza);
			
			order.calculateTotalPrice();
			double totalPrice=order.getTotalAmount();
			assertEquals(3093.75,totalPrice,2);
			
		}
		
		@Test
		public void placeOrderWithMultiplePizzaToppings() throws InvalidOrderException, InvalidCrustException, InvalidToppingException {
			OrderPizza order = new OrderPizza();
			Pizza pizza = new Pizza("Zesty Chicken","Medium");//
			pizza.setCrust(new Crust("Cheese Burst"));
			pizza.getRemoveDefaultTopping().add("Paprika");
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
			pizza.setCrust(new Crust("Thin Crust"));
			pizza.getRemoveDefaultTopping().add("Capsicum");
			pizza.getExtraTopping().add("Baby Corn");
			pizza.getExtraTopping().add("Olives");
			order.addPizza(pizza);
			
			pizza = new Pizza("Cloud9","Medium");
			pizza.setCrust(new Crust("Thin Crust"));
			pizza.getRemoveDefaultTopping().add("Capsicum");
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
