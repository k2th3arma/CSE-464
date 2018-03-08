package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.ManageOrder;
import model.Movie;
import model.MovieDB;
import model.MovieShowing;
import model.MovieShowingDB;
import model.Order;
import model.OrderDB;
import model.OrderItems;
import model.OrderItemsDB;
import model.ShowroomDB;
import model.TheatreDB;

/**
 * Servlet implementation class CancelOrderServlet
 */
public class CancelOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CancelOrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		int orderID = Integer.parseInt(request.getParameter("orderID"));
		
		OrderDB callOrder = new OrderDB();

		MovieDB callMovie = new MovieDB();
		MovieShowingDB callMovieShowing = new MovieShowingDB();
		ShowroomDB callShowroom = new ShowroomDB();
		TheatreDB callTheatre = new TheatreDB();
		
		ArrayList<ManageOrder> ManageList = new ArrayList<ManageOrder>();
		ManageOrder theOrder = new ManageOrder();
		
		Order order = callOrder.GetOrderByID(orderID);

		theOrder.setOrderID(order.getOrderID());
		theOrder.setDate(order.getOrderDate());
		theOrder.setTickets(Integer.parseInt(order.getTickets()));
		theOrder.setTotal(order.getCost());
		
		theOrder.setStartTime(callMovieShowing.GetMovieShowingByID(order.getShowingID()).getStartTime());
		theOrder.setMovieName(callMovie.getMovieByMovieID(callMovieShowing.GetMovieShowingByID(order.getShowingID()).getMovieID()).getTitle());
		theOrder.setTheatreName(
								callTheatre.getTheatreName(
										callShowroom.getShowroomByID(
												callMovieShowing.GetMovieShowingByID(order.getShowingID()).getShowroomID()).getTheatre()));
		
		ManageList.add(theOrder);
		
		session.setAttribute("theOrder", ManageList);
			
		
		//callOrder.removeOrder(callOrder.GetOrderByID(orderID));
				
		
		response.sendRedirect("Customer/CancelOrder.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
