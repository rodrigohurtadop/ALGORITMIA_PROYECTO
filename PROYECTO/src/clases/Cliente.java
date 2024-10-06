package clases;

public class Cliente {
	
	//Atributos
	private static int generadorCodigo = 1001;
	private int codigoCliente;
	private String nombres, apellidos, direccion, telefono, dni;

	
	//Constructores
	public Cliente(int codigoCliente, String nombres, String apellidos, String direccion, String telefono, String dni) {
		this.codigoCliente = generadorCodigo++;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.direccion = direccion;
		this.telefono = telefono;
		this.dni = dni;
	}

	
	//Setters and Getters
	public int getCodigoCliente() {
		return codigoCliente;
	}
	
	public String getNombres() {
		return nombres;
	}


	public void setNombres(String nombres) {
		this.nombres = nombres;
	}


	public String getApellidos() {
		return apellidos;
	}


	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}


	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	public String getTelefono() {
		return telefono;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


	public String getDni() {
		return dni;
	}


	public void setDni(String dni) {
		this.dni = dni;
	}

}
