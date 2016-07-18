package com.bitwise.dominos.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.bitwise.dominos.vo.Crust;
import com.bitwise.dominos.vo.Pizza;
import com.bitwise.dominos.vo.Topping;

/**
 * @author tinshuk
 *
 */
public class PizzaDB {

	private static Map<String, Pizza> allPizzaMap = 
			new HashMap<String, Pizza>();
	
	static {
		// Margherita
		Pizza pizza = new Pizza("Margherita","Medium");
		ArrayList<Topping> defaultTopping = new ArrayList<Topping>();
		defaultTopping.add(ToppingDB.getPizzaToppingsMap().get("Tomato"));
		pizza.setDefaultToppipng(defaultTopping);
		pizza.setCrust(new Crust("Regular", 0));
		allPizzaMap.put("Margherita", pizza);
		
		// Hawaiian Delight Non Veg
		pizza = new Pizza("Hawaiian Delight NonVeg","Medium");
		defaultTopping = new ArrayList<Topping>();
		defaultTopping.add(ToppingDB.getPizzaToppingsMap().get("Chicken Salami"));
		defaultTopping.add(ToppingDB.getPizzaToppingsMap().get("Jalapeno"));
		defaultTopping.add(ToppingDB.getPizzaToppingsMap().get("Pineapple"));
		pizza.setDefaultToppipng(defaultTopping);
		pizza.setCrust(new Crust("Regular", 0));
		allPizzaMap.put("Hawaiian Delight NonVeg", pizza);
		
		// Hawaiian Delight Veg
		pizza = new Pizza("Hawaiian Delight Veg","Medium");
		defaultTopping = new ArrayList<Topping>();
		defaultTopping.add(ToppingDB.getPizzaToppingsMap().get("Chicken Salami"));
		defaultTopping.add(ToppingDB.getPizzaToppingsMap().get("Pineapple"));
		defaultTopping.add(ToppingDB.getPizzaToppingsMap().get("Jalapeno"));
		pizza.setDefaultToppipng(defaultTopping);
		pizza.setCrust(new Crust("Regular", 0));
		allPizzaMap.put("Hawaiian Delight Veg", pizza);
		
		// Veggie Paradise
		pizza = new Pizza("Veggie Paradise","Medium");
		defaultTopping = new ArrayList<Topping>();
		defaultTopping.add(ToppingDB.getPizzaToppingsMap().get("Baby Corn"));
		defaultTopping.add(ToppingDB.getPizzaToppingsMap().get("Olives"));
		defaultTopping.add(ToppingDB.getPizzaToppingsMap().get("Capsicum"));
		defaultTopping.add(ToppingDB.getPizzaToppingsMap().get("Paprika"));
		pizza.setDefaultToppipng(defaultTopping);
		pizza.setCrust(new Crust("Regular", 0));
		allPizzaMap.put("Veggie Paradise", pizza);
		
		// Peppy Paneer
		pizza = new Pizza("Peppy Paneer","Medium");
		defaultTopping = new ArrayList<Topping>();
		defaultTopping.add(ToppingDB.getPizzaToppingsMap().get("Panner"));
		defaultTopping.add(ToppingDB.getPizzaToppingsMap().get("Capsicum"));
		defaultTopping.add(ToppingDB.getPizzaToppingsMap().get("Paprika"));
		pizza.setDefaultToppipng(defaultTopping);
		pizza.setCrust(new Crust("Regular", 0));
		allPizzaMap.put("Peppy Paneer", pizza);

		// Zesty Chicken
		pizza = new Pizza("Zesty Chicken","Medium");
		defaultTopping = new ArrayList<Topping>();
		defaultTopping.add(ToppingDB.getPizzaToppingsMap().get("Capsicum"));
		defaultTopping.add(ToppingDB.getPizzaToppingsMap().get("Paprika"));
		defaultTopping.add(ToppingDB.getPizzaToppingsMap().get("Chicken Sausage"));
		defaultTopping.add(ToppingDB.getPizzaToppingsMap().get("Barbeque Chicken"));
		pizza.setDefaultToppipng(defaultTopping);
		pizza.setCrust(new Crust("Regular", 0));
		allPizzaMap.put("Zesty Chicken", pizza);
		
		// Chicken Maxicana
		pizza = new Pizza("Chicken Maxicana","Medium");
		defaultTopping = new ArrayList<Topping>();
		defaultTopping.add(ToppingDB.getPizzaToppingsMap().get("Paprika"));
		defaultTopping.add(ToppingDB.getPizzaToppingsMap().get("Onion"));
		defaultTopping.add(ToppingDB.getPizzaToppingsMap().get("Tomato"));
		defaultTopping.add(ToppingDB.getPizzaToppingsMap().get("Spicy Chicken"));		
		pizza.setDefaultToppipng(defaultTopping);
		pizza.setCrust(new Crust("Regular", 0));
		allPizzaMap.put("Chicken Maxicana", pizza);
		
		// Seventh Heaven
		pizza = new Pizza("Seventh Heaven","Medium");
		defaultTopping = new ArrayList<Topping>();
		defaultTopping.add(ToppingDB.getPizzaToppingsMap().get("Paprika"));
		defaultTopping.add(ToppingDB.getPizzaToppingsMap().get("Onion"));
		defaultTopping.add(ToppingDB.getPizzaToppingsMap().get("Tomato"));
		defaultTopping.add(ToppingDB.getPizzaToppingsMap().get("Spicy Chicken"));		
		pizza.setDefaultToppipng(defaultTopping);
		pizza.setCrust(new Crust("Regular", 0));
		allPizzaMap.put("Seventh Heaven", pizza);
		
		// Cloud9
		pizza = new Pizza("Cloud9","Medium");
		defaultTopping = new ArrayList<Topping>();
		defaultTopping.add(ToppingDB.getPizzaToppingsMap().get("Paprika"));
		defaultTopping.add(ToppingDB.getPizzaToppingsMap().get("Onion"));
		defaultTopping.add(ToppingDB.getPizzaToppingsMap().get("Tomato"));
		defaultTopping.add(ToppingDB.getPizzaToppingsMap().get("Spicy Chicken"));		
		pizza.setDefaultToppipng(defaultTopping);
		pizza.setCrust(new Crust("Regular", 0));
		allPizzaMap.put("Cloud9", pizza);
		
	}

	public static Map<String, Pizza> getAllPizzaMap() {
		return allPizzaMap;
	}
	
	public static void setAllPizzaMap(Map<String, Pizza> allPizzaMap) {
		PizzaDB.allPizzaMap = allPizzaMap;
	}
}
