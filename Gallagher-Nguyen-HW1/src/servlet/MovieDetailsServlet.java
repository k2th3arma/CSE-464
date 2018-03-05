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
import model.MovieDetailsModel;
import model.MovieShowing;
import model.MovieShowingDB;
import model.Review;
import model.ReviewDB;
import model.SearchModel;
import model.ShowroomDB;
import model.TheatreDB;

/**
 * Servlet implementation class MovieDetailsServlet
 */
public class MovieDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MovieDetailsServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		int movieID = Integer.parseInt(request.getParameter("id"));
		String theatre = request.getParameter("theatre");
		HttpSession session = request.getSession();

		// Calling methods
		MovieDB callMovie = new MovieDB();
		ShowroomDB callShowroom = new ShowroomDB();
		MovieShowingDB callShowings = new MovieShowingDB();
		ReviewDB callReview = new ReviewDB();
		
		//Initialize the return model
		ArrayList<MovieDetailsModel> models = new ArrayList<MovieDetailsModel>();
		MovieDetailsModel model = new MovieDetailsModel();
		
		//Add movie data
		Movie movie = callMovie.getMovieByMovieID(movieID);
		
		model.setMovieID(movieID);
		model.setMovieName(movie.getTitle());
		model.setDescription(movie.getDescription());
		model.setRating(movie.getRating());
		model.setImage(movie.getThumbnail());
		
		//Add movie showing data
		MovieShowing showing = callShowings.GetMovieShowingByMovie(movieID);
		
		int seats = callShowroom.getShowroomSeats(showing.getShowroomID());
		model.setAvailableSeats(seats - showing.getNumberPurchased());
		model.setPrice(showing.getPrice());
		model.setStartTime(showing.getStartTime());
		model.setEndTime(showing.getEndTime());
		model.setTheatreName(theatre);
		model.setShowroomNumber(showing.getShowroomID());
		
		//The nice method of taglibs demanded an arraylist
		models.add(model);
		
		//Set session for the movie details
		session.setAttribute("details", models);
		
		//Reviews.....
		ArrayList<Review> reviews = callReview.GetReviewsByMovieID(model.getMovieID());
		
		//If there are no reviews, pass indication
		if(reviews.isEmpty()){
			Review note = new Review();
			note.setUserName("No Reviews");
			reviews.add(note);
		}
		
		//Set session for reviews
		session.setAttribute("reviews", reviews);
		
		//Redirect to details page
		response.sendRedirect("Customer/MovieDetailsSelection.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
