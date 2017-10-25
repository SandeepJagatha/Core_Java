package multithreading;

import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 
 * the {@link java.util.concurrent.locks.ReentrantLock} class in Java as an
 * alternative to synchronized code blocks.
 * <br>
 * {@link java.util.concurrent.locks.ReentrantLock}s let you do all the
 * stuff that you can do with {@code synchronized}, {@link Object#wait()} and
 * {@link Object#notify()}, plus some more stuff. Besides that may come in
 * handy from time to time.
 * 
 * 
 * 
 * * Source:<em>
 * http://docs.oracle.com/javase/1.5.0/docs/api/java/util/concurrent/locks/ReentrantLock.html
 * </em>
 * <br><br>
 * {@link java.util.concurrent.locks.ReentrantLock} Extended capabilities
 * include:
 * <br>
 * <ul>
 * <li>
 * The ability to have more than one {@link java.util.concurrent.locks.Condition}
 * variable per monitor.
 * </li>
 * <li>Monitors that use the synchronized keyword can only have one. This means
 * {@link java.util.concurrent.locks.ReentrantLock}s support more than one
 * {@link Object#wait()}/{@link Object#notify()} queue.
 * </li>
 * <li>
 * The ability to make the lock "fair".
 * <em>
 * "[fair] locks favor granting access to the longest-waiting
 * thread. Otherwise this lock does not guarantee any particular access order."
 * </em>
 * </li>
 * <li>Synchronized blocks are unfair.</li>
 * <li>The ability to check if the lock is being
 * held.</li>
 * <li>The ability to get the list of threads waiting on the lock.</li>
 * </ul>
 * <br><br>
 * The disadvantages of {@link java.util.concurrent.locks.ReentrantLock}s are:
 * <br>
 * <ul>
 * <li>Need to add import statement.</li>
 * <li>Need to wrap lock acquisitions in a try/finally block. This makes it more
 * ugly than the synchronized keyword.</li>
 * <li>The synchronized keyword can be put in method definitions which avoids
 * the need for a block which reduces nesting.</li>
 * </ul>
 * <br><br>
 * For more complete comparison of
 * {@link java.util.concurrent.locks.ReentrantLock}s and {@code synchronized}
 * see:<em>
 * http://guruzon.com/1/concurrency/explicit-lock-locking/difference-between-synchronized-and-reentrantlock-in-java
 * </em>
 * 
 * 
 * 
 * Source:<em>
 * http://www.journaldev.com/2377/java-lock-example-and-concurrency-lock-vs-synchronized</em>
 * <p>
 * {@link java.util.concurrent.locks.Lock}:
 * This is the base interface for Lock API. It provides all the features
 * of synchronized keyword with additional ways to create different Conditions
 * for locking, providing timeout for thread to wait for lock. Some of the
 * important methods are {@link java.util.concurrent.locks.Lock#lock()} to
 * acquire the lock, {@link java.util.concurrent.locks.Lock#unlock()} to release
 * the lock, {@link java.util.concurrent.locks.Lock#tryLock()} to wait for lock
 * for a certain period of time,
 * {@link java.util.concurrent.locks.Lock#newCondition()}
 * to create the Condition etc.
 * <p>
 * {@link java.util.concurrent.locks.ReentrantLock}:
 * This is the most widely used implementation class of Lock
 * interface. This class implements the Lock interface in similar way as
 * synchronized keyword. (see App.java for more)
 * <p>
 * {@link java.util.concurrent.locks.Condition}:
 * Condition objects are similar to Object wait-notify model with
 * additional feature to create different sets of wait. A Condition object is
 * always created by Lock object. Some of the important methods are
 * {@link java.util.concurrent.locks.Condition#await()}
 * that is similar to {@link Object#wait()}.
 * {@link java.util.concurrent.locks.Condition#signal()} and
 * {@link java.util.concurrent.locks.Condition#signalAll()}
 * that are similar to
 * {@link Object#notify()} and {@link Object#notifyAll()} methods.
 * 
 */
public class C10_ReentrantLocks {
	public static void main(String[] args) throws Exception {
		final Runner runner = new Runner();
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				try {
					runner.firstThread();
				} catch (InterruptedException ignored) {
				}
			}
		});

		Thread t2 = new Thread(new Runnable() {
			public void run() {
				try {
					runner.secondThread();
				} catch (InterruptedException ignored) {
				}
			}
		});

		t1.start();
		t2.start();
		t1.join();
		t2.join();
		runner.finished();
	}
}

class Runner {

	private int count = 0;
	private Lock lock = new ReentrantLock();
	private Condition cond = lock.newCondition();

	private void increment() {
		for (int i = 0; i < 10000; i++) {
			count++;
		}
	}

	public void firstThread() throws InterruptedException {
		lock.lock();
		System.out.println("Waiting ....");
		cond.await();
		System.out.println("Woken up!");
		try {
			increment();
		} finally {
			lock.unlock();
		}
	}

	public void secondThread() throws InterruptedException {
		Thread.sleep(1000);
		lock.lock();
		System.out.println("Press the return key!");
		new Scanner(System.in).nextLine();
		System.out.println("Got return key!");
		cond.signal();
		try {
			increment();
		} finally {
			// should be written to unlock Thread whenever signal() is called
			lock.unlock();
		}
	}

	public void finished() {
		System.out.println("Count is: " + count);
	}
}