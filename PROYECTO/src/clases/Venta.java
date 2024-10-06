package clases;


public class Venta {
		
	//Atributos
	private static int generadorCodigo3 = 3001;
	private int codigoVenta, cantidad;
	private Cliente codigoCliente;
	private Producto codigoProducto; 
	private double precio;
	private String fecha;
	
	//Atributos
	public Venta(int codigoVenta, Cliente codigoCliente, Producto codigoProducto, int cantidad, double precio, String fecha) {
		this.codigoVenta = generadorCodigo3++;
		this.codigoCliente = codigoCliente;
		this.codigoProducto = codigoProducto;
		this.cantidad = cantidad;
		this.precio = precio;
		this.fecha = fecha;
	}
	
	
	//Getters and setters
	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Cliente getCodigoCliente() {
		return codigoCliente;
	}

	public void setCodigoCliente(Cliente codigoCliente) {
		this.codigoCliente = codigoCliente;
	}

	public Producto getCodigoProducto() {
		return codigoProducto;
	}

	public void setCodigoProducto(Producto codigoProducto) {
		this.codigoProducto = codigoProducto;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public int getCodigoVenta() {
		return codigoVenta;
	}
	

	
	
	
	
}
