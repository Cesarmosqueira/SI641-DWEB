package com.mitocode.mapflatmap.flatmap;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.IntUnaryOperator;
import java.util.stream.Collectors;

public class Program {
	
	public static void main(String[] args) {
		
		List<Persona> personas=database();
		System.out.println("Paises a los que viajan algunas personas");
		for (Persona persona : personas) {
			for (Viaje viaje: persona.getViajes()) {
				System.out.println(viaje.getPais());
			}
		}
		System.out.println("");
		
		
		int[][] numeros= {
				{1,2,2,3,1,4},
				{4,2,3,3,1,1}
		};
		
		//{1,2,2,3,1,4,4,2,3,3,1,1}
		
		Arrays.stream(numeros).flatMapToInt(x->Arrays.stream(x))
					.map(IntUnaryOperator.identity()).distinct()
					.forEach(System.out::println);
		
		
		
		personas.stream()//Stream<Persona>
		     .map(persona->persona.getViajes())//Stream<List<Viaje>>
		     .flatMap(viajes->viajes.stream())//Stream<Viaje>
		     .map(viaje->viaje.getPais())//Stream<String>
		     //.distinct()//Stream<String>
		     .forEach(System.out::println);
		
		
		List<List<String>> list=Arrays.asList(
				
			Arrays.asList("a"),
			Arrays.asList("b"));
		
		System.out.println(list);
		
		System.out.println(list
				.stream()
				.flatMap(Collection::stream)
				.collect(Collectors.toList()));
				
			
	}
	
	public static List<Persona> database(){
		
		Persona p1=new Persona("Henry");
		p1.getViajes().add(new Viaje("España"));
		p1.getViajes().add(new Viaje("Italia"));
		p1.getViajes().add(new Viaje("Francia"));
		
		Persona p2=new Persona("Maria");
		p2.getViajes().add(new Viaje("Italia"));
		p2.getViajes().add(new Viaje("Francia"));
		p2.getViajes().add(new Viaje("Alemania"));
		
		
		return Arrays.asList(p1,p2);
	}
}
