package edu.ucam.services;

import java.util.Hashtable;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.PathParam;

import org.json.JSONObject;

import edu.ucam.acciones.CrudCategoria;
import edu.ucam.acciones.CrudValoracion;
import edu.ucam.acciones.CrudVideojuego;
import edu.ucam.objetos.Categoria;
import edu.ucam.objetos.Valoracion;
import edu.ucam.objetos.Videojuegos;


@Path("/")
public class MiRest {

	
	@GET
	@Path("/categoria")
	@Produces(MediaType.APPLICATION_JSON)
	public Response miGet (@javax.ws.rs.core.Context HttpServletRequest req) {
		System.out.println("\nmiGet de categoria");
		System.out.println("1"+req.getServletPath());
		System.out.println("2"+req.getServletContext().toString());
		System.out.println("3"+req.getContextPath());
		Hashtable<String, Categoria> contenedorCategoria = CrudCategoria.getCategoriaContexto(req);

		JSONObject jsonRespuesta = new JSONObject();
		
		contenedorCategoria.forEach( (s,u) -> {
			JSONObject categorias = new JSONObject();
			categorias.put("nombreCategoria", u.getNombre());
		
			
			jsonRespuesta.append("categorias", categorias);
			
			System.out.println("Nombre de la categoria: "+ u.getNombre());
		;});
		
		
		return Response.status(200).entity(jsonRespuesta.toString()).build();
	}

	@POST
	@Path("/categoria")
	@Produces(MediaType.APPLICATION_JSON)
	public Response miPut (String inputStrJSON) {
System.out.println("\nmiPost de categoria");
System.out.println("1"+CrudCategoria.request.getServletPath());
System.out.println("3"+CrudCategoria.request.getContextPath());
		JSONObject inputJSON = new JSONObject(inputStrJSON);
		
		String nombre = inputJSON.getString("nombreCategoria");
		
		System.out.println("Nombre de la categoria: "+ nombre);
		
		Categoria categoria = new Categoria(nombre);
		
		CrudCategoria.addCategoriaContexto(categoria);

		JSONObject jsonRespuesta = new JSONObject();
		jsonRespuesta.put("nombreCategoria", categoria.getNombre());
		
		
		
		return Response.status(200).entity(jsonRespuesta.toString()).build();
	}

	@DELETE
	@Path("/categoria/{nombreCategoria}")
	public void miDelete (@PathParam("nombreCategoria") String idX) {
System.out.println("\nmiDelete DE CATEGORIAS");
		
		CrudCategoria.deleteCategoriaContexto(idX);
		
		
	}
	
	
	@GET
	@Path("/videojuego")
	@Produces(MediaType.APPLICATION_JSON)
	public Response miGetVideojuego (@javax.ws.rs.core.Context HttpServletRequest req) {
		
		System.out.println("\nmiGet de videojuego");
		System.out.println("1"+req.getServletPath());
		System.out.println("3"+req.getContextPath());
		Hashtable<String, Videojuegos> contenedorVideojuegos = CrudVideojuego.getVideojuegoContexto(req);

		JSONObject jsonRespuesta = new JSONObject();
		
		    contenedorVideojuegos.forEach( (s,u) -> {
			JSONObject videojuegos = new JSONObject();
			videojuegos.put("nombreVideojuego", u.getNombre());
			videojuegos.put("categoria", u.getCategorias());

			
			jsonRespuesta.append("videojuegos", videojuegos);
			
			System.out.println("Nombre del videojuego: "+ u.getNombre());
		;});
		
		
		return Response.status(200).entity(jsonRespuesta.toString()).build();
	}
	@POST
	@Path("/videojuego")
	@Produces(MediaType.APPLICATION_JSON)
	public Response miPostVideojuego (String inputStrJSON) {
		System.out.println("\nmiPost de videojuego");
		System.out.println("1"+CrudCategoria.request.getServletPath());
		System.out.println("3"+CrudCategoria.request.getContextPath());
		System.out.println(inputStrJSON);
		JSONObject inputJSON = new JSONObject(inputStrJSON);
		
		String nombre = inputJSON.getString("nombreVideojuego");
		String categoria = inputJSON.getString("categoria");
		
		System.out.println("Nombre del videojuego: "+ nombre);
		System.out.println("nombre de la categoria: "+categoria);
		
		Videojuegos videojuego = new Videojuegos(nombre,categoria,true,true);
		
		CrudVideojuego.addVideojuegoContexto(videojuego);

		JSONObject jsonRespuesta = new JSONObject();
		jsonRespuesta.put("nombreVideojuego", videojuego.getNombre());
		
		
		
		return Response.status(200).entity(jsonRespuesta.toString()).build();
	}

	@DELETE
	@Path("/videojuego/{nombreVideojuego}")
	public void miDeleteVideojuego (@PathParam("nombreVideojuego") String idX) {
		System.out.println("\nmiDelete de videojuego");
		
		CrudVideojuego.deleteVideojuegoContexto(idX);
		
		
	}
	
	
	@GET
	@Path("/valoracion")
	@Produces(MediaType.APPLICATION_JSON)
	public Response miGetValoracion (@javax.ws.rs.core.Context HttpServletRequest req) {
		
		System.out.println("\nmiGet de valoracion");
		System.out.println("1"+req.getServletPath());
		System.out.println("3"+req.getContextPath());
		Hashtable<String, Valoracion> contenedorValoraciones = CrudValoracion.getValoracionContexto(req);

		JSONObject jsonRespuesta = new JSONObject();
		
		contenedorValoraciones.forEach( (s,u) -> {
			JSONObject valoraciones = new JSONObject();
			valoraciones.put("nombre", u.getNombreVideojuego());
			valoraciones.put("valoracion", u.getValoracion());

			
			jsonRespuesta.append("valoraciones", valoraciones);
			
			System.out.println("Nombre del videojuego: "+ u.getNombreVideojuego());
		;});
		
		
		return Response.status(200).entity(jsonRespuesta.toString()).build();
	}
	@POST
	@Path("/valoracion")
	@Produces(MediaType.APPLICATION_JSON)
	public Response miPostValoracion (String inputStrJSON) {
		System.out.println("\nmiPost de valoracion");
		System.out.println("1"+CrudCategoria.request.getServletPath());
		System.out.println("3"+CrudCategoria.request.getContextPath());
		System.out.println(inputStrJSON);
		JSONObject inputJSON = new JSONObject(inputStrJSON);
		
		String nombre = inputJSON.getString("nombre");
		String valoracio = inputJSON.getString("valoracion");
		
		System.out.println("Nombre del videojuego: "+ nombre);
		System.out.println("nombre de la categoria: "+valoracio);
		
		Valoracion valoracion = new Valoracion(nombre, valoracio);
		
		CrudValoracion.addValoracionContexto(valoracion);

		JSONObject jsonRespuesta = new JSONObject();
		jsonRespuesta.put("nombre", valoracion.getNombreVideojuego());
		
		
		
		return Response.status(200).entity(jsonRespuesta.toString()).build();
	}

	@DELETE
	@Path("/valoracion/{nombre}")
	public void miDeleteValoracion (@PathParam("nombre") String idX) {
		System.out.println("\nmiDelete de valoracion");
		
		CrudValoracion.deleteValoracionContexto(idX);
		
		
	}
	
	
}


