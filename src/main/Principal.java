package main;

import java.sql.Date;
import java.time.LocalDate;
import java.util.LinkedList;

import DAO.DAOProducto;
import entidades.Producto;

public class Principal {

	public static void main(String[] args) {

		cargarproductos();
		LinkedList<Producto> lista = DAOProducto.findAll();
		System.out.println();
		System.out.println("____________________________________________________");
		System.out.println("Listado de productos");
		System.out.println();
		
		for (Producto p : lista) {
			System.out.println(p);
		}
	}
	private static void cargarproductos() {
		LocalDate fecha = LocalDate.of(2022, 12, 31);
		Producto p = new Producto(1, "Arroz", 100, 50, fecha);
		LinkedList<Producto> lista = new LinkedList<Producto>();
		lista.add(p);
		p = new Producto(2, "Aceite", 50, 100, fecha);
		lista.add(p);
		p = new Producto(3, "Cafe", 500, 250, fecha);
		lista.add(p);
		p = new Producto(4, "Yerba", 600, 150, fecha);
		lista.add(p);
		p = new Producto(5, "Harina", 200, 50, fecha);
		lista.add(p);

		for (Producto e : lista) {

			if (DAOProducto.insert(e)) {
				System.out.println("Se inserto correctamente");
				System.out.println(e);
			}
		}
	}

}

