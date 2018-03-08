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
import model.Showroom;
import model.ShowroomDB;
import model.Theatre;
import model.TheatreDB;

/**
 * Servlet implementation class MovieShowingsServlet
 */
public class MovieShowingsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MovieShowingsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Getting data
		int theatreID = Integer.parseInt(request.getParameter("theatre"));
		int id = Integer.parseInt(request.getParameter("id"));
		
		//Calling Managers
		MovieDB callMovie = new MovieDB();
		ShowroomDB callShowroom = new ShowroomDB();
		
		//Setting the session
		HttpSession session = request.getSession();
		
		//Getting all movies for dopdown
		ArrayList<Movie> movie = callMovie.GetMovies();
		
		//Add movies to session
		session.setAttribute("movies", movie);
		
		//Getting showrooms based on the theatre ID provided
		ArrayList<Showroom> showroom = callShowroom.getShowroom(theatreID);
		
		//Adding showrooms to the session
		session.setAttribute("showrooms", showroom);
		
		response.sendRedirect("Owner/AddShowtime.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//Get Data
		int price = Integer.parseInt(request.getParameter("price"));
		String startTime = request.getParameter("startTime");
		String endTime = request.getParameter("endTime");
		int movie = Integer.parseInt(request.getParameter("movie"));
		int theatre = Integer.parseInt(request.getParameter("theatre"));
		
		//Call the manager
		MovieShowingDB callShowing = new MovieShowingDB();
		
		//Add the data to the database
		callShowing.addMovieShowing(new MovieShowing(price, 0, startTime, endTime, movie, theatre));
		
		response.sendRedirect("OwnerServlet");
	}

}
