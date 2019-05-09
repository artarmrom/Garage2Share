
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class login extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
	  doPost(request, response);
	}
	
	public void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user = request.getParameter("user");
		String pwd = request.getParameter("password");
		String status;
		
		try{
			//Ir a base de datos para verificar si el login y password son correctos
			DBInteraction db = new DBInteraction();
			
			String auth = db.authentication(user, pwd);
			
			PrintWriter out = response.getWriter();
			
			
			// COMPROBAR SI EL USUARIO AUN PERTENECE A LA SESION DE LA COOKIE O NO. 

			if(auth != "0"){
				//Si son correctos, se redirige a otro servlet donde dará acceso a la aplicación con los permisos propios del usuario 
				HttpSession session = request.getSession(true);
				//String authid = new String(auth);
				session.setAttribute("id",auth);
				status="200";
			
			}else{
				status="404";
			}
			out.write(status);
			out.close();
			db.close();
		}catch(Exception ex){
            System.err.print("Exception: ");
            System.err.println(ex.getMessage());
		}

	}
}
