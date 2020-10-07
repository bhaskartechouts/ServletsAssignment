package org.techouts.app;

import java.io.IOException;
import java.io.PrintWriter;
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
 * Servlet implementation class NumberOfShows
 */
@WebServlet("/NumberOfShows")
public class NumberOfShows extends HttpServlet {
	static List<String> showsName = new LinkedList<String>();
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NumberOfShows() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		showsName.add("Uma Maheswara Ugra Roopasya");
		showsName.add("Nishabdham");
		showsName.add("Orey bujjiga");
		String number = request.getParameter("number");
		HttpSession httpSession2 = request.getSession();
		int index = Integer.parseInt(number)-1;
		httpSession2.setAttribute("number", showsName.get(index));
		if(!number.equals(null)) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("TimeSlot.html");
			dispatcher.include(request, response);
		}
		else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("NumberOfShows.html");
			dispatcher.include(request, response);
		}
	}

}
