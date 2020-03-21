package com.ronaldo.ficheiro;

public class Persona {

	private String nombre;
	private String Apellido;

	public Persona(String nombre, String apellido) {
		super();
		this.nombre = nombre;
		Apellido = apellido;
	}

	public Persona() {

	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return Apellido;
	}

	public void setApellido(String apellido) {
		Apellido = apellido;
	}

}
