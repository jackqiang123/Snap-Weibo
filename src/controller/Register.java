package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Account;
import model.UserService;

/**
 * Servlet implementation class Register
 */
@WebServlet(urlPatterns = { "/register.do" }, initParams = {
		@WebInitParam(name = "SUCCESS_VIEW", value = "success.jsp"),
		@WebInitParam(name = "ERROR_VIEW", value = "register.jsp") })
public class Register extends HttpServlet {
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
		String email = request.getParameter("email");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String confirmedPasswd = request.getParameter("confirmedPasswd");
		UserService userService = (UserService) getServletContext()
				.getAttribute("userService");
		Account account = new Account(username, password, email);
		List<String> errors = new ArrayList<String>();

		if (isInvalidEmail(email)) {
			errors.add("Invalid Email Address");
		}

		if (userService.isUserExisted(account)) {
			errors.add("User Name Existed");
		}
		if (isInValidPW(password, confirmedPasswd)) {
			errors.add("Wrong Confirmed Password");
		}
		String page = ERROR_VIEW;
		if (errors.isEmpty()) {
			page = SUCCESS_VIEW;
			userService.add(account);// (account);
		} else {
			request.setAttribute("errors", errors);
		}

		request.getRequestDispatcher(page).forward(request, response);
	}

	private boolean isInValidPW(String password, String confirmedPasswd) {
		// TODO Auto-generated method stub
		return !password.equals(confirmedPasswd);
	}

	private boolean isInvalidEmail(String email) {
		return email == null
				|| !email.matches("^[_a-z0-9-]+([.]"
						+ "[_a-z0-9-]+)*@[a-z0-9-]+([.][a-z0-9-]+)*$");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
