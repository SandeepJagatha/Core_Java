package collections.framework;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

public class C8_NaturalOrderingComparable {

	public static void main(String[] args) {
		List<Being> list = new ArrayList<Being>();
		SortedSet<Being> set = new TreeSet<Being>();

		addElements(list);
		addElements(set);

		Collections.sort(list);

		showElements(list);
		System.out.println();
		showElements(set);
	}

	private static void addElements(Collection<Being> col) {
		col.add(new Being("Joe"));
		col.add(new Being("Sue"));
		col.add(new Being("Juliet"));
		col.add(new Being("Clare"));
		col.add(new Being("Mike"));
	}

	private static void showElements(Collection<Being> col) {
		for (Being element : col) {
			System.out.println(element);
		}
	}

}

class Being implements Comparable<Being> {
    private String name;
    
    public Being(String name) {
        this.name = name;
    }
    
    public String toString() {
        return name;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final Being other = (Being) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }

    @Override
    public int compareTo(Being person) {
        int len1 = name.length();
        int len2 = person.name.length();
        
        if(len1 > len2) {
            return 1;
        }
        else if(len1 < len2) {
            return -1;
        }
        else {
            return name.compareTo(person.name);
        }
    }
}


/*
Joe
Sue
Mike
Clare
Juliet

Joe
Sue
Mike
Clare
Juliet
*/


