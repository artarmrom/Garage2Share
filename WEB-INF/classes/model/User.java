package classes.model;

public class User {

  private int id; /* ID unico para cada usuario */
  private String user; /* Usuario para autenticacion */
  private String mail; 
  private String name; /* Nombre */
  private String surname; /* Apellido */
  private String password;
  private int phone;

  public User() {
  }

  public User(String user) {
    this();
    this.user = user;
  }

  public User(String user, String mail, String name, String surname, int phone) {
    this();
    this.user = user;
	this.mail = mail;
    this.name = name;
    this.surname = surname;
    this.phone = phone;
  }
  
  public User(int id, String user, String mail, String name, String surname, String password, int phone) {
    this();
    this.id = id;
    this.user = user;
    this.mail = mail;
    this.name = name;
    this.surname = surname;
    this.password = password;
    this.phone = phone;
  }

  public User(String user, String mail, String name, String surname, String password, int phone) {
    this();
    this.user = user;
    this.mail = mail;
    this.name = name;
    this.surname = surname;
    this.password = password;
    this.phone = phone;
  }

  public int getId() {
    return this.id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getUser() {
    return this.user;
  }

  public void setUser(String user) {
    this.user = user;
  }

  public String getMail() {
    return this.mail;
  }

  public void setMail(String mail) {
    this.mail = mail;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSurname() {
    return this.surname;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }  

  public String getPassword() {
    return this.password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
  
  public int getPhone() {
	    return this.phone;
	  }

  public void setPhone(int phone) {
	  this.phone = phone;
  }

}

