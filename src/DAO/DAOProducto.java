package DAO;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.LinkedList;

import conexion.Coneccion1;
import entidades.Producto;

public class DAOProducto {

	private static final String INSERT_PRODUCTOS = "INSERT INTO PRODUCTOS (ID, NOMBRE, CANTIDAD,PRECIO,VENCIMIENTO) values (?,?, ?, ?,?)";

	private static final String ALL_PRODUCTOS = "SELECT * FROM PRODUCTOS";
	
	//Obtiene todos los productos almacenados
		public static LinkedList<Producto> findAll(){
			LinkedList<Producto> productos = new LinkedList<>();
			
			try{
				PreparedStatement statement = Coneccion1.getConnection().prepareStatement(ALL_PRODUCTOS);
										
				ResultSet resultado = statement.executeQuery();
				
				while (resultado.next()){
					
					Producto producto = getProductoFromResultSet(resultado);				
					productos.add(producto);				
				}
				return productos;
			}
			catch(SQLException e){
				e.printStackTrace();
				return null;
			}		
		}
	// Inserta el producto pasado por parámetro
	public static boolean insert(Producto p) {
		try {
			PreparedStatement statement = Coneccion1.getConnection().prepareStatement(INSERT_PRODUCTOS);
			statement.setInt(1, p.getId_producto());
			statement.setString(2, p.getNombre());
			statement.setInt(3, p.getCantidad());
			statement.setDouble(4, p.getPrecio());

			// Hay que pasar del tipo date de LocalDate a date de java.sql, para poder
			// insertar en la BD
			statement.setDate(5, Date.valueOf(p.getVencimiento()));

			int retorno = statement.executeUpdate();

			return retorno > 0;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

	}
	//Funcion auxiliar que traduce un registro a una instancia de producto
	// Este método siempre esta en el DAO para transformar una valor leido en
	// ResulSet para armar una instancia de la tabla que estemos trabajando
	// En este caso la tabla de SQL es PRODUCTOS y lo colocamos en una instancia
	// del tipo de dato complejo Producto.
	// A este método auxiliar lo usan otros métodos del DAO.
	
		private static Producto getProductoFromResultSet(ResultSet resultado) throws SQLException{
		
			int id = resultado.getInt("ID");
			String nombre = resultado.getString("NOMBRE");
			int cantidad = resultado.getInt("CANTIDAD");
			double precio = resultado.getDouble("PRECIO");
			// Primer paso lo ponemos en una variable auxiliar para 
			// guardar un elemento del tipo fecha
			Date fecaux = new Date(resultado.getDate("VENCIMIENTO").getTime());
			// aca pasamos de Date que se guarda en SQL a LocalDate en Java
			LocalDate fecha = fecaux.toLocalDate();
	
			Producto producto  = new Producto (id, nombre, cantidad, precio, fecha);
			
			return producto;
		}
	
}
