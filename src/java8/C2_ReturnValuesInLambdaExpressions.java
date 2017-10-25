package java8;

interface Executablee {
	int execute();
}

class Runnerr {
	public void run(Executablee e) {
		e.execute();
	}
}

public class C2_ReturnValuesInLambdaExpressions {
	public static void main(String[] args) {

		Runnerr runner = new Runnerr();

		//
		// anonymous class version
		runner.run(new Executablee() {
			public int execute() {
				System.out.println("Hello there.");
				System.out.println("And hello again.");
				return 7;
			}
		});

		//
		// lambda expression
		runner.run(() -> {
			System.out.println("Hello there.");
			System.out.println("And hello again.");
			return 7;
		});

		//
		//
		runner.run(() -> 7);
	}
}
