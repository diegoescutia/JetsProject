package com.skilldistillery.jets.entities;

public class Passenger extends Jet {
	private String name = "Passenger";
	
	public Passenger() {
		super();
	}

	public Passenger(String model, double speed, int range, double price) {
		super(model, speed, range, price);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
		
	
}
