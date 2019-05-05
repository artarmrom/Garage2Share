import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import entities.*;

public class registerGarage extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
	  doPost(request, response);
	}
	
	public void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cks = request.getCookies();
        if(cks != null) {
        	for(Cookie ck : cks) {
        		if(ck.getName().equals("username")) {
        			String vehicle = request.getParameter("vehicle");
        			String place = request.getParameter("place");
        			String direction = request.getParameter("direction");
        			int space = request.getParameter("space");
        			int code = request.getParameter("code");
        			float price = request.getParameter("price");
        			String initialTime = request.getParameter("initialTime");
        			String endTime = request.getParameter("endTime");
        			boolean status = true;
        			String userId = ck.getName();
        			
        			PrinterWriter out = response.getWriter();
        			
        			//Ir a base de datos para verificar si el login y password son correctos
        			DBInteraction db = new DBInteraction();
        			
        			db.addgar(place, direction, space, code, price, vehicle, status, initialTime, endTime, userId);
        			
        			status = "200";
        			
        			out.println(status);
        			out.close();
        			db.close();
        		}
        	}
        }
	}
}