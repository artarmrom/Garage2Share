
import java.io.*;
import java.util.ArrayList;

import javax.servlet.*;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class perfil extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			
			DBInteraction db = new DBInteraction();
			HttpSession session = request.getSession(true);
			int id = Integer.parseInt((String)session.getAttribute("id"));

			ArrayList<User> userL = db.listpersonaluser(id);
			
			User  u = userL.get(0);
			response.setContentType("text/html");
			RequestDispatcher disp = request.getRequestDispatcher("/view/perfil.jsp?user="+u.getUser()+"&name="+u.getName()+"&surname="+u.getSurname()+"&phone="+u.getPhone()+"&mail="+u.getMail()+"&busy="+busy+"&rented="+rented);
			disp.include(request,response);						
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
