package sceneeyeftdi;

public enum CameraFreezeMode {

	ON(0x58),
	OFF(0x59),
	TOGGLE(0x5A);
	
	private final int value;

	private CameraFreezeMode(int value) {
		this.value = value;
	}

	public byte getValue() {
		return (byte)value;
	}	
}
