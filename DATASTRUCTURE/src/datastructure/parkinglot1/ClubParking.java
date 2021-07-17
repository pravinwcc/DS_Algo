package datastructure.parkinglot1;

public class ClubParking implements ParkingChain{
	ParkingChain nextChain;
	@Override
	public void setNextParkingSlot(ParkingChain nextChain) {
		this.nextChain = nextChain;
		
	}

	@Override
	public void parkVehicle(String vehicle) {
		setNextParkingSlot(new GeneralCarParking());
		if (PakingSpaceManager.clubCarParking.size()<ParkingCapacity.club) {
			PakingSpaceManager.clubCarParking.add(vehicle);
			System.out.println("Your vehicle park successfully. Available space is-"+ (ParkingCapacity.club - PakingSpaceManager.clubCarParking.size()));
		} else{
			System.out.println("Club parking is full, Sending the request for Gen parking");
			this.nextChain.parkVehicle(vehicle);
			}
		
	}

}
