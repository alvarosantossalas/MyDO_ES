/**
 * 
 */

function cargarArchivo(elemento) {
	
	var file = elemento.files[0];
	var objHidden = document.formulario.nombre;
	
	objHidden.value = file.name;
	
	// Redirigir la página al iframe una vez que el formulario sea procesado
	document.formulario.target = "null";
	
	document.formulario.action = "../../ProcesoArchivo";
	document.formulario.submit();
	
	alert("Proceso terminado");
	
}