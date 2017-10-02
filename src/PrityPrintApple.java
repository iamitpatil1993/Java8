import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import org.omg.Messaging.SyncScopeHelper;

public class PrityPrintApple {

	public static void main(String[] args) {

		List<Apple> apples = Arrays.asList(new Apple("red", 100d)
				,new Apple("green", 120d),
				new Apple("blue", 200d),
				new Apple("red", 160d),
				new Apple("red", 100d),
				new Apple("red", null));
		List<String> names = Arrays.asList("Amit", "Green lanton", "Ramesh", "Sumit");

		//PrityPrintApple.print(apples, apple -> "color ::  " + apple.getColour() + " weight :: " + apple.getWeight());

		//PrityPrintApple.print(names, name -> "My Name is :: " + name);


		names.sort((name1, name2) -> name1.compareTo(name2));

		names.forEach(name -> System.out.println(name));


		apples.sort((apple1, apple2) -> {
			if(apple1.getWeight() != null && apple2.getWeight() != null) {
				if (apple1.getWeight() > apple2.getWeight())
					return -1;
				else if (apple1.getWeight() < apple2.getWeight())
					return 1;
				else
					return 0;
			}
			else 
				return 0;
		});

		PrityPrintApple.print(apples, apple -> apple.getWeight());
	
	}

	private static <T, R> void print(List<T> apples, Function<T, R> outputGenerator) {


		apples.forEach(apple -> {
			System.out.println("output :: " + outputGenerator.apply(apple));
		});
	}
}
