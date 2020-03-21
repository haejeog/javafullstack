package com.ronaldo.empresa;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		List<Persona> p1 = new ArrayList<>();
		p1.add(new Persona("12345678P", "Pepe", 'H', 1000.0, LocalDate.of(2000, 1, 15)));
		p1.add(new Persona("12345673P", "Bianca", 'M', 2300.0, LocalDate.of(1999, 2, 15)));
		p1.add(new Persona("12345648P", "Ronaldo", 'H', 2040.0, LocalDate.of(1985, 9, 15)));
		p1.add(new Persona("12345568P", "Julia", 'M', 2990.0, LocalDate.of(2001, 8, 15)));
		p1.add(new Persona("12567888P", "Ana", 'M', 5000.0, LocalDate.of(2002, 10, 15)));
		p1.add(new Persona("12342338P", "Cristian", 'H', 2330.0, LocalDate.of(1973, 5, 15)));
		p1.add(new Persona("12876548P", "Nuria", 'M', 23200.0, LocalDate.of(1943, 9, 15)));

		Empresa everis = new Empresa("B21293", "Everis SPAIN", p1);
		Empresa eoi = new Empresa("B212121", "EOI SPAIN", p1);
		Empresa santander = new Empresa("C211293", "Santander SPAIN", p1);
		System.out.println("-----------------------Trabajadores ANTIGOS-----------------------");
		int x = 1;
		for (Persona person2 : santander.getTrabajadores()) {
			System.out.println(x + " - " + person2);
			x++;
		}
		System.out.println("-----------------------Trabajadores NUEVOS-----------------------");
		System.out.println(santander.darAltaTrabajadores(p1));
		x = 1;
		for (Persona person3 : santander.getTrabajadores()) {
			System.out.println(x + " - " + person3);
			x++;
		}
		System.out.println("-----------------------Añadir una persona-----------------------");
		System.out.println(santander
				.darAltaTrabajador(new Persona("12345648P", "Ronaldo", 'H', 2040.0, LocalDate.of(1985, 9, 15))));
		System.out.println("-----------------------Trabajadores SEXO-----------------------");
		System.out.println(everis.buscarTrabajadores('M'));
		System.out.println("-----------------------Trabajadores EDAD-----------------------");
		System.out.println(eoi.buscarTrabajadores(25));
		System.out.println("-----------------------Trabajadores SALARIO-----------------------");
		System.out.println(santander.buscarTrabajadores(5000.0));
	}

}
