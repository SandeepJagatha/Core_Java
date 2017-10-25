package java8;

interface IntExecutable {
    int execute(int a);
}

interface StringExecutable {
    int execute(String a);
}


class LERunner {
    public void run(IntExecutable e) {
        e.execute(7);
    }
    
    public void run(StringExecutable e) {
        System.out.println("Executing code block ...");
        int value = e.execute("Hello");
        System.out.println("Return value is: " + value);
    }
    
}

public class C2_LambdaExpressionParameters {

	public static void main(String[] args) {
		LERunner runner = new LERunner();
        
        // Anonymous class
        runner.run(new IntExecutable() {
            public int execute(int a) {
                System.out.println("Hello there.");
                System.out.println("And hello again.");
                return a + 7;
            }
        });
        
        // Lambda expression
        runner.run( (int a) -> {
            System.out.println("Hello there.");
            System.out.println("And hello again.");
            return a + 7;
        });
	}

}
