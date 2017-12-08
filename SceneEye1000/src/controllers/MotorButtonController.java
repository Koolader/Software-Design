package controllers;
/*
 * control motors
 * Cristian Salinas-O'Neill
 * 
 * NOTE : READ HOW TO USE THE RXTX LIBRARY FOR THE S.O.
 * 
 * 
 * */

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;






/**
 * Servlet implementation class MotorController
 */
@WebServlet("/MotorButtonController")
public class MotorButtonController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Ardu a;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MotorButtonController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String direction = request.getParameter("leftright");
		if (direction !=null)
		{
		System.out.println(direction);
		a.call_movement( direction);
		
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
