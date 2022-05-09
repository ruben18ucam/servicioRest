package edu.ucam.acciones;


import java.util.Hashtable;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;

import edu.ucam.objetos.Categoria;
import edu.ucam.objetos.Valoracion;
import edu.ucam.objetos.Videojuegos;


public class CrudCategoria {
	public static HttpServletRequest request;

	
	
	
	public static Hashtable<String, Categoria> getCategoriaContexto(HttpServletRequest req){
		 request = req;
		System.out.println("En el contexto para añadir categoria");
		 Hashtable<String,Categoria> contenedorCategorias;    
		 contenedorCategorias = (Hashtable<String, Categoria>) req.getServletContext().getAttribute("ATR_CATEGORIAS");
         if(contenedorCategorias==null) {

        	 System.out.println("Creando las categorias");
        	 contenedorCategorias = new Hashtable<String, Categoria>();
             contenedorCategorias.put("deportes", new Categoria("deportes"));
             contenedorCategorias.put("accion", new Categoria("accion"));
             request.getServletContext().setAttribute("ATR_CATEGORIAS", contenedorCategorias);
         }else {
        	 System.out.println("ya esta en el contexto");
         }
         
		
         Hashtable<String,Videojuegos> contenedorVideojuegos = (Hashtable<String, Videojuegos>) CrudCategoria.request.getServletContext().getAttribute("ATR_VIDEOJUEGOS");
         if(contenedorVideojuegos==null) {
        	 System.out.println("no estan los videojuegos en el contexto");
        	 contenedorVideojuegos = new Hashtable<String, Videojuegos>();
             contenedorVideojuegos.put("fifa", new Videojuegos("fifa","deportes", true,true));
             contenedorVideojuegos.put("call of duty", new Videojuegos("call of duty","accion", true,true));
             CrudCategoria.request.getServletContext().setAttribute("ATR_VIDEOJUEGOS", contenedorVideojuegos);
         }else {
        	 System.out.println("ya estan los videojuegos en el contexto");
         }
    	 Hashtable<String,Valoracion> contenedorValoraciones = (Hashtable<String, Valoracion>) CrudCategoria.request.getServletContext().getAttribute("ATR_VALORACIONES");

         if(contenedorValoraciones==null) {
        	 contenedorValoraciones = new Hashtable<String, Valoracion>();
             CrudCategoria.request.getServletContext().setAttribute("ATR_VALORACIONES", contenedorValoraciones);
             System.out.println("Valoraciones tabla insertados");
         }else {
        	 System.out.println("ya esta la tabla valoracion en el contexto");
         }
		 
         
		 
		 return contenedorCategorias;
	}
	
	
	
	
	 public static void addCategoriaContexto (Categoria categoria) {
		 Hashtable<String,Categoria> contenedorCategorias;    
		 contenedorCategorias = (Hashtable<String, Categoria>) request.getServletContext().getAttribute("ATR_CATEGORIAS");
		 contenedorCategorias.put(categoria.getNombre(), categoria);
	 }
	
	 public static void deleteCategoriaContexto(String id ) {
		   Hashtable<String,Categoria> contenedorCategorias;    
			 contenedorCategorias = (Hashtable<String, Categoria>) request.getServletContext().getAttribute("ATR_CATEGORIAS");
			 contenedorCategorias.remove(id);
	   }
	
	
}
