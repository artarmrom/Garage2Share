import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import entities.*;

public class register extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
	  doPost(request, response);
	}
	
	public void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter("user");
		String pwd = request.getParameter("password");
		String name = request.getParameter("name");
		String surname = request.getParameter("surname");
		String mail = request.getParameter("mail");
		int phone = request.getParameter("phone");
		String status;
		
		
		PrinterWriter out = response.getWriter();
		
		//COMPROBAR SI EL USUARIO SE HA REGISTRADO ANTERIORMENTE O NO CON EL MAIL
		
		DBInteraction db = new DBInteraction();
		
		db.addusr(login,pwd,name,surname,mail,phone);
		
		status = "200";
		
		out.println(status);
		out.close();
		
		db.close();

	}
}
