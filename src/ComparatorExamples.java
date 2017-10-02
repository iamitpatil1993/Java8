import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ComparatorExamples {

	public static void main(String ars9[]) {
		List<Apple> apples = new ArrayList<>();
		
		apples.add(new Apple("red", 5d, "Amit"));
		apples.add(new Apple("read", 5d, "Bharat"));
		apples.add(new Apple("yellow", 10d, "ramesh"));
		
		Comparator<Apple> comparator = Comparator.comparing(Apple::getColour);
		comparator = comparator.thenComparing(Apple::getName);
		apples.sort(comparator);
		
		apples.stream().forEach(apple -> {
			System.out.println(apple.getColour() + " :: " + apple.getWeight() + " :: " + apple.getName());
		});



	}
}
