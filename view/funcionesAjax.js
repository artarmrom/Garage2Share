function login(user, passwd){
	datos="user="+user+"&password="+passwd;

	$.ajax({
        type:"POST",
        url:"/session",
        data: datos		 ,
        success:function(r){
            if(r=="200"){
                document.location.href = "pantallaPrincipal.jsp";
            }else{
                alert("El usuario o la contraseña son incorrectas.\n Inténtalo de nuevo");
            }
        }
    });
	
}

function register(user, passwd,name,surname,mail,phone){
	datos="user="+user+"&password="+passwd+"&name="+name+"&surname="+surname+"&mail="+mail+"&phone="+phone;
	var xhr = new XMLHttpRequest();
	xhr.open('POST',"/register",true);
	console.log(xhr);
	xhr.send(datos);
	if(xhr.satus == 0){
		document.location.href = "index.html";
	}
	
}


function registrarGaraje(vehicle,place,direction,space,code,price,initialTime,endTime){
	datos="vehicle="+vehicle+"&place="+place+"&direction="+direction+"&space="+space+"&code="+code+"&price="+price+"&initialTime="+initialTime+"&endTime="+endTime;
	var xhr = new XMLHttpRequest();
	xhr.open('POST',"/registergarage",true);
	console.log(xhr);
	xhr.send(datos);
	if(xhr.satus == 0){
		document.location.href = "index.html";
	}
}