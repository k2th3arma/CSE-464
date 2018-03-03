package servlet;

import java.io.File;
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
		
		System.out.println("The search point: "+search +", The type: "+ type);

		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String movieName = request.getParameter("movie");
		String description = request.getParameter("description");
		byte[] thumbnail = request.getParameter("thumbnail").getBytes();
		String rating = request.getParameter("rating");
		
		MovieDB movieD = new MovieDB();
		
		movieD.addMovie(new Movie(movieName, description, thumbnail, rating));
		
		response.sendRedirect("Owner/OwnerHomePage.jsp");
		
	}

}
