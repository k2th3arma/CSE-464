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
import model.Address;
import model.AddressDB;

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
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String street = request.getParameter("address");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String zip = request.getParameter("zip");
		String type = request.getParameter("type");
		
		//String address = street +" "+ city +", "+ state +" "+ zip;
		
		Utilities util = new Utilities();
		if(!util.Check(password, passwordTwo)){
			response.sendRedirect("Register.jsp");
		}
		else
		{
			
		Address address = new Address(street, city, state, zip, userName);
		
		AddressDB addressDB = new AddressDB();
		
		
		Users aUser = new Users(firstName,lastName, userName, password, email, phone, address, type);
		
		UsersDB aUserDB = new UsersDB();		
		
		boolean userExists = false;
		
		userExists = aUserDB.validateUserByUsername(userName);
		
		if(!userExists) {
			
			aUserDB.registerUser(aUser);
			addressDB.addAddress(address);
			
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
