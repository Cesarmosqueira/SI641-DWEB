package com.mitocode.collectors;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Colecciones {
	public static void main(String[] args) {
		
		List<Empleado> empleados=Arrays.asList(
				new Empleado("Henry",30000,"Ventas"),
				new Empleado("Henry",30000,"Ventas"),
				new Empleado("Karen",31000,"Ventas"),
				new Empleado("Jaime",33000,"Compras"),
				new Empleado("Pepe",34000,"Ejecutivo")
		);
		
		Set<Empleado> empleadosSet=empleados.stream().collect(Collectors.toSet());
		System.out.println("Set: "+empleadosSet);
		
		List<Empleado> empleadosList=empleados.stream().collect(Collectors.toList());
		System.out.println("List: "+empleadosList);
		
		Map<String,Double> empleadosMap=empleados.stream()
							.distinct()
							//.collect(Collectors.toMap(e->e.getNombre(), e->e.getSalario()));
							.collect(Collectors.toMap(Empleado::getNombre, Empleado::getSalario));
		
		System.out.println("Map: "+empleadosMap);
	}
}
