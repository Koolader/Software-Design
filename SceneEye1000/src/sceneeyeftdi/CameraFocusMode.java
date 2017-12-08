package sceneeyeftdi;

public enum CameraFocusMode {

	AUTO_FOCUS(0x5C),
	MANUAL_FOCUS(0x5D),
	ONE_SHOT_FOCUS(0x5E),
	SET_FOCUS(0x5F);
	
	private final int value;

	private CameraFocusMode(int value) {
		this.value = value;
	}

	public byte getValue() {
		return (byte)value;
	}	
	
}
