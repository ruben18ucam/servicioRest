<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Probar API REST</title>
	<script type="text/javascript" src="js/jquery-1.12.4.min.js"></script>
	
	<script type="text/javascript">
	
	function load(nombreCategoria){
        
			var entry = document.createElement('li');
			
			var a = document.createElement('a');
			
			var linkText = document.createTextNode(" [Borrar]");
			
			a.appendChild(linkText);
			
		a.onclick = function () {
				$.ajax({
				    url: 'rest/categoria/' + nombreCategoria +'/',
				    type: 'DELETE',
				    dataType: "json",
				    success: function(result) {
				    	document.getElementById(nombreCategoria).remove();
				    },
			    	error: function(jqXhr, textStatus, errorMessage){
				    	alert('error');	
				    }
				});
			};
	
			entry.id = nombreCategoria;
            
			entry.appendChild(document.createTextNode(nombreCategoria));
			
			entry.appendChild(a);
			
			$('#listado').append(entry);
			
		}
	
		$(document).ready(function(){
        
			$("#sendButton").click(function(){
            
				var sendInfo = {nombreCategoria: $('#nombreCategoria').val()};
				
			    $.ajax({
					    url: 'rest/categoria',
					    headers: { 
				               'Accept': 'application/json',
				               'Content-Type': 'application/json' 
				           },
					    type: 'POST',
					    dataType: "json", 
					    success: function(result) {
					    	load(result.nombreCategoria);
					    },
				    	error: function(jqXhr, textStatus, errorMessage){
					    	alert('Error: ' + jqXhr.responseJSON.resultado);	
					    },
					    data:  JSON.stringify(sendInfo)
					    
					});
			    });
		
			$.ajax({
			    url: 'rest/categoria',
			    type: 'GET',
			    dataType: "json",
			    success: function(result) {
			    	jQuery.each(result.categorias, function(i, val) {
			    		  load(val.nombreCategoria);
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
	Nombre Categoria:<input type=text id="nombreCategoria"><br>
	
	<button id="sendButton">Crear</button>
	
	<br>
	<br>
	Listado de categorias creadas
	<br>
	<ul id="listado"></ul>

</body>
</html>
