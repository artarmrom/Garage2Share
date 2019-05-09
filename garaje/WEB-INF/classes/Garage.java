

public class Garage {

  private int id;
  private String place; /* Ciudad del garaje */
  private String direction; /* Direccion del garaje */
  private String space; /* Plaza del garaje */
  private String code; /* Codigo para entrar al garaje */
  private String price; /* Precio por hora */
  private String vehicle; /* Tipo de vehiculo */
  private String status; /* TRUE:Libre/FALSE:Ocupado */
  private String initialTime; /* Fecha Inicio */
  private String endTime; /* Fecha Inicio */
  private String userId;

  public Garage() {
  }

  public Garage(int id) {
    this();
    this.id = id;
  }

  public Garage(int id, String place, String direction, String space, String code, String price, String vehicle, String status, String endTime, String initialTime, String userId) {
    this();
    this.id = id;
    this.place = place;
    this.direction = direction;
    this.space = space;
    this.code = code;
    this.price = price;
    this.vehicle = vehicle;
    this.status = status;
    this.endTime = endTime;
    this.initialTime = initialTime;
  }

  public Garage(String place, String direction, String space, String code, String price, String vehicle, String status, String endTime, String initialTime, String userId) {
	    this();
	    this.place = place;
	    this.direction = direction;
	    this.space = space;
	    this.code = code;
	    this.price = price;
	    this.vehicle = vehicle;
	    this.status = status;
	    this.endTime = endTime;
	    this.initialTime = initialTime;
	  }

  public int getId() {
    return this.id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getPlace() {
    return this.place;
  }

  public void setPlace(String place) {
    this.place = place;
  }

  public String getDirection() {
    return this.direction;
  }

  public void setDirection(String direction) {
    this.direction = direction;
  }

  public String getSpace() {
    return this.space;
  }

  public void setSpace(String space) {
    this.space = space;
  }

  public String getCode() {
    return this.code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getPrice() {
    return this.price;
  }

  public void setPrice(String price) {
    this.price = price;
  }

  public String getStatus() {
    return this.status;
  }
  
  public void setStatus(String status) {
    this.status = status;
  }

  public String getVehicle() {
    return this.vehicle;
  }

  public void setVehicle(String vehicle) {
    this.vehicle = vehicle;
  }

    public String getInitialTime() {
    return this.initialTime;
  }

  public void setInitialTime(String initialTime) {
    this.initialTime = initialTime;
  }
  
  public String getEndTime() {
    return this.endTime;
  }

  public void setEndTime(String endTime) {
    this.endTime = endTime;
  }
  
    public String getUserId() {
    return this.userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }
  

}
