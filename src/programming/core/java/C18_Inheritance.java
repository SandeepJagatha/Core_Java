package programming.core.java;

class Machinee {
    protected String name = "Machine Type 1";
    
    public void start() {
        System.out.println("Machine started.");
    }
    
    public void stop() {
        System.out.println("Machine stopped.");
    }
}

class Car extends Machinee {
	
    @Override
    public void start() {
        System.out.println("Car started");
    }

    public void wipeWindShield() {
        System.out.println("Wiping windshield");
    }
    
    public void showInfo() {
        System.out.println("Car name: " + name);
    }
}

public class C18_Inheritance {
	public static void main(String[] args) {
        Machinee mach1 = new Machinee();
        
        mach1.start();
        mach1.stop();
        
        Car car1 = new Car();
        
        car1.start();
        car1.wipeWindShield();
        car1.showInfo();
        car1.stop();
    }
}
