
public interface FooInterface {

	void sayHello();
	default void sayGoodBye() {
		System.out.println("Good Bye");
	}
}
