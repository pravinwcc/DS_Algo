package datastructure.parkinglot1;

import java.util.Scanner;

public class Admin {
	public static void main(String arg[]) {

		while(true){
			System.out.println("Enter vehicle type for park");
			Scanner vehicle = new Scanner(System.in);
			String vehicleType = vehicle.next();
			switch (vehicleType) {
			case "VIP": {
				new VIPCarParking().parkVehicle(vehicleType) ;
				break;
			}
			case "CLUB": {
				new ClubParking().parkVehicle(vehicleType);
				break;
			}
			case "GENERAL": {
				new GeneralCarParking().parkVehicle(vehicleType);
				break;
			}
			default:
				System.out.println("Parkin details not available !!");
			}
		}
	
	}
}
