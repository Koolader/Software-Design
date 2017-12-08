package controllers;
import arduino.*;
public class Ardu {
static	 Arduino obj ;
	public Ardu() {
		// TODO Auto-generated constructor stub
	}
	
public static  void call_movement( String string)

{ 
	System.out.println("received by servlet "+string);
	System.out.println("Trying to open comm");
    if (obj==null)
    {
    obj= new Arduino("COM6", 9600);
    obj.openConnection();
    System.out.println("open Comm");
    obj.serialWrite(string);
    System.out.println("end writing "+string);
    
    }
    else
    {
    	if (string!=null)
    	{
    obj.serialWrite(string); 
    System.out.println("object was open, wring"+string);
    }else {System.out.println("string is null");}
    }
   
}


}
