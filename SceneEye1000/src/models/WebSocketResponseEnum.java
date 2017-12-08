package models;

public enum WebSocketResponseEnum {

		R101(101, "TRYING"),	
		R200(200, "OK"),
		R500(500, "SERVER INTERNAL ERROR"),
		R501(501, "NOT IMPLEMENTED"),
		R503(503, "NOT AVAILABLE"),
		R580(580, "COMMAND FAILURE");
		
		
		private final int response;
		private final String reason;

		private WebSocketResponseEnum(int response, String reason) {			
			this.response = response;
			this.reason = reason;
		}

		
		public int getValue(){
			return response;			
		}
		
		public String getValueStr(){
			return Integer.toString(response);
		}
		
		public String getReason() {
			return reason;
		}	

}
