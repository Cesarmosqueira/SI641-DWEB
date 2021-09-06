package com.mitocode.mapflatmap.filter;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class Program {

	public static void main(String[] args) {

		List<Persona> personas = Arrays.asList(new Persona("Ana", LocalDate.of(1930, 12, 20)),
				new Persona("Jesus", LocalDate.of(1931, 3, 13)), new Persona("Miguel", LocalDate.of(1943, 8, 1)),
				new Persona("Simon", LocalDate.of(1949, 5, 22)), new Persona("Luisa", LocalDate.of(1959, 8, 28)),
				new Persona("Antonio", LocalDate.of(1965, 4, 28)), new Persona("Alicia", LocalDate.of(1974, 2, 10)),
				new Persona("Angel", LocalDate.of(1982, 10, 12)), new Persona("Alberto", LocalDate.of(2000, 1, 2)),
				new Persona("Maria", LocalDate.of(2020, 4, 21)));
		
		personas.stream()
				.filter(p->p.getEdad()>=18 && p.getEdad()<=65)
				.forEach(persona->System.out.printf("%s (%d años)%n", persona.getNombre(),
						persona.getEdad()));

		long numeroPersona=personas.stream()
				.filter(p->p.getFechaNacimiento().getYear()>=2000)
				.count();
		System.out.println("Numero de personas:"+numeroPersona);
		
	}

}
