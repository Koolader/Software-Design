package models;

public enum WebSocketRequestEnum {

		UNKNOWN("UNKNOWN"),	
		SESSION("SESSION"),
		VIDEO("VIDEO"),
		COLOR("COLOR"),
		CONTRAST("CONTRAST"),
		TEXT("TEXT"),
		ZOOM("ZOOM"),	
		FREEZE("FREEZE"),
		FLIP("FLIP"),		
		SNAPSHOT("SNAPSHOT"),
		SLIDESHOW("SLIDESHOW");
		
		
		private final String request;

		private WebSocketRequestEnum(String value) {			
			this.request = value;
		}

		public String getValue() {
			return request;
		}	

}
