package programming.core.java;

public class C30_InnerClasses {

	public static void main(String[] args) {
		Roobot robot = new Roobot(7);
		robot.start();

		// The syntax below will only work if Brain is
		// declared public. It is quite unusual to do this.
		// Roobot.Brain brain = robot.new Brain();
		// brain.think();

		// This is very typical Java syntax, using
		// a static inner class.
		Roobot.Battery battery = new Roobot.Battery();
		battery.charge();
	}

}

class Roobot {

	private int id;

	// Non-static nested classes have access to the enclosing
	// class's instance data. E.g. implement Iterable
	// http://www.caveofprogramming.com/java/using-iterable-java-collections-framework-video-tutorial-part-11/
	// Use them to group functionality.
	private class Brain {
		public void think() {
			System.out.println("Roobot " + id + " is thinking.");
		}
	}

	// static inner classes do not have access to instance data.
	// They are really just like "normal" classes, except that they are grouped
	// within an outer class. Use them for grouping classes together.
	public static class Battery {
		public void charge() {
			System.out.println("Battery charging...");
		}
	}

	public Roobot(int id) {
		this.id = id;
	}

	public void start() {
		System.out.println("Starting robot " + id);

		// Use Brain. We don't have an instance of brain
		// until we create one. Instances of brain are
		// always associated with instances of Roobot (the
		// enclosing class).
		Brain brain = new Brain();
		brain.think();

		final String name = "Robert";

		// Sometimes it's useful to create local classes
		// within methods. You can use them only within the method.
		class Temp {
			public void doSomething() {
				System.out.println("ID is: " + id);
				System.out.println("My name is " + name);
			}
		}

		Temp temp = new Temp();
		temp.doSomething();
	}
}