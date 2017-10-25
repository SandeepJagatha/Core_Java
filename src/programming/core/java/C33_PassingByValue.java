package programming.core.java;

public class C33_PassingByValue {

	public static void main(String[] args) {
		C33_PassingByValue app = new C33_PassingByValue();

		// ===========================================

		int value = 7;
		System.out.println("1. Value is: " + value);

		app.show(value);

		System.out.println("4. Value is: " + value);

		// ===========================================
		System.out.println();

		Human human = new Human("Bob");
		System.out.println("1. Human is: " + human);

		app.show(human);

		System.out.println("4. Human is: " + human);
	}

	public void show(int value) {
		System.out.println("2. Value is: " + value);

		value = 8;

		System.out.println("3. Value is: " + value);
	}

	public void show(Human human) {
		System.out.println("2. Human is: " + human);

		human = new Human("Mike");
		human.setName("Sue");

		System.out.println("3. Human is: " + human);

	}
}

class Human {
    private String name;

    public Human(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Human [name=" + name + "]";
    }
}