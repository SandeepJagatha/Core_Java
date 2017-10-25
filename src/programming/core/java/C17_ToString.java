package programming.core.java;

class Frogg {

	private int id;
	private String name;

	public Frogg(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public String toString() {
		return String.format("%-4d: %s", id, name);

		/*
		 * StringBuilder sb = new StringBuilder();
		 * sb.append(id).append(": ").append(name);
		 * 
		 * return sb.toString();
		 */
	}
}

public class C17_ToString {
	public static void main(String[] args) {
		Frogg frog1 = new Frogg(7, "Freddy");
		Frogg frog2 = new Frogg(5, "Roger");

		System.out.println(frog1);
		System.out.println(frog2);
	}
}
