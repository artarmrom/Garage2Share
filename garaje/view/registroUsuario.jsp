<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <title>Garage2Share</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
	<link href='https://fonts.googleapis.com/css?family=Open+Sans:400,300,700' rel='stylesheet' type='text/css'>
	<script src="funcionesAjax.js"></script>
		<link href='https://fonts.googleapis.com/css?family=Open+Sans:400,300,700' rel='stylesheet' type='text/css'>
	<link href="style/bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css" />
	<link href="style/alertifyjs/css/alertify.css" rel="stylesheet" type="text/css" />
	<link href="style/alertifyjs/css/themes/default.css" rel="stylesheet" type="text/css" />
	<link href="style/checkbox.css" rel="stylesheet" type="text/css" />
	<link href="lstyle/loading.css" rel="stylesheet" type="text/css" />
	<script src="style/jquery-3.3.1.min.js"></script>
	<script src="style/bootstrap/js/bootstrap.js"></script>
	<script src="style/alertifyjs/alertify.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>	
  <style>
      .header1 
      {
      	font-size:150%;
        color: #0B618A;
        padding: 10px;
        text-align: center;
  		position: relative;
      }
      .Text 
      { 
     	padding: 8px;
     	margin: 10px;
     	margin-left: 100px;
        text-align: center;
  		position: relative;
      }
      .downText 
      {
      	color: #0B618A;
      	text-align: center;
  		position: relative;
      }
      .back
      {
      	 background-size:100% 100%;
      	 background-opacity:0.4;
      }
      h1,h2{
		  font-size:40px;
		  color:white;
		  -webkit-text-stroke-width:2px;
		  -webkit-text-stroke-color: #0B618A;
		  }
      label, input{
		  color: #0B618A;
		  font-weight:bold;
		  text-align:center;
	  }
  </style>

</head>
<body background= garajePortada.jpg class="back">
	<div class="header1" >
        <div class="text-center">
      		<h1><strong>Garage2Share</strong></h1>
    	 </div>
    </div>  
 <div class="Text">  
    <div>
        <div>
              <h2 class="text-center"><strong>
              	Indícanos los siguientes datos para proceder con el registro
              </strong></h2>
        </div>
        <br/>
        <br/>
        <br/>
        <br/>
        <br/>
        <br/>
        <br/>
        <br/>
        <div>
            <div>
				<label for="email">Usuario</label>
                <input type="text" class="form-control"  id="nuevoUsuario" name="nuevoUsuario">
			</div>
            <br>
            <div>
                <label for="contraseña">Contraseña</label>
                <input type="password" class="form-control" id="contraseña"  name="contraseña">
            </div>
            <br>
            <div>
			    <label >Nombre</label>
			    <input type="text" class="form-control"  id="nombre" name="nombre">
			</div>
			<br>
			<div>
			    <label >Apellido</label>
			    <input type="text" class="form-control"  id="apellido" name="apellido">
			</div>
			<br>
			<div>
			    <label >Mail</label>
			    <input type="text" class="form-control"  id="mail" name="mail">
			</div>
			<br>
			<div>
			    <label >Telefono</label>
			    <input type="text" class="form-control"  id="telefono" name="telefono">
			</div>
         	<br>
		<button class="btn btn-info" id="registro">
			<span  class="glyphicon glyphicon-user"></span> Registrar Usuario</button>
            <p></p>
            <p></p>       
        </div>
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
        $('#registro').click(function(){
			var nuevoUsuario = document.getElementById("nuevoUsuario");
			var contraseña = document.getElementById("contraseña");
			var nombre = document.getElementById("nombre");
			var apellido = document.getElementById("apellido");
			var mail = document.getElementById("mail");
			var telefono = document.getElementById("telefono");
			var fallo = 0;
			
			if((nuevoUsuario.value == null || nuevoUsuario.value=="")){
				nuevoUsuario.style.backgroundColor = '#ff0000';
				fallo = 1;
			}
			if((contraseña.value == null || contraseña.value=="")){
				contraseña.style.backgroundColor = '#ff0000';
				fallo = 1;
			}
			if((nombre.value == null || nombre.value=="")){
				nombre.style.backgroundColor = '#ff0000';
				fallo = 1;
			}
			if((apellido.value == null || apellido.value=="")){
				apellido.style.backgroundColor = '#ff0000';
				fallo = 1;
			}
			if((mail.value == null || mail.value=="")){
				mail.style.backgroundColor = '#ff0000';
				fallo = 1;
			}
			if((telefono.value == null || telefono.value=="")){
				telefono.style.backgroundColor = '#ff0000';
				fallo = 1;
			}else if(isNaN(telefono.value))
			{			
				alert("EL campo telefono debe ser un numero!");
				telefono.style.backgroundColor = '#ff0000';
				fallo = 1;		
			}
			if(fallo == 0){			
				register(nuevoUsuario.value,contraseña.value,nombre.value,apellido.value,mail.value,telefono.value);
			}else
				{
					alert("Es necesario rellenar todos los campos.");
					telefono.style.backgroundColor = '#ffffff';
					mail.style.backgroundColor = '#ffffff';
					apellido.style.backgroundColor = '#ffffff';
					nombre.style.backgroundColor = '#ffffff';
					contraseña.style.backgroundColor = '#ffffff';
					nuevoUsuario.style.backgroundColor = '#ffffff';
				}
		
        });
    });

</script>
</html>
