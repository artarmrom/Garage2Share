<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix ="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
        padding: 80px;
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
              <h1 class="text-center"><strong>
              	Bienvenido a tu perfil!
              </strong></h2>
        </div>
	<div id="collapseTotal">
	<div class="col-sm-12" align="center">
		
			 <button class = "btn btn-primary" type="submit" data-toggle="collapse" data-target="#collapseP" data-parent="#collapseTotal" aria-expanded="false" aria-controls="collapseP" id = "miPerfil">
				 <span  class="glyphicon glyphicon-triangle-bottom" id="iconPerfil"></span>Mi perfil</button>
			 <button class = "btn btn-primary" type="submit" data-toggle="collapse" data-target="#collapseB" data-parent="#collapseTotal" aria-expanded="false" aria-controls="collapseB" id = "miGaraje">
				 <span  class="glyphicon glyphicon-triangle-bottom" id="iconGaraje"></span>Mis garajes</button>
			 <button class = "btn btn-primary" type="submit" data-toggle="collapse" data-target="#collapseC" data-parent="#collapseTotal" aria-expanded="false" aria-controls="collapseC" id = "miHistorial">
				 <span  class="glyphicon glyphicon-triangle-bottom" id="iconHistorial"></span>Historial de Contratos</button>
		
		<div class="collapse" id="collapseB">
		          	
         <form  style="float: left" action="/garaje/vermisgarajes" method = "get"><button class = "btn btn-secondary" type="submit" data-toggle="collapse" data-target="#collapseG" data-parent="#collapseTotal" aria-expanded="false" aria-controls="collapseG" id = "verGTodos">
			 <span  class="glyphicon glyphicon-triangle-bottom" id="iconGTodos"></span>Ver Todos</button></form>
         <form  style="float: left" action="/garaje/vermisgarajeslibres" method = "get"><button class = "btn btn-secondary" type="submit" data-toggle="collapse" data-target="#collapseG" data-parent="#collapseTotal" aria-expanded="false" aria-controls="collapseG" id = "verGLibres">
			 <span  class="glyphicon glyphicon-triangle-bottom" id="iconGLibres"></span>Ver Libres</button></form>
         <form  style="float: left" action="/garaje/vermisgarajesocupados" method = "get"><button class = "btn btn-secondary" type="submit" data-toggle="collapse" data-target="#collapseG" data-parent="#collapseTotal" aria-expanded="false" aria-controls="collapseG" id = "verGOcupados">
			 <span  class="glyphicon glyphicon-triangle-bottom" id="iconGOcupados"></span>Ver Ocupados</button></form>

		</div>
        <div class="collapse" id="collapseP">
		<div class="well">
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
    </div>
		<div class="collapse" id="collapseG">
		<div class="well">
    <form>
		
    	<table style="margin: 0 auto;" class = "table table-hover table-condensed table-bordered table-striped"  border = "1">
		<tr>
			<th class = "tableHead"> Identificador</th>
			<th class = "tableHead"> Fecha inicio</th>
			<th class = "tableHead"> Hora inicio</th>
			<th class = "tableHead"> Fecha fin</th>
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
            <c:out value="${g.initialHour}"></c:out> 
        </td>
        <td>
            <c:out value="${g.endTime}"></c:out> 
        </td>
        <td>
            <c:out value="${g.endHour}"></c:out> 
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
    </form>
   </div>
    </div>
	<div class="collapse" id="collapseC">
	<div class="well">
    <form action="/garaje/vercontrato" method="get">
    	<table style="margin: 0 auto;" class="table table-hover table-condensed table-bordered table-striped"  border = "1">
		<tr>
			<th class = "tableHead"> Identificador</th>
			<th class = "tableHead"> Horas totales</th>
			<th class = "tableHead"> Fecha inicio</th>
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
            <c:out value="${g.hours}"></c:out> 
        </td>
        <td>
            <c:out value="${g.initialTime}"></c:out> 
        </td>
        <td>
            <c:out value="${g.initialHour}"></c:out> 
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
    </form>
    </div>
    </div>
  </div>
  </div>
  </div>
<div class="downText" >
    <div class="text-center">
        www.garage2share.com
    </div>
</div>			
</body>
<script text="">

