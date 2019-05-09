
import java.io.*;
import java.util.ArrayList;


import javax.servlet.*;
import javax.servlet.http.*;


@SuppressWarnings("serial")
public class vercontratos extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {				
		try{
			HttpSession session = request.getSession(true);
			int id = (int)session.getAttribute("id");
			DBInteraction db = new DBInteraction();			

			ArrayList<Contract> contracts = db.listmyownercontinact(id);
					
			request.setAttribute("contracts", contracts);
			response.setContentType("text/html");
			RequestDispatcher view=request.getRequestDispatcher("/view/perfil.jsp");
			view.include(request, response);
		
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
