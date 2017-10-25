package programming.core.java;

class Devicee {
    public void start() {
        System.out.println("Starting machine ...");
    }
}

interface Treee {
    public void grow();
}

public class C26_AnonymousClasses {
	public static void main(String[] args) {
		// This is equivalent to creating a class that "extends"
        // Devicee and overrides the start method.
        Devicee machine1 = new Devicee() {
            @Override public void start() {
                System.out.println("Camera snapping ....");
            }
        };
        
        machine1.start();
        
        // This is equivalent to creating a class that "implements"
        // the Treee interface
        Treee plant1 = new Treee() {
            @Override
            public void grow() {
                System.out.println("Treee growing");
                
            }
        };
        
        plant1.grow();
	}
}
