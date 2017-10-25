package java8;

public class C2_LambdaExpressions {

	public static void main(String[] args) {
		//
		// It's really important to keep in mind that all this is, is a way of
		// passing a block of code that the run() method here is going to
		// execute.
		Runner runner = new Runner();
		runner.run(() -> System.out.println("Hello there."));

		//
		// if we want multiple lines or blocks of code
		runner.run(() -> {
			System.out.println("Hello there.");
			System.out.println("And hello again.");
		});
	}

}
