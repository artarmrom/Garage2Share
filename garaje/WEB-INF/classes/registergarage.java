
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
		String initialTime = request.getParameter("initialTime");
		String endTime = request.getParameter("endTime");
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
				db.addgar(place, direction, space, code, price, vehicle, status, initialTime, endTime, userId);
        		
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
