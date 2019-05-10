

public class Garage {

  private int id;
  private String place; /* Ciudad del garaje */
  private String direction; /* Direccion del garaje */
  private String space; /* Plaza del garaje */
  private String code; /* Codigo para entrar al garaje */
  private String price; /* Precio por hora */
  private String vehicle; /* Tipo de vehiculo */
  private String status; /* TRUE:Libre/FALSE:Ocupado */
  private int initialTime; /* Fecha Inicio */
  private int initialHour; /* Hora Inicio */
  private int endTime; /* Fecha Fin */
  private int endHour; /* Fecha Fin */
  private int userId;

  public Garage() {
  }

  public Garage(int id) {
    this();
    this.id = id;
  }

  public Garage(int id, String place, String direction, String space, String code, String price, String vehicle, String status, int initialTime, int initialHour, int endTime, int endHour, int userId) {
    this();
    this.id = id;
    this.place = place;
    this.direction = direction;
    this.space = space;
    this.code = code;
    this.price = price;
    this.vehicle = vehicle;
    this.status = status;
    this.initialTime = initialTime;
    this.initialHour = initialHour;
    this.endTime = endTime;
    this.endHour = endHour;
  }

  public Garage(String place, String direction, String space, String code, String price, String vehicle, String status, int initialTime, int initialHour, int endTime, int endHour, int userId) {
	    this();
	    this.place = place;
	    this.direction = direction;
	    this.space = space;
	    this.code = code;
	    this.price = price;
	    this.vehicle = vehicle;
	    this.status = status;
		this.initialTime = initialTime;
		this.initialHour = initialHour;
		this.endTime = endTime;
		this.endHour = endHour;
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

   public int getInitialTime() {
    return this.initialTime;
  }

  public void setInitialTime(int initialTime) {
    this.initialTime = initialTime;
  }
  
  public int getInitialHour() {
    return this.initialHour;
  }

  public void setInitialHour(int initialHour) {
    this.initialHour = initialHour;
  }
  
  public int getEndTime() {
    return this.endTime;
  }

  public void setEndTime(int endTime) {
    this.endTime = endTime;
  }
    
  public int getEndHour() {
    return this.endHour;
  }

  public void setEndHour(int endHour) {
    this.endTime = endHour;
  }
  
  
    public int getUserId() {
    return this.userId;
  }

  public void setUserId(int userId) {
    this.userId = userId;
  }
  

}
