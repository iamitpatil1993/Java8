import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import com.example.streams.Characterstic;
import com.example.streams.DISH_TYPE;
import com.example.streams.Dish;

public class StreamReduceExample {

	public static void main(String[] args) {
		List<Dish> dishs = new ArrayList<>();
		Dish dish = new Dish("Cake", 100);
		dish.setCharacterstics(Arrays.asList(new Characterstic("Sweet")));
		dish.setType(DISH_TYPE.VEG);
		dishs.add(dish);
		

		dish = new Dish("Fish", 200);
		dish.setType(DISH_TYPE.NON_VEG);
		dish.setCharacterstics(
				Arrays.asList(new Characterstic("Spicy"), new Characterstic("Oily"), new Characterstic("Red Curry")));

		dishs.add(dish);

		dish = new Dish("Rice", 500);
		dish.setType(DISH_TYPE.VEG);
		dish.setCharacterstics(Arrays.asList(new Characterstic("White"), new Characterstic("Healthy")));

		dishs.add(dish);

		dish = new Dish("Egg", 300);
		dish.setType(DISH_TYPE.NON_VEG);
		dish.setCharacterstics(Arrays.asList(new Characterstic("Heat"), new Characterstic("Body builder")));

		dishs.add(dish);
		
		System.out.println("Number of dishes in stream are :: " + dishs.stream().count());
		
		Integer dishSize = dishs.stream()
		.map(d -> 1)
		.reduce(0, Integer::sum);
		
		System.out.println("Number if dishes in stream are :: " + dishSize);
	}

}
