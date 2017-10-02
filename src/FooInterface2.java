
public interface FooInterface2 {

	void sayGoodMorning();
	default void sayGoodBye() {
		System.out.println("Good Bye from FooInterface2");
	}
}
