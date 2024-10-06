package clases;

public class Producto {
	
	//Atributos
	private static int generadorCodigo2 = 2001;
	private int codigoProducto, stockActual, stockMin, stockMax;
	private String nombre;
	private double precio;
	
	//Constructores
	public Producto(int codigoProducto, int stockActual, int stockMin, int stockMax, String nombre, double precio) {
		this.codigoProducto = generadorCodigo2++;
		this.stockActual = stockActual;
		this.stockMin = stockMin;
		this.stockMax = stockMax;
		this.nombre = nombre;
		this.precio = precio;
	}
	
	//Setters and getters
	public int getStockActual() {
		return stockActual;
	}

	public void setStockActual(int stockActual) {
		this.stockActual = stockActual;
	}

	public int getStockMin() {
		return stockMin;
	}

	public void setStockMin(int stockMin) {
		this.stockMin = stockMin;
	}

	public int getStockMax() {
		return stockMax;
	}

	public void setStockMax(int stockMax) {
		this.stockMax = stockMax;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getCodigoProducto() {
		return codigoProducto;
	}
	
	

	
	
	

}
