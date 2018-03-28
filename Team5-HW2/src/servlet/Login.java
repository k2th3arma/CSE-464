package servlet;

import model.UsersDB;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import util.PasswordUtil;
import model.Users;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		boolean persist = request.getParameter("persist") != null;
		HttpSession session = request.getSession();
		
		UsersDB user = new UsersDB();
		Users usr = user.getUser(userName);
		
		
		Cookie cookie = new Cookie("user_name", userName);
		
		String hashedPassword = "";
		try {
			hashedPassword = PasswordUtil.hashPassword(password);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
				
		if(user.validateUserByUsername(userName) && user.validateUserByPassword(hashedPassword))
		{
			
			if(persist)
			{
				System.out.println("true");
				response.addCookie(cookie);
			}
			int id = usr.getUserID();
			String type = usr.getType();
			
			session.setAttribute("userName", userName);
			session.setAttribute("userID", id);
			session.setAttribute("userType", usr.getType());
			
			System.out.println(usr.getType());
			
			if(type.equals("customer")){
				response.sendRedirect("MovieQueryServlet");
			}
			else if(type.equals("owner")){
				response.sendRedirect("OwnerServlet");
			}
			else{
				response.sendRedirect("Register.jsp");
			}
			
		}
		else
		{
			
			response.sendRedirect("Register.jsp");
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		HttpSession session = request.getSession();
		
		UsersDB user = new UsersDB();
		Users usr = user.getUser(userName);
		
		int status = 0;
		
		String hashedPassword = "";
		try {
			hashedPassword = PasswordUtil.hashPassword(password);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
				
		if(user.validateUserByUsername(userName) && user.validateUserByPassword(hashedPassword))
		{
			
			
			status = 1;
			
			
			
			
		}
		else
		{
			status = -1;
			
		}
		
		PrintWriter out = response.getWriter(); 
		out.println(status);
	}

}
