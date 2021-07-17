package datastructure.parkinglot1;

public class GeneralCarParking implements ParkingChain {

	@Override
	public void setNextParkingSlot(ParkingChain nextChain) {

	}

	@Override
	public void parkVehicle(String vehicle) {
		if (PakingSpaceManager.clubCarParking.size()<ParkingCapacity.gen) {
			PakingSpaceManager.clubCarParking.add(vehicle);
			System.out.println("Your vehicle park successfully. Available space is-"+ (ParkingCapacity.gen - PakingSpaceManager.genCarParking.size()));
		} else {
			System.out.println("Parking is full please wait !!");
		}

	}

}
