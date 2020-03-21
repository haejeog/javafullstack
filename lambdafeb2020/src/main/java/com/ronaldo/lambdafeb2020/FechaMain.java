package com.ronaldo.lambdafeb2020;

import java.util.Scanner;

public class FechaMain {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Introduce fecha:");
		Fecha fecha = new Fecha();
		System.out.print("Dia: ");
		fecha.setDia(sc.nextInt());
		System.out.print("Mes: ");
		fecha.setMes(sc.nextInt());
		System.out.print("Año: ");
		fecha.setAnyo(sc.nextInt());
		System.out.println(fecha.fechaCorrecta() ? "Fecha introducida: " + fecha : "Fecha incorrecta");
		System.out.println("Los 10 dias seguientes");
		fecha.diaSiguiente();
		
		

	}
}
