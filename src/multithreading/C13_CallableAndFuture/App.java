package multithreading.C13_CallableAndFuture;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeoutException;

// A Future represents the result of an asynchronous computation. Methods
// are provided to check if the computation is complete, to wait for its
// completion, and to retrieve the result of the computation. The result can
// only be retrieved using method get when the computation has completed,
// blocking if necessary until it is ready. Cancellation is performed by the
// cancel method. Additional methods are provided to determine if the task
// completed normally or was cancelled. Once a computation has completed,
// the computation cannot be cancelled. If you would like to use a Future
// for the sake of cancellability but not provide a usable result, you can
// declare types of the form Future<?> and return null as a result of the
// underlying task.

/*
 * 
 * Callable
 * A task that returns a result and may throw an exception. Implementors
 * define a single method with no arguments called call.
 * 
 * The Callable interface is similar to java.lang.Runnable, in that both are
 * designed for classes whose instances are potentially executed by another
 * thread. A Runnable, however, does not return a result and cannot throw a
 * checked exception.
 * 
 */

public class App {

	public static void main(String[] args) throws InterruptedException {
		ExecutorService executor = Executors.newCachedThreadPool();

		// anonymous call of Callable
		Future<Integer> future = executor.submit(new Callable<Integer>() {

			@Override
			// return value is Integer
			public Integer call() throws TimeoutException {
				Random random = new Random();
				int duration = random.nextInt(4000);
				if (duration > 2000) {
					throw new TimeoutException("Sleeping for too long.");
				}

				System.out.println("Starting ...");
				try {
					Thread.sleep(duration);
				} catch (InterruptedException ignored) {
				}
				System.out.println("Finished.");
				return duration;
			}
		});

		executor.shutdown();
		// executor.awaitTermination(1, TimeUnit.DAYS);
		try {
			// get returned value from call()
			System.out.println("Result is: " + future.get());

		} catch (InterruptedException ignored) {
		} catch (ExecutionException e) {
			TimeoutException ex = (TimeoutException) e.getCause();
			System.out.println(ex.getMessage());
		}
	}

}