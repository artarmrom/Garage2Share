import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import entities.*;

public class session extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
	  doPost(request, response);
	}
	
	public void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter("user");
		String pwd = request.getParameter("password");
		String status;
		
		//Ir a base de datos para verificar si el login y password son correctos
		DBInteraction db = new DBInteraction();
		
		boolean auth = db.authentication(login,pwd);
		
		PrinterWriter out = response.getWriter();
		// COMPROBAR SI EL USUARIO AUN PERTENECE A LA SESION DE LA COOKIE O NO. 
		
		if(auth){
			//Si son correctos, se redirige a otro servlet donde dará acceso a la aplicación con los permisos propios del usuario 
			Object authuser = db.getUserByName(login).get(0);
			Cookie ck=new Cookie("user",authuser);
	        ck.setMaxAge(24 * 60 * 60);
	       	response.addCookie(ck);
			status = "200";
			
		}else{
			status = "404";
		}
		out.println(status);
		out.close();

		db.close();

	}
}
