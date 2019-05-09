
import java.io.*;
import java.util.ArrayList;

import javax.servlet.*;
import javax.servlet.http.*;


@SuppressWarnings("serial")
public class masgaraje extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {				
		int id = Integer.parseInt(request.getParameter("uid"));
		
		try{
		
			DBInteraction db = new DBInteraction();
						
			Garage gar = db.listfreeidgarages(id).get(0);
			String hora_inicio = gar.getInitialTime();
			String hora_fin = gar.getEndTime();
			String lugar = gar.getPlace();
			String direccion = gar.getDirection();
			String precio = gar.getPrice();
			String tipo = gar.getVehicle();
			
			response.setContentType("text/html");
			RequestDispatcher view=request.getRequestDispatcher("/view/masgaraje.jsp?id="+id+
							"&hora_inicio="+hora_inicio+"&hora_fin="+hora_fin+"&lugar="+lugar+
							"&direccion="+direccion+"&precio="+precio+"&tipo="+tipo);
			view.include(request, response);
		
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
