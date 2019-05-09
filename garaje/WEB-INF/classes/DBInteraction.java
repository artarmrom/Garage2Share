
import java.sql.*;
import java.util.ArrayList;



public class DBInteraction {

	private static final String dblogin = "root";
	private static final String dbpasswd = "dat14";
    
	Query q;
	Connection con;

	//Constructor that connects to the Database
	public DBInteraction () throws SQLException {
		String url="jdbc:mysql://localhost/GARAGE2SHARE";
        try {
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch (java.lang.ClassNotFoundException e) {
            System.err.print("ClassNotFoundException: ");
            System.err.println(e.getMessage());
        }
        try {
            System.out.println("Trying to connect...");
            con = DriverManager.getConnection (url, dblogin, dbpasswd);
            System.out.println("Connected!");
		}
		catch(SQLException ex) {
            System.err.print("SQLException: ");
            System.err.println(ex.getMessage());
        }
        q=new Query(con);
	}    

	//Method to close the database Connection
	public void close()throws Exception{
		try{
			q.close();
			con.close();
		}
		catch(Exception ex) {
            System.err.print("SQLException: ");
            System.err.println(ex.getMessage());
        }
	}

	//Method to add a new user to the USERS table
	public void addusr(String user, String password, String name, String surname, String mail, String phone)throws Exception{
		
        String addusr="INSERT INTO USERS (USER, PASSWORD, NAME, SURNAME, MAIL, PHONE) VALUES ('"+user+"','"+password+"','"+name+"','"+surname+"','"+mail+"','"+phone+"')";
	    q.doUpdate(addusr);
	}

	// This method returns 'true' in case there exists a row in the USERS table with the login and password passed as parameters
	// If there is no such row exists then it returns 'false'	
	public String authentication(String user, String password)throws Exception{
		String list="SELECT * FROM USERS WHERE USER='"+user+"'";
		String pwd=null;
		ResultSet rs=q.doSelect(list); //rs will contain the row with login passed as parameter
		if (rs.next()){ //Check if the Resultset is empty
		    pwd = rs.getString(3);
		}
		if (pwd == null){
			return("0");
		}
		if(pwd.equals(password)){ // In case the password for this login in the table is the same as the one passed as parameter
			return(rs.getString(1));
		}
		else {
			return("0");
		}
	}
	
	//This method deletes the user whose login is passed as a parameter from the USERS table.
	public void delusr(int id) throws Exception{
		String delusr="DELETE FROM USERS WHERE ID='"+id+"'";
		q.doUpdate(delusr);
	}

	//This method adds a new activity in the GARAGES table using the data passed as parameters
	public void addgar( String place, String direction, String space, String code, String price, String vehicle, String status,  String initialTime, String endTime, int userId)throws Exception{
		
		String addgarage="INSERT INTO GARAGES (PLACE, DIRECTION, SPACE, CODE, PRICE, VEHICLE, STATUS, INITIALTIME, ENDTIME, USERID) VALUES ('"+place+"','"+direction+"','"+space+"','"+code+"','"+price+"','"+vehicle+"','"+status+"','"+initialTime+"','"+endTime+"','"+userId+"')";
		q.doUpdate(addgarage);
		
	}
	
	//This method deletes the row whose id is passed as a parameter from the GARAGES table.   
	public void delgar(int id) throws Exception{
		String delgar="DELETE FROM GARAGES WHERE ID='"+id+"'";
		q.doUpdate(delgar);
	}

	//This method adds a new pavillion in the CONTRACTS table using the data passed as parameters
	public void addcont(int owner, int customer, int garage, int hours, String price, String initialTime, String vehicle, String status) throws Exception{
		String addcontract="INSERT INTO CONTRACTS (OWNER, CUSTOMER, GARAGE, HOURS, PRICE, INITIALTIME, VEHICLE, STATUS) VALUES ('"+owner+"','"+customer+"','"+garage+"','"+hours+"','"+price+"','"+initialTime+"','"+vehicle+"','"+status+"')";
		q.doUpdate(addcontract);
	}

	//This method deletes the pavillion whose name is passed as a parameter from the CONTRACTS table.
	public void delcont(int id) throws Exception{
		String delcont="DELETE FROM CONTRACTS WHERE ID='"+id+"'";
		q.doUpdate(delcont);
	}

	//This method requests the execution of an SQL sentence for listing all the users
	//and retrieves all the information for each user, storing each user as an element
	//of an array. Each element contains an object of the type User
	public ArrayList<User> listnameusers(String selection) throws Exception{
		ArrayList<User> data = new ArrayList<User>();
		ResultSet rs=q.doSelect(selection);
		while (rs.next()) {                     
           String user = rs.getString(4);
           data.add(new User(user));
	    }
		return (data);	
	}
	
	//This method requests the execution of an SQL sentence for listing all the users
	//and retrieves all the information for each user, storing each user as an element
	//of an array. Each element contains an object of the type User
	public ArrayList<User> listpersonalusers(String selection) throws Exception{
		ArrayList<User> data = new ArrayList<User>();
		ResultSet rs=q.doSelect(selection);
		while (rs.next()) {    
           String user = rs.getString(2);
		   String name = rs.getString(4);
		   String surname = rs.getString(5);
		   String mail = rs.getString(6);
		   String phone = rs.getString(7);
           data.add(new User(user, name, surname, mail, phone));
	    }
		return (data);	
	}

	//This method is common to all the listing garages operations
	//It requests the execution of a SQL sentence for listing garages depending on some criterion
	//and retrieves all the information for each garage, storing each garage as an element
	//of an ArrayList (of Garage objects)
	public ArrayList<Garage> listgarages(String selection) throws Exception{
		ArrayList<Garage> data = new ArrayList<Garage>();
		ResultSet rs=q.doSelect(selection);
		while (rs.next()) {                     
		    int id = rs.getInt(1);
			String place = rs.getString(2);
			String direction = rs.getString(3);
			String space = rs.getString(4);
			String code = rs.getString(5);
			String price = rs.getString(6);
			String vehicle = rs.getString(7);
			String status = rs.getString(8);
			String initialTime = rs.getString(9);
			String endTime = rs.getString(10);
			String userId = rs.getString(11);
			data.add(new Garage(id, place, direction, space, code, price, vehicle, status, initialTime, endTime, userId));
		}
		return (data);
	}
	
	
	//This method is common to all the listing contracts operations
	//It requests the execution of a SQL sentence for listing contracts depending on some criterion
	//and retrieves all the information for each contract, storing each contract as an element
	//of an ArrayList (of Contract objects)
	public ArrayList<Contract> listcontracts(String selection) throws Exception{
		ArrayList<Contract> data = new ArrayList<Contract>();
		ResultSet rs=q.doSelect(selection);
		while (rs.next()) {                     
		    int id = rs.getInt(1);
			int owner = rs.getInt(2);
			int customer = rs.getInt(3);
			int garage = rs.getInt(4);
			int hours = rs.getInt(5);
			String price = rs.getString(6);
			String initialTime = rs.getString(7);
			String vehicle = rs.getString(8);
			String status = rs.getString(9);
			data.add(new Contract( id,owner, customer, garage, hours, price, initialTime, vehicle, status));
		}
		return (data);
	}

	//This method builds an SQL sentence for listing all the garages
	public ArrayList<Garage> listallgar() throws Exception{
		String selection="SELECT * FROM GARAGES";
		ArrayList<Garage> data = this.listgarages(selection);
		return (data);	
	}

    // This method builds an SQL sentence for listing the garages that are available at that exact period of time
	public ArrayList<Garage> listgarfreegarages() throws Exception{
		String selection="SELECT * FROM GARAGES WHERE STATUS = 'TRUE'";
		ArrayList<Garage> data = this.listgarages(selection);
		return (data);
	}
	
	
    // This method builds an SQL sentence for listing the garages that are free
	public ArrayList<Garage> listmyfreegarages(int userId) throws Exception{
		String selection="SELECT * FROM GARAGES WHERE STATUS = 'TRUE' AND USERID ="+userId+"'";
		ArrayList<Garage> data = this.listgarages(selection);
		return (data);
	}	
	
	
    // This method builds an SQL sentence for listing the garages that are busy
	public ArrayList<Garage> listmybusygarages(int userId) throws Exception{
		String selection="SELECT * FROM GARAGES WHERE STATUS = 'FALSE' AND USERID ="+userId+"'";
		ArrayList<Garage> data = this.listgarages(selection);
		return (data);
	}
	
	// This method builds an SQL sentence for listing the garages that is owner a certain user
	public ArrayList<Garage> listactmygar(int userId) throws Exception{
		String selection="SELECT * FROM GARAGES WHERE USERID ="+userId+"'";
		ArrayList<Garage> data = this.listgarages(selection);
		return (data); 
	}
	
	// This method builds an SQL sentence for get garages that are free with a certain id
	public ArrayList<Garage> listfreeidgarages(int id) throws Exception{
		String selection="SELECT * FROM GARAGES WHERE STATUS = 'TRUE' AND ID ="+id+"'";
		ArrayList<Garage> data = this.listgarages(selection);
		return (data);
	}	

	// This method builds an SQL sentence for listing the name of the user that is owner of a certain garage
	public ArrayList<User> listnameuser(int id) throws Exception{
		String selection="SELECT * FROM USERS WHERE ID='"+id+"'";
		ArrayList<User> data = this.listnameusers(selection);
		return (data);
	}
	
	// This method builds an SQL sentence for listing the personal information of the user that is owner or a customer of a certain garage when it's already in the contract
	public ArrayList<User> listpersonaluser(int id) throws Exception{
		String selection="SELECT * FROM USERS WHERE ID='"+id+"'";
		ArrayList<User> data = this.listpersonalusers(selection);
		return (data);
	}

	// This method builds an SQL sentence for listing the personal information of the user
	public boolean checkName(String user) throws Exception{
		String selection="SELECT * FROM USERS WHERE USER='"+user+"'";
		ResultSet data = q.doSelect(selection);
		return (data.next());
	}
	
	// This method builds an SQL sentence for listing the personal information of the user
	public boolean checkMail(String mail) throws Exception{
		String selection="SELECT * FROM USERS WHERE MAIL='"+mail+"'";
		ResultSet data = q.doSelect(selection);
		return (data.next());
	}
	
	// This method builds an SQL sentence for listing the personal information of the user
	public boolean checkGarage(String place, String direction, String space, String code, String vehicle, int userId) throws Exception{
		String selection="SELECT * FROM GARAGES WHERE PLACE='"+place+"' AND DIRECTION='"+direction+"' AND SPACE='"+space+"' AND CODE='"+code+"' AND VEHICLE='"+vehicle+"' AND USERID='"+userId+"'";
		ResultSet data = q.doSelect(selection);
		return (data.next());
	}

	
	
	// This method builds an SQL sentence for listing the contracts that a user has as a owner
	public ArrayList<Contract> listmyownercont(int owner) throws Exception{
		String selection="SELECT * FROM CONTRACTS WHERE OWNER='"+owner+"'";
		ArrayList<Contract> data = this.listcontracts(selection);
		return (data);
	}
	
	// This method builds an SQL sentence for listing the contracts that a user has as a owner and is active
	public ArrayList<Contract> listmyownercontact(int owner) throws Exception{
		String selection="SELECT * FROM CONTRACTS WHERE STATUS='TRUE' AND OWNER='"+owner+"'";
		ArrayList<Contract> data = this.listcontracts(selection);
		return (data);
	}
	
	// This method builds an SQL sentence for listing the contracts that a user has as a owner and is inactive
	public ArrayList<Contract> listmyownercontinact(int owner) throws Exception{
		String selection="SELECT * FROM CONTRACTS WHERE STATUS='FALSE' AND OWNER='"+owner+"'";
		ArrayList<Contract> data = this.listcontracts(selection);
		return (data);
	}
	
	// This method builds an SQL sentence for listing the contract that a user has as a customer
	public ArrayList<Contract> listmycustcont(int customer) throws Exception{
		String selection="SELECT * FROM CONTRACTS WHERE CUSTOMER='"+customer+"'";
		ArrayList<Contract> data = this.listcontracts(selection);
		return (data);
	}
	
	// This method builds an SQL sentence for listing the contract that a user has as a customer and is active
	public ArrayList<Contract> listmycustcontact(int customer) throws Exception{
		String selection="SELECT * FROM CONTRACTS WHERE STATUS='TRUE' AND CUSTOMER='"+customer+"'";
		ArrayList<Contract> data = this.listcontracts(selection);
		return (data);
	}
	
	// This method builds an SQL sentence for listing the contract that a user has as a customer and is inactive
	public ArrayList<Contract> listmycustcontinact(int customer) throws Exception{
		String selection="SELECT * FROM CONTRACTS WHERE STATUS='FALSE' AND CUSTOMER='"+customer+"'";
		ArrayList<Contract> data = this.listcontracts(selection);
		return (data);
	}
	
	// This method builds an SQL sentence for listing the contract that a garage is involved in and is active
	public ArrayList<Contract> listmygarcontact(int garage) throws Exception{
		String selection="SELECT * FROM CONTRACTS WHERE STATUS='TRUE' AND GARAGE='"+garage+"'";
		ArrayList<Contract> data = this.listcontracts(selection);
		return (data);
	}
	
	// This method builds an SQL sentence for listing the contract that a garage is involved in and is inactive
	public ArrayList<Contract> listmygarcontinact(int garage) throws Exception{
		String selection="SELECT * FROM CONTRACTS WHERE STATUS='FALSE' AND GARAGE='"+garage+"'";
		ArrayList<Contract> data = this.listcontracts(selection);
		return (data);
	}
	
	public ArrayList<Garage> listgarplacveh(String place, String vehicle) throws Exception{
		String selection="SELECT * FROM GARAGES WHERE PLACE = '"+place+"' AND VEHICLE ='"+vehicle+"'";
		ArrayList<Garage> data = this.listgarages(selection);
		return (data);
	}
	
}
