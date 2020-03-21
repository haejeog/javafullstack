package com.ronaldo.empresa;

import java.util.List;
import java.util.stream.Collectors;

public class Empresa {

	private String cif;
	private String nombre;
	private List<Persona> trabajadores;
	private int cuentaTrabajadores;
	private static int cuentaEmpresas;

	public Empresa(String cif, String nombre, List<Persona> trabajadores) {

		this.cif = cif;
		this.nombre = nombre;
		this.trabajadores = trabajadores;
		this.cuentaTrabajadores = trabajadores.size();
		cuentaEmpresas += trabajadores.size();

	}

	public Empresa() {

	}

	public String getCif() {
		return cif;
	}

	public void setCif(String cif) {
		this.cif = cif;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Persona> getTrabajadores() {
		return trabajadores;
	}

	public void setTrabajadores(List<Persona> trabajadores) {
		cuentaEmpresas = cuentaEmpresas - this.trabajadores.size() + trabajadores.size();
		this.trabajadores = trabajadores;
	}

	public static double getCuentaEmpresas() {
		return cuentaEmpresas;
	}

	public int darAltaTrabajadores(List<Persona> personas) {
		int contador = 0;
		for (Persona person : personas) {
			if (darAltaTrabajador(person)) {
				contador++;
			}
		}
		return contador;
	}

	public boolean darAltaTrabajador(Persona persona) {
		if (trabajadores.contains(persona)) {
			return false;
		} else {
			trabajadores.add(persona);
			cuentaTrabajadores++;
			return true;
		}
	}

	public void darBajaTrabajador(Persona persona) {
		trabajadores.remove(persona);
	}

	public void darBajaTrabajadores(List<Persona> personas) {
		trabajadores.removeAll(personas);
	}

	public List<Persona> buscarTrabajadores(int edad) {
		return trabajadores.stream().filter(e -> e.getEdad() > edad).collect(Collectors.toList());
	}

	public List<Persona> buscarTrabajadores(double salario) {
		return trabajadores.stream().filter(e -> e.getSalario() > salario).collect(Collectors.toList());
	}

	public List<Persona> buscarTrabajadores(char sexo) {
		return trabajadores.stream().filter(e -> e.getSexo() == sexo).collect(Collectors.toList());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cif == null) ? 0 : cif.hashCode());
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
		Empresa other = (Empresa) obj;
		if (cif == null) {
			if (other.cif != null)
				return false;
		} else if (!cif.equals(other.cif))
			return false;
		return true;
	}

}
