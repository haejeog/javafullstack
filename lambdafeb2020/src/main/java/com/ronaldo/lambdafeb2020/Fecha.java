package com.ronaldo.lambdafeb2020;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.GregorianCalendar;

public class Fecha {

	private int dia;
	private int mes;
	private int anyo;

	enum Meses {
		ENERO, FEBRERO, MARZO, ABRIL, MAYO, JUNIO, JULIO, AGOSTO, SEPTIEMPRE, OCTUBRE, NOVIEMBRE, DECIEMBRE
	};

	public Fecha() {

	}

	public Fecha(int dia, int mes, int anyo) {

		this.dia = dia;
		this.mes = mes;
		this.anyo = anyo;

	}

	public int getDia() {
		return dia;
	}

	public void setDia(int dia) {
		this.dia = dia;
	}

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public int getAnyo() {
		return anyo;
	}

	public void setAnyo(int anyo) {
		this.anyo = anyo;
	}

	public boolean fechaCorrecta() {
		try {
			LocalDate ld = LocalDate.of(anyo, mes, dia);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/*
	 * private boolean esBisiesto() { GregorianCalendar calendar = new
	 * GregorianCalendar(); return calendar.isLeapYear(this.anyo); }
	 */
	public void diaSiguiente() {
		for (int i = 0; i < 11; i++) {
			LocalDate ld = LocalDate.of(anyo, mes, dia);
			LocalDate diasiguiente = ld.plusDays(1);
			anyo = diasiguiente.getYear();
			mes = diasiguiente.getMonthValue();
			dia = diasiguiente.getDayOfMonth();
			System.out.println(dia + "/" + mes + "/" + anyo);
		}
	}

	@Override
	public String toString() {
		return (dia < 10 ? "0" + dia : dia) + "-" + (mes < 10 ? "0" + mes : mes) + "-" + anyo;
	}

}
