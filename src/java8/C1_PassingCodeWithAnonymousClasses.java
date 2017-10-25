package java8;

interface Executable {
	void execute();
}

class Runner {
	public void run(Executable e) {
		e.execute();
	}
}

public class C1_PassingCodeWithAnonymousClasses {

	public static void main(String[] args) {
		Runner runner = new Runner();
		runner.run(new Executable() {
			public void execute() {
				System.out.println("Hello there.");
			}
		});
	}
}


/*
The whole point of this is just to pass in some code to the run() method. 
Then this method can and do what it likes with it, and in this case it’s just executing the code that we passed it in the execute() method. 
So this is a lot of text purely just to pass a code block.
*/