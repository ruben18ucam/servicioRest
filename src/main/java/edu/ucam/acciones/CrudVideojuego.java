package edu.ucam.acciones;

import java.util.Hashtable;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;


import edu.ucam.objetos.Categoria;
import edu.ucam.objetos.Videojuegos;

public class CrudVideojuego {

	
	
	public static Hashtable<String, Videojuegos> getVideojuegoContexto(HttpServletRequest req){
		 CrudCategoria.request = req;
	    System.out.println("Primero la peticion get");
          System.out.println("Metodo getVideojuegoContexto");
          System.out.println("1"+CrudCategoria.request.getServletPath());
		  System.out.println("3"+CrudCategoria.request.getContextPath());
        
		 Hashtable<String,Categoria> contenedorCategorias;  
		 Hashtable<String,Videojuegos> contenedorVideojuegos;  
		 contenedorVideojuegos = (Hashtable<String, Videojuegos>) CrudCategoria.request.getServletContext().getAttribute("ATR_VIDEOJUEGOS");
		 contenedorCategorias = (Hashtable<String, Categoria>) CrudCategoria.request.getServletContext().getAttribute("ATR_CATEGORIAS");
         if(contenedorCategorias==null) {
        	 System.out.println("no estan las categorias en el contexto de videojuegos");
        	 contenedorCategorias = new Hashtable<String, Categoria>();
             contenedorCategorias.put("deportes", new Categoria("deportes"));
             contenedorCategorias.put("accion", new Categoria("accion"));
             CrudCategoria.request.getServletContext().setAttribute("ATR_CATEGORIAS", contenedorCategorias);
         }else {
        	 System.out.println("ya estan las categorias en el contexto");
         }
         
         if(contenedorVideojuegos==null) {
        	 contenedorVideojuegos = new Hashtable<String, Videojuegos>();
             contenedorVideojuegos.put("fifa", new Videojuegos("fifa","deportes", true,true));
             contenedorVideojuegos.put("call of duty", new Videojuegos("call of duty","accion", true,true));
             CrudCategoria.request.getServletContext().setAttribute("ATR_VIDEOJUEGOS", contenedorVideojuegos);
             System.out.println("Videojuegos insertados");
         }else {
        	 System.out.println("ya estan los videojuegos en el contexto");
         }
		 
		 return contenedorVideojuegos;
	}
	
	public static void addVideojuegoContexto (Videojuegos videojuego) {
		System.out.println("Metodo addVideojuegoContexto");
        System.out.println("1"+CrudCategoria.request.getServletPath());
		  System.out.println("3"+CrudCategoria.request.getContextPath());
		 Hashtable<String,Videojuegos> contenedorVideojuegos;    
		 contenedorVideojuegos = (Hashtable<String, Videojuegos>) CrudCategoria.request.getServletContext().getAttribute("ATR_VIDEOJUEGOS");
		 contenedorVideojuegos.put(videojuego.getNombre(), videojuego);
	 }
	
	  public static void deleteVideojuegoContexto(String id ) {
		     Hashtable<String,Videojuegos> contenedorVideojuegos;    
		     contenedorVideojuegos = (Hashtable<String, Videojuegos>) CrudCategoria.request.getServletContext().getAttribute("ATR_VIDEOJUEGOS");
		     contenedorVideojuegos.remove(id);
	   }
	   
	  public static Hashtable<String, Categoria> getCategoriaVideojuego(){

          System.out.println("1"+CrudCategoria.request.getServletPath());
		  System.out.println("3"+CrudCategoria.request.getContextPath());
		  
			 Hashtable<String,Categoria> contenedorCategorias;    
			 contenedorCategorias = (Hashtable<String, Categoria>) CrudCategoria.request.getServletContext().getAttribute("ATR_CATEGORIAS"); 
			 return contenedorCategorias;
		}
	
}
