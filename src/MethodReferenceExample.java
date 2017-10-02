import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import static java.util.stream.Collectors.toList;

public class MethodReferenceExample {

	public static void main(String[] args) {

		List<String> names = Arrays.asList("Rakesh", "Zoo", "Xerox", "Amit", "Broker", "Rakesh", "Zoo", "Xerox", "Amit",
				"Broker", "Rakesh", "Zoo", "Xerox", "Amit", "Broker", "Rakesh", "Zoo", "Xerox", "Amit", "Broker",
				"Rakesh", "Zoo", "Xerox", "Amit", "Broker", "Rakesh", "Zoo", "Xerox", "Amit", "Broker", "Rakesh", "Zoo",
				"Xerox", "Amit", "Broker", "Rakesh", "Zoo", "Xerox", "Amit", "Broker", "Rakesh", "Zoo", "Xerox", "Amit",
				"Broker", "Rakesh", "Zoo", "Xerox", "Amit", "Broker");

		/*List<Apple> applesWithNames = names.parallelStream().map(Apple::new).collect(toList());
		applesWithNames.stream().filter(apple -> apple.getName().charAt(0) == 'A').forEach(System.out::println);
		TriFunction<Apple, String, Double, String> applefactory = Apple::new;
		System.out.println(applefactory.apply("amia", 133d, "red").toString());*/
		
	Comparator.comparing((Apple apple) -> apple.getWeight());
	}


}
