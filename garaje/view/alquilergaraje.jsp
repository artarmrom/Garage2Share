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
	<link href="style/bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css" />
	<link href="style/alertifyjs/css/alertify.css" rel="stylesheet" type="text/css" />
	<link href="style/alertifyjs/css/themes/default.css" rel="stylesheet" type="text/css" />
	<link href="style/checkbox.css" rel="stylesheet" type="text/css" />
	<link href="lstyle/loading.css" rel="stylesheet" type="text/css" />
	<script src="style/jquery-3.3.1.min.js"></script>
	<script src="style/bootstrap/js/bootstrap.js"></script>
	<script src="style/alertifyjs/alertify.js"></script>
	<script src="funcionesAjax.js"></script>
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
			border:1px solid-black;
			border-collapse: collapse;
			width: 70%;
		}
		.tableHead{
			color:black;
			background-color: #b5f2f2;
			height: 50px;
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
		nav ul li .b {
		  display: block; /* Convertimos los elementos a en elementos bloque para manipular el padding */
		  padding: 20px;
		  background: black;
		  border: none;
		  color: #fff;
		  text-decoration: none;
		  font-family: Arial, sans-serif;
		  font-size: 16px;
		}
		nav ul li .b:hover {
		  background: #b5f2f2;
		}
		.boton {
		text-decoration:none;
		font-weight:600;
		font-size:20px;
		color:black;
		padding-top:15px;
		padding-bottom:15px;
		padding-left:15px;
		padding-right:15px;
		background-color:#b5f2f2;
		border: none;		
		font-family: Arial, sans-serif;
		font-size: 16px;
		}
		select {
     background: b5f2f2;
     border: none;
     font-size: 14px;
     height: 30px;
     padding: 5px;
     width: 250px;
  }
  
  		h1,h2{
		  font-size:40px;
		  color:#0B618A;
		  }
		  
		        label, input{
		  color: #0B618A;
		  font-weight:bold;
		  text-align:center;
	  }
  
  </style>
</head>
<body>
<header>
	<nav>
		<ul>
			<li><a href="pantallaPrincipal.jsp">Inicio</a></li>
			<li><form action="/garaje/vergarajes" method = "get"><button class = "b" type="submit" id = "ver">Ver garajes</button></form></li>			
			<li><a href="view/ofrecerGaraje.jsp">Ofrecer un garaje</a></li>
			<li><a href="/view/infoEmpresa.jsp">Información de la empresa</a></li>
			<li><a href="/view/contactoEmpresa.jsp">Contacto</a></li>
			<li><form action="/garaje/perfil" method = "get"><button class = "b"  type="submit" id = "perfil">Perfil</button></form></li>			
			<li><form action="/garaje/logout" method = "post"><button class = "b"  type="submit" id = "cerrarsesion">Cerrar Sesión</button></form></li>	
		</ul>
	</nav>
</header>
	<div class="header1" >
        <div class="text-center">
      		<h1><strong>Garage2Share</strong></h1>
    	 </div>
    </div>  
 <div class="Text">  
    <div>
        <div>
              <h2 class="text-center"><strong>
              	Busca el garaje por la zona y el tipo de vehiculo que deseas
              </strong></h2>
              <br></br>
        </div>
        <form action="/garaje/listagarage" method = "get">
  <div>
  	  </br><label style="font-size:17px">Ciudad</label></br>
    <select id="lugar">
		<option value="leganes" SELECTED> Leganés 
		<option value="getafe" > Getafe
		<option value="fuenlabrada" > Fuenlabrada 
		<option value="centro" >  Madrid centro
		<option value="villaverde" > Villaverde
</select>
	</br><label style="font-size:17px">Tipo de Vehiculo</label></br>
<select id="tipo">
		<option value="coche" SELECTED> Coche 
		<option value="furgoneta" > Furgoneta
		<option value="moto" > Moto 
		<option value="caravana">  Caravana
</select>

		</br><label style="font-size:17px">Horario libre</label></br>
		<label>Inicio</label></br>
<select id="diainicial">
		<option value="10" SELECTED> 10/05
		<option value="11" > 11/05
		<option value="12" > 12/05
		<option value="13" > 13/05
		<option value="14" > 14/05 
		<option value="15" > 15/05
</select>
<select id="horainicial">
		<option value="9" SELECTED> 09:00
		<option value="10" > 10:00
		<option value="11" > 11:00 
		<option value="12" > 12:00
		<option value="13" > 13:00
		<option value="14" > 14:00 
		<option value="15" > 15:00
		<option value="16" > 16:00
		<option value="17" > 17:00 
		<option value="18" > 18:00
		<option value="19" > 19:00
		<option value="20" > 20:00 
		<option value="21" > 21:00
</select></br>
		<label>Fin</label></br>
<select id="diafinal">
		<option value="10" SELECTED> 10/05
		<option value="11" > 11/05
		<option value="12" > 12/05
		<option value="13" > 13/05
		<option value="14" > 14/05 
		<option value="15" > 15/05
</select>
<select id="horafinal">
		<option value="9" > 09:00
		<option value="10" SELECTED> 10:00
		<option value="11" > 11:00 
		<option value="12" > 12:00
		<option value="13" > 13:00
		<option value="14" > 14:00 
		<option value="15" > 15:00
		<option value="16" > 16:00
		<option value="17" > 17:00 
		<option value="18" > 18:00
		<option value="19" > 19:00
		<option value="20" > 20:00 
		<option value="21" > 21:00
</select>
<p>
</p>
	<button class="btn btn-info">
        <span  class="glyphicon glyphicon-search"></span> Buscar
    </button>
<br></br>
<p></p>
</div>
</form>
<form action="/garaje/masgaraje" method="post">
<div>
	<table style="margin: 0 auto;" class = "table table-hover table-condensed table-bordered table-striped"  border = "1">
		<tr>
			<th class = "tableHead"> Identificador</th>
			<th class = "tableHead"> Hora inicio</th>
			<th class = "tableHead"> Hora fin</th>
			<th class = "tableHead"> Lugar</th>
			<th class = "tableHead"> Dirección</th>
			<th class = "tableHead"> Tipo de garaje</th>
			<th class = "tableHead"> Precio</th>
			<th class = "tableHead"> Elección</th>
		</tr>
		<c:forEach var="g" items="${garages}">
    <tr>
    	<td>
            <c:out id = "uid" value="${g.id}"></c:out> 
        </td>
        <td>
            <c:out id = "initialtime" value="${g.initialTime}"></c:out> 
        </td>
        <td>
            <c:out id = "endtime" value="${g.endTime}"></c:out> 
        </td>
        <td>
            <c:out id ="place" value="${g.place}"></c:out> 
        </td>
        <td>
            <c:out id="direction"value="${g.direction}"></c:out> 
        </td>
        <td>
            <c:out id="vehicle" value="${g.vehicle}"></c:out> 
        </td>
        <td>
            <c:out id="price" value="${g.price}"></c:out> 
        </td>
        <td>
            <input value="${g.id}" type="radio" id="elec" name="elec">
        </td>
    </tr>
   </c:forEach>
</table>
	<br></br>
	<button class="btn btn-info">
        <span  class="glyphicon glyphicon-send"></span> Continuar
    </button>
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
</html>
