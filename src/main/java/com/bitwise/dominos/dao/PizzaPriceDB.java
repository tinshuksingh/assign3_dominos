package com.bitwise.dominos.dao;

import java.util.HashMap;
import java.util.Map;

/**
 * @author tinshuk
 *
 */
@SuppressWarnings({ "unchecked", "rawtypes" })
public class PizzaPriceDB {

	
	private static Map<String, Map<String,Integer>> allPizzaPrice = 
			new HashMap<String, Map<String,Integer>>();
	
	static{
		Map newMap=new HashMap<String, Integer>();
		newMap.put("Small", 80);
		newMap.put("Medium", 150);
		newMap.put("Large", 300);
		allPizzaPrice.put("Margherita", newMap);
		
		newMap=new HashMap<String, Integer>();
		newMap.put("Small", 100);
		newMap.put("Medium", 200);
		newMap.put("Large", 400);
		allPizzaPrice.put("Hawaiian Delight Veg", newMap);
		
		newMap=new HashMap<String, Integer>();
		newMap.put("Small", 110);
		newMap.put("Medium", 220);
		newMap.put("Large", 440);
		allPizzaPrice.put("Hawaiian Delight NonVeg", newMap);
		
		newMap=new HashMap<String, Integer>();
		newMap.put("Small", 115);
		newMap.put("Medium",230);
		newMap.put("Large", 460);
		allPizzaPrice.put("Veggie Paradise", newMap);
		
		newMap=new HashMap<String, Integer>();
		newMap.put("Small", 115);
		newMap.put("Medium", 230);
		newMap.put("Large", 460);
		allPizzaPrice.put("Peppy Paneer", newMap);
		
		newMap=new HashMap<String, Integer>();
		newMap.put("Small", 140);
		newMap.put("Medium", 280);
		newMap.put("Large", 560);
		allPizzaPrice.put("Zesty Chicken", newMap);
		
		newMap=new HashMap<String, Integer>();
		newMap.put("Small", 150);
		newMap.put("Medium", 300);
		newMap.put("Large", 600);
		allPizzaPrice.put("Chicken Maxicana", newMap);
		
		newMap=new HashMap<String, String>();
		newMap.put("Small", 125);
		newMap.put("Medium", 250);
		newMap.put("Large", 500);
		allPizzaPrice.put("Seventh Heaven", newMap);
		
		newMap=new HashMap<String, Integer>();
		newMap.put("Small", 120);
		newMap.put("Medium",240);
		newMap.put("Large", 480);
		allPizzaPrice.put("Cloud9", newMap);
		
	}
	
	public static Map<String, Integer> getPizzaPrice(String name) {
		return allPizzaPrice.get(name);
	}
	
}
