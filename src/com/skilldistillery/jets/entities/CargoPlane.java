package com.skilldistillery.jets.entities;

public class CargoPlane extends Jet implements CargoCarrier {
	private String name = "Cargo Plane";

	public CargoPlane() {
		super();
	}
	
	public void fly(){}

	public CargoPlane(String model, double speed, int range, double price) {
		super(model, speed, range, price);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void loadCargo() {
		System.out.println("Loading cargo into plane...");
		System.out.println("... Plane is cocked and loaded ...ready to go!");

	}
}
