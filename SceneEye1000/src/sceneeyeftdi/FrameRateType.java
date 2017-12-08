package sceneeyeftdi;

public enum FrameRateType {

	FPS_30(0),
	FPS_22_5(1),
	FPS_15(2),
	FPS_7_5(3);

	private final int value;

	private FrameRateType(int value) {
		this.value = value;
	}
	
	public byte getValue() {
		return (byte)value;
	}	
}
