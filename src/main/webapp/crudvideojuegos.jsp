<!DOCTYPE html>
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
	
		function load(nombreVideojuego,categoria){
        
			var entry = document.createElement('li');
			
			var a = document.createElement('a');
			
			var linkText = document.createTextNode(" [Borrar]");
			
			a.appendChild(linkText);
			
			a.onclick = function () {
				$.ajax({
				    url: 'rest/videojuego/' + nombreVideojuego +'/',
				    type: 'DELETE',
				    dataType: "json",
				    success: function(result) {
				    	document.getElementById(nombreVideojuego).remove();
				    },
			    	error: function(jqXhr, textStatus, errorMessage){
				    	alert('error');	
				    }
				});
			};
	
			entry.id = nombreVideojuego;
            			
			entry.appendChild(document.createTextNode(nombreVideojuego+" "+categoria));
			
			entry.appendChild(a);
			
			$('#listadoVideojuego').append(entry);
			
		}
	
		$(document).ready(function(){
        
			$("#sendButtonVideojuego").click(function(){
            
				var sendInfo = {nombreVideojuego: $('#nombreVideojuego').val(),categoria: $('#categoria').val()};        
				
			    $.ajax({
					    url: 'rest/videojuego',
					    headers: { 
				               'Accept': 'application/json',
				               'Content-Type': 'application/json' 
				           },
					    type: 'POST',
					    dataType: "json", 
					    success: function(result) {
					    	load(result.nombreVideojuego, result.categoria);
					    },
				    	error: function(jqXhr, textStatus, errorMessage){
					    	alert('Error: ' + jqXhr.responseJSON.resultado);	
					    },
					    data:  JSON.stringify(sendInfo)
					    
					});
			    });
		
			$.ajax({
			    url: 'rest/videojuego',
			    type: 'GET',
			    dataType: "json",
			    success: function(result) {
			    	jQuery.each(result.videojuegos, function(i, val) {
			    		  load(val.nombreVideojuego, val.categoria);
			    		});
			    }
			});
			
			
			
		});
</script>
	
	
</head>
<body>

	<center><b>Ejemplo API Rest</b></center>
<br>
<% 
System.out.println("Antes de rellenar el combito");
System.out.println("1"+CrudCategoria.request.getServletPath());
System.out.println("3"+CrudCategoria.request.getContextPath());%>
	Formulario para insertar<br>
	Nombre del videojuego:<input type=text id="nombreVideojuego"><br>	
  <select name="categoria" id="categoria">
    <option>Escoge una categoria</option>
    <% 
    System.out.println("Primero se intenta rellenar el comboBox");
    Hashtable<String,Categoria> contenedorCategorias = CrudVideojuego.getCategoriaVideojuego(); 
       for(Categoria c: contenedorCategorias.values()){
     %>
     <option value="<%=c.getNombre()%>"><%=c.getNombre()%></option>
     <%
     } 
     %>
</select>
	<button id="sendButtonVideojuego">Crear</button>
	<br>
	<br>
	Listado de usuarios creados
	<br>
	<ul id="listadoVideojuego"></ul>





</body>
</html>
	
	
