package com.split.dto;

public class EachPersonDTO {
	
	private String name;
	private double amount;
	
	public EachPersonDTO() {
		super();
	}
	public EachPersonDTO(String name, double amount) {
		super();
		this.name = name;
		this.amount = amount;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	@Override
	public String toString() {
		return "EachPersonDTO [name=" + name + ", amount=" + amount + "]";
	}
	
}
