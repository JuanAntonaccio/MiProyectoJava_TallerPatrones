
package conexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.*;

public class Coneccion1 {

	private static Connection databaseConnection;

	private static String CONNECTIONSTRING = "Jdbc:oracle:thin:@localhost:1521:xe";
	private static String USUARIO = "TALLER1";
	private static String CLAVE = "TALLER1";

	static {
		databaseConnection = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Se encontr� el Driver para Oracle DB - La librer�a necesaria est� referenciada");
			try {
				databaseConnection = DriverManager.getConnection(CONNECTIONSTRING, USUARIO, CLAVE);
				System.out.println("Conexi�n creada con �xito, es posible acceder a la base de datos!");
			} catch (SQLException e) {
				System.out.println("No logramos instanciar una conexi�n!!");
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			System.out.println("No tienes el driver en tu build-path?");
			e.printStackTrace();
		}
	}
	public static Connection getConnection() {
		return databaseConnection;
	}
}