<!DOCTYPE html>
<%@page import="edu.ucam.acciones.CrudValoracion"%>
<%@page import="edu.ucam.objetos.Videojuegos"%>
<%@page import="edu.ucam.acciones.CrudVideojuego"%>
<%@page import="javax.ws.rs.core.Context"%>
<%@page import="edu.ucam.acciones.CrudCategoria"%>
<%@page import="edu.ucam.objetos.Categoria"%>
<%@page import="java.util.Hashtable"%>

<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Probar API REST</title>
<script type="text/javascript" src="js/jquery-1.12.4.min.js"></script>
	
	<script type="text/javascript">
	
		function load(nombre,valoracion){
        
			var entry = document.createElement('li');
			
			var a = document.createElement('a');
			
			var linkText = document.createTextNode(" [Borrar]");
			
			a.appendChild(linkText);
			
			a.onclick = function () {
				$.ajax({
				    url: 'rest/valoracion/' + nombre +'/',
				    type: 'DELETE',
				    dataType: "json",
				    success: function(result) {
				    	document.getElementById(nombre).remove();
				    },
			    	error: function(jqXhr, textStatus, errorMessage){
				    	alert('error');	
				    }
				});
			};
	
			entry.id = nombre;
            			
			entry.appendChild(document.createTextNode("("+ nombre + ") " + valoracion));
			
			entry.appendChild(a);
			
			$('#listadoValoraciones').append(entry);
			
		}
	
		$(document).ready(function(){
        
			$("#sendButtonValoracion").click(function(){
            
				var sendInfo = {nombre: $('#nombre').val(),valoracion: $('#valoracion').val()};        
				
			    $.ajax({
					    url: 'rest/valoracion',
					    headers: { 
				               'Accept': 'application/json',
				               'Content-Type': 'application/json' 
				           },
					    type: 'POST',
					    dataType: "json", 
					    success: function(result) {
					    	load(result.nombre, result.valoracion);
					    },
				    	error: function(jqXhr, textStatus, errorMessage){
					    	alert('Error: ' + jqXhr.responseJSON.resultado);	
					    },
					    data:  JSON.stringify(sendInfo)
					    
					});
			    });
		
			$.ajax({
			    url: 'rest/valoracion',
			    type: 'GET',
			    dataType: "json",
			    success: function(result) {
			    	jQuery.each(result.valoraciones, function(i, val) {
			    		  load(val.nombre, val.valoracion);
			    		});
			    }
			});
			
			
			
		});
</script>
	
	
</head>
<body>

	<center><b>Ejemplo API Rest</b></center>
<br>

	Formulario para insertar<br>
	Valoracion:<input type=text id="valoracion"><br>	
  <select name="nombre" id="nombre">
    <option>Escoge un videojuego</option>
    <% 
    System.out.println("Primero se intenta rellenar el comboBox");
    Hashtable<String,Videojuegos> contenedorVideojuegos = CrudValoracion.getVideojuegoValoracion();
       for(Videojuegos v: contenedorVideojuegos.values()){
     %>
     <option value="<%=v.getNombre()%>"><%=v.getNombre()%></option>
     <%
     } 
     %>
</select>
	<button id="sendButtonValoracion">Crear</button>
	<br>
	<br>
	Listado de valoraciones creados
	<br>
	<ul id="listadoValoraciones"></ul>





</body>
</html>
	
	