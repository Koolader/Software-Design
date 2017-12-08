package models;

public class WebSocketResponse implements WebSocketMessage {

	private String _status = EMPTY;
	private String _reason = EMPTY;
	private WebSocketRequestEnum _request = WebSocketRequestEnum.UNKNOWN;
	private String _cmd = EMPTY;
	private String _data = EMPTY;
	private String _encoded = EMPTY;
	
	public WebSocketResponse(String status, String reason, String request, String command, String data) {
		
		if (status != null && !status.isEmpty() && request != null && !request.isEmpty()){

			_status = status;
			_reason = reason;
			_cmd = command;
			_data = data;
			
			if (request != null && !request.isEmpty()){
				_request = WebSocketRequestEnum.valueOf(request);
			}		
		}
	}


	@Override
	public String build() {
		
		StringBuilder x = new StringBuilder();
		
		x.append(VERSION + DELIMITER);
		x.append(_status + DELIMITER);
		x.append(_reason + DELIMITER);
		x.append(_request + DELIMITER);
		x.append(_cmd + DELIMITER);
		x.append(_data);
		
		_encoded = x.toString();
		
		return _encoded;		
	}
		
	public String getStatus(){
		return _status;		
	}
	
	public String getReason(){
		return _reason;
	}
	
	public WebSocketRequestEnum getRequestType(){
		return _request;
	}
	
	public String getCommand(){
		return _cmd;
	}

	public String getData(){		
		return _data;		
	}
	
}
