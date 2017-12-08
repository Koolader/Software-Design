package models;

public enum SceneEyeStates {

	NO_VIDEO(0),
	LIVE_VIDEO_MODE(1),
	SNAPSHOT_MODE(2),
	FREEZE_MODE(3),
	VIEW_MODE(4),
	ERROR(5);

	private final int value;

	private SceneEyeStates(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}	
	
}
