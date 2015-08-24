package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Logout
 */
@WebServlet(urlPatterns = { "/logout.do" }, initParams = { @WebInitParam(name = "LOGIN_VIEW", value = "index.jsp") })
public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String LOGIN_VIEW;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public void init() throws ServletException {
		LOGIN_VIEW = getServletConfig().getInitParameter("LOGIN_VIEW");
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.getSession().invalidate();
		response.sendRedirect(LOGIN_VIEW);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.getSession().invalidate();
		response.sendRedirect(LOGIN_VIEW);
	}

}
