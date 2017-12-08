package controllers;
import arduino.*;



public class Ardutest {
static Ardu a =new Ardu();
	
	public static void main(String[] args) {
		
		        Arduino obj = new Arduino("COM6", 9600);		        
		        obj.openConnection();		        
		        for (int i=0 ; i <30 ;i++)
		        {
		        obj.serialWrite("U");
		        System.out.print(i);
		        }
		        for (int i=0 ; i <80 ;i++)
		        {
		        obj.serialWrite("D");
		        System.out.println(i);
		        }
		        
		        obj.closeConnection();

		
		
		
	}

}
