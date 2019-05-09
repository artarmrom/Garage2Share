
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;


public class registergarage extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
	  doPost(request, response);
	}
	
	public void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		String id = (String)session.getAttribute("id");

		String vehicle = request.getParameter("vehicle");
		String place = request.getParameter("place");
		String direction = request.getParameter("direction");
		String space = request.getParameter("space");
		String code = request.getParameter("code");
		String price = request.getParameter("price");
		int initialTime = Integer.parseInt(request.getParameter("initialTime"));
		int initialHour = Integer.parseInt(request.getParameter("initialHour"));
		int endTime = Integer.parseInt(request.getParameter("endTime"));
		int endHour = Integer.parseInt(request.getParameter("endHour"));
		String status = "true";
		int userId = Integer.parseInt(id);
		
		String stat = "404";
		boolean gck;
		
		PrintWriter out = response.getWriter();
		
        try{
			//Ir a base de datos para verificar si el login y password son correctos
			DBInteraction db = new DBInteraction();
        	
        	gck = db.checkGarage(place, direction, space, code, vehicle, userId);
			if(gck){
				stat="garage";
			}

			if(stat=="404"){
				db.addgar(place, direction, space, code, price, vehicle, status, initialTime, initialHour, endTime, endHour, userId);
        		
				stat = "200";
			}
        	

        	db.close();
        			
		}catch(Exception ex){
            System.err.print("Exception: ");
            System.err.println(ex.getMessage());
		}
		
		out.write(stat);
		out.close();
		
	}
}
