package com.mitocode.datoscalculados;

import java.util.Arrays;
import java.util.Random;

public class Datos {
	public static void main(String[] args) {
		
		double array[]=generarArrayAleatoria();
		System.out.println(Arrays.toString(array));
		
		System.out.println("El numero de elementos:"+Arrays.stream(array).count());
		
		double maximo=Arrays.stream(array).max().orElse(0);
		double minimo=Arrays.stream(array).min().orElse(0);
		
		System.out.printf("El valor maximo es %.2f y minimo %.2f%n",maximo, minimo);
		
		double suma=Arrays.stream(array).sum();
		System.out.println("La suma de todos los elementos del array es:"+suma);
	}
	
	public static double[] generarArrayAleatoria() {
		return new Random().doubles(100, 0, 1000).toArray();
	}
}
