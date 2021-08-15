package entidades;

import java.time.LocalDate;

public class Producto {

	private int id_producto;
	private String nombre;
	private int cantidad;
	private double precio;
	private LocalDate vencimiento;

	public Producto(int id_producto, String nombre, int cantidad, double precio, LocalDate vencimiento) {
		super();
		this.id_producto = id_producto;
		this.nombre = nombre;
		this.cantidad = cantidad;
		this.precio = precio;
		this.vencimiento = vencimiento;
	}

	public int getId_producto() {
		return id_producto;
	}

	public void setId_producto(int id_producto) {
		this.id_producto = id_producto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public LocalDate getVencimiento() {
		return vencimiento;
	}

	public void setVencimiento(LocalDate vencimiento) {
		this.vencimiento = vencimiento;
	}

	@Override
	public String toString() {
		return "Producto [id_producto=" + id_producto + ", nombre=" + nombre + ", cantidad=" + cantidad + ", precio="
				+ precio + ", vencimiento=" + vencimiento + "]";
	}

}
