package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.*;

import model.Users;
import model.UsersDB;
import model.Order;
import model.OrderDB;

/**
 * Servlet implementation class ViewOrdersServlet
 */
public class ViewOrdersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewOrdersServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String userName = session.getAttribute("userName").toString();
		UsersDB callUser = new UsersDB();
		OrderDB callOrder = new OrderDB();
		
		Users User = callUser.getUser(userName);
		
		ArrayList<Order> orders = new ArrayList<Order>();
		
		orders.addAll(callOrder.GetOrdersByUser(User.getUserID()));
		
		session.setAttribute("orders", orders);
		
		response.sendRedirect("Customer/ViewOrders.jsp");
		//System.out.println(User.toString());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
