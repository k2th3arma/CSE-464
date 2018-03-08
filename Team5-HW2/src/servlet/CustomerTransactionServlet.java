package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.Date;

import model.MovieShowingDB;
import model.Order;
import model.OrderDB;
import model.OrderItems;
import model.OrderItemsDB;
import model.Transaction;
import model.TransactionDB;

/**
 * Servlet implementation class CustomerTransactionServlet
 */
public class CustomerTransactionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerTransactionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String cardType = request.getParameter("cardType");
		String cardNumber = request.getParameter("cardNumber");
		int userID = Integer.parseInt(request.getParameter("userID"));
		int total = Integer.parseInt(request.getParameter("total"));
		String billingAddress = request.getParameter("billingAddress");
		String shippingAddress = request.getParameter("shippingAddress");
		String tickets = request.getParameter("tickets");
		int movieID = Integer.parseInt(request.getParameter("movieID"));
		int showroomID = Integer.parseInt(request.getParameter("showroomID"));
		
		//** Ints below crash the app, will fix **//
		
		String securityCode = request.getParameter("securityCode");
		int expMonth = Integer.parseInt(request.getParameter("expMonth"));
		int expDay = Integer.parseInt(request.getParameter("expDay"));
		
		//create transaction and order info
		Transaction transaction = new Transaction();
		TransactionDB callTransaction = new TransactionDB();
		Order order = new Order();
		OrderDB callOrder = new OrderDB();
		OrderItems orderItems = new OrderItems();
		OrderItemsDB callOrderItems = new OrderItemsDB();
		MovieShowingDB callShowings = new MovieShowingDB();
		
		Date date = new Date();
		String orderDate = date.toString();
		
		transaction.setCardHolderName(firstName + " " + lastName);
		transaction.setCardNumber(cardNumber);
		transaction.setBalance((float)total);
		transaction.setCardType(cardType);
		transaction.setUserID(userID);
		transaction.setCVV(securityCode);
		transaction.setExpiration(expMonth + "/" + expDay);
		
		callTransaction.addTranaction(transaction);
		
		order.setUserID(userID);
		order.setCost(total);
		order.setAddress(billingAddress);
		order.setOrderDate(orderDate);
		order.setCardNumber(cardNumber);
		order.setTickets(tickets);
		order.setShowingID(callShowings.GetMovieShowingIDByMovieAndShowroom(movieID, showroomID).getShowingID());
		
		callOrder.addOrder(order);
		
		
		
		//track user info
		session.setAttribute("transaction", transaction);
		session.setAttribute("order", order);
		
		response.sendRedirect("Customer/CustomerTransactionConfirmation.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
