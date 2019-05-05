package classes.model;

import java.sql.*;
import java.util.ArrayList;

import javax.management.Query;
import model.User;
import model.Garage;
import model.Contract;
import model.Query;

public class DBInteraction {

	private static final String dblogin = "";
	private static final String dbpasswd = "";
    
	Query q;
	Connection con;

	//Constructor that connects to the Database
	public DBInteraction () throws SQLException {
		String url="jdbc:mysql://localhost/garage2share";
        try {
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch (java.lang.ClassNotFoundException e) {
            System.err.print("ClassNotFoundException: ");
            System.err.println(e.getMessage());
        }
        try {
            System.out.println("Trying to connect...");
            con = DriverManager.getConnection (url, "root", "password");
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
        q.close();
		con.close();
	}

	//Method to add a new user to the USERS table
	public void addusr(String user, String password, String name, String surname, String mail, int phone)throws Exception{
        String addusr="INSERT INTO USERS (USER, PASSWORD, NAME, SURNAME, MAIL, PHONE) VALUES ('"+user+"','"+password+"','"+name+"','"+surname+"','"+mail+"','"+phone+"')";
	    q.doUpdate(addusr);
	}

	// This method returns 'true' in case there exists a row in the USERS table with the login and password passed as parameters
	// If there is no such row exists then it returns 'false'	
	public boolean authentication(String user, String password)throws Exception{
		String list="SELECT * FROM USERS WHERE USER='"+user+"'";
		String pwd=null;
		ResultSet rs=q.doSelect(list); //rs will contain the row with login passed as parameter
		if (rs.next()){ //Check if the Resultset is empty
		    pwd = rs.getString(2);
		}
		if (pwd == null){
			return(false);
		}
		if(pwd.equals(password)){ // In case the password for this login in the table is the same as the one passed as parameter
			return(true);
		}
		else {
			return(false);
		}
	}
	
	//This method deletes the user whose login is passed as a parameter from the USERS table.
	public void delusr(int id) throws Exception{
		String delusr="DELETE FROM USERS WHERE ID='"+id+"'";
		q.doUpdate(delusr);
	}

	//This method adds a new activity in the GARAGES table using the data passed as parameters
	public void addgar( String place, String direction, int space, int code, float price, String vehicle, boolean status,  String initialTime, String endTime, int userId)throws Exception{
		String addgarage="INSERT INTO GARAGES (PLACE, DIRECTION, SPACE, CODE, PRICE, VEHICLE, STATUS, INITIALTIME, ENDTIME, USERID) VALUES ('"+place+"','"+direction+"','"+space+"','"+code+"','"+price+"','"+vehicle+"','"+status+"','"+initialTime+"','"+endTime+"','"+userId+"')";
		q.doUpdate(addgarage);
	}
	
	//This method deletes the row whose id is passed as a parameter from the GARAGES table.   
	public void delgar(int id) throws Exception{
		String delgar="DELETE FROM GARAGES WHERE ID='"+id+"'";
		q.doUpdate(delgar);
	}

	//This method adds a new pavillion in the CONTRACTS table using the data passed as parameters
	public void addcont(int owner, int customer, int garage, int hours, float price, String initialTime, String vehicle, boolean status) throws Exception{
		String addcontract="INSERT INTO CONTRACTS (OWNER, CUSTOMER, GARAGE, HOURS, PRICE, INTIALTIME, VEHICLE, STATUS) VALUES ('"+owner+"','"+customer+"','"+garage+"','"+hours+'","'+price+"','"+initialTime+"','"+vehicle+"','"+status+"')";
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
	public ArrayList listnameusers(String selection) throws Exception{
		ArrayList data = new ArrayList();
		ResultSet rs=q.doSelect(selection);
		while (rs.next()) {                     
           String user = rs.getString(2);
           data.add(new User(user));
	    }
		return (data);	
	}
	
	//This method requests the execution of an SQL sentence for listing all the users
	//and retrieves all the information for each user, storing each user as an element
	//of an array. Each element contains an object of the type User
	public ArrayList listpersonalusers(String selection) throws Exception{
		ArrayList data = new ArrayList();
		ResultSet rs=q.doSelect(selection);
		while (rs.next()) {                     
           String user = rs.getString(2);
		   String mail = rs.getString(3);
		   String name = rs.getString(4);
		   String surname = rs.getString(5);
		   int phone = rs.getString(7);
           data.add(new User(user, mail, name, surname, phone));
	    }
		return (data);	
	}

	//This method is common to all the listing garages operations
	//It requests the execution of a SQL sentence for listing garages depending on some criterion
	//and retrieves all the information for each garage, storing each garage as an element
	//of an ArrayList (of Garage objects)
	public ArrayList listgarages(String selection) throws Exception{
		ArrayList data = new ArrayList();
		ResultSet rs=q.doSelect(selection);
		while (rs.next()) {                     
		    int id = rs.getInt(1);
			String place = rs.getString(2);
			String direction = rs.getString(3);
			int space = rs.getInt(4);
			int code = rs.getInt(5);
			float price = rs.getFloat(6);
			String vehicle = rs.getString(7);
			boolean status = rs.getBoolean(8);
			String initialTime = rs.getString(9);
			String endTime = rs.getString(10);
			int userId = rs.getInt(11);
			data.add(new Garage(id, place, direction, space, code, price, vehicle, status, initialTime, endTime, userId));
		}
		return (data);
	}
	
	
	//This method is common to all the listing contracts operations
	//It requests the execution of a SQL sentence for listing contracts depending on some criterion
	//and retrieves all the information for each contract, storing each contract as an element
	//of an ArrayList (of Contract objects)
	public ArrayList listcontracts(String selection) throws Exception{
		ArrayList data = new ArrayList();
		ResultSet rs=q.doSelect(selection);
		while (rs.next()) {                     
		    int id = rs.getInt(1);
			int owner = rs.getInt(2);
			int customer = rs.getInt(3);
			int garage = rs.getInt(4);
			int hours = rs.getInt(5);
			float price = rs.getFloat(6);
			String initialTime = rs.getString(7);
			String vehicle = rs.getString(8);
			boolean status = rs.getBoolean(9);
			data.add(new Contract (id, owner, customer, garage, hours, price, initialTime, vehicle, status));
		}
		return (data);
	}

	//This method builds an SQL sentence for listing all the garages
	public ArrayList listallgar() throws Exception{
		String selection="SELECT * FROM GARAGES";
		ArrayList data = this.listgarages(selection);
		return (data);	
	}

    // This method builds an SQL sentence for listing the garages that are available at that exact period of time
	public ArrayList listgarfreegarages() throws Exception{
		String selection="SELECT * FROM GARAGES WHERE STATUS = TRUE";
		ArrayList data = this.listgarages(selection);
		return (data);
	}
	
	
    // This method builds an SQL sentence for listing the garages that are free
	public ArrayList listmyfreegarages(int userId) throws Exception{
		String selection="SELECT * FROM GARAGES WHERE STATUS = TRUE AND USERID ="+userId+"'";
		ArrayList data = this.listgarages(selection);
		return (data);
	}	
	
	
    // This method builds an SQL sentence for listing the garages that are busy
	public ArrayList listmybusygarages(int userId) throws Exception{
		String selection="SELECT * FROM GARAGES WHERE STATUS = FALSE AND USERID ="+userId+"'";
		ArrayList data = this.listgarages(selection);
		return (data);
	}
	
	
	// This method builds an SQL sentence for listing the garages that is owner a certain user
	public ArrayList listactmygar(int userId) throws Exception{
		String selection="SELECT * FROM GARAGES WHERE USERID ="+userId+"'";
		ArrayList data = this.listgarages(selection);
		return (data); 
	}

	// This method builds an SQL sentence for listing the name of the user that is owner of a certain garage
	public ArrayList listnameuser(int id) throws Exception{
		String selection="SELECT * FROM USERS WHERE ID='"+id+"'";
		ArrayList data = this.listnameusers(selection);
		return (data);
	}
	
	// This method builds an SQL sentence for listing the personal information of the user that is owner or a customer of a certain garage when it's already in the contract
	public ArrayList listpersonaluser(int id) throws Exception{
		String selection="SELECT * FROM USERS WHERE ID='"+id+"'";
		ArrayList data = this.listpersonalusers(selection);
		return (data);
	}

	// This method builds an SQL sentence for listing the personal information of the user
	public ArrayList getUserByName(String user) throws Exception{
		String selection="SELECT * FROM USERS WHERE USER='"+user+"'";
		ArrayList data = this.listpersonalusers(selection);
		return (data);
	}
	
	// This method builds an SQL sentence for listing the contracts that a user has as a owner
	public ArrayList listmyownercont(int owner) throws Exception{
		String selection="SELECT * FROM CONTRACTS WHERE OWNER='"+owner+"'";
		ArrayList data = this.listcontracts(selection);
		return (data);
	}
	
	// This method builds an SQL sentence for listing the contracts that a user has as a owner and is active
	public ArrayList listmyownercontact(int owner) throws Exception{
		String selection="SELECT * FROM CONTRACTS WHERE STATUS=TRUE AND OWNER='"+owner+"'";
		ArrayList data = this.listcontracts(selection);
		return (data);
	}
	
	// This method builds an SQL sentence for listing the contracts that a user has as a owner and is inactive
	public ArrayList listmyownercontinact(int owner) throws Exception{
		String selection="SELECT * FROM CONTRACTS WHERE STATUS=FALSE AND OWNER='"+owner+"'";
		ArrayList data = this.listcontracts(selection);
		return (data);
	}
	
	// This method builds an SQL sentence for listing the contract that a user has as a customer
	public ArrayList listmycustcont(int customer) throws Exception{
		String selection="SELECT * FROM CONTRACTS WHERE CUSTOMER='"+customer+"'";
		ArrayList data = this.listcontracts(selection);
		return (data);
	}
	
	// This method builds an SQL sentence for listing the contract that a user has as a customer and is active
	public ArrayList listmycustcontact(int customer) throws Exception{
		String selection="SELECT * FROM CONTRACTS WHERE STATUS=TRUE AND CUSTOMER='"+customer+"'";
		ArrayList data = this.listcontracts(selection);
		return (data);
	}
	
	// This method builds an SQL sentence for listing the contract that a user has as a customer and is inactive
	public ArrayList listmycustcontinact(int customer) throws Exception{
		String selection="SELECT * FROM CONTRACTS WHERE STATUS=FALSE AND CUSTOMER='"+customer+"'";
		ArrayList data = this.listcontracts(selection);
		return (data);
	}
	
	// This method builds an SQL sentence for listing the contract that a garage is involved in and is active
	public ArrayList listmygarcontact(int garage) throws Exception{
		String selection="SELECT * FROM CONTRACTS WHERE STATUS=TRUE AND GARAGE='"+garage+"'";
		ArrayList data = this.listcontracts(selection);
		return (data);
	}
	
	// This method builds an SQL sentence for listing the contract that a garage is involved in and is inactive
	public ArrayList listmygarcontinact(int garage) throws Exception{
		String selection="SELECT * FROM CONTRACTS WHERE STATUS=FALSE AND GARAGE='"+garage+"'";
		ArrayList data = this.listcontracts(selection);
		return (data);
	}
	
}