package com.ronaldo.empresafeb2020;

import java.util.Scanner;

public class NIF {
	final String posicionFinal = "TRWAGMYFPDXBNJZSQVHLCKE";
	private long dni;
	private char letra;

	public NIF() {

	}

	public NIF(long dni) {

		this.dni = dni;
		this.letra = calcularLetra();

	}

	public long getDni() {

		return dni;

	}

	public void setDni(long dni) {

		this.dni = dni;
		this.letra = calcularLetra();

	}

	public char getLetra() {

		return letra;

	}

	public void leer() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce DNI");
		this.dni = sc.nextInt();
		calcularLetra();
		sc.close();
	}

	private char calcularLetra() {
		return posicionFinal.charAt((int) (dni % 23));

	}

	@Override
	public String toString() {
		return pasarOchoLetras() + "-" + Character.toUpperCase(letra);
	}

	private String pasarOchoLetras() {
		String txt = "";
		int numeroCero = 8 - Long.toString(dni).length();
		for (int i = 0; i < numeroCero; i++) {
			txt += 0;
		}
		txt += dni;
		return txt;
	}
}
