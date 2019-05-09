
import java.io.*;


import javax.servlet.*;
import javax.servlet.http.*;


@SuppressWarnings("serial")
public class crearcontrato extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {				
		int garage = Integer.parseInt(request.getParameter("idgar"));
		int hours = Integer.parseInt(request.getParameter("hours"));
		String initialTime = request.getParameter("initialTime");
		
		try{
		
			DBInteraction db = new DBInteraction();			
			Garage gar = db.listfreeidgarages(garage).get(0);
			
			HttpSession session = request.getSession(true);
			int customer = Integer.parseInt((String)session.getAttribute("id"));
			int owner = Integer.parseInt(gar.getUserId());
			int price = Integer.parseInt(gar.getPrice());
			int totalPrice = price*hours;
			String status = "true";
			String vehicle = gar.getVehicle();
			db.addcont(owner, customer, garage, hours, Integer.toString(totalPrice), initialTime, vehicle, status);
			
			String place = gar.getPlace();
			String direction = gar.getDirection();
			String space = gar.getSpace();
			String code = gar.getCode();
			
			User user = db.listpersonaluser(owner).get(0);
			String name = user.getName();
			String surname = user.getSurname();
			String mail = user.getMail();
			String phone = user.getPhone();			
			
			response.setContentType("text/html");
			RequestDispatcher view=request.getRequestDispatcher("/view/contrato.jsp?name="+name+
				"&surname="+surname+"&mail="+mail+"&phone="+phone+"&place="+place+"&direction="+direction+
				"&hours="+hours+"&price="+totalPrice+"&initialTime="+initialTime+"&vehicle="+vehicle);
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
