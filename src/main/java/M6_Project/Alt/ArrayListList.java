package M6_Project.Alt;// Project 1: Implementation using Vector
import java.util.ArrayList;
import java.util.Vector;
import java.util.ArrayList;
// Define the ListInterface
interface ListInterface<T> {
    void add(T newEntry);                // Add a new entry to the end
    void add(int position, T newEntry); // Add a new entry at a specific position
    T remove(int position);             // Remove an entry at a specific position
    void clear();                       // Remove all entries
    T replace(int position, T newEntry);// Replace an entry at a specific position
    T getEntry(int position);           // Retrieve an entry at a specific position
    boolean contains(T anEntry);        // Check if the list contains a specific entry
    int getLength();                    // Get the number of entries
    boolean isEmpty();                  // Check if the list is empty
    Object[] toArray();                 // Convert list to an array
}

// Implementation of ListInterface using Vector
class VectorList<T> implements ListInterface<T> {
    private Vector<T> list;

    // Constructor
    public VectorList() {
        list = new Vector<>();
    }

    // a. Program tests add(T newEntry)
    @Override
    public void add(T newEntry) {
        list.add(newEntry);
    }
    // End of a. Program tests add(T newEntry)

    // b. Program tests add(int newPosition, T newEntry)
    @Override
    public void add(int position, T newEntry) {
        if (position >= 0 && position <= list.size()) {
            list.add(position, newEntry);
        } else {
            throw new IndexOutOfBoundsException("Invalid position.");
        }
    }
    // End of b. Program tests add(int newPosition, T newEntry)

    // c. Program tests remove(int givenPosition)
    @Override
    public T remove(int position) {
        if (position >= 0 && position < list.size()) {
            return list.remove(position);
        } else {
            throw new IndexOutOfBoundsException("Invalid position.");
        }
    }
    // End of c. Program tests remove(int givenPosition)

    // d. Program tests clear()
    @Override
    public void clear() {
        list.clear();
    }
    // End of d. Program tests clear()

    // e. Program tests replace(int givenPosition, T newEntry)
    @Override
    public T replace(int position, T newEntry) {
        if (position >= 0 && position < list.size()) {
            return list.set(position, newEntry);
        } else {
            throw new IndexOutOfBoundsException("Invalid position.");
        }
    }
    // End of e. Program tests replace(int givenPosition, T newEntry)

    // f. Program tests getEntry(int givenPosition)
    @Override
    public T getEntry(int position) {
        if (position >= 0 && position < list.size()) {
            return list.get(position);
        } else {
            throw new IndexOutOfBoundsException("Invalid position.");
        }
    }
    // End of f. Program tests getEntry(int givenPosition)

    // g. Program tests toArray()
    @Override
    public Object[] toArray() {
        return list.toArray();
    }
    // End of g. Program tests toArray()

    // h. Program tests contains(T anEntry)
    @Override
    public boolean contains(T anEntry) {
        return list.contains(anEntry);
    }
    // End of h. Program tests contains(T anEntry)

    // i. Program tests getLength()
    @Override
    public int getLength() {
        return list.size();
    }
    // End of i. Program tests getLength()

    // j. Program tests isEmpty()
    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }
    // End of j. Program tests isEmpty()

    @Override
    public String toString() {
        return list.toString();
    }
}

// Main method to test Vector implementation
class VectorListTest {
    public static void main(String[] args) {
        // Author: Ahmet C. Sekerci
        VectorList<String> myList = new VectorList<>();

        // a. Program tests add(T newEntry)
        myList.add("A");
        myList.add("B");
        myList.add(1, "C");

        // c. Program tests remove(int givenPosition)
        System.out.println("Removed: " + myList.remove(1));

        // d. Program tests clear()
        myList.clear();
        System.out.println("After clear: " + myList);

        // e. Program tests replace(int givenPosition, T newEntry)
        myList.add("X");
        myList.add("Y");
        myList.replace(0, "Z");
        System.out.println("After replace: " + myList);

        // f. Program tests getEntry(int givenPosition)
        System.out.println("Entry at 0: " + myList.getEntry(0));

        // h. Program tests contains(T anEntry)
        System.out.println("Contains A: " + myList.contains("A"));

        // i. Program tests getLength() and j. Program tests isEmpty()
        System.out.println("Length: " + myList.getLength());
        System.out.println("Is Empty: " + myList.isEmpty());

        // g. Program tests toArray()
        System.out.println("Array: " + java.util.Arrays.toString(myList.toArray()));

        System.out.println("List: " + myList);
    }
}

