package servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;










import sun.misc.IOUtils;

import java.sql.Blob;
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
		response.sendRedirect("Owner/AddMovie.jsp");

		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String movieName = request.getParameter("movie");
		String description = request.getParameter("description");
		String file = request.getParameter("thumbnail");
		String rating = request.getParameter("rating");
		
		Path path = Paths.get(file);
		byte[] data = Files.readAllBytes(path);
		File newFile = new File(file);
		byte[] array = Files.readAllBytes(new File(file).toPath());
		
		MovieDB movieD = new MovieDB();
		
		movieD.addMovie(new Movie(movieName, description, read(newFile), rating));
		
		response.sendRedirect("Owner/OwnerHomePage.jsp");
		
	}
	
	private byte[] read(File file) throws IOException, FileNotFoundException {

	    byte[] buffer = new byte[(int) file.length()];
	    InputStream ios = null;
	    try {
	        ios = new FileInputStream(file);
	        if (ios.read(buffer) == -1) {
	            throw new IOException(
	                    "EOF reached while trying to read the whole file");
	        }
	    } finally {
	        try {
	            if (ios != null)
	                ios.close();
	        } catch (IOException e) {
	        }
	    }
	    return buffer;
	}

}
