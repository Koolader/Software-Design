package sceneeyeftdi;

public enum CameraTextMode {
	

	TXT_BLACK_ON_WHITE(0x74),
	TXT_BLACK_ON_AMBER(0x75),
	TXT_BLACK_ON_GREEN(0x76),
	TXT_BLUE_ON_WHITE(0x77),
	TXT_AMBER_ON_BLUE(0x78),
	TXT_WHITE_ON_BLACK(0x79),
	TXT_AMBER_ON_BLACK(0x7A),
	TXT_GREEN_ON_BLACK(0x7B),
	TXT_WHITE_ON_BLUE(0x7C),
	TXT_BLUE_ON_AMBER(0x7D),
	TXT_TOGGLE(0x7E);
	
	private final byte value;

	private CameraTextMode(int value) {
		this.value = (byte)value;
	}

	public byte getValue() {
		return value;
	}

}
