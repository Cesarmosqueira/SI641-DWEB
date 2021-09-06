package com.mitocode.collectors;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.*;

public class GroupBy {
	public static void main(String[] args) {
		List<Empleado> empleados = Arrays.asList(new Empleado("Henry", 30000, "Ventas"),
				new Empleado("Karen", 31000, "Ventas"), new Empleado("Jaime", 33000, "Compras"),
				new Empleado("Pepe", 34000, "Ejecutivo"));

		Map<String, List<Empleado>> porDepartamento = empleados.stream().collect(groupingBy(Empleado::getDepartamento));

		System.out.println("Empleados agrupados por deparamento");
		porDepartamento.forEach((k, v) -> {
			String nombresEmpleados = v.stream().map(Empleado::getNombre).collect(joining(", "));
			System.out.printf("Departamento: %s | Empleados:%s %n", k, nombresEmpleados);
		});

		// Se puede agrupar con otro collector, para obtener un valor en lugar de
		// otra coleccion
		Map<String, Long> porDepartamentoCantidad = empleados.stream()
				.collect(groupingBy(Empleado::getDepartamento, counting()));

		System.out.println("N�MERO DE EMPLEADOS POR DEPARTAMENTO");
		porDepartamentoCantidad.forEach((k, v) -> System.out.printf("%s (%d empleados) %n", k, v));
		System.out.println();

	}
}
