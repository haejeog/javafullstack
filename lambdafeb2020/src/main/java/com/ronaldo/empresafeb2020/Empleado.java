package com.ronaldo.empresafeb2020;

public class Empleado {

	private String nif;
	private String nombre;
	private double sueldoBase;
	private int horasExtras;
	private double irpf;
	private boolean casado;
	private int hijos;
	private double importeHoraExtra;

	public Empleado() {

	}

	public Empleado(String nif) {

		this.nif = nif;

	}

	public double calcularComplemento() {

		this.importeHoraExtra = this.horasExtras * 10;
		return this.importeHoraExtra;

	}

	public double calcularSueldoBruto() {

		return this.sueldoBase + calcularComplemento();

	}

	public void calcularIRPF() {
		int cont = 20;
		cont -= ((casado == true) ? 2 : 0) - this.hijos;
		this.irpf = (cont * this.sueldoBase) / 100;
	}

	public String getNif() {

		return nif;

	}

	public void setNif(String nif) {

		this.nif = nif;

	}

	public String getNombre() {

		return nombre;

	}

	public void setNombre(String nombre) {

		this.nombre = nombre;

	}

	public double getSueldoBase() {

		return sueldoBase;

	}

	public void setSueldoBase(double sueldoBase) {

		this.sueldoBase = sueldoBase;

	}

	public int getHorasExtras() {

		return horasExtras;

	}

	public void setHorasExtras(int horasExtras) {

		this.horasExtras = horasExtras;

	}

	public double getIrpf() {

		return irpf;

	}

	public void setIrpf(double irpf) {

		this.irpf = irpf;

	}

	public boolean isCasado() {

		return casado;

	}

	public void setCasado(boolean casado) {

		this.casado = casado;

	}

	public int getHijos() {

		return hijos;

	}

	public void setHijos(int hijos) {

		this.hijos = hijos;

	}

	public double getImporteHoraExtra() {

		return importeHoraExtra;

	}

	public void setImporteHoraExtra(double importeHoraExtra) {

		this.importeHoraExtra = importeHoraExtra;

	}

	@Override
	public String toString() {

		return nif + " " + nombre + "\nSueldo Base: " + sueldoBase + "\nHoras Extras: " + horasExtras + "\nTipo IRPF: "
				+ irpf + "\nCasado: " + ((this.casado == true) ? "S" : "N") + "\nNumeros de hijos: " + hijos;

	}

}
