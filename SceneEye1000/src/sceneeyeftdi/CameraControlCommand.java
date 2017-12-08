package sceneeyeftdi;

public enum CameraControlCommand {

	SET_FRAME_RATE(0x90),
	SET_FIELD_RATE(0x91);
	
	private final int value;

	private CameraControlCommand(int value) {
		this.value = value;
	}

	public byte getValue() {
		return (byte)value;
	}	
	
}
