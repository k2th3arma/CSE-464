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
import model.SearchModel;
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
public class MovieQueryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MovieQueryServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// Sets the session
		HttpSession session = request.getSession();

		// Returns all theatres available for searching
		TheatreDB theatre = new TheatreDB();
		ArrayList<Theatre> theatres = theatre.getAllTheatres();

		// Adds the theatres to the session
		session.setAttribute("theatres", theatres);

		response.sendRedirect("Customer/CustomerHomePage.jsp");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// Getting data from search jsp
		String search = request.getParameter("search");
		int theatreID = Integer.parseInt(request.getParameter("theatre"));
		String date = request.getParameter("date");
		HttpSession session = request.getSession();

		// Calling methods
		MovieDB callMovie = new MovieDB();
		ShowroomDB callShowroom = new ShowroomDB();
		MovieShowingDB callShowings = new MovieShowingDB();
		TheatreDB callTheatre = new TheatreDB();

		ArrayList<SearchModel> models = new ArrayList<SearchModel>();

		// A list of each showroom for the theater selected
		ArrayList<Showroom> showrooms = callShowroom.getShowroom(theatreID);

		// A list of showings that are available based on showrooms
		ArrayList<MovieShowing> showings = new ArrayList<MovieShowing>();

		// Should retrieve each showing that is assigned a showroom
		for (Showroom item : showrooms) {
			MovieShowing show = callShowings.GetMovieShowingByShowroom(item
					.getShowroomID());
			if (show.getMovieID() != 0) {
				showings.add(callShowings.GetMovieShowingByShowroom(item
						.getShowroomID()));
			}

		}

		// End result, searching a filtered list of movies only available by
		// supplied values.
		ArrayList<Movie> movies = new ArrayList<Movie>();

		// Adds movies that have a showing
		for (MovieShowing item : showings) {
			movies.add(callMovie.getMovieByMovieID(item.getMovieID()));
		}

		// Filters the movies by the search parameter
		ArrayList<Movie> searchedMovies = new ArrayList<Movie>();

		if (movies.isEmpty()) {
			response.sendRedirect("Error/NoItemsFound.jsp");
		} else {
			for (Movie item : movies) {
				if (item.getTitle().contains(search)) {
					searchedMovies.add(item);
				} else if (item.getDescription().contains(search)) {
					searchedMovies.add(item);
				}
			}
			for (Movie item : searchedMovies) {
				SearchModel model = new SearchModel();
				for (MovieShowing show : showings) {
					if (show.getMovieID() == item.getMovieID()) {
						int seats = 0;
						if(show.getStartTime().contains(date) | date.isEmpty()){
						model.setMovieName(item.getTitle());
						model.setMovieID(item.getMovieID());
						model.setImage(item.getThumbnail());
						model.setTheatreName(callTheatre
								.getTheatreName(theatreID));

						model.setStartTime(show.getStartTime());
						model.setEndTime(show.getEndTime());
						model.setPrice(show.getPrice());
						model.setTheatreNumber(show.getShowroomID());
						seats = callShowroom.getShowroomSeats(show
								.getShowroomID());
						model.setAvailableSeats(seats
								- show.getNumberPurchased());
						}
					}
					

				}
				models.add(model);
			}

		}

		// Sets the movies session for the result page
		session.setAttribute("movies", models);

		if (models.isEmpty()) {
			response.sendRedirect("Error/NoItemsFound.jsp");
		} else {
			response.sendRedirect("Customer/MovieSearchResults.jsp");
		}

	}

}
