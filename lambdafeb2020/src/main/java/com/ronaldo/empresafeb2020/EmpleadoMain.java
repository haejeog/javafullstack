package com.ronaldo.empresafeb2020;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.ronaldo.lambdafeb2020.User;

public class EmpleadoMain {
	static List<Empleado> empleados;

	public static void setUpEmpleado() {
		int cont = 1;
		double sueldo = 1150;
		empleados = new ArrayList<>();
		empleados.add(new Empleado("12345678H"));
		empleados.add(new Empleado("12345678P"));
		empleados.add(new Empleado("12345678R"));
		empleados.add(new Empleado("12345678E"));
		empleados.add(new Empleado("12345678Q"));
		empleados.add(new Empleado("12345678W"));
		for (Empleado empleado : empleados) {
			empleado.setNombre((cont % 2 == 0) ? "Ronaldo" : "Luis");
			empleado.setSueldoBase(sueldo);
			empleado.setHorasExtras((cont % 2 == 0) ? 4 : 2);
			empleado.setCasado((cont % 2 == 0) ? true : false);
			empleado.setHijos((cont % 2 == 0) ? 2 : 0);
			empleado.calcularIRPF();
			cont++;
			sueldo += 200;
		}
	}

	public static void main(String[] args) {
		setUpEmpleado();
		System.out.println("Tiene " + empleados.size() + " empleados en la empresa");
		empleados.stream().forEach(e -> System.out.println(e + "\n"));
		test();
	}

	public static void test() {
		Empleado minimoSueldo = empleados.stream().min(Comparator.comparing(Empleado::getSueldoBase)).orElse(null);
		Empleado maximoSueldo = empleados.stream().max(Comparator.comparing(Empleado::getSueldoBase)).orElse(null);
		System.out.println("Minimo sueldo:\n " + minimoSueldo + "\nMaximo sueldo:\n " + maximoSueldo);
	}

}
