package models;

public interface WebSocketMessage {

	public static final String VERSION = "SES1.0";
	
	public static final String DELIMITER = "|";
	public static final String EMPTY = "";
	public static final String DATA_DELIMITER = ","; 
	
	public String build();
	
}
