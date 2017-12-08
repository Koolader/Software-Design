package sceneeyeftdi;

public enum CameraContrastMode {

	COLOR_NO_BOOST(0x65),
	COLOR_MIN_BOOST(0x66),
	COLOR_MAX_BOOST(0x67),
	BW_INV_MAX_BOOST(0x68),
	TOGGLE(0x69),
	BW_NO_BOOST(0x6A),
	BW_MIN_BOOST(0x6B),
	BW_MAX_BOOST(0x6C);
	
	private final int value;

	private CameraContrastMode(int value) {
		this.value = value;
	}

	public byte getValue() {
		return (byte)value;
	}	
	
	
}
