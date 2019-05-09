<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
		align:center;
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
      		<h1>Garage2Share</h1>
    	 </div>
    </div>  
 <div class="Text">  
    <div>
        <div>
              <h2 class="text-center">
              	Bienvenido a tu perfil!
              </h2>
        </div>
        <br></br>
    <p></p> 
        <div >            	
         <form  style="float: left;padding-left:33%" action="/garaje/vermisgarajes" method = "get"><button class = "boton" type="submit" id = "verG">Ver Todos</button></form>
         <form  style="float: left" action="/garaje/vermisgarajeslibres" method = "get"><button class = "boton" type="submit" id = "verG">Ver Libres</button></form>
         <form  style="float: left" action="/garaje/vermisgarajesocupados" method = "get"><button class = "boton" type="submit" id = "verG">Ver Ocupados</button></form>
    </div>
    <br></br>
    <p></p>
     <p></p>
    <div><h3>Mi perfil</h3></div> 
    <br></br>
    <p></p>     
        <div>
        Usuario:<%=request.getParameter("user")%>
        	<p></p>
        Nombre:<%=request.getParameter("name") %>
        <p></p>
        Apellido:<%=request.getParameter("surname") %>
        <p></p>
        Telefono:<%=request.getParameter("phone") %>
        <p></p>
        Mail:<%=request.getParameter("mail") %>
        <p></p>            
         </div>                       
    </div>
    <h3>Mis garajes</h3>
    <p></p>
    
    <br></br>
    <p></p>
    <form>
    <div>
    	<table style="margin: 0 auto;" class = "table"  border = "1">
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
            <c:out value="${g.id}"></c:out> 
        </td>
        <td>
            <c:out value="${g.initialTime}"></c:out> 
        </td>
        <td>
            <c:out value="${g.endTime}"></c:out> 
        </td>
        <td>
            <c:out value="${g.place}"></c:out> 
        </td>
        <td>
            <c:out value="${g.direction}"></c:out> 
        </td>
        <td>
            <c:out value="${g.vehicle}"></c:out> 
        </td>
        <td>
            <c:out value="${g.price}"></c:out> 
        </td>
        <td>
            <input type="radio" id="elec" name="elec">
        </td>
    </tr>
   </c:forEach>
   </table>
    </div>
    </form>
    <h3>Mis contratos</h3>
    <p></p>
    <form action="/garaje/vercontrato" method="get">
    <div>
    	<table style="margin: 0 auto;" class = "table"  border = "1">
		<tr>
			<th class = "tableHead"> Identificador</th>
			<th class = "tableHead"> Horas totales</th>
			<th class = "tableHead"> Hora inicio</th>
			<th class = "tableHead"> Tipo de vehiculo</th>
			<th class = "tableHead"> Estado</th>
			<th class = "tableHead"> Propietario</th>
			<th class = "tableHead"> Cliente</th>
			<th class = "tableHead"> Elección</th>
		</tr>
		<c:forEach var="g" items="${garages}">
    <tr>
    	<td>
            <c:out value="${g.id}"></c:out> 
        </td>
        <td>
            <c:out value="${g.initialTime}"></c:out> 
        </td>
        <td>
            <c:out value="${g.endTime}"></c:out> 
        </td>
        <td>
            <c:out value="${g.place}"></c:out> 
        </td>
        <td>
            <c:out value="${g.direction}"></c:out> 
        </td>
        <td>
            <c:out value="${g.vehicle}"></c:out> 
        </td>
        <td>
            <c:out value="${g.price}"></c:out> 
        </td>
        <td>
            <input type="radio" id="elec" name="elec">
        </td>
    </tr>
   </c:forEach>
   </table>
    </div>
    </form>
  </div>
<div class="downText" >
    <div class="text-center">
        www.garage2share.com
    </div>
</div>			
</body>
</html>
