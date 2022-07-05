package com.skilldistillery.jets.app;

import java.util.Scanner;

import com.skilldistillery.jets.entities.Airfield;

public class JetsApplication {

	public static void main(String[] args) {
		JetsApplication rn = new JetsApplication();
		rn.run();
	}

	public void run() {
		Scanner scan = new Scanner(System.in);
		menu(scan);
		scan.close();
	}
	
	public void menu(Scanner scan) {
		Airfield fleet = new Airfield();
		
		boolean trigger = true;
		while(trigger) {
		
		System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
		System.out.println(" --      WELCOME TO JETS        -- ");
		System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
		System.out.println("     Type a number from menu"      );
		System.out.println("-----------------------------------");
		System.out.println("| 1. List fleet                   |");
		System.out.println("| 2. Fly all jets                 |");
		System.out.println("| 3. View fastest jet             |");
		System.out.println("| 4. View jet with longest range  |");
		System.out.println("| 5. Load all Cargo Jets          |");
		System.out.println("| 6. Dogfight!                    |");
		System.out.println("| 7. Add a jet to Fleet           |");
		System.out.println("| 8. Remove a jet from Fleet      |");
		System.out.println("| 9. Quit                         |");
		System.out.println("-----------------------------------");
		
		int selection = scan.nextInt();
		
		switch(selection) {
		
		case 1: fleet.viewFleet();
				break;
		
		case 2: fleet.flyAllPlanes();
				break;
		
		case 3: fleet.fastestJet();
				break;
				
		case 4: fleet.longestRange();
				break;
				
		case 5: fleet.loadCargo();
				break;
				
		case 6: fleet.dogFight();
				break;
		
		case 7: fleet.addJet(scan);
				break;
				
		case 8: fleet.removeJet(scan);
				break;
				
		case 9: fleet.quit();
				trigger=false;
				break;
		default: System.out.println("Enter a number between 1-9 ");
		}
		}
	}
}
