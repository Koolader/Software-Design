package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServoController
 */
@WebServlet("/ServoButtonController")
public class ServoButtonController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	 Ardu a =new Ardu();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServoButtonController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String updown = request.getParameter("updown");	
		
		if (updown !=null)
		{
		System.out.println(updown);
		a.call_movement(updown);
		}   
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
