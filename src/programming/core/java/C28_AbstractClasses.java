package programming.core.java;

/*
 * Abstract classes allow you to define the parent class of a 
 * new hierarchy without having to worry about the user actually 
 * instantiating the parent. For instance you could create an 
 * "Animal" class just to act as the basis for "Dog", "Cat, "Sheep" 
 * and so on, even defining some functionality in "Animal", 
 * but at the same time preventing the user of your hierarchy 
 * from trying to create an "Animal" object 
 * (which after all wouldn't make much sense -- you never encounter an abstract "animal" in the real world; only particular kinds of animals). 
*/

abstract class MachineDevice {
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public abstract void start();
    public abstract void doStuff();
    public abstract void shutdown();
    
    public void run() {
        start();
        doStuff();
        shutdown();
    }
}

class CanonCam extends MachineDevice {

    @Override
    public void start() {
        System.out.println("Starting camera.");
    }

    @Override
    public void doStuff() {
        System.out.println("Taking a photo");
        
    }

    @Override
    public void shutdown() {
        System.out.println("Shutting down the camera.");
        
    }

}

class MiniCar extends MachineDevice {

    @Override
    public void start() {
        System.out.println("Starting ignition...");
        
    }

    @Override
    public void doStuff() {
        System.out.println("Driving...");
    }

    @Override
    public void shutdown() {
        System.out.println("Switch off ignition.");
          
    }

}


public class C28_AbstractClasses {
	public static void main(String[] args) {
        CanonCam cam1 = new CanonCam();
        cam1.setId(5);
        
        MiniCar car1 = new MiniCar();
        car1.setId(4);
        
        car1.run();
        
        //MachineDevice machine1 = new MachineDevice();
    }
}
