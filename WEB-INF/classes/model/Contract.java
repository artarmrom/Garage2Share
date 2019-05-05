package classes.model;

public class Contract {

  private int id; /* Id del contrato */
  private int owner; /* Id del usuario propietario */
  private int customer; /* Id del usuario cliente */
  private int garage; /* Id del garaje del propietario */
  private int hours; /* Horas totales */
  private float price; /* Precio total */
  private String initialTime; /* Hora inicial */
  private String vehicle; /* Coche/Moto/Caravana */
  private boolean status; /* TRUE:Activo/FALSE:Inactivo */

  public Contract() {
  }

  public Contract(int id) {
    this();
    this.id = id;
  }

  public Contract(int id, int owner,  int customer,  int garage, int hours, float price, String initialTime, String vehicle, boolean status) {
    this();
    this.id = id;
    this.owner = owner;
    this.customer = customer;
    this.garage = garage;
    this.hours = hours;
    this.price = price;
    this.initialTime = initialTime;
    this.vehicle = vehicle;
    this.status = status;
  }

  public Contract(int hours, float price, String initialTime, String vehicle) {
    this();
    this.hours = hours;
    this.price = price;
    this.initialTime = initialTime;
    this.vehicle = vehicle;
  }

  public int getId() {
    return this.id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getOwner() {
    return this.owner;
  }

  public void setOwner(int owner) {
    this.owner = owner;
  }
  
  public int getCustomer() {
    return this.customer;
  }

  public void setCustomer(int customer) {
    this.customer = customer;
  }

  public int getContract() {
    return this.garage;
  }

  public void setContract(int garage) {
    this.garage = garage;
  }
  
    public int getHours() {
    return this.hours;
  }
  
  public void setHours(int hours) {
    this.hours = hours;
  }
  
  public float getPrice() {
    return this.price;
  }

  public void setPrice(float price) {
    this.price = price;
  }

  public int getInitialTime() {
    return this.initialTime;
  }

  public void setInitialTime(int initialTime) {
    this.initialTime = initialTime;
  }
  
    public String getVehicle() {
    return this.vehicle;
  }

  public void setVehicle(String vehicle) {
    this.vehicle = vehicle;
  }

  public boolean getStatus() {
	  return this.status;
  }

  public void setStatus(boolean status) {
	  this.status = status;
  }

}