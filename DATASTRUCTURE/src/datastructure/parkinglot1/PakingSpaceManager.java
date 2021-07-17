package datastructure.parkinglot1;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class PakingSpaceManager {
	public static BlockingQueue vipCarParking = new LinkedBlockingQueue<>(ParkingCapacity.vip);
	public static BlockingQueue clubCarParking = new LinkedBlockingQueue<>(ParkingCapacity.club);
	public static BlockingQueue genCarParking = new LinkedBlockingQueue<>(ParkingCapacity.gen);

}
