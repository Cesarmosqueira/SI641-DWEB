package com.mitocode;

@FunctionalInterface
public interface Calculadora {
	int operacion(int a, int b);

	default void saludo() {
		System.out.println("Buenas noches");
	}
	
	default void despedida() {
		System.out.println("Hasta luego");
	}	
}
