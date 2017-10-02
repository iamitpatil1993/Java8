import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Foo implements FooInterface, FooInterface2 {

	@Override
	public void sayGoodBye() {
		FooInterface.super.sayGoodBye();
	}

	@Override
	public void sayGoodMorning() {
		System.out.println("saying good morning");
	}

	@Override
	public void sayHello() {
		System.out.println("saying hello");
	}

	public static void main(String[] args) {
		/*Foo foo = new Foo();
		foo.sayGoodBye();
		foo.sayGoodMorning();
		foo.sayHello();*/

		List<String> names = Arrays.asList("Rakesh", "Zoo", "Xerox", "Amit", "Broker", "Rakesh", "Zoo", "Xerox", "Amit",
				"Broker", "Rakesh", "Zoo", "Xerox", "Amit", "Broker", "Rakesh", "Zoo", "Xerox", "Amit", "Broker",
				"Rakesh", "Zoo", "Xerox", "Amit", "Broker", "Rakesh", "Zoo", "Xerox", "Amit", "Broker", "Rakesh", "Zoo",
				"Xerox", "Amit", "Broker", "Rakesh", "Zoo", "Xerox", "Amit", "Broker", "Rakesh", "Zoo", "Xerox", "Amit",
				"Broker", "Rakesh", "Zoo", "Xerox", "Amit", "Broker");

		/*names.sort((String name1, String name2) -> name1.compareTo(name2));
		System.out.println("sorted names are :: " + names);*/
		
	
		List<String> firstCharacters = names.stream().parallel().map(name -> name.substring(0, 1)).collect(Collectors.toList());
		firstCharacters.forEach(name -> {try {
			throw new IOException();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}});
		
	}//the abstract method in functional interface is called as functional method.

	
	public static <T> List<T> filter(List<T> list, Predicate<T> predicate) {
		
		List<T> filteredList = new ArrayList<T>();
		list.forEach(listItem -> {
			if(predicate.negate().test(listItem)) {
				filteredList.add(listItem);
			}
		});
		return filteredList;
	}
}
