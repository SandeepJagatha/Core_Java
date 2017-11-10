package java8;

interface FunctionalInterfaceTest {
	void display();
}

@FunctionalInterface
interface Processor {
  int getStringLength(String str);
}

//
// A functional interface is an interface with one method and used as the type
// of a lambda expression.
public class C3_FunctionalInterface {

	public static void main(String[] args) {

		// Old way using anonymous inner class
		FunctionalInterfaceTest fit = new FunctionalInterfaceTest() {
			public void display() {
				System.out.println("Display from old way");
			}
		};
		fit.display();// outputs: Display from old way

		// Using lambda expression
		FunctionalInterfaceTest newWay = () -> System.out.println("Display from new Lambda Expression");
		newWay.display();// outputs : Display from new Lambda Expression
		
		
		//
		// Demo2
		
		Processor stringProcessor = (String str) -> str.length();
	    String name = "Java Lambda";
	    int length = stringProcessor.getStringLength(name);
	    System.out.println(length);
	}

}
