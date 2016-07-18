package com.bitwise.dominos.vo;

/**
 * @author tinshuk
 *
 */
public class Crust {
	@Override
	public String toString() {
		return "Crust [crustType=" + crustType + ", crustPrice=" + crustPrice
				+ "]";
	}
	private String crustType;
	private double crustPrice;
	
	public Crust(String crustType) {
		this.crustType=crustType;
	}
	
	public Crust(String crustType, int crustPrice) {
		this.crustPrice=crustPrice;
		this.crustType=crustType;
	}
	public String getCrustType() {
		return crustType;
	}
	public void setCrustType(String crustType) {
		this.crustType = crustType;
	}
	public double getCrustPrice() {
		return crustPrice;
	}
	public void setCrustPrice(double crustPrice) {
		this.crustPrice = crustPrice;
	}
	
}
