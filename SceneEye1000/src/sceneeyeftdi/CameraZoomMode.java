package sceneeyeftdi;

public enum CameraZoomMode {
	
	CONTINUOUS_IN(0x50),
	CONTINUOUS_OUT(0x51),
	GOTO_POS(0x52),
	STOP(0x53),
	RESET(0x54);
	
	private final int value;

	private CameraZoomMode(int value) {
		this.value = value;
	}

	public byte getValue() {
		return (byte)value;
	}	
	
}
