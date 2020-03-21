package com.ronaldo.ficheiro;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class App {
	final static File f = new File("personas.dat");

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		crearFichero();
		leerFichero();
	}

	public static void crearFichero() throws FileNotFoundException, IOException, ClassNotFoundException {

		FileOutputStream fichero = new FileOutputStream(f);
		ObjectOutputStream fObjetos = new ObjectOutputStream(fichero);
		Persona p1 = new Persona("cristian", "jimenez");
		fObjetos.writeObject(p1);
		fObjetos.close();

	}

	public static void leerFichero() throws FileNotFoundException, IOException, ClassNotFoundException {

		FileInputStream fichero = new FileInputStream(f);
		ObjectInputStream fObjetos = new ObjectInputStream(fichero);
		Persona p1 = (Persona) fObjetos.readObject();
		p1.escribir();
		fObjetos.close();

	}

	public static void agenda() throws FileNotFoundException, IOException, ClassNotFoundException {

		Scanner sc = new Scanner(System.in);
		FileOutputStream fichero = new FileOutputStream(f);
		ObjectOutputStream fObjetos = new ObjectOutputStream(fichero);
		System.out.println("Introduce el nombre de la persona deseada");
		String nombre = sc.nextLine();
		System.out.println("Introduce el apellido de la persona deseada");
		String apellido = sc.nextLine();
		Persona p2 = new Persona(nombre, apellido);
		fObjetos.writeObject(p2);
		fObjetos.close();

	}

}