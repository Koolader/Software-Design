package sceneeyeftdi;

public enum CameraStatusType {
	
	NO_ERROR(0),
	ERROR(1),
	CAMERA_DISCONNECTED(2),
	MEMORY_ALLOCATION_ERROR(3);

	private final int value;

	private CameraStatusType(int value) {
		this.value = value;
	}

	public byte getValue() {
		return (byte)value;
	}
	
	public boolean equals(int i){
		
		return (i == value);
	}
}
