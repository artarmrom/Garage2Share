
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;


public class register extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
	  doPost(request, response);
	}
	
	public void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user = request.getParameter("user");
		String pwd = request.getParameter("password");
		String name = request.getParameter("name");
		String surname = request.getParameter("surname");
		String mail = request.getParameter("mail");
		String phone = request.getParameter("phone");
		String status = "404";
		boolean nck;
		boolean mck;
		
		
		PrintWriter out = response.getWriter();
		
		//COMPROBAR SI EL USUARIO SE HA REGISTRADO ANTERIORMENTE O NO CON EL MAIL
		try{
			DBCreation dbc = new DBCreation();
			dbc.close();
			DBInteraction db = new DBInteraction();
			
			nck = db.checkName(user);
			
			if(nck){
				status="name";
			}
				
			mck = db.checkMail(mail);
			if(mck){
				status="mail";
			}

			if(status=="404"){
				db.addusr(user,pwd,name,surname,mail,phone);
			
				status="200";
			}
			
			db.close();
		}catch(SQLException ex){
            System.err.print("SQLException: ");
            System.err.println(ex.getMessage());
		}catch(Exception ex){
            System.err.print("Exception: ");
            System.err.println(ex.getMessage());
		}
		out.write(status);
		out.close();

	}
}
