package edu.ucam.objetos;

public class Usuarios {

	private String nombreUsuario;
	private String clave;
	public static final String PARAM_NOMBREE = "PARAM_NOMBREE";
	
    public Usuarios(String nombreUsuario, String clave) {
		super();
		this.nombreUsuario = nombreUsuario;
		this.clave = clave;
	}
    
    
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}


	@Override
	public String toString() {
		return "Usuarios [nombreUsuario=" + nombreUsuario + ", clave=" + clave + "]";
	}
	
	
	
	
	
}
