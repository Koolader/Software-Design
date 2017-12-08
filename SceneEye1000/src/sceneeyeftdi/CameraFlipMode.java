package sceneeyeftdi;

public enum CameraFlipMode {

	BOTH(0),
	VERTICAL(1),
	HORIZONTAL(2),
	NORMAL(3);
	
	private final int value;

	private CameraFlipMode(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}	
}
