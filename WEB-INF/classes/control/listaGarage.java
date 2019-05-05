import java.beans.XMLEncoder;
import java.io.*;
import java.util.ArrayList;

import javax.servlet.*;
import javax.servlet.http.*;

import entities.*;

public class listaGarage extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {		
        Cookie[] cks = request.getCookies();
        if(cks != null) {
        	for(Cookie ck : cks) {
        		if(ck.getName().equals("username")) {
					
					DBInteraction db = new DBInteraction();
					
					ArrayList garages = db.listallgar();
					FileOutputStream fos = new FileOutputStream(new File("./garages.xml"));
					XMLEncoder encoder = new XMLEncoder(fos);
					for (Garage gar : garages) {
						encoder.writeObject(gar);
					}
					
					response.setContentType("text/xml");
					response.getWriter().write(encoder);  
					
					db.close();
					encoder.close();
					fos.close();
        		}
        	}
        }
	}
	
	public void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  doGet(request, response);
	}
}