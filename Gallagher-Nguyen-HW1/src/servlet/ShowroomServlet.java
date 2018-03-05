package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Showroom;
import model.ShowroomDB;
import model.Theatre;
import model.TheatreDB;

/**
 * Servlet implementation class ShowroomServlet
 */
public class ShowroomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowroomServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		
		TheatreDB theatre = new TheatreDB();
		ArrayList<Theatre> theatres = theatre.getTheatres(Integer.parseInt(session.getAttribute("userID").toString()));
		
		session.setAttribute("theatres", theatres);
		
		response.sendRedirect("Owner/AddShowroom.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int seats = Integer.parseInt(request.getParameter("seats"));
		int theatreID = Integer.parseInt(request.getParameter("theatre"));
		int id = Integer.parseInt(request.getParameter("id"));

		ShowroomDB showroom = new ShowroomDB();
		
		showroom.addShowroom(new Showroom(seats, theatreID));
		
		response.sendRedirect("Owner/OwnerHomePage.jsp");
		
		
	}

}
