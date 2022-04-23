package Java_advanced_less_8.Java_advanced_less_8.projectServlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import Java_advanced_less_8.Java_advanced_less_8.Dto.UserLogin;
import Java_advanced_less_8.Java_advanced_less_8.Service.UserService;
import Java_advanced_less_8.Java_advanced_less_8.Service.Implements.UserServiceImpl;
import Java_advanced_less_8.Java_advanced_less_8.Shop.User;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    private UserService userService = UserServiceImpl.getUserService();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("UTF-8");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		User user = userService.getUserByEmail(email);	

		if(user!=null && user.getPassword().equals(password)) {
			HttpSession session = request.getSession(true);
			session.setAttribute("user_id", user.getId());
				
			UserLogin userLogin = new UserLogin();
			userLogin.destinationUrl = "userCabinet.jsp";
			userLogin.userEmail = user.getEmail();
			String json = new Gson().toJson(userLogin);
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(json);
			
		}
	}
}
