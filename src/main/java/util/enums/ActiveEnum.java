package util.enums;

public enum ActiveEnum {
	ACTIVE("ACTIVE"), PASIVE("PASIVE");
	
	private final String label;
	
	private ActiveEnum(String label) {
		this.label = label;
	}
	
	public String getLabel() {
		return label;
	}
}