// Project 2: Implementation using ArrayList


// Implementation of ListInterface using ArrayList
public class ArrayListList<T> implements ListInterface<T> {
    private ArrayList<T> list;

    // Constructor
    public ArrayListList() {
        list = new ArrayList<>();
    }

    // a. Program tests add(T newEntry)
    @Override
    public void add(T newEntry) {
        list.add(newEntry);
    }
    // End of a. Program tests add(T newEntry)

    // b. Program tests add(int newPosition, T newEntry)
    @Override
    public void add(int position, T newEntry) {
        if (position >= 0 && position <= list.size()) {
            list.add(position, newEntry);
        } else {
            throw new IndexOutOfBoundsException("Invalid position.");
        }
    }
    // End of b. Program tests add(int newPosition, T newEntry)

    // c. Program tests remove(int givenPosition)
    @Override
    public T remove(int position) {
        if (position >= 0 && position < list.size()) {
            return list.remove(position);
        } else {
            throw new IndexOutOfBoundsException("Invalid position.");
        }
    }
    // End of c. Program tests remove(int givenPosition)

    // d. Program tests clear()
    @Override
    public void clear() {
        list.clear();
    }
    // End of d. Program tests clear()

    // e. Program tests replace(int givenPosition, T newEntry)
    @Override
    public T replace(int position, T newEntry) {
        if (position >= 0 && position < list.size()) {
            return list.set(position, newEntry);
        } else {
            throw new IndexOutOfBoundsException("Invalid position.");
        }
    }
    // End of e. Program tests replace(int givenPosition, T newEntry)

    // f. Program tests getEntry(int givenPosition)
    @Override
    public T getEntry(int position) {
        if (position >= 0 && position < list.size()) {
            return list.get(position);
        } else {
            throw new IndexOutOfBoundsException("Invalid position.");
        }
    }
    // End of f. Program tests getEntry(int givenPosition)

    // g. Program tests toArray()
    @Override
    public Object[] toArray() {
        return list.toArray();
    }
    // End of g. Program tests toArray()

    // h. Program tests contains(T anEntry)
    @Override
    public boolean contains(T anEntry) {
        return list.contains(anEntry);
    }
    // End of h. Program tests contains(T anEntry)

    // i. Program tests getLength()
    @Override
    public int getLength() {
        return list.size();
    }
    // End of i. Program tests getLength()

    // j. Program tests isEmpty()
    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }
    // End of j. Program tests isEmpty()

    @Override
    public String toString() {
        return list.toString();
    }

    // Main method to test ArrayList implementation
    public static void main(String[] args) {
        // Author: Ahmet C. Sekerci
        ArrayListList<String> myList = new ArrayListList<>();

        // a. Program tests add(T newEntry)
        myList.add("A");
        myList.add("B");
        myList.add(1, "C");

        // c. Program tests remove(int givenPosition)
        System.out.println("Removed: " + myList.remove(1));

        // d. Program tests clear()
        myList.clear();
        System.out.println("After clear: " + myList);

        // e. Program tests replace(int givenPosition, T newEntry)
        myList.add("X");
        myList.add("Y");
        myList.replace(0, "Z");
        System.out.println("After replace: " + myList);

        // f. Program tests getEntry(int givenPosition)
        System.out.println("Entry at 0: " + myList.getEntry(0));

        // h. Program tests contains(T anEntry)
        System.out.println("Contains A: " + myList.contains("A"));

        // i. Program tests getLength() and j. Program tests isEmpty()
        System.out.println("Length: " + myList.getLength());
        System.out.println("Is Empty: " + myList.isEmpty());

        // g. Program tests toArray()
        System.out.println("Array: " + java.util.Arrays.toString(myList.toArray()));

        System.out.println("List: " + myList);
    }
}
