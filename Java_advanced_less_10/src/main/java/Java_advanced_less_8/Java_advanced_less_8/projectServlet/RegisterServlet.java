package Java_advanced_less_8.Java_advanced_less_8.projectServlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Java_advanced_less_8.Java_advanced_less_8.Service.UserService;
import Java_advanced_less_8.Java_advanced_less_8.Service.Implements.UserServiceImpl;
import Java_advanced_less_8.Java_advanced_less_8.Shop.StatusUser;
import Java_advanced_less_8.Java_advanced_less_8.Shop.User;


/**
 * Servlet implementation class RegisterServlet
 */
public class RegisterServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private UserService userService = UserServiceImpl.getUserService();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String email = request.getParameter("email");
		String firstName = request.getParameter("firstName");
		String surName = request.getParameter("surName");
		String password = request.getParameter("password");
		String status = null;

		if ("user".equals(request.getParameter(status))) {
			status = StatusUser.user.toString();
		} else if ("admin".equals(request.getParameter(status))) {
			status = StatusUser.admin.toString();
		}

		if (!email.isEmpty() && !firstName.isEmpty() && !surName.isEmpty() && !password.isEmpty()
				&& !status.isEmpty()) {
			userService.create(new User(email, firstName, surName, password, status));

		}
		response.setContentType("text/plain");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write("Success");

	}

}
