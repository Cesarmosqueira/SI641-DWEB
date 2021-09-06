package com.mitocode.mapflatmap.map;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Program {
	public static void main(String[] args) {
		List<Persona> personas = new ArrayList<>();

		personas.add(new Persona( "Pepe", "Perez", LocalDate.of(1990, 1, 2)));
		personas.add(new Persona("Juan", "Martinez", LocalDate.of(1981, 2, 3)));
		personas.add(new Persona( "Ana", "Ramirez", LocalDate.of(1972, 3, 4)));
		personas.add(new Persona( "Maria", "Lopez", LocalDate.of(1993, 4, 5)));
		
		personas.stream()//Stream<Persona>
				.map(p->p.getNombre())//Stream<String>
				.map(s->s.toUpperCase())//Stream<String>
				.forEach(System.out::println);

		
		personas.stream()//Stream<Persona>
				.map(p->p.getFechaNacimiento())//Stream<LocalDate>
				.map(f->f.format(DateTimeFormatter.ofPattern("dd-MM")))//Stream<String>
				.forEach(System.out::println);
	}
}
