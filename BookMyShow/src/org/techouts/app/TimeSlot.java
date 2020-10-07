package org.techouts.app;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class TimeSlot
 */
@WebServlet("/TimeSlot")
public class TimeSlot extends HttpServlet {
	List<String> timeSlot = new LinkedList<String>();
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TimeSlot() {
        super();
      
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		timeSlot.add("11:00");
		timeSlot.add("2:00");
		timeSlot.add("6:00");
		timeSlot.add("9:00");
	
		String number1 = request.getParameter("number1");
		int index = Integer.parseInt(number1)-1;
		HttpSession httpSession = request.getSession();
		httpSession.setAttribute("number1", timeSlot.get(index));		
		if(!number1.equals(null)) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("Category.html");
			dispatcher.include(request, response);
		}
		else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("TimeSlot.html");
			dispatcher.include(request, response);
		}
	}

}
