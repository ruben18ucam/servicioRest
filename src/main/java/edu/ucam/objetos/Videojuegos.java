package edu.ucam.objetos;

import java.util.Hashtable;

public class Videojuegos {
  
	public static final String paramCategoria ="paramCategoria";
	
	private String nombre;
	private int id;
	private static int idd=0;
	private String categorias;
	private boolean venta;
	private boolean alquiler;
	//private Hashtable<String,String> valoraciones;
	
	public Videojuegos(String nombre, String categorias, boolean venta, boolean alquiler) {
		super();
		this.nombre = nombre;
		this.categorias = categorias;
		this.venta = venta;
		this.alquiler = alquiler;
		this.id= idd;
		idd++;
	}
	
	
	@Override
	public String toString() {
		return "Videojuegos [nombre=" + nombre + ", id=" + id + ", categorias=" + categorias + ", venta=" + venta
				+ ", alquiler=" + alquiler + "]";
	}


	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getId() {
		return id;
	}
	
	public String getCategorias() {
		return categorias;
	}
	public void setCategorias(String categorias) {
		this.categorias = categorias;
	}
	public boolean isVenta() {
		return venta;
	}
	public void setVenta(boolean venta) {
		this.venta = venta;
	}
	public boolean isAlquiler() {
		return alquiler;
	}
	public void setAlquiler(boolean alquiler) {
		this.alquiler = alquiler;
	}
	
	
	
	
}
