
import java.io.*;
import java.util.ArrayList;

import javax.servlet.*;
import javax.servlet.http.*;


@SuppressWarnings("serial")
public class vergarajes extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {				
		try{
		
			DBInteraction db = new DBInteraction();
						
			ArrayList<Garage> garages = db.listgarfreegarages();
			
			request.setAttribute("garages", garages);
	        RequestDispatcher view = request.getRequestDispatcher("view/alquilergaraje.jsp");
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
