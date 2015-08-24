package controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Blah;
import model.UserService;

/**
 * Servlet implementation class Delete
 */
@WebServlet(urlPatterns = { "/delete.do" }, initParams = { @WebInitParam(name = "SUCCESS_VIEW", value = "message.do") })
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String SUCCESS_VIEW;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public void init() throws ServletException {
		SUCCESS_VIEW = getServletConfig().getInitParameter("SUCCESS_VIEW");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String username = (String) request.getSession().getAttribute("login");
		String message = request.getParameter("message");
		UserService userservice = (UserService) getServletContext()
				.getAttribute("userService");

		Blah blah = new Blah();
		blah.setUsername(username);
		blah.setDate(new Date(Long.parseLong(message)));
		userservice.deleteBlah(blah);
		response.sendRedirect(SUCCESS_VIEW);
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
