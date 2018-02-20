package servlet;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.Utilities;
import model.Users;
import model.UsersDB;

/**
 * Servlet implementation class Register
 */
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String passwordTwo = request.getParameter("password2");
		
		Utilities util = new Utilities();
		if(!util.Check(password, passwordTwo)){
			response.sendRedirect("Register.jsp");
		}
		else
		{
			
		
		
		
		Users aUser = new Users(firstName,lastName, userName, password);
		
		UsersDB aUserDB = new UsersDB();	
		
		
		boolean userExists = false;
		
		userExists = aUserDB.validateUserByUsername(userName);
		
		if(!userExists) {
			aUserDB.registerUser(aUser);
			response.sendRedirect("Welcome.jsp");
		} else {
			response.sendRedirect("Register.jsp");
		}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
