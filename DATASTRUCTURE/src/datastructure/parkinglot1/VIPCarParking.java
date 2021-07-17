package datastructure.parkinglot1;

public class VIPCarParking implements ParkingChain {
	ParkingChain nextChain;

	@Override
	public void setNextParkingSlot(ParkingChain nextChain) {
		this.nextChain = nextChain;

	}

	@Override
	public void parkVehicle(String vehicle) {
		setNextParkingSlot(new ClubParking());
		if (PakingSpaceManager.vipCarParking.size()<ParkingCapacity.vip) {
			PakingSpaceManager.vipCarParking.add(vehicle);
			System.out.println("Your vehicle park successfully. Available space is-"+ (ParkingCapacity.vip - PakingSpaceManager.vipCarParking.size()));
		} else{
			System.out.println("VIP parking is full, Sending the request for club parking");
			this.nextChain.parkVehicle(vehicle);
		}
			

	}
}
