package com.bitwise.dominos.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.bitwise.dominos.vo.Crust;
import com.bitwise.dominos.vo.Pizza;
import com.bitwise.dominos.vo.Topping;

public class PizzaDB {

	private static Map<String, Pizza> allPizzaMap = 
			new HashMap<String, Pizza>();
	
	static {
		// Margherita
		Pizza pizza = new Pizza();
		ArrayList<Topping> defaultTopping = new ArrayList<Topping>();
		pizza.setName("Margherita");
		pizza.setPrice(150);
		defaultTopping.add(ToppingDB.getPizzaToppingsMap().get("Tomato"));
		pizza.setDefaultToppipng(defaultTopping);
		pizza.setCrust(new Crust("Regular", 0));
		allPizzaMap.put("Margherita", pizza);
		
		// Hawaiian Delight Non Veg
		pizza = new Pizza();
		defaultTopping = new ArrayList<Topping>();
		pizza.setName("Hawaiian Delight Non Veg");
		pizza.setPrice(220);
		defaultTopping.add(ToppingDB.getPizzaToppingsMap().get("Chicken Salami"));
		defaultTopping.add(ToppingDB.getPizzaToppingsMap().get("Jalapeno"));
		defaultTopping.add(ToppingDB.getPizzaToppingsMap().get("Pineapple"));
		pizza.setDefaultToppipng(defaultTopping);
		pizza.setCrust(new Crust("Regular", 0));
		allPizzaMap.put("Hawaiian Delight Non Veg", pizza);
		
		// Hawaiian Delight Veg
		pizza = new Pizza();
		defaultTopping = new ArrayList<Topping>();
		pizza.setName("Hawaiian Delight Veg");
		pizza.setPrice(200);
		defaultTopping.add(ToppingDB.getPizzaToppingsMap().get("Chicken Salami"));
		defaultTopping.add(ToppingDB.getPizzaToppingsMap().get("Pineapple"));
		defaultTopping.add(ToppingDB.getPizzaToppingsMap().get("Jalapeno"));
		pizza.setDefaultToppipng(defaultTopping);
		pizza.setCrust(new Crust("Regular", 0));
		allPizzaMap.put("Hawaiian Delight Veg", pizza);
		
		// Veggie Paradise
		pizza = new Pizza();
		defaultTopping = new ArrayList<Topping>();
		pizza.setName("Veggie Paradise");
		pizza.setPrice(230);
		defaultTopping.add(ToppingDB.getPizzaToppingsMap().get("Baby Corn"));
		defaultTopping.add(ToppingDB.getPizzaToppingsMap().get("Olives"));
		defaultTopping.add(ToppingDB.getPizzaToppingsMap().get("Capsicum"));
		defaultTopping.add(ToppingDB.getPizzaToppingsMap().get("Paprika"));
		pizza.setDefaultToppipng(defaultTopping);
		pizza.setCrust(new Crust("Regular", 0));
		allPizzaMap.put("Veggie Paradise", pizza);
		
		// Peppy Paneer
		pizza = new Pizza();
		pizza.setName("Peppy Paneer");
		pizza.setPrice(230);
		defaultTopping = new ArrayList<Topping>();
		defaultTopping.add(ToppingDB.getPizzaToppingsMap().get("Panner"));
		defaultTopping.add(ToppingDB.getPizzaToppingsMap().get("Capsicum"));
		defaultTopping.add(ToppingDB.getPizzaToppingsMap().get("Paprika"));
		pizza.setDefaultToppipng(defaultTopping);
		pizza.setCrust(new Crust("Regular", 0));
		allPizzaMap.put("Peppy Paneer", pizza);
		/*Map<String, Integer> pp = new HashMap<String, Integer>();
		pp.put("Small", 115);
		pp.put("Medium", 230);
		pp.put("Large", 460);*/

		// Zesty Chicken
		pizza = new Pizza();
		defaultTopping = new ArrayList<Topping>();
		pizza.setName("Zesty Chicken");
		pizza.setPrice(280);
		defaultTopping.add(ToppingDB.getPizzaToppingsMap().get("Capsicum"));
		defaultTopping.add(ToppingDB.getPizzaToppingsMap().get("Paprika"));
		defaultTopping.add(ToppingDB.getPizzaToppingsMap().get("Chicken Sausage"));
		defaultTopping.add(ToppingDB.getPizzaToppingsMap().get("Barbeque Chicken"));
		pizza.setDefaultToppipng(defaultTopping);
		pizza.setCrust(new Crust("Regular", 0));
		allPizzaMap.put("Zesty Chicken", pizza);
		
		/*Map<String, Integer> chicZest = new HashMap<String, Integer>();
		chicZest.put("Small", 140);
		chicZest.put("Medium", 280);
		chicZest.put("Large", 560);*/
		
		// Chicken Maxicana
		pizza = new Pizza();
		defaultTopping = new ArrayList<Topping>();
		pizza.setName("Chicken Maxicana");
		pizza.setPrice(300);
		defaultTopping.add(ToppingDB.getPizzaToppingsMap().get("Paprika"));
		defaultTopping.add(ToppingDB.getPizzaToppingsMap().get("Onion"));
		defaultTopping.add(ToppingDB.getPizzaToppingsMap().get("Tomato"));
		defaultTopping.add(ToppingDB.getPizzaToppingsMap().get("Spicy Chicken"));		
		pizza.setDefaultToppipng(defaultTopping);
		pizza.setCrust(new Crust("Regular", 0));
		allPizzaMap.put("Chicken Maxicana", pizza);
		
		/*Map<String, Integer> chicMaxi = new HashMap<String, Integer>();
		chicMaxi.put("Small", 150);
		chicMaxi.put("Medium", 300);
		chicMaxi.put("Large", 600);*/

		// Seventh Heaven
		pizza = new Pizza();
		defaultTopping = new ArrayList<Topping>();
		pizza.setName("Seventh Heaven");
		pizza.setPrice(250);
		defaultTopping.add(ToppingDB.getPizzaToppingsMap().get("Paprika"));
		defaultTopping.add(ToppingDB.getPizzaToppingsMap().get("Onion"));
		defaultTopping.add(ToppingDB.getPizzaToppingsMap().get("Tomato"));
		defaultTopping.add(ToppingDB.getPizzaToppingsMap().get("Spicy Chicken"));		
		pizza.setDefaultToppipng(defaultTopping);
		pizza.setCrust(new Crust("Regular", 0));
		allPizzaMap.put("Seventh Heaven", pizza);
		/*Map<String, Integer> seven = new HashMap<String, Integer>();
		seven.put("Small", 125);
		seven.put("Medium", 250);
		seven.put("Large", 500);*/
		
		// Cloud9
		pizza = new Pizza();
		defaultTopping = new ArrayList<Topping>();
		pizza.setName("Cloud9");
		pizza.setPrice(240);
		defaultTopping.add(ToppingDB.getPizzaToppingsMap().get("Paprika"));
		defaultTopping.add(ToppingDB.getPizzaToppingsMap().get("Onion"));
		defaultTopping.add(ToppingDB.getPizzaToppingsMap().get("Tomato"));
		defaultTopping.add(ToppingDB.getPizzaToppingsMap().get("Spicy Chicken"));		
		pizza.setDefaultToppipng(defaultTopping);
		pizza.setCrust(new Crust("Regular", 0));
		allPizzaMap.put("Cloud9", pizza);
		
		/*Map<String, Integer> cloud9 = new HashMap<String, Integer>();
		cloud9.put("Small", 120);
		cloud9.put("Medium", 240);
		cloud9.put("Large", 480);*/

	}

	public static Map<String, Pizza> getAllPizzaMap() {
		return allPizzaMap;
	}
	
	public static void setAllPizzaMap(Map<String, Pizza> allPizzaMap) {
		PizzaDB.allPizzaMap = allPizzaMap;
	}
}
