
import java.io.*;
import java.util.ArrayList;

import javax.servlet.*;
import javax.servlet.http.*;


@SuppressWarnings("serial")
public class listaGarage extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {		
		String place = request.getParameter("lugar");
		String vehicle = request.getParameter("tipo");
		int initialTime = Integer.parseInt(request.getParameter("diainicial")); 
		int initialHour = Integer.parseInt(request.getParameter("horainicial"));
		int endTime = Integer.parseInt(request.getParameter("diafinal"));
		int endHour = Integer.parseInt(request.getParameter("horafinal"));
		
		try{
		
			DBInteraction db = new DBInteraction();
						
			ArrayList<Garage> garages = db.listgaravail(place,vehicle,initialTime,initialHour,endTime,endHour);
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
