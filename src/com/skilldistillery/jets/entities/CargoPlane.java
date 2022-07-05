package com.skilldistillery.jets.entities;

public class CargoPlane extends Jet implements CargoCarrier {

	public CargoPlane() {
		super();
	}
	
	public void fly(){}

	public CargoPlane(String model, double speed, int range, double price) {
		super(model, speed, range, price);
	}

	public void loadCargo() {
		System.out.println("Loading cargo into plane...");
		System.out.println("... Plane is locked and loaded ...ready to go!");

	}
}
