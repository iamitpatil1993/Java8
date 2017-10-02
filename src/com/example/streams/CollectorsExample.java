package com.example.streams;

import static java.util.stream.Collectors.averagingInt;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.reducing;
import static java.util.stream.Collectors.summarizingInt;
import static java.util.stream.Collectors.summingInt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class CollectorsExample {
	static List<Dish> dishs = new ArrayList<>();
	static final Logger LOGGER;
	static {

		LOGGER = Logger.getLogger(CollectorsExample.class.getName());
		Dish dish = new Dish("Cake", 100, DISH_TYPE.VEG);
		dish.setCharacterstics(Arrays.asList(new Characterstic("Sweet")));
		dishs.add(dish);

		dish = new Dish("Fish", 700, DISH_TYPE.NON_VEG);
		dish.setCharacterstics(
				Arrays.asList(new Characterstic("Spicy"), new Characterstic("Oily"), new Characterstic("Red Curry")));

		dishs.add(dish);

		dish = new Dish("Rice", 500, DISH_TYPE.VEG);
		dish.setCharacterstics(Arrays.asList(new Characterstic("White"), new Characterstic("Healthy")));

		dishs.add(dish);

		dish = new Dish("Egg", 300, DISH_TYPE.NON_VEG);
		dish.setCharacterstics(Arrays.asList(new Characterstic("Heat"), new Characterstic("Body builder")));

		dishs.add(dish);
	}

	/*
	 * @apiNote asdas
	 */
	public static void main(String[] args) {

		System.out.println("\n\n------------- counting number of dishes in stream ----------------");
		System.out.println("> number of dishes in menu :: " + dishs.stream().count());
		System.out.println("> Sum using collector :: " + dishs.stream().collect(summingInt(dish -> 1)));
		;
		System.out.println("> Sum of dishes using COllectors.couting() :: " + dishs.stream().collect(counting()));
		System.out.println("> Sum using reduce :: " + dishs.stream().reduce(0L, (identity, dish) -> identity + 1L, Long::sum));

		System.out.println("> sum using Collectors.reducing() :: " + dishs.stream().collect(reducing(0L, dish -> 1L, Long::sum)));


		System.out.println("\n\n---------------- Finding dish with maximum calories -------------");
		Optional<Dish> maxCaloriesDish = dishs.stream().collect(Collectors.maxBy(Comparator.comparing(Dish::getCalories)));
		System.out.println("> Usingg Collectors.maxBy, maximum calory dish is :: " + (maxCaloriesDish.isPresent() ? maxCaloriesDish.get() : "Not Found, Menu is empty"));

		Optional<Dish> maxCaloriesDish2 = dishs.stream().filter(dish -> dish.getCalories() != null).reduce((dish1, dish2) -> dish1.getCalories() > dish2.getCalories() ? dish1 : dish2);
		System.out.println("> Using reduce, maximum calory dish is :: " + (maxCaloriesDish2.isPresent() ? maxCaloriesDish2.get() : "Not Found, Menu is empty"));


		System.out.println("\n\n---------------- Finding dish with minimal calories -------------");
		Optional<Dish> minimalCaloriesDish = dishs.stream().collect(Collectors.minBy(Comparator.comparing(Dish::getCalories)));
		System.out.println("> Usingg Collectors.minBy, minimal calory dish is :: " + (minimalCaloriesDish.isPresent() ? minimalCaloriesDish.get() : "Not Found, Menu is empty"));

		Optional<Dish> minCaloriesDish2 = dishs.stream().filter(dish -> dish.getCalories() != null).reduce((dish1, dish2) -> dish1.getCalories() < dish2.getCalories() ? dish1 : dish2);
		System.out.println("> Using reduce, minimal calory dish is :: " + (minCaloriesDish2.isPresent() ? minCaloriesDish2.get() : "Not Found, Menu is empty"));

		System.out.println("\n\n-------------------- Finding sum of calories --------------------");
		System.out.println("> Using summingInt. Sum of calories of of dishes(Summarization) :: " + dishs.stream().collect(summingInt(Dish::getCalories)));

		System.out.println("\n\n-------------------- Average calories dishes of menu ------------");
		System.out.println("> Using averagingInt, Average calories of menu(Summarization) :: " + dishs.stream().collect(averagingInt(Dish::getCalories)));
	
		System.out.println("\n\n-------------------- Calory Statistics  dishes of menu ------------");
		IntSummaryStatistics caloryStatisticks = dishs.stream().collect(summarizingInt(Dish::getCalories));
		System.out.println("> Using summarizingInt, calory statistics :: " + caloryStatisticks);
		

		System.out.println("\n\n-------------------- Comma separated list of menu ------------");
		System.out.println("> Using joining, Comma separated list of menu :: " + dishs.stream().map(Dish::getName).collect(joining(", ")));
		
		
		System.out.println("------------------------------------------------------------------------ Using generalized reduction ----------------------------------------------------------");
		System.out.println("\n\n-------------------- Finding sum of calories --------------------");
		System.out.println("> Using reducing(U identity, Function, Binaryoperator), Sum of calories of all dishes :: " + dishs.stream().collect(reducing(0, Dish::getCalories, Integer::sum)));;
		
		System.out.println("\n\n-------------------- Finding maximum calory dish --------------------");
		System.out.println("> Using reducing(U identity, Function, Binaryoperator), Highest Calory dish :: " + dishs.stream().collect(reducing((dish1, dish2) -> dish1.getCalories() > dish2.getCalories() ? dish1 : dish2)).get());;
		
		System.out.println("------------------------------------------------------------------------ Grouping ----------------------------------------------------------");
		System.out.println("\n\n-------------------- Group by Dish_TYPE of dish --------------------");
		dishs.stream().collect(groupingBy(Dish::getType)).forEach((dishType, dishes) -> {
			System.out.println("------ " + dishType + "------------");
			dishes.forEach(System.out::println);
		});
		
		System.out.println("\n\n-------------------- Group by CaloricLevel of dish --------------------");
		dishs
		.stream()
		.collect(groupingBy((Dish dish) -> {
			if(dish.getCalories() <= 300) {
				return CaloricLevel.DIET;
			} else if(dish.getCalories() > 300 && dish.getCalories() <= 500) {
				return CaloricLevel.NORMAL;
			} else
				return CaloricLevel.FAT;
		})).forEach((dishCalryLevel, dishes) -> {
			System.out.println("------ " + dishCalryLevel + "------------");
			dishes.forEach(System.out::println);
		});
		
		System.out.println("\n\n-------------------- Group by Dish Type and then average of calories in each group of dish --------------------");
		dishs
		.stream()
		.collect(groupingBy(Dish::getType, averagingInt(Dish::getCalories)))
		.forEach((dishTypeKey, averageCalory) -> {
			System.out.println(dishTypeKey + " :: " + averageCalory);
		});
		
		System.out.println("\n\n-------------------- Group by Dish Type and calory level of dish --------------------");
		dishs.stream()
		.collect(groupingBy(Dish::getType, groupingBy((Dish dish) -> {
			if(dish.getCalories() <= 300) {
				return CaloricLevel.DIET;
			} else if(dish.getCalories() > 300 && dish.getCalories() <= 500) {
				return CaloricLevel.NORMAL;
			} else
				return CaloricLevel.FAT;
		})))
		.forEach((dishType, caloryDishMap) -> {
			System.out.println("------ " + dishType + "------------");
			caloryDishMap.forEach((dishCalryLevel, dishes) -> {
				System.out.println("\t\t------ " + dishCalryLevel + "------------");
				dishes.forEach(dish -> {
					System.out.println("\t\t" + dish);
				});
			});
		});
		
		System.out.println("\n\n-------------------- Count by dish type --------------------");
		dishs.stream()
		.collect(groupingBy(Dish::getType, counting()))
		.forEach((dishType, count) -> {
			System.out.println(dishType + " :: " + count);
		});
		
		System.out.println("\n\n-------------------- Max calories by dish type --------------------");
		dishs.stream()
		.collect(groupingBy(Dish::getType, Collectors.maxBy(Comparator.comparing(Dish::getCalories))))
		.forEach((dishType, maxCalory) -> {
			System.out.println(dishType + " :: " + maxCalory.get().getCalories());
		});
		
		System.out.println("\n\n-------------------- Max calories by dish type(Using Finisher/comparingAndThen) --------------------");
		dishs.stream()
		.collect(groupingBy(Dish::getType, Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparing(Dish::getCalories)), Optional::get)))
		.forEach((dishType, maxCaloryInDishType) -> {
			System.out.println(dishType + " :: " + maxCaloryInDishType);
		});
		
		System.out.println("\n\n-------------------- Comma separated dish list(Using Finisher/comparingAndThen) --------------------");
		String lowercaseCommaSeparatedMenus = dishs.stream()
		.map(Dish::getName)
		.collect(Collectors.collectingAndThen(joining(","), String::toLowerCase));
		System.out.println("Lowercase comma seprated list of menu :: " + lowercaseCommaSeparatedMenus);
		
		System.out.println("\n\n-------------------- Sum of calories by Dish type --------------------");
		dishs.stream()
		.collect(groupingBy(Dish::getType, Collectors.summingInt(Dish::getCalories)))
		.forEach((dishType, sumOfCalories) -> {
			System.out.println(dishType + " :: " + sumOfCalories);
		});
		
		System.out.println("\n\n-------------------- CaloryLevels by Dish type --------------------");
		dishs.stream()
		.collect(Collectors.groupingBy(Dish::getType, Collectors.mapping(dish -> {
			if(dish.getCalories() <= 300) {
				return CaloricLevel.DIET;
			} else if(dish.getCalories() > 300 && dish.getCalories() <= 500) {
				return CaloricLevel.NORMAL;
			} else
				return CaloricLevel.FAT;
		}, Collectors.toSet())))
		.forEach((dishType, caloryLevels) -> {
			System.out.println(dishType + " :: " + caloryLevels);
		});
		
		System.out.println("\n\n-------------------- Veg and Non-veg dish(Using partitioning) --------------------");
		dishs.stream()
		.collect(Collectors.partitioningBy(Dish::getIsVegetarian))
		.forEach((isvegetarian, dishList) -> {
			System.out.println(isvegetarian + " :: " + dishList.stream().map(Dish::getName).collect(Collectors.joining(",")));
		});
		
		System.out.println("\n\n-------------------- Veg and Non-veg dish(Using partitioning with downstream collector, with mapping) --------------------");
		dishs.stream()
		.collect(Collectors.partitioningBy(Dish::getIsVegetarian, Collectors.mapping(Dish::getName, Collectors.joining(","))))
		.forEach((isVegetarian, commmaSeparatedDishListAsString) -> {
			System.out.println(isVegetarian + " :: " + commmaSeparatedDishListAsString);
		});
	}

}
