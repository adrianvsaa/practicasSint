function validar_datos() {
	if(document.formulario.cod[0].checked)
		document.formulario.encoding = 'application/x-www-form-urlencoded';
	else
	 	document.formulario.encoding = 'multipart/form-data';
	if (document.formulario.envio[1].checked)
				document.formulario.action = 'http://193.146.210.123/phpinfo.php';
	else
		document.formulario.action = 'p1.php';
	if(document.formulario.metodo[0].checked){
			document.formulario.method = 'get';
			document.formulario.encoding = 'application/x-www-form-urlencoded';
	}
	else
			document.formulario.method = 'post';
	if(!comprobarTelefono()){
		alert('Numero de telefono incorrecto');
		return false;
	}
	if(document.formulario.imagen.value.length>0&&document.formulario.encoding=='application/x-www-form-urlencoded'){
		alert('No se pueden enviar imagenes usando la codificacion x-www-form-urlencoded');
		return false;
	}

 	document.formulario.navegador.value = navigator.userAgent;
	var f = new Date();
	var hora = f.getHours()+":"+f.getMinutes()+":"+f.getSeconds();
	document.formulario.hora.value = hora;


}

function limpiar_formulario(){
	if(confirm("Desea limpiar el formulario"))
		return true;
	else {
		return false;
	}
}

function marcarTodos() {
	document.formulario.ingles.checked = true;
	document.formulario.vose.checked = true;
	document.formulario.castellano.checked = true;
	document.formulario.latino.checked = true;
}

function desmarcarTodos(){
	document.formulario.ingles.checked = false;
	document.formulario.vose.checked = false;
	document.formulario.castellano.checked = false;
	document.formulario.latino.checked = false;
}

function comprobar_metodo(){
	if (document.formulario.metodo[0].checked) {
		alert('No es posible escoger ese metodo de codificaci�n');
		document.formulario.cod[1].checked = false;
	}
		document.formulario.imagen.type = 'file';
}

function comprobar_cod(){
	if(document.formulario.cod[1].checked){
		alert('No es posible enviarlo con este metodo para esa codificacion');
		document.formulario.metodo[0].checked = false;
	}
}

function quitarImagen(){
	document.formulario.imagen.value = null;
}

function mostrarTelefono(){
	document.getElementById('formatoTelef').classList.add('visible');
	document.getElementById('formatoTelef').classList.remove('oculto');
}

function comprobarTelefono() {
	var aux = true;
	document.getElementById('formatoTelef').classList.add('oculto');
	document.getElementById('formatoTelef').classList.remove('visible');
	var telef = document.formulario.telefono.value;
	if(telef.length==9){
		for (var i = 0; i < telef.length; i++) {
			if(telef.charAt(i)<'0'||telef.charAt(i)>'9'){
				aux = false;
				break;
			}

		}
	}
	else if (telef.length==0) {	}
	else {
		aux = false;
	}
	if(!aux)
		document.formulario.telefono.classList.add('error');
	else
		document.formulario.telefono.classList.remove('error');
	return aux;
}

function mostrarFormatoFichero(){
	document.getElementById('formatoFichero').classList.add('visible');
	document.getElementById('formatoFichero').classList.remove('oculto');
}

function ocultarFormatoFichero(){
	document.getElementById('formatoFichero').classList.add('oculto');
	document.getElementById('formatoFichero').classList.remove('visible');
}

function comprobarImagen(f){
	document.getElementById('formatoFichero').classList.add('oculto');
	document.getElementById('formatoFichero').classList.remove('visible');
	var ext=['jpg','jpeg','png'];
	var v=f.value.split('.').pop().toLowerCase();
	for(var i=0,n;n=ext[i];i++){
		if(n.toLowerCase()==v)
			return
	}
	alert('formato de imagen no válido');
	document.getElementById('imagen').value = null;
	return false;

}