$(document).ready(function() {
    $('#miPerfil').click(function(){
    if($("#miGaraje").hasClass("btn btn-link")){
        $("#miGaraje").attr("class","btn btn-primary");
    }
    if($("#iconGaraje").hasClass("glyphicon glyphicon-triangle-top")){
        $("#iconGaraje").attr("class","glyphicon glyphicon-triangle-bottom");
    }
    if($("#miHistorial").hasClass("btn btn-link")){
        $("#miHistorial").attr("class","btn btn-primary");
    }
    if($("#iconHistorial").hasClass("glyphicon glyphicon-triangle-top")){
        $("#iconHistorial").attr("class","glyphicon glyphicon-triangle-bottom");
    }
        $('#collapseC').collapse('hide');
        $('#collapseB').collapse('hide');
        modColor('#miPerfil','#iconPerfil');
    });
    
    $('#miGaraje').click(function(){
    if($("#miPerfil").hasClass("btn btn-link")){
        $("#miPerfil").attr("class","btn btn-primary");
    }
    if($("#iconPerfil").hasClass("glyphicon glyphicon-triangle-top")){
        $("#iconPerfil").attr("class","glyphicon glyphicon-triangle-bottom");
    }
    if($("#miHistorial").hasClass("btn btn-link")){
        $("#miHistorial").attr("class","btn btn-primary");
    }
    if($("#iconHistorial").hasClass("glyphicon glyphicon-triangle-top")){
        $("#iconHistorial").attr("class","glyphicon glyphicon-triangle-bottom");
    }
        $('#collapseP').collapse('hide');
        $('#collapseC').collapse('hide');
        modColor('#miGaraje','#iconGaraje');
    });
    
    $('#miHistorial').click(function(){
    if($("#miPerfil").hasClass("btn btn-link")){
        $("#miPerfil").attr("class","btn btn-primary");
    }
    if($("#iconPerfil").hasClass("glyphicon glyphicon-triangle-top")){
        $("#iconPerfil").attr("class","glyphicon glyphicon-triangle-bottom");
    }
    if($("#miGaraje").hasClass("btn btn-link")){
        $("#miGaraje").attr("class","btn btn-primary");
    }
    if($("#iconGaraje").hasClass("glyphicon glyphicon-triangle-top")){
        $("#iconGaraje").attr("class","glyphicon glyphicon-triangle-bottom");
    }
        $('#collapseP').collapse('hide');
        $('#collapseB').collapse('hide');
        modColor('#miHistorial','#iconHistorial');
    });



    $('#verGTodos').click(function(){
    if($("#verGLibres").hasClass("btn btn-link")){
        $("#verGLibres").attr("class","btn btn-primary");
    }
    if($("#iconGLibres").hasClass("glyphicon glyphicon-triangle-top")){
        $("#iconGLibres").attr("class","glyphicon glyphicon-triangle-bottom");
    }
    if($("#verGOcupados").hasClass("btn btn-link")){
        $("#verGOcupados").attr("class","btn btn-primary");
    }
    if($("#iconGOcupados").hasClass("glyphicon glyphicon-triangle-top")){
        $("#iconGOcupados").attr("class","glyphicon glyphicon-triangle-bottom");
    }

        modColor('#verGTodos','#iconGTodos');
    });
    
    $('#verGLibres').click(function(){
    if($("#verGTodos").hasClass("btn btn-link")){
        $("#verGTodos").attr("class","btn btn-primary");
    }
    if($("#iconGTodos").hasClass("glyphicon glyphicon-triangle-top")){
        $("#iconGTodos").attr("class","glyphicon glyphicon-triangle-bottom");
    }
    if($("#verGOcupados").hasClass("btn btn-link")){
        $("#verGOcupados").attr("class","btn btn-primary");
    }
    if($("#iconGOcupados").hasClass("glyphicon glyphicon-triangle-top")){
        $("#iconGOcupados").attr("class","glyphicon glyphicon-triangle-bottom");
    }

        modColor('#verGLibres','#iconGLibres');
    });
    
    $('#verGOcupados').click(function(){
    if($("#verGTodos").hasClass("btn btn-link")){
        $("#verGTodos").attr("class","btn btn-primary");
    }
    if($("#iconGTodos").hasClass("glyphicon glyphicon-triangle-top")){
        $("#iconGTodos").attr("class","glyphicon glyphicon-triangle-bottom");
    }
    if($("#verGLibres").hasClass("btn btn-link")){
        $("#verGLibres").attr("class","btn btn-primary");
    }
    if($("#iconGLibres").hasClass("glyphicon glyphicon-triangle-top")){
        $("#iconGLibres").attr("class","glyphicon glyphicon-triangle-bottom");
    }
    
        modColor('#verGOcupados','#iconGOcupados');
    });
    
    
    
});    
</script>
</html>
