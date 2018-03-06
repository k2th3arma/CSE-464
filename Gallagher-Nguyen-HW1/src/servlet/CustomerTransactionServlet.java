package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;

import model.Order;
import model.Transaction;

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
		
		String billingAddress = request.getParameter("billingAddress");
		String shippingAddress = request.getParameter("shippingAddress");
		
		
		//** Ints below crash the app, will fix **//
		
		String securityCode = request.getParameter("securityCode");
		int expMonth = Integer.parseInt(request.getParameter("expMonth"));
		int expDay = Integer.parseInt(request.getParameter("expDay"));
		
		//create transaction and order info
		Transaction transaction = new Transaction();
		Order order = new Order();
		Date date = new Date();
		String orderDate = date.toString();
		
		transaction.setCardHolderName(firstName + " " + lastName);
		transaction.setCardType(cardType);
		transaction.setCardNumber(cardNumber);
		transaction.setCVV(securityCode);
		transaction.setExpiration(expMonth + " " + expDay);
		
		
		order.setAddress(billingAddress);
		order.setOrderDate(orderDate);
		order.setCardNumber(cardNumber);
		
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
