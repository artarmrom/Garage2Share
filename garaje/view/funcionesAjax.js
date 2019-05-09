function login(user, passwd){
	dato="user="+user+"&password="+passwd;

	$.ajax({
        type:"POST",
        url:"/garaje/login",
        data: dato		 ,
        success:function(r){
            if(r=="200"){
                document.location.href = "/garaje/view/pantallaPrincipal.jsp";
                alert("Bienvenido");
            }else{
                alert("El usuario o la contraseña son incorrectas.\nInténtalo de nuevo");
            }
        }
    });
	
}

function register(user, passwd,name,surname,mail,phone){
	datos="user="+user+"&password="+passwd+"&name="+name+"&surname="+surname+"&mail="+mail+"&phone="+phone;
	console.log(datos);
	$.ajax({
        type:"POST",
        url:"/garaje/register",
        data: datos		 ,
        success:function(r){
            if(r=="200"){
                document.location.href = "/garaje";
            }else if(r=="name"){
                alert("El usuario introducido ya existe");
            }else if(r=="mail"){
                alert("El correo introducido ya existe");
            }else {
                alert("Error en el sistema");
            }
        }
    });
	
}


function registrarGaraje(vehicle,place,direction,space,code,price,initialTime,endTime){
	datos="vehicle="+vehicle+"&place="+place+"&direction="+direction+"&space="+space+"&code="+code+"&price="+price+"&initialTime="+initialTime+"&endTime="+endTime;
	$.ajax({
        type:"POST",
        url:"/garaje/registergarage",
        data: datos,
        success:function(r){
            if(r=="200"){
                document.location.href = "/garaje/view/ofrecerGaraje.jsp";
                alert("Garaje registrado satisfactoriamente");
            }else if(r=="garage"){
                alert("El garaje introducido ya existe");
            }else{
                alert("Los datos son incorrectos.\nInténtalo de nuevo");
            }
        }
    });
}
