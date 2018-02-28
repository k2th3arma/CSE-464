package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.*;

import model.Movie;
import model.MovieDB;

import model.Theatre;
import model.TheatreDB;

import model.Showroom;
import model.ShowroomDB;

import model.MovieShowing;
import model.MovieShowingDB;

import model.Review;
import model.ReviewDB;

import model.Transaction;
import model.TransactionDB;

import model.Order;
import model.OrderDB;

/**
 * Servlet implementation class MovieServlet
 */
public class MovieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MovieServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String search = request.getParameter("Search");
		String type = request.getParameter("type");
		HttpSession session = request.getSession();
		
		//System.out.println("The search point: "+search +", The type: "+ type);
		
		MovieDB movie = new MovieDB();
				
		TheatreDB theatre = new TheatreDB();
		
		ShowroomDB showroom = new ShowroomDB();
		
		MovieShowingDB movieShowing = new MovieShowingDB();
		
		ReviewDB review = new ReviewDB();
		
		TransactionDB transaction = new TransactionDB();
		
		OrderDB order = new OrderDB();
		
		if(type.contentEquals("Title")){
			
			System.out.println(movie.getMovie(search).toString());
			
			System.out.println(movieShowing.GetMovieShowing(search).toString());
			
			session.setAttribute("Movies", movie.getMovie(search));
			
			session.setAttribute("MoviesShowing", movieShowing.GetMovieShowing(search));
			
			response.sendRedirect("Customer/MovieSearchResults.jsp");
			
		}
		else if(type.contentEquals("Year")){
			
			System.out.println(movie.getMovieByYear(search).toString());
			
			ArrayList<Movie> movies = movie.getMovieByYear(search);			
			
			response.sendRedirect("Customer/MovieSearchResults.jsp");
			
		}
		else if(type.contentEquals("Length")){
			
			System.out.println(movie.getMovieByLength(search).toString());
			
			ArrayList<Movie> movies = movie.getMovieByLength(search);
						
			response.sendRedirect("Customer/MovieSearchResults.jsp");
			
		}
		else if(type.contentEquals("MPAA")){
			
			System.out.println(movie.getMovieByMpaa(search).toString());
			
			ArrayList<Movie> movies = movie.getMovieByMpaa(search);
						
			response.sendRedirect("Customer/MovieSearchResults.jsp");
			
		}
		else if(type.contentEquals("Genre")){
			
			System.out.println(movie.getMovieByGenre(search).toString());
			
			ArrayList<Movie> movies = movie.getMovieByGenre(search);
						
			response.sendRedirect("Customer/MovieSearchResults.jsp");
			
		}
		else if(type.contentEquals("Theatre")){
			System.out.println(theatre.getTheatre(search));
		}
		else if(type.contentEquals("Showroom")){
			System.out.println(showroom.getShowroom(search));
		}
		else if(type.contentEquals("MovieShowing")){
			System.out.println(movieShowing.GetMovieShowing(search));
		}
		else if(type.contentEquals("Review")){
			System.out.println(review.GetReviewByMovie(search));
		}
		else if(type.contentEquals("Transaction")){
			//System.out.println(transaction.GetTransactionByID(Integer.parseInt(search)));
			
			System.out.println(transaction.GetTransactionByUser(search));
		}
		else if(type.contentEquals("Order")){
			//System.out.println(order.GetOrderByID(Integer.parseInt(search)));
			
			System.out.println(order.GetOrdersByUser(Integer.parseInt(search)));
		}
		else{
			response.sendError(404, "Error");
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
