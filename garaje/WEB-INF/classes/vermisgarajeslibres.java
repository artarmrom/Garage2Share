
import java.io.*;
import java.util.ArrayList;

import javax.servlet.*;
import javax.servlet.http.*;


@SuppressWarnings("serial")
public class vermisgarajeslibres extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {				
		try{
		
			DBInteraction db = new DBInteraction();
			HttpSession session = request.getSession(true);
			int id = Integer.parseInt((String)session.getAttribute("id"));	
			ArrayList<Garage> garages = db.listmyfreegarages(id);
			
			request.setAttribute("garages", garages);
	        RequestDispatcher view = request.getRequestDispatcher("view/perfil.jsp");
	        view.forward(request, response);
		
			db.close();
		}catch(Exception ex){
            System.err.print("Exception: ");
            System.err.println(ex.getMessage());
		}
	}
	
	public void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  doGet(request, response);
	}
}
