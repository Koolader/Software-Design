package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class init_arduino
 */
@WebServlet("/init_arduino")
public class init_arduino extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public init_arduino() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Ardu.call_movement("UD");
		try {
			System.out.println("entering 1 second delay");
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Ardu.call_movement("UUUUUUUUUUUUUUUUUUUUUUUUUUUUU");
		Ardu.call_movement("DDDDDDDDDDDDDDDDDDDDDDDDDDDDD");
		Ardu.call_movement("LLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL");
		Ardu.call_movement("RRRRRRRRRRRRRRRRRRRRRRRRRRRRRRR");
	
		   
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
