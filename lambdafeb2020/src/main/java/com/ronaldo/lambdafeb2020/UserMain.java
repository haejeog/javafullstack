package com.ronaldo.lambdafeb2020;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class UserMain {

	private static List<User> users;

	public static void main(String[] args) {
		List<String> nombresSantander = new ArrayList<String>();
		nombresSantander.add("Fran");
		nombresSantander.add("Paco");
		nombresSantander.add("Dani");

		List<String> nombresSabadell = new ArrayList<String>();
		nombresSabadell.add("Luis");
		nombresSabadell.add("Cristian");
		nombresSabadell.add("Ronaldo");

		List<List<String>> nombresTotales = new ArrayList<List<String>>();
		nombresTotales.add(nombresSantander);
		nombresTotales.add(nombresSabadell);

		List<String> nombresFusionados = nombresTotales.stream().flatMap(e -> e.stream()).collect(Collectors.toList());
		nombresFusionados.stream().forEach(e -> System.out.println(e));

		/*
		 * System.out.println(
		 * "--------------------------------------peek--------------------------------------"
		 * );
		 * 
		 * List<String>nombresFusionadosConApellido = nombresFusionados.stream()
		 * .peek(e->e.replace(e, e)) .collect(Collectors.toList());
		 * nombresFusionadosConApellido.stream().forEach(e->System.out.println(e));
		 */
		System.out.println("--------------------------------------Skip y Limit--------------------------------------");

		List<String> sublista = nombresFusionados.stream().skip(2).limit(3).collect(Collectors.toList());
		sublista.stream().forEach(e -> System.out.println(e));

		System.out.println("--------------------------------------Sorted--------------------------------------");

		setUpUser();

		List<User> ordenadosNombres = users.stream().sorted(Comparator.comparing(User::getNombre))
				.collect(Collectors.toList());
		printUser(ordenadosNombres);

		ordenadosNombres.stream().forEach(e -> System.out.println(e));

		System.out.println("--------------------------------------Min y Max--------------------------------------");

		setUpUser();

		User minimoId = users.stream().min(Comparator.comparing(User::getId)).orElse(null);
		User maximoId = users.stream().max(Comparator.comparing(User::getId)).orElse(null);
		System.out.println(minimoId.getId() + " " + maximoId.getId());

		System.out.println("--------------------------------------Distinct--------------------------------------");

		List<String> nombres2 = new ArrayList<String>();
		nombres2.add("Fran");
		nombres2.add("Ronaldo");
		nombres2.add("Fran");
		nombres2.add("Luis");

		List<String> nombresSinDuplicados = nombres2.stream().distinct().collect(Collectors.toList());
		nombresSinDuplicados.stream().forEach(e -> System.out.println(e));

		System.out.println(
				"--------------------------------------allMatch, anyMatch, noneMatch--------------------------------------");

		setUpUser();
		boolean todos = users.stream().allMatch(e -> e.getId() > 3);
		boolean alguno = users.stream().anyMatch(e -> e.getId() > 3);
		boolean ninguno = users.stream().noneMatch(e -> e.getId() > 3);
		System.out.println(todos + "\n" + alguno + "\n" + ninguno);

		System.out.println(
				"--------------------------------------sum, average, range--------------------------------------");

		setUpUser();
		double sumaId = users.stream().mapToDouble(e -> e.getId()).sum();
		double mediaId = users.stream().mapToDouble(e -> e.getId()).average().orElse(0);
		System.out.println("La suma es " + sumaId + " y la media es " + mediaId);
		System.out.println(IntStream.range(0, 100).sum());

		// Coge el stream y lo combina en un unico resultado
		// Mediante la operación repetida de una operación
		System.out.println("--------------------------------------Reduce--------------------------------------");

		setUpUser();

		long suma = users.stream().map(User::getId).reduce(100, Integer::sum);
		System.out.println(suma);

		System.out.println("--------------------------------------Joining--------------------------------------");

		setUpUser();

		String nombresSeguidos = users.stream().map(User::getNombre).collect(Collectors.joining(" - "));
		System.out.println(nombresSeguidos);
		// nos vamos a crear una lista sin nombres repetidos
		System.out.println("--------------------------------------toSet--------------------------------------");

		setUpUser();

		Set<String> setNombres = users.stream().map(User::getNombre).collect(Collectors.toSet());
		setNombres.stream().forEach(e -> System.out.println(e));
		// Saca datos estadísticos
		System.out.println(
				"--------------------------------------SummarizingDouble--------------------------------------");

		setUpUser();

		DoubleSummaryStatistics estatidisticas = users.stream().collect(Collectors.summarizingDouble(User::getId));
		System.out.println("Media " + estatidisticas.getAverage() + "\nMáximo= " + estatidisticas.getMax()
				+ "\nMínimo= " + estatidisticas.getMin() + "\nCantidad= " + estatidisticas.getCount());
		// Divide la lista original en sublistas con la condicion pasada
		System.out.println("--------------------------------------GroupingBy--------------------------------------");

		setUpUser();

		Map<Character, List<User>> grupoAlfabetico = users.stream()
				.collect(Collectors.groupingBy(e -> new Character(e.getNombre().charAt(0))));
		grupoAlfabetico.get('A').stream().forEach(e -> System.out.println(e.getNombre()));
		grupoAlfabetico.get('N').stream().forEach(e -> System.out.println(e.getNombre()));

		System.out.println("--------------------------------------partitionBy--------------------------------------");

		setUpUser();

		Map<Boolean, List<User>> nombresLargos = users.stream()
				.collect(Collectors.partitioningBy(e -> e.getNombre().length() > 3));
		System.out.println("Nombres largos");
		nombresLargos.get(true).stream().forEach(e -> System.out.println(e));
		System.out.println("Nombres Cortos");
		nombresLargos.get(false).stream().forEach(e -> System.out.println(e));

		System.out.println("--------------------------------------Mapping--------------------------------------");

		setUpUser();

		List<String> nombresPersonas = users.stream().collect(Collectors.mapping(User::getNombre, Collectors.toList()));

		System.out
				.println("--------------------------------------Stream Paralelo--------------------------------------");

		setUpUser();

		long tiempoInicial = System.currentTimeMillis();
		users.stream().forEach(e -> convertirMayuscula(e.getNombre()));
		long tiempoFinal = System.currentTimeMillis();
		System.out.println("La duración es " + (tiempoFinal - tiempoInicial));
		tiempoInicial = System.currentTimeMillis();
		users.parallelStream().forEach(e -> convertirMayuscula(e.getNombre()));
		tiempoFinal = System.currentTimeMillis();
		System.out.println("La duración es " + (tiempoFinal - tiempoInicial));
	}

	private static void setUpUser() {
		users = new ArrayList<User>();
		users.add(new User(1, "Fran"));
		users.add(new User(2, "Nuria"));
		users.add(new User(3, "Ana"));
		users.add(new User(4, "Cristian"));
		users.add(new User(5, "Aleix"));
		users.add(new User(6, "Ana"));

	}

	private static void printUser(List<User> lista) {
		for (User user : lista) {
			System.out.println(user);
		}
	}

	public static String convertirMayuscula(String nombre) {

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return nombre.toUpperCase();
	}
}
