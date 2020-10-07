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
 * Servlet implementation class Category
 */
@WebServlet("/Category")
public class Category extends HttpServlet {
	static List<String> category = new LinkedList<String>();
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Category() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		category.add("Normal");
		category.add("VIP");
		category.add("VVIP");
		String ticket = request.getParameter("ticket");
		String nTicket = request.getParameter("nTicket");
		int index = Integer.parseInt(ticket)-1;
		int value = Integer.parseInt(nTicket);
		HttpSession httpSession = request.getSession();
		httpSession.setAttribute("ticket", category.get(index));
		httpSession.setAttribute("nTicket", nTicket);
		switch(index+1){
		
		case 1 :
			value = value*200;
			break;
		case 2 :
			value = value*300;
			break;
		case 3 :
			value = value*500;
			break;
		}
		httpSession.setAttribute("total", value);
		if(!ticket.equals(null) && !nTicket.equals(null)) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("Display.html");
			dispatcher.include(request, response);
		}
		else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("Category.html");
			dispatcher.include(request, response);
		}
	}

}
