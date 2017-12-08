package models;

public enum ViewModeOperations {
	
	VIEW_MODE_START(0),
	VIEW_MODE_FIRST(1),
	VIEW_MODE_PREVIOUS(2),
	VIEW_MODE_NEXT(3),
	VIEW_MODE_LAST(4),	
	VIEW_MODE_STOP(5);
	
	private final int value;

	private ViewModeOperations(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}	

}
