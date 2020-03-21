package com.ronaldo.empresa;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Persona {

	private String dni;
	private String nombre;
	private Character sexo;
	private double salario;
	private LocalDate fechaNacimiento;
	private Integer edad;

	public Persona(String dni, String nombre, char sexo, double salario, LocalDate fechaNacimiento) {

		this.dni = dni;
		this.nombre = nombre;
		this.sexo = sexo;
		this.salario = salario;
		this.fechaNacimiento = fechaNacimiento;
		setEdad();

	}

	public Persona() {

	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public String getDni() {
		return dni;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	private void setEdad() {

		LocalDate ahora = LocalDate.now();
		Period periodo = Period.between(fechaNacimiento, ahora);
		this.edad = periodo.getYears();
	}

	public Integer getEdad() {
		return edad;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dni == null) ? 0 : dni.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		if (dni == null) {
			if (other.dni != null)
				return false;
		} else if (!dni.equals(other.dni))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return dni + " " + nombre + "\nSexo: " + sexo + "\nSalario: " + salario + "\nFecha Nacimiento: "
				+ fechaNacimiento + " " + edad + " años\n";
	}

}
