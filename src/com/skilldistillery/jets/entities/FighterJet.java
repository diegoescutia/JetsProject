package com.skilldistillery.jets.entities;

public class FighterJet extends Jet implements CombatReady{
 
	
	
	public FighterJet() {
	}

	public FighterJet(String model, double speed, int range, double price) {
		super(model, speed, range, price);
	}

	@Override
	public void fight() {
		System.out.println("Great balls of fire!! ");
		System.out.println("Talk to me Goose! ");
		System.out.println("I lost them!");
		System.out.println("pew! pew! pew!");
		System.out.println("...Dogfight is over");
		
		
	}

	
}
