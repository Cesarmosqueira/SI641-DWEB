package com.mitocode;

public class Program {

	public static void main(String[] args) {
		
		Calculadora calculadora=new Calculadora() {			
			@Override
			public int operacion(int a, int b) {
				// TODO Auto-generated method stub
				return a+b;
			}
		};
		
		System.out.println("Calculo sin lambdas:"+calculadora.operacion(3, 4));

		Calculadora calculadora1=(a,b)->a+b;
		
		System.out.println("Calculo con lambdas:"+calculadora1.operacion(3, 4));
		
		
		Calculadora calculadora3=(a,b)->a-b;
		
		System.out.println("Calculo con lambdas:"+calculadora3.operacion(4, 3));
		calculadora3.saludo();
		calculadora3.despedida();
	}

}
