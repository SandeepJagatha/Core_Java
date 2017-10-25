package multithreading;

import java.util.Scanner;

// the volatile modifier guarantees that any thread that 
// reads a field will see the most recently written value.
public class C2_VolatileKeyword {

	public static void main(String[] args) {
		Processor pro = new Processor();
		pro.start();
		// Wait for the enter key
		System.out.println("Enter something to stop the thread,\nVolatile variable running will be forced to true :");
		new Scanner(System.in).nextLine();
		pro.shutdown();
	}

}

class Processor extends Thread {

	private volatile boolean running = true;

	public void run() {
		while (running) {
			System.out.println("Running");

			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void shutdown() {
		running = false;
	}
}
