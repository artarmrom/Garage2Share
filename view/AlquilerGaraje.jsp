<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import="java.util.*" %>
<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix ="c" %>
<!DOCTYPE html>

<html>
<head>
  <title>Garage2Share</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
	<link href='https://fonts.googleapis.com/css?family=Open+Sans:400,300,700' rel='stylesheet' type='text/css'>
  <style>
      .header1 
      {
      	font-size:150%;
        color: black;
        padding: 60px;
        text-align: center;
  		position: relative;
      }
      .Text 
      { 
     	padding: 30px;
     	margin: 10px;
     	margin-left: 100px;
        text-align: center;
  		position: relative;
      }
      .downText 
      {
      	color: black;
      	text-align: center;
  		position: relative;
      }
      
		.table{
			border:1px solid-green;
		}
		.tableHead{
			color:black;
			background-color: #b5f2f2;
		}
		      /*Eliminamos los margenes y paddings que agrega el navegador por defecto*/
		* {
		  padding: 0;
		  margin: 0;
		}
		 
		/*Agregamos margenes inferiores a los parrafos*/
		p {
		  margin-bottom: 20px;
		}
			
		header {
		  background: rgba(0,0,0,0.9);
		  width: 100%;
		  position: fixed;
		  z-index: 100;
		}
		nav {
		  float: left; /* Desplazamos el nav hacia la izquierda */
		}
		 
		nav ul {
		  list-style: none;
		  overflow: hidden; /* Limpiamos errores de float */
		}
		 
		nav ul li {
		  float: left;
		  font-family: Arial, sans-serif;
		  font-size: 16px;
		}
		 
		nav ul li a {
		  display: block; /* Convertimos los elementos a en elementos bloque para manipular el padding */
		  padding: 20px;
		  color: #fff;
		  text-decoration: none;
		}
		 
		nav ul li:hover {
		  background: #b5f2f2;
		}
  </style>
</head>
<body>
<header>
	<nav>
		<ul>
			<li><a href="pantallaPrincipal.html">Inicio</a></li>
			<li><a href="AlquilerGaraje.html">Alquilar un garaje</a></li>
			<li><a href="ofrecerGaraje.html">Ofrecer un garaje</a></li>
			<li><a href="infoEmpresa.html">Información de la empresa</a></li>
			<li><a href="contactoEmpresa.html">Contacto</a></li>
			<li><a href="perfil.html">Perfil</a></li>
		</ul>
	</nav>
</header>
	<div class="header1" >
        <div class="text-center">
      		<h1>Garage2Share</h1>
    	 </div>
    </div>  
 <div class="Text">  
    <div>
        <div>
              <h2 class="text-center">
              	Busca el garaje por la zona y el tipo de vehiculo que deseas
              </h2>
              <br></br>
        </div>
        <form>
  <div>
    <select name="lugar">
		<option value="leganes" SELECTED> Leganés 
		<option value="getafe" SELECTED> Getafe
		<option value="fuenlabrada" SELECTED> Fuenlabrada 
		<option value="centro" SELECTED>  Madrid centro
		<option value="villaverde" SELECTED> Villaverde
</select>
<select name="tipo">
		<option value="coche" SELECTED> Coche 
		<option value="furgoneta" SELECTED> Furgoneta
		<option value="moto" SELECTED> Moto 
		<option value="caravana" SELECTED>  Caravana
</select>
<p>
</p>
<button type ="submit">Buscar</button>
<br></br>
<p></p>

<table style="margin: 0 auto;" class = "table"  border = "1">
		<tr>
			<th class = "tableHead"> Identificador</th>
			<th class = "tableHead"> Zona</th>
			<th class = "tableHead"> Tipo de garaje</th>
			<th class = "tableHead"> Precio</th>
			<th class = "tableHead"> Elección</th>
		</tr>
      <c:forEach var="i" items="${Garaje}">
      <div class="radio">
        <tr>
         <td>${i.id}</td>
         <td>${i.place}</td> 
         <td>${i.vehicle}</td>
         <td>${i.price}</td> 
         <td>
           <div class="checkbox">
            <label style="font-size: 1.5em">
              <input type="checkbox" id="gar'+${i.id}'">
              <span class="cr"><i class="cr-icon glyphicon glyphicon-ok"></i></span>
            </label>
          </div>
        </td>

       </tr>
     </div>
   </c:forEach>
	</table>
	<br></br>
	<button id="selectGarage" >Continuar</button>
  </div>
</form>
            <p></p>
            <p></p>       
    </div>
  </div>
<div class="downText" >
    <div class="text-center">
        www.garage2share.com
    </div>
</div>			
</body>

<script type="text/javascript">
	
	var XMLHttpReq = new XMLHttpRequest();
	var garages;

	function getData(){
		if(XMLHttpReq){
			XMLHttpReq.open("GET","listaGarage.java");
			
			XMLHttpReq.onreadystatechange = function(){
				if(XMLHttpReq.readyState == 4 && XMLHttpReq.status == 200){
					var xmlDoc = XMLHttpReq.responseXML;
					garages = xmlDoc.getElementsByTagName("garages");
					listgarages();
				}
			}
		}
		
	}
	
	function listgarages(){
		
	}
</script>


</html>