package com.mitocode.predicatefunction.predicate;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Program {

	public static void main(String[] args) {
		List<Persona> personas=new ArrayList<>();
		
		personas.add(new Persona("12345678", "Pepe","Perez", LocalDate.of(1990, 1, 2)));
		personas.add(new Persona("21345678", "Juan","Martinez", LocalDate.of(1981, 2, 3)));
		personas.add(new Persona("12435678", "Ana","Ramirez", LocalDate.of(1972, 3, 4)));
		personas.add(new Persona("12346578", "Maria","Lopez", LocalDate.of(1993, 4, 5)));
		
		Predicate<Persona> predicateEdad=p->p.getEdad()>=35;
		Predicate<Persona> predicateApellidos=p->p.getApellidos().contains("e");
		Predicate<Persona> predicateComplejo=predicateEdad.and(predicateApellidos);
		
		personas.stream()//Stream<Persona>
				.filter(predicateComplejo)//Stream<Persona>
				.forEach(System.out::println);
		
	}
}
