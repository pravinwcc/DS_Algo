package datastructure.atmmachine;

public enum Notes {
	HUNDREDE("HUNDREDE"), FIFTY("FIFTY"), TWENTY("TWENTY"), TEN("TEN");

	private String value;

	private Notes(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
