<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
              	Rellena los datos de tu garaje
              </h2>
        </div>
            <p></p>
            <p></p> 
<form>
  <div>
    <select id="lugar" name="lugar" >
		<option value="leganes" SELECTED > Leganés 
		<option value="getafe" SELECTED> Getafe
		<option value="fuenlabrada" SELECTED> Fuenlabrada 
		<option value="centro" SELECTED>  Madrid centro
		<option value="villaverde" SELECTED> Villaverde
</select>
<p></p>
<select id="tipo" name="tipo">
		<option value="coche" SELECTED> Coche 
		<option value="furgoneta" SELECTED> Furgoneta
		<option value="moto" SELECTED> Moto 
		<option value="caravana" SELECTED>  Caravana
</select>
<p>
</p>
<div>
        <label >Dirección:</label>
        <input type="text" class="form-control"  id="direccion" name="direccion">
</div>
<div>
        <label >Numero plaza:</label>
        <input type="text" class="form-control"  id="plaza" name="plaza">
</div>
<div>
        <label >Codigo puerta:</label>
        <input type="text" class="form-control"  id="codigo" name="codigo">
</div>
<div>
        <label >Precio:</label>
        <input type="text" class="form-control"  id="precio" name="precio">
</div>
<div>
        <label >Horario libre inicial:</label>
        <input type="text" class="form-control"  id="horainicial" name="horainicial">
</div>
<div>
        <label >Horario libre final:</label>
        <input type="text" class="form-control"  id="horafinal" name="horafinal">
</div>
    <button type="submit"  id="agregar" name="agregar" >Agregar</button>
  </div>
</form>      
    </div>
  </div>
<div class="downText" >
    <div class="text-center">
        www.garage2share.com
    </div>
</div>			
</body>
  <script type="text/javascript">
  
  	$(document).ready(function(){
        $('#agregar').click(function(){
			var tipo = document.getElementById("tipo");
			var lugar = document.getElementById("lugar");
			var direccion = document.getElementById("calle");
			var plaza = document.getElementById("plaza");
			var codigo = document.getElementById("codigo");
			var precio = document.getElementById("precio");
			var horainicial = document.getElementById("horainicial");
			var horafinal = document.getElementById("horafinal");
			var fallo = 0;
			
			//	COMPROBAR TIPO Y LUGAR
			
			
			if((direccion.value == null || direccion.value=="")){
				direccion.style.backgroundColor = '#ff0000';
				fallo = 1;
			}
			if((plaza.value == null || plaza.value=="")){
				plaza.style.backgroundColor = '#ff0000';
				fallo = 1;
			}else if(isNaN(plaza.value)){			
				alert("EL campo plaza debe ser un numero!");
				plaza.style.backgroundColor = '#ff0000';
				fallo = 1;		
			}
			if((codigo.value == null || codigo.value=="")){
				codigo.style.backgroundColor = '#ff0000';
				fallo = 1;
			}
			if((precio.value == null || precio.value=="")){
				precio.style.backgroundColor = '#ff0000';
				fallo = 1;
			}else if(isNaN(precio.value)){			
				alert("EL campo precio debe ser un numero!");
				precio.style.backgroundColor = '#ff0000';
				fallo = 1;		
			}
			if((horainicial.value == null || horainicial.value=="")){
				horainicial.style.backgroundColor = '#ff0000';
				fallo = 1;
			}
			if((horafinal.value == null || horafinal.value=="")){
				horafinal.style.backgroundColor = '#ff0000';
				fallo = 1;
			}
			if(fallo == 0){			
				registrarGaraje(tipo,lugar,direccion,plaza,codigo,precio,horainicial,horafinal);
			}
		
        });
    });

</script>
</html>