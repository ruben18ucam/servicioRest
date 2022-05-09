package edu.ucam.objetos;

public class Valoracion {

	private String nombreVideojuego;
	private String valoracion;
	
	
	public Valoracion(String nombreVideojuego, String valoracion) {
		super();
		this.nombreVideojuego = nombreVideojuego;
		this.valoracion = valoracion;
	}
	
	
	public String getNombreVideojuego() {
		return nombreVideojuego;
	}
	public void setNombreVideojuego(String nombreVideojuego) {
		this.nombreVideojuego = nombreVideojuego;
	}
	
	public String getValoracion() {
		return valoracion;
	}
	public void setValoracion(String valoracion) {
		this.valoracion = valoracion;
	}
	
	
	
}
