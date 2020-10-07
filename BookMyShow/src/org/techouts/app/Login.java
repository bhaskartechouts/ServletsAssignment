package org.techouts.app;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Login() {

    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		String name = request.getParameter("name");
		String password = request.getParameter("pwd");
		HttpSession httpSession1 = request.getSession();
		httpSession1.setAttribute("name", name);
		if(!name.equals(null)&& !password.equals(null)) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("NumberOfShows.html");
			dispatcher.include(request, response);
		}
		else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("Login.html");
			dispatcher.include(request, response);
		}
	}

}
