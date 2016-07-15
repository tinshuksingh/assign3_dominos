package com.bitwise.dominos.vo;

public class Crust {
	@Override
	public String toString() {
		return "Crust [crustType=" + crustType + ", crustPrice=" + crustPrice
				+ "]";
	}
	private String crustType;
	private float crustPrice;
	
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
	public float getCrustPrice() {
		return crustPrice;
	}
	public void setCrustPrice(float crustPrice) {
		this.crustPrice = crustPrice;
	}
	
}
