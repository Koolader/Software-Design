package sceneeyeftdi;

public enum CaptureMode {

	INTERLACED(0),
	INTERPOLATED(1);

	private final int value;

	private CaptureMode(int value) {
		this.value = value;
	}

	public byte getValue() {
		return (byte)value;
	}	
	
}
