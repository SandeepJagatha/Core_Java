package programming.core.java;

import java.util.ArrayList;

class Device {

    @Override
    public String toString() {
        return "I am a machine";
    }
    
    public void start() {
        System.out.println("Device starting.");
    }

}

class Cam extends Device {
    @Override
    public String toString() {
        return "I am a camera";
    }
    
    public void snap() {
        System.out.println("snap!");
    }
}

// Wildcards are mostly useful when you want to pass parametrized 
// classes to methods and those classes may contain various kinds 
// of subtype or supertype objects. 

public class C25_GenericsWildcards {

	public static void main(String[] args) {
		ArrayList<Device> list1 = new ArrayList<Device>();

        list1.add(new Device());
        list1.add(new Device());

        ArrayList<Cam> list2 = new ArrayList<Cam>();

        list2.add(new Cam());
        list2.add(new Cam());

        showList(list2);
        showList2(list1);
        showList3(list1);
	}
	
	public static void showList(ArrayList<? extends Device> list) {
        for (Device value : list) {
            System.out.println(value);
            value.start();
        }

    }
    
    public static void showList2(ArrayList<? super Cam> list) {
        for (Object value : list) {
            System.out.println(value);
        }
    }
    
    public static void showList3(ArrayList<?> list) {
        for (Object value : list) {
            System.out.println(value);
        }
    }

}
