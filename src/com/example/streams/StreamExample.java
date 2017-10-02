package com.example.streams;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamExample {

	public static void main(String[] args) {
		List<Dish> dishs = new ArrayList<>();
		Dish dish = new Dish("Cake", 100);
		dish.setCharacterstics(Arrays.asList(new Characterstic("Sweet")));
		dishs.add(dish);
		
		dish = new Dish("Fish", 200);
		dish.setCharacterstics(Arrays.asList(new Characterstic("Spicy"),new Characterstic("Oily"), new Characterstic("Red Curry")));
		
		dishs.add(dish);
		
		dish = new Dish("Rice", 500);
		dish.setCharacterstics(Arrays.asList(new Characterstic("White"), new Characterstic("Healthy")));
		
		
		dishs.add(dish);
		
		dish = new Dish("Egg", 300);
		dish.setCharacterstics(Arrays.asList(new Characterstic("Heat"), new Characterstic("Body builder")));
		
		dishs.add(dish);

		
		dishs.stream()
		.map(d -> {
			d.setName(d.getName().toLowerCase());
			return d;
		})
		.filter(d -> d.getCalories() <= 300)
		.sorted(Comparator.comparing(Dish::getCalories))
		//.flatMap(d -> d.getCharacterstics().stream())
		.collect(toList()).forEach(System.out::println);;
		
		
		IntStream.rangeClosed(1, 5)
		.map(no -> no * no)
		.forEach(System.out::println);
		
		List<Integer> integers = Arrays.asList(3,4);
		List<Integer> integers2 = Arrays.asList(1,2,3);
		
		integers2.stream()
		.flatMap(no -> integers.stream().map(no2 -> new int[]{no, no2}))
		.forEach(arr -> System.out.println(arr[0] + "," + arr[1]));
		
		System.out.println("\n");
		
		integers2.stream()
		.flatMap(no -> integers.stream().map(no2 -> new int[]{no, no2}))
		.filter(arr -> (arr[0] + arr[1]) % 3 == 0)
		.forEach(arr -> System.out.println(arr[0] + "," + arr[1]));
		
		Arrays.stream(dishs.toArray(new Dish[dishs.size()]));
		
		/*What flatStream does is as follow
		1.flat stream creates new stream from existing one. It applies provided function on each element in stream, and then create new stream 
		by concatenating the individual stream into single one*/
		
		
	}

}
