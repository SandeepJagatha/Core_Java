package multithreading.C5_ThreadPool;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
 * Source: http://stackoverflow.com/questions/17827022/what-is-countdown-latch-in-java-multithreading
 * 
 * CountDownLatch works in latch principle, main thread will wait until gate is open. 
 * One thread waits for n number of threads specified while creating CountDownLatch in Java.
 * 
 * Any thread, usually main thread of application, which calls CountDownLatch.await() will wait until 
 * count reaches zero or its interrupted by another thread. All other thread are required to do count down by 
 * calling CountDownLatch.countDown() once they are completed or ready.
 * 
 * 
 * As soon as count reaches zero, Thread awaiting starts running. One of the 
 * disadvantages/advantages of CountDownLatch is that it's not reusable once count reaches to zero you
 *  can not use CountDownLatch any more.
 * 
 * Use CountDownLatch when one thread like main thread, requires to wait for one or more thread to complete, 
 * before it can start processing.
 * 
 * 
 * Classical example of using CountDownLatch in Java is any server side core Java application 
 * which uses services architecture, where multiple services are provided by multiple threads and 
 * application can not start processing until all services have started successfully.
 * 
 * 
 * ref : https://howtodoinjava.com/core-java/multi-threading/when-to-use-countdownlatch-java-concurrency-example-tutorial/
 * 
 * 
 * 
//Main thread start
//Create CountDownLatch for N threads
//Create and start N threads
//Main thread wait on latch
//N threads completes there tasks are returns
//Main thread resume execution
 * 
 * 
 */
public class C6_CountDownLatch {

	public static void main(String[] args) {
		CountDownLatch latch = new CountDownLatch(3);
		ExecutorService executor = Executors.newFixedThreadPool(3);
		for (int i = 0; i < 3; i++) {
			executor.submit(new CDLProcessor(latch));
		}
		executor.shutdown();

		try {
			// Application’s main thread waits, till other service threads which
			// are as an example responsible for starting framework services have
			// completed started all services.
			latch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Completed.");
	}

}

class CDLProcessor implements Runnable {

	private CountDownLatch latch;

	public CDLProcessor(CountDownLatch latch) {
		this.latch = latch;
	}

	public void run() {
		System.out.println("Started.");

		try {
			Thread.sleep(3000);
		} catch (InterruptedException ignored) {
		}
		latch.countDown();
	}
}