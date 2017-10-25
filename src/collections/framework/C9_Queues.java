package collections.framework;

import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class C9_Queues {

	public static void main(String[] args) {
		// (head) <- ooooooooo <- (tail) FIFO (first in, first out)

		Queue<Integer> q1 = new ArrayBlockingQueue<Integer>(3);

		// Throws NoSuchElement exception --- no items in queue yet
		// System.out.println("Head of queue is: " + q1.element());

		q1.add(10);
		q1.add(20);
		q1.add(30);

		System.out.println("Head of queue is: " + q1.element());

		try {
			q1.add(40);
		} catch (IllegalStateException e) {
			System.out.println("Tried to add too many items to the queue.");
		}

		for (Integer value : q1) {
			System.out.println("Queue value: " + value);
		}

		System.out.println("Removed from queue: " + q1.remove());
		System.out.println("Removed from queue: " + q1.remove());
		System.out.println("Removed from queue: " + q1.remove());

		try {
			System.out.println("Removed from queue: " + q1.remove());
		} catch (NoSuchElementException e) {
			System.out.println("Tried to remove too many items from queue");
		}

		////////////////////////////////////////////////////////////////////

		Queue<Integer> q2 = new ArrayBlockingQueue<Integer>(2);

		System.out.println("Queue 2 peek: " + q2.peek());

		q2.offer(10);
		q2.offer(20);

		System.out.println("Queue 2 peek: " + q2.peek());

		if (q2.offer(30) == false) {
			System.out.println("Offer failed to add third item.");
		}

		for (Integer value : q2) {
			System.out.println("Queue 2 value: " + value);
		}

		System.out.println("Queue 2 poll: " + q2.poll());
		System.out.println("Queue 2 poll: " + q2.poll());
		System.out.println("Queue 2 poll: " + q2.poll());
	}

}

/*
Head of queue is: 10
Tried to add too many items to the queue.
Queue value: 10
Queue value: 20
Queue value: 30
Removed from queue: 10
Removed from queue: 20
Removed from queue: 30
Tried to remove too many items from queue
Queue 2 peek: null
Queue 2 peek: 10
Offer failed to add third item.
Queue 2 value: 10
Queue 2 value: 20
Queue 2 poll: 10
Queue 2 poll: 20
Queue 2 poll: null

*/
