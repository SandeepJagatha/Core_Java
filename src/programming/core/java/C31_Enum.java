package programming.core.java;

public class C31_Enum {
	public static void main(String[] args) {

		Animall animal = Animall.DOG;

		switch (animal) {
		case CAT:
			System.out.println("Cat");
			break;
		case DOG:
			System.out.println("Dog");
			break;
		case MOUSE:
			break;
		default:
			break;

		}

		System.out.println(Animall.DOG); // This animal is called: Fido
		System.out.println("Enum name as a string: " + Animall.DOG.name()); // Enum name as a string: DOG

		System.out.println(Animall.DOG.getClass()); // class programming.core.java.Animall

		System.out.println(Animall.DOG instanceof Enum); // true

		System.out.println(Animall.MOUSE.getName()); // Jerry

		Animall animal2 = Animall.valueOf("CAT"); // This animal is called: Fergus

		System.out.println(animal2);
	}
}

enum Animall {
    CAT("Fergus"), DOG("Fido"), MOUSE("Jerry");
    
    private String name;
    
    Animall(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    
    public String toString() {
        return "This animal is called: " + name;
    }
}