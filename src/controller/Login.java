package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Account;
import model.UserService;

/**
 * Servlet implementation class Login
 */
@WebServlet(urlPatterns = { "/login.do" }, initParams = {
		@WebInitParam(name = "SUCCESS_VIEW", value = "message.do"),
		@WebInitParam(name = "ERROR_VIEW", value = "index.jsp") })
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String SUCCESS_VIEW;
	private String ERROR_VIEW;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public void init() throws ServletException {
		SUCCESS_VIEW = getServletConfig().getInitParameter("SUCCESS_VIEW");
		ERROR_VIEW = getServletConfig().getInitParameter("ERROR_VIEW");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String page = ERROR_VIEW;
		Account account = new Account(username, password, "");
		UserService userService = (UserService) getServletContext()
				.getAttribute("userService");
		
		if (userService.checkLogin(account)) {
			request.getSession().setAttribute("login", username);
			page = SUCCESS_VIEW;
		
		}
		request.getRequestDispatcher(page).forward(request, response);
	}

}
