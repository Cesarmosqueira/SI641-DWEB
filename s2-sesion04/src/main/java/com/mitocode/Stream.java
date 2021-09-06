package com.mitocode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Stream {

	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8,8, 9,9);
		System.out.println("Lista de numeros original:" + numbers);

		System.out.println("Lista de numeros-filter:" + filterAllNumbersGreaterThan5AndDividedBy2(numbers));

		System.out.println("Lista de numeros-map:" + multiplyElementBy2(numbers));
		
		System.out.println(checkIdThereIsNumberGreaterThan4(numbers));
		
		System.out.println(getLimitNumbers(numbers));

		System.out.println(getSkipNumbers(numbers));
		
		System.out.println(getDistinctNumbers(numbers));
		
		System.out.println(countAllNumbers(numbers)); 
		
	}

	public static List<Integer> filterAllNumbersGreaterThan5AndDividedBy2(List<Integer> numbers) {

		/*
		 * List<Integer> numbersThanGreather5AndDividesBy2=new ArrayList<Integer>(); for
		 * (Integer number : numbers) { if (number>5 && number%2==0) {
		 * numbersThanGreather5.add(number); } }
		 */

		Predicate<Integer> greaterThan5 = number -> number > 5;// Lambda
		Predicate<Integer> otherFilter = number -> number<=2;// Lambda

		List<Integer> numbersThanGreather5AndDividesBy2 = numbers.stream() // Stream<Integer>
				.filter(greaterThan5)// Stream<Integer>
				.filter(number -> number % 2 == 0)// Stream<Integer>
				.filter(otherFilter)// Stream<Integer>
				.collect(Collectors.toList());// List<Integer>
		
		return numbersThanGreather5AndDividesBy2;

	}

	public static List<String> multiplyElementBy2(List<Integer> numbers) {

		Function<Integer, Integer> multiplyBy2 = number -> number * 2;

		Function<Integer, String> transformString = number -> String.valueOf(number);

		Comparator<String> inversed=(o1,o2)->o2.compareTo(o1);
		
		List<String> multipliedNumberAsString = numbers.stream() //Stream<Integer>
								.map(multiplyBy2)//Stream<Integer>
								.map(transformString)//Stream<String>
								.sorted(inversed)
								.collect(Collectors.toList());//List<String>
		
		return multipliedNumberAsString;

	}
	
	public static boolean checkIdThereIsNumberGreaterThan4(List<Integer> numbers) {
		
		boolean anyNumberGreateThan4=numbers.stream()
							.anyMatch(number->number>4);
		
		return anyNumberGreateThan4;
		
	}
	
	public static boolean checkNumberIsPair(List<Integer> numbers) {
		
		boolean numbersPair=numbers.stream()
							.allMatch(number->number%2==0);
		
		return numbersPair;		
	}

	
	public static List<Integer> getLimitNumbers(List<Integer> numbers) {
		
		List<Integer> numberLimit=numbers.stream()
						.limit(3)
						.collect(Collectors.toList());
		
		return numberLimit;		
	}
	
	
	public static List<Integer> getSkipNumbers(List<Integer> numbers) {
		
		List<Integer> numberSkip=numbers.stream()
						.skip(3)
						.collect(Collectors.toList());
		
		return numberSkip;		
	}
	
	
	public static List<Integer> getDistinctNumbers(List<Integer> numbers) {
		
		List<Integer> numberDistinct=numbers.stream()
						.distinct()
						.collect(Collectors.toList());
		
		return numberDistinct;		
	}
	
	
	public static long countAllNumbers(List<Integer> numbers) {
		
		return numbers.stream()
						.distinct()
						.filter(number->number>4)
						.count();		
	}

}
