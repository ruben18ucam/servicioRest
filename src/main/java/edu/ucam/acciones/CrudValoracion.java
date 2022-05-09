package edu.ucam.acciones;

import java.util.Hashtable;

import javax.servlet.http.HttpServletRequest;

import edu.ucam.objetos.Categoria;
import edu.ucam.objetos.Valoracion;
import edu.ucam.objetos.Videojuegos;

public class CrudValoracion {
	  
	  
	  public static Hashtable<String, Videojuegos> getVideojuegoValoracion(){
		  System.out.println("Metodo getCategoriaVideojuego");
          System.out.println("1"+CrudCategoria.request.getServletPath());
		  System.out.println("3"+CrudCategoria.request.getContextPath());
		  
			 Hashtable<String,Videojuegos> contenedorVideojuegos;    
			 contenedorVideojuegos = (Hashtable<String, Videojuegos>) CrudCategoria.request.getServletContext().getAttribute("ATR_VIDEOJUEGOS"); 
			 return contenedorVideojuegos;
		}
	  
		public static Hashtable<String, Valoracion> getValoracionContexto(HttpServletRequest req){
			 CrudCategoria.request = req;
		      System.out.println("Primero la peticion get");
	          System.out.println("Metodo getValoracionContexto");
	          System.out.println("1"+CrudCategoria.request.getServletPath());
			  System.out.println("3"+CrudCategoria.request.getContextPath());
	        
			 Hashtable<String,Valoracion> contenedorValoraciones;  
			 Hashtable<String,Videojuegos> contenedorVideojuegos;  
			 contenedorVideojuegos = (Hashtable<String, Videojuegos>) CrudCategoria.request.getServletContext().getAttribute("ATR_VIDEOJUEGOS");
			 contenedorValoraciones = (Hashtable<String, Valoracion>) CrudCategoria.request.getServletContext().getAttribute("ATR_VALORACIONES");
	         if(contenedorVideojuegos==null) {
	        	 System.out.println("no estan los videojuegos en el contexto");
	        	 contenedorVideojuegos = new Hashtable<String, Videojuegos>();
	             contenedorVideojuegos.put("fifa", new Videojuegos("fifa","deportes", true,true));
	             contenedorVideojuegos.put("call of duty", new Videojuegos("call of duty","accion", true,true));
	             CrudCategoria.request.getServletContext().setAttribute("ATR_VIDEOJUEGOS", contenedorVideojuegos);
	         }else {
	        	 System.out.println("ya estan los videojuegos en el contexto");
	         }
	         
	         if(contenedorValoraciones==null) {
	        	 contenedorValoraciones = new Hashtable<String, Valoracion>();
	             CrudCategoria.request.getServletContext().setAttribute("ATR_VALORACIONES", contenedorValoraciones);
	             System.out.println("Valoraciones tabla insertados");
	         }else {
	        	 System.out.println("ya esta la tabla valoracion en el contexto");
	         }
			 
			 return contenedorValoraciones;
		}
		
		public static void addValoracionContexto (Valoracion valoracion) {
			System.out.println("Metodo addValoracionContexto");
	        System.out.println("1"+CrudCategoria.request.getServletPath());
			  System.out.println("3"+CrudCategoria.request.getContextPath());
			 Hashtable<String,Valoracion> contenedorValoraciones;    
			 contenedorValoraciones = (Hashtable<String, Valoracion>) CrudCategoria.request.getServletContext().getAttribute("ATR_VALORACIONES");
			 contenedorValoraciones.put(valoracion.getNombreVideojuego(), valoracion);
		 }
	  
	  
		public static void deleteValoracionContexto(String id ) {
		     Hashtable<String,Valoracion> contenedorValoraciones;    
		     contenedorValoraciones = (Hashtable<String, Valoracion>) CrudCategoria.request.getServletContext().getAttribute("ATR_VALORACIONES");
		     contenedorValoraciones.remove(id);
	   }
	  
	  
	  
}
