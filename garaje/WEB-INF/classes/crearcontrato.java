
import java.io.*;


import javax.servlet.*;
import javax.servlet.http.*;


@SuppressWarnings("serial")
public class crearcontrato extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {				
		int garage = Integer.parseInt(request.getParameter("idgar"));
		int hours = Integer.parseInt(request.getParameter("horas"));
		String time = request.getParameter("fecha_inicio");
		String hour = request.getParameter("hora_inicio");
		
		try{
			DBInteraction db = new DBInteraction();	
			
			
			int time1 = Character.getNumericValue(time.charAt(0));
			int hour1 = Character.getNumericValue(hour.charAt(0));
			
			int initialTime;
			int initialHour;
			
			if(time1>9){
				initialTime = time1 + Character.getNumericValue(time.charAt(1));
			}else{
				initialTime = time1;
			}
			if(hour1>9){
				initialHour = hour1 + Character.getNumericValue(hour.charAt(1));
			}else{
				initialHour = hour1;
			}
			
			int endHour = hours+initialHour;
			int endTime = initialTime;
			if (endHour%24 != 0){
				endHour=24-endHour;
				endTime=endTime+1;
			}
			
			boolean cktime = db.checkTimegar(garage, initialTime, initialHour, endTime, endHour);
				
			if(cktime){	
				Garage gar = db.listfreeidgarages(garage).get(0);
				
				HttpSession session = request.getSession(true);
				int customer = Integer.parseInt((String)session.getAttribute("id"));
				int owner = gar.getUserId();
				int price = Integer.parseInt(gar.getPrice());
				int totalPrice = price*hours;
				String status = "true";
				String vehicle = gar.getVehicle();
				db.addcont(owner, customer, garage, hours, Integer.toString(totalPrice), initialTime, initialHour, vehicle, status);
				
				db.modstatgar("false");
				
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
					"&price="+totalPrice+"&initialTime="+initialTime+"&initialHour="+initialHour+
					"&endTime="+endTime+"&endHour="+endHour+"&vehicle="+vehicle);
				view.include(request, response);
			}
			
		
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
