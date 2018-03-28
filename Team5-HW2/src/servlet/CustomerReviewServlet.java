package servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Review;
import model.ReviewDB;

/**
 * Servlet implementation class CustomerReviewServlet
 */
public class CustomerReviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerReviewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		String movieName = request.getParameter("movie");
		int userID = Integer.parseInt(request.getParameter("id"));
		int movieID = Integer.parseInt(request.getParameter("movieID"));
		
		System.out.println("In the review section");
		
		ArrayList<Review> reviews = new ArrayList<Review>();
		
		long time = System.currentTimeMillis();		
		
		Date date = new Date(time);
		
		
		reviews.add(new Review(movieID, userID, date.toString(), 0, ""));
		
		session.setAttribute("reviews", reviews);
		
		response.sendRedirect("Customer/CustomerReview.jsp");
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		int userID = Integer.parseInt(request.getParameter("id"));
		int movieID = Integer.parseInt(request.getParameter("movieID"));
		int rating = Integer.parseInt(request.getParameter("rating"));
		String description = request.getParameter("description");
		String date = request.getParameter("date");
		
		session.setAttribute("problem", 0);
		
		if(description.isEmpty()){
			session.setAttribute("problem", 1);
			response.sendRedirect("Customer/CustomerReviewConfirmation.jsp");
		}
		
		
		
		ReviewDB callReview = new ReviewDB();
		
		callReview.addReview(new Review(movieID, userID, date, rating, description));
		
		
		response.sendRedirect("Customer/CustomerReviewConfirmation.jsp");
		
	}

}
