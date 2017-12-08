package models;

import java.net.ProtocolException;
import java.util.regex.Pattern;

public class WebSocketRequest implements WebSocketMessage {

	private String _type = EMPTY;
	private String _cmd = EMPTY;
	private String _options = EMPTY;
	
	public WebSocketRequest(String request) throws ProtocolException  {
		
		if (request != null && !request.isEmpty()){
			
			String[] r = request.split(Pattern.quote(DELIMITER));
				
			if (!r[0].equals(VERSION)){
				throw new ProtocolException("UNSUPPORTED VERSION:  EXPECTING " + VERSION + "[ RECEIVED: " + r[0] + " ]");
			}
			
			_type = (r[1] != null && !r[1].isEmpty()) ? r[1] : EMPTY;			
			_cmd = (r[2] != null && !r[2].isEmpty()) ? r[2] : EMPTY;
			
			if (r.length > 3){
				_options = (r[3] != null && !r[2].isEmpty()) ? r[3] : EMPTY;
			}
		}
	}
	
	public WebSocketRequestEnum getType(){
		return WebSocketRequestEnum.valueOf(_type);
	}
	
	public String getCommand(){
		return _cmd;
	}
	
	public String getOptions(){
		
		return _options;
	}

	@Override
	public String build() {

		return null;
	}
}
