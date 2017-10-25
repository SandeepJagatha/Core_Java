package programming.core.java;

class CMachine {
	public void start() {
		System.out.println("Machine started.");
	}
}

class Camera extends CMachine {
	public void start() {
		System.out.println("Camera started.");
	}

	public void snap() {
		System.out.println("Photo taken.");
	}
}

public class C23_UpcastingAndDowncasting {
	public static void main(String[] args) {
		CMachine machine1 = new CMachine();
	    Camera camera1 = new Camera();
	    
	    machine1.start();
	    camera1.start();
	    camera1.snap();
	    
	    // Upcasting 
	    CMachine machine2 = camera1;
	    machine2.start();
	    // error: machine2.snap();

	    // Downcasting
	    CMachine machine3 = new Camera();
	    Camera camera2 = (Camera)machine3;
	    camera2.start();
	    camera2.snap();
	    
	    // Doesn't work --- runtime error.
	    Machine machine4 = new Machine();
	    // Camera camera3 = (Camera)machine4;
	    // camera3.start();
	    // camera3.snap();
	}
}
