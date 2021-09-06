package com.mitocode.predicatefunction.function;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import com.mitocode.predicatefunction.predicate.Persona;

public class Program {

	public static void main(String[] args) {
		List<Persona> personas=new ArrayList<>();
		
		
		personas.add(new Persona("12345678", "Pepe","Perez", LocalDate.of(1990, 1, 2)));
		personas.add(new Persona("21345678", "Juan","Martinez", LocalDate.of(1981, 2, 3)));
		personas.add(new Persona("12435678", "Ana","Ramirez", LocalDate.of(1972, 3, 4)));
		personas.add(new Persona("12346578", "Maria","Lopez", LocalDate.of(1993, 4, 5)));
		
		
		/*personas.stream()//Stream<Persona>
				.map(p->p.getNombre())//Stream<String>
				.forEach(System.out::println);*/
		
		Function<Persona, String> functionPersonaANombres=p->p.getNombre();
		
		List<String> nombres=transformarEmpleadosEnNombres(personas, functionPersonaANombres);
		
		nombres.forEach(System.out::println);
		
		/*for (String nombre : nombres) {
			System.out.println(nombre);
		}*/
	}

	private static List<String> transformarEmpleadosEnNombres(List<Persona> personas, 
			Function<Persona, String> funcionPersonaANombre){
		
		List<String> result=new ArrayList<>();
		//for (var per : personas) {
		for (Persona per : personas) {
			result.add(funcionPersonaANombre.apply(per));
		}
		
		return result;
	}
	
	
}


