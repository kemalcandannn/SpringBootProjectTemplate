package util.enums;

public enum CaseSizeEnum {
	LOWER("LOWER"), NORMAL("NORMAL"), UPPER("UPPER");
	
	private final String label;
	
	private CaseSizeEnum(String label) {
		this.label = label;
	}
	
	public String getLabel() {
		return label;
	}
}
