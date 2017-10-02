import java.util.Arrays;
import java.util.List;

public class OptionalExample {


	public static void main(String[] args) {

	/*	Function<String, String> getSecondString = input -> input.split(" ").length > 1 ? input.split(" ")[1] : null;
		Function<String, Integer> getStringLength = string -> string.length();
		
		//System.out.println(Optional.ofNullable(getSecondString.apply("Amit")).map(getStringLength).orElseThrow(IllegalStateException::new));;
		System.out.println(Optional.ofNullable(getSecondString.apply("Amit")).map(getStringLength).orElseThrow((() -> new InsufficientDataException("Invalid input"))));
	
	*/
		
		List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20);
		
		System.out.println(numbers.stream().filter(OptionalExample::isPrime).count());
	}
	
	
	
	static private boolean isPrime(Integer number) {
		
		for(int counter = 2 ; counter <= number/2 ; counter++) {
			if(number % counter == 0 )
				return false;
			else
				continue;
		}
		
		return true;
		
	}
	
	
	
	
	
}
