package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.ShoppingCart;

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
				
				shop.add(shopItem);
		
				//Set session to track the shopping cart
				session.setAttribute("total", total);
				session.setAttribute("Shoppingcart", shop);
		
		
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
