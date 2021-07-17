package datastructure.parkinglot1;

public enum VehicleType {
	VIP("VIP"), CLUB("CLUB"), GENERAL("GENERAL");
	
	private String value;

	private VehicleType(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
