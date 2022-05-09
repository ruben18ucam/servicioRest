
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Inicio</title>
	<script type="text/javascript" src="js/jquery-1.12.4.min.js"></script>
	<script type="text/javascript">

		$(document).ready(function(){
 		$.ajax({
			    url: 'rest/categoria',
			    type: 'GET',
			    dataType: "json"
			});
		});
</script>
	
	
</head>
<body>

	<center><b>Inicio</b></center>
<br>

<a href="crudcategorias.jsp">Crud Categorias</a>
<a href="crudvideojuegos.jsp">Crud Videojuegos</a>
<a href="valoraciones.jsp">Valorar videojuego</a>

</body>
</html>