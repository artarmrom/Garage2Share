
import java.sql.*;
import java.util.ArrayList;

public class DBCreation {

	private static final String dblogin = "root";
	private static final String dbpasswd = "dat14";
   
   	Query q;
	Connection con = null;

	//Constructor that connects to the Database
	public DBCreation () throws SQLException {
		String url="jdbc:mysql://localhost/";
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
        try {
            System.out.println("Creating database...");
            String sql="CREATE DATABASE IF NOT EXISTS GARAGE2SHARE";
            q.doUpdate(sql);
            System.out.println("Created!");
		}
		catch(SQLException ex) {
            System.err.print("SQLException: ");
            System.err.println(ex.getMessage());
        }
		q.close();
		url="jdbc:mysql://localhost/GARAGE2SHARE";
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
        try {
            System.out.println("Creating tables...");
            String sql="CREATE TABLE IF NOT EXISTS USERS (ID INT UNSIGNED NOT NULL AUTO_INCREMENT, USER VARCHAR(16) NOT NULL, PASSWORD VARCHAR(16) NOT NULL, NAME VARCHAR(16) NOT NULL, SURNAME VARCHAR(32) NOT NULL, MAIL VARCHAR(32) NOT NULL, PHONE INT NOT NULL, PRIMARY KEY (ID))";
            q.doUpdate(sql);
            String sql2="CREATE TABLE IF NOT EXISTS GARAGES ( ID INT UNSIGNED NOT NULL AUTO_INCREMENT, PLACE VARCHAR(16), DIRECTION VARCHAR(32), SPACE VARCHAR(16) NOT NULL, CODE VARCHAR(16) NOT NULL, PRICE VARCHAR(16) NOT NULL, VEHICLE VARCHAR(16) NOT NULL, STATUS VARCHAR(16) NOT NULL, INITIALTIME VARCHAR(16) NOT NULL, ENDTIME VARCHAR(16) NOT NULL, USERID INT UNSIGNED NOT NULL, PRIMARY KEY (ID), FOREIGN KEY (USERID) REFERENCES USERS(ID))";
            q.doUpdate(sql2);
            System.out.println("Created!");
		}
		catch(SQLException ex) {
            System.err.print("SQLException: ");
            System.err.println(ex.getMessage());
        }
        
	}    

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

}
