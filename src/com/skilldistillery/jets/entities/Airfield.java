package com.skilldistillery.jets.entities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Airfield {

	private List<Jet> fleet;

	public Airfield() {
		fleet = new ArrayList<>();
		defaultPlanes();
	}

	public void viewFleet() {
		System.out.println("These are all the planes in your fleet:");
		for (Jet jet : fleet) {
			System.out.println(jet);
		}
		System.out.println();
	}

	public void flyAllPlanes() {
		for (Jet jet : fleet) {
			System.out.println(jet.toString());
			System.out.println("At top speed, it can fly for:" + jet.fly(jet.getRange(), jet.getSpeed()) + " hours");
			System.out.println();
		}
	}

	public void fastestJet() {
		Jet fastest = fleet.get(0);

		for (Jet jet : fleet) {
			if (jet.getSpeed() > fastest.getSpeed()) {
				fastest = jet;
			}
		}
		System.out.println();
		System.out.println("The fastest jet is: " + fastest.toString());
		System.out.println();
	}

	public void longestRange() {
		Jet longest = fleet.get(0);

		for (Jet jet : fleet) {
			if (jet.getRange() > longest.getRange()) {
				longest = jet;
			}
		}
		System.out.println();
		System.out.println("The jet with the longest range is: " + longest.toString());
		System.out.println();
	}

	public void loadCargo() {
		for (Jet jet : fleet) {
			if (jet instanceof CargoPlane) {
				System.out.println(jet.getModel());
				((CargoPlane) jet).loadCargo();
				System.out.println();
			}
		}

	}

	public void dogFight() {
		for (Jet jet : fleet) {
			if (jet instanceof FighterJet) {
				System.out.println(jet.getModel());
				((FighterJet) jet).fight();
				System.out.println();
			}
		}
	}

	public void addJet(Scanner scan) {
		System.out.println("Enter model");
		String model = scan.next();
		
		System.out.println("Enter speed");
		double speed = scan.nextDouble();

		System.out.println("Enter range");
		int range = scan.nextInt();

		System.out.println("Enter price");
		double price = scan.nextDouble();

		System.out.println("Enter the number for the type of aircraft");
		System.out.println("1. Passenger Plane");
		System.out.println("2. Cargo Plane");
		System.out.println("3. Fighter Jet");
		int option = scan.nextInt();
		Jet newPlane = null;
		if (option == 1) {
			newPlane = new Passenger(model, speed, range, price);
		} else if (option == 2) {
			newPlane = new CargoPlane(model, speed, range, price);
		} else if (option == 3) {
			newPlane = new FighterJet(model, speed, range, price);
		}
		
		fleet.add(newPlane);
		System.out.println("Your plane was added to the fleet");
		System.out.println();
		viewFleet();
	}
	
	public void removeJet(Scanner scan) {
		
		System.out.println("Type the number of the plane you want to remove");
		
		for( int i = 0; i < fleet.size(); i++) {
			Jet jet = fleet.get(i);
			System.out.println((i + 1) + ".) " + jet.toString());
		}
		
		int choice = scan.nextInt();
		fleet.remove(choice - 1);
		System.out.println("Plane removed");
		viewFleet();
	}
	
	public void quit() {
		System.out.println("Thank you for using JETS ");
		
		
	}

	public void defaultPlanes() {
		List<String> defaultPlanes = new ArrayList<String>();

		try (BufferedReader bufIn = new BufferedReader(new FileReader("jets.csv"))) {
			String line;
			while ((line = bufIn.readLine()) != null) {
				defaultPlanes.add(line);

			}
		} catch (IOException e) {
			System.err.println(e);
		}

		for (String line : defaultPlanes) {
			String[] lineSplit = line.split(",");
			String type = lineSplit[0];
			String model = lineSplit[1];
			double speed = Double.valueOf(lineSplit[2]);
			int range = Integer.valueOf(lineSplit[3]);
			double price = Double.valueOf(lineSplit[4]);

			if (type.equals("Passenger")) {
				Passenger e = new Passenger(model, speed, range, price);
				fleet.add(e);
			} else if (type.equals("FighterJet")) {
				FighterJet e = new FighterJet(model, speed, range, price);
				fleet.add(e);
			} else if (type.equals("Cargo")) {
				CargoPlane e = new CargoPlane(model, speed, range, price);
				fleet.add(e);
			}
		}
	}

}
