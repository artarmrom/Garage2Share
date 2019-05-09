
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
		    /*for(int i=0;i<garages.size();i++) {
			     Garage r = (Garage) garages.get(0);
			     System.out.println(""+r.getId()+""+r.getInitialTime());
			     int id = r.getId();
			     String hora_inicio = r.getInitialTime();
			     String hora_fin = r.getEndTime();
			     String lugar = r.getPlace();
			     String precio = r.getPrice();
			     String tipo = r.getVehicle();
			     response.setContentType("text/html");
			     RequestDispatcher view=request.getRequestDispatcher("/view/alquilergaraje.jsp?id="+id+
							"&hora_inicio="+hora_inicio+"&hora_fin="+hora_fin+"&lugar="+lugar+"&precio="+precio+"&tipo="+tipo);
			     view.include(request, response);
				}*/
		
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
