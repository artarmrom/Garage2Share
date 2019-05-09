function login(user, passwd){
	dato="user="+user+"&password="+passwd;

	$.ajax({
        type:"POST",
        url:"/garaje/login",
        data: dato		 ,
        success:function(r){
            if(r=="200"){
                document.location.href = "/garaje/view/pantallaPrincipal.jsp";
                alertify.success("Bienvenido");
            }else{
                alertify.error("El usuario o la contraseña son incorrectas.\nInténtalo de nuevo");
            }
        }
    });
	
}

function register(user, passwd,name,surname,mail,phone){
	datos="user="+user+"&password="+passwd+"&name="+name+"&surname="+surname+"&mail="+mail+"&phone="+phone;

	$.ajax({
        type:"POST",
        url:"/garaje/register",
        data: datos		 ,
        success:function(r){
            if(r=="200"){
                document.location.href = "/garaje";
            }else if(r=="name"){
                alertify.error("El usuario introducido ya existe");
            }else if(r=="mail"){
                alertify.error("El correo introducido ya existe");
            }else {
                alertify.error("Error en el sistema");
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
                alertify.success("Garaje registrado satisfactoriamente");
            }else if(r=="garage"){
                alertify.error("El garaje introducido ya existe");
            }else{
                alertify.error("Los datos son incorrectos.\nInténtalo de nuevo");
            }
        }
    });
}

function modColor(id,icon){
    if($(id).hasClass("btn btn-link")){
        $(id).attr("class","btn btn-primary");
    }
    else{
        $(id).attr("class","btn btn-link");
    }
    if($(icon).hasClass("glyphicon glyphicon-triangle-bottom")){
        $(icon).attr("class","glyphicon glyphicon-triangle-top");
    }
    else{
        $(icon).attr("class","glyphicon glyphicon-triangle-bottom");
    }
}
