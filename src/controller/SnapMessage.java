package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Blah;
import model.UserService;
@WebServlet(urlPatterns = { "/snapmessage.do" }, initParams = { @WebInitParam(name = "MEMBER_VIEW", value = "member.jsp"), 
@WebInitParam(name = "SNAP_VIEW", value = "snap.jsp")})
public class SnapMessage extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Constructor of the object.
	 */
	//private String MEMBER_VIEW;
	private String SNAP_VIEW;
	public void init() throws ServletException {
	//	MEMBER_VIEW = getServletConfig().getInitParameter("MEMBER_VIEW");
		SNAP_VIEW = getServletConfig().getInitParameter("SNAP_VIEW");
	
	}



	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("  the snap blog is number");
		//String username = (String) request.getSession().getAttribute("login");
		UserService userService = (UserService) getServletContext()
				.getAttribute("userService");
		// default value is 30 mins.
		List<Blah> blahs = userService.getSnapBlahs(30);

		request.setAttribute("snapblahs", blahs);
		request.getRequestDispatcher(SNAP_VIEW).forward(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request,response);
	}



}
