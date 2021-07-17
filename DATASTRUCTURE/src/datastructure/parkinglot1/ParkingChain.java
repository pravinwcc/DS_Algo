package datastructure.parkinglot1;

public interface ParkingChain {
	void setNextParkingSlot(ParkingChain nextChain);

	void parkVehicle(String vehicle);
}
