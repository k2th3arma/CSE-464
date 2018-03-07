package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Movie;
import model.MovieDB;
import model.MovieShowing;
import model.MovieShowingDB;
import model.Order;
import model.OrderDB;
import model.OrderItems;
import model.OrderItemsDB;
import model.Showroom;
import model.ShowroomDB;
import model.Theatre;
import model.TheatreDB;

/**
 * Servlet implementation class ManageOrdersServlet
 */
public class ManageOrdersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManageOrdersServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int orderID = Integer.parseInt(request.getParameter("orderid"));
		
		OrderDB callOrder = new OrderDB();
		OrderItemsDB callOrderItems = new OrderItemsDB();
		MovieDB callMovie = new MovieDB();
		MovieShowingDB callMovieShowing = new MovieShowingDB();
		ShowroomDB callShowroom = new ShowroomDB();
		TheatreDB callTheatre = new TheatreDB();
		
		Order order = callOrder.GetOrderByID(orderID);
		System.out.println("order ID = " + order.getOrderID());
		OrderItems orderItems = callOrderItems.GetOrderItemsByOrder(order.getOrderID());
		System.out.println("Showing ID = " + orderItems.getItemID());
		MovieShowing movieShowing = callMovieShowing.GetMovieShowingByID(orderItems.getShowingID());
		Movie movie = callMovie.getMovieByMovieID(movieShowing.getMovieID());
		String theatreName = callTheatre.getTheatreName(movieShowing.getMovieID());
		
		
		
		session.setAttribute("order", order);
		session.setAttribute("movieShowing", movieShowing);
		session.setAttribute("movie", movie);
		session.setAttribute("orderItems", orderItems);
		session.setAttribute("theatre", theatreName);
	
		
		response.sendRedirect("Customer/ManageOrder.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
