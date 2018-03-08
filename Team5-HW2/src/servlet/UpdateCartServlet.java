package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.User;

import model.QuickCheckout;
import model.ShoppingCart;
import model.Transaction;
import model.TransactionDB;
import model.Users;
import model.UsersDB;

/**
 * Servlet implementation class UpdateCartServlet
 */
public class UpdateCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateCartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		String remove = request.getParameter("remove");
		int movieID = Integer.parseInt(request.getParameter("movieID"));
		
		if(remove.equals("false")){
		//Getting data from the form
		String movieName = request.getParameter("movie");
		int price = Integer.parseInt(request.getParameter("price"));
		int showroomID = Integer.parseInt(request.getParameter("showroomID"));
		int tickets = Integer.parseInt(request.getParameter("tickets"));
		int userID = Integer.parseInt(request.getParameter("id"));
		double total = price * tickets;
		
		String theatreName = request.getParameter("theatre");
		String startTime = request.getParameter("startTime");
		byte[] image = request.getParameter("image").getBytes();
		
		//Create shopping cart
				ArrayList<ShoppingCart> shop = new ArrayList<ShoppingCart>();
				
				//Add an item to the shopping cart
				ShoppingCart shopItem = new ShoppingCart();
				
				shopItem.setImage(image);
				shopItem.setMovieID(movieID);
				shopItem.setMovieName(movieName);
				shopItem.setPrice(price);
				shopItem.setStartTime(startTime);
				shopItem.setTickets(tickets);
				shopItem.setUserID(userID);
				shopItem.setTheatreName(theatreName);
				shopItem.setTotal(price*tickets);
				shopItem.setShowroomID(showroomID);
				shop.add(shopItem);
		
				//Set session to track the shopping cart
				session.setAttribute("total", total);
				session.setAttribute("Shoppingcart", shop);
		
				TransactionDB callTrans = new TransactionDB();
				UsersDB callUser = new UsersDB();
				Users user = callUser.getUser((String)session.getAttribute("userName"));
				
				ArrayList<QuickCheckout> userData = new ArrayList<QuickCheckout>();
				
				Transaction data = callTrans.GetTransactionByUserID(userID);
				
				if(data != null){
					QuickCheckout check = new QuickCheckout();
					check.setCardNumber(data.getCardNumber());
					check.setCardType(data.getCardType());
					check.setCvv(data.getCVV());
					String[] half = data.getExpiration().split("/");
					check.setMonth(half[0]);
					check.setYear(half[1]);
					check.setFirstName(user.getFirstName());
					check.setLastName(user.getLastName());
					check.setBilling(user.getAddress() +" "+ user.getCity() +", "+ user.getState() +" "+ user.getPostalCode());
					check.setShipping(user.getAddress() +" "+ user.getCity() +", "+ user.getState() +" "+ user.getPostalCode());
					
					userData.add(check);				
					
					
					session.setAttribute("userData", userData);
				}
		}
		
		
		if(remove.equals("true")){			
			ArrayList<ShoppingCart> shop = (ArrayList<ShoppingCart>)session.getAttribute("Shoppingcart");
			for(ShoppingCart item: shop){
				if(item.getMovieID() == movieID){
					shop.remove(item);
				}
			}
		}
		
		
		
		response.sendRedirect("Customer/ViewAndCheckoutShoppingCart.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		
		String remove = request.getParameter("remove");
		int movieID = Integer.parseInt(request.getParameter("movieID"));
			
		ArrayList<ShoppingCart> shopping = new ArrayList<ShoppingCart>();
				
			ArrayList<ShoppingCart> shop = (ArrayList<ShoppingCart>)session.getAttribute("Shoppingcart");
			session.setAttribute("Shoppingcart", null);
			for(ShoppingCart item: shop){
				if(item.getMovieID() != movieID){
					shopping.add(item);
				}
			}
			session.setAttribute("Shoppingcart", shopping);
		
		
		
		response.sendRedirect("Customer/ViewAndCheckoutShoppingCart.jsp");
	}

}
