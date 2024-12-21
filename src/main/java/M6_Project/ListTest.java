package M6_Project;

import java.util.ArrayList;
import java.util.Vector;
import java.util.Arrays;

/**
 * Interface for List ADT operations
 * @author Ahmet C Sekerci
 */
interface ListInterface<T> {
    void add(T newEntry);                // Add a new entry to the end
    void add(int position, T newEntry);  // Add a new entry at a specific position
    T remove(int position);              // Remove an entry at a specific position
    void clear();                        // Remove all entries
    T replace(int position, T newEntry); // Replace an entry at a specific position
    T getEntry(int position);            // Retrieve an entry at a specific position
    T[] toArray();                       // Convert list to array
    boolean contains(T anEntry);         // Check if list contains entry
    int getLength();                     // Get number of entries
    boolean isEmpty();                   // Check if list is empty
}

/**
 * Implementation of ListInterface using Vector
 * Project 1
 * @author [Your Name Here]
 */
class VectorList<T> implements ListInterface<T> {
    private Vector<T> list;

    public VectorList() {
        list = new Vector<>();
    }

    // a. Program tests add(T newEntry)
    @Override
    public void add(T newEntry) {
        list.add(newEntry);
    }

    // b. Program tests add(int newPosition, T newEntry)
    @Override
    public void add(int position, T newEntry) {
        if (position >= 0 && position <= list.size()) {
            list.add(position, newEntry);
        } else {
            throw new IndexOutOfBoundsException("Invalid position: " + position);
        }
    }

    // c. Program tests remove(int givenPosition)
    @Override
    public T remove(int position) {
        if (position >= 0 && position < list.size()) {
            return list.remove(position);
        } else {
            throw new IndexOutOfBoundsException("Invalid position: " + position);
        }
    }

    // d. Program tests clear()
    @Override
    public void clear() {
        list.clear();
    }

    // e. Program tests replace(int givenPosition, T newEntry)
    @Override
    public T replace(int position, T newEntry) {
        if (position >= 0 && position < list.size()) {
            return list.set(position, newEntry);
        } else {
            throw new IndexOutOfBoundsException("Invalid position: " + position);
        }
    }

    // f. Program tests getEntry(int givenPosition)
    @Override
    public T getEntry(int position) {
        if (position >= 0 && position < list.size()) {
            return list.get(position);
        } else {
            throw new IndexOutOfBoundsException("Invalid position: " + position);
        }
    }

    // g. Program tests toArray()
    @Override
    @SuppressWarnings("unchecked")
    public T[] toArray() {
        return (T[]) list.toArray();
    }

    // h. Program tests contains(T anEntry)
    @Override
    public boolean contains(T anEntry) {
        return list.contains(anEntry);
    }

    // i. Program tests getLength()
    @Override
    public int getLength() {
        return list.size();
    }

    // j. Program tests isEmpty()
    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public String toString() {
        return list.toString();
    }
}

/**
 * Implementation of ListInterface using ArrayList
 * Project 2
 * @author [Your Name Here]
 */
class ArrayListList<T> implements ListInterface<T> {
    private ArrayList<T> list;

    public ArrayListList() {
        list = new ArrayList<>();
    }

    // a. Program tests add(T newEntry)
    @Override
    public void add(T newEntry) {
        list.add(newEntry);
    }

    // b. Program tests add(int newPosition, T newEntry)
    @Override
    public void add(int position, T newEntry) {
        if (position >= 0 && position <= list.size()) {
            list.add(position, newEntry);
        } else {
            throw new IndexOutOfBoundsException("Invalid position: " + position);
        }
    }

    // c. Program tests remove(int givenPosition)
    @Override
    public T remove(int position) {
        if (position >= 0 && position < list.size()) {
            return list.remove(position);
        } else {
            throw new IndexOutOfBoundsException("Invalid position: " + position);
        }
    }

    // d. Program tests clear()
    @Override
    public void clear() {
        list.clear();
    }

    // e. Program tests replace(int givenPosition, T newEntry)
    @Override
    public T replace(int position, T newEntry) {
        if (position >= 0 && position < list.size()) {
            return list.set(position, newEntry);
        } else {
            throw new IndexOutOfBoundsException("Invalid position: " + position);
        }
    }

    // f. Program tests getEntry(int givenPosition)
    @Override
    public T getEntry(int position) {
        if (position >= 0 && position < list.size()) {
            return list.get(position);
        } else {
            throw new IndexOutOfBoundsException("Invalid position: " + position);
        }
    }

    // g. Program tests toArray()
    @Override
    @SuppressWarnings("unchecked")
    public T[] toArray() {
        return (T[]) list.toArray();
    }

    // h. Program tests contains(T anEntry)
    @Override
    public boolean contains(T anEntry) {
        return list.contains(anEntry);
    }

    // i. Program tests getLength()
    @Override
    public int getLength() {
        return list.size();
    }

    // j. Program tests isEmpty()
    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public String toString() {
        return list.toString();
    }
}

/**
 * Main test class for both implementations
 * @author [Your Name Here]
 */
public class ListTest {
    public static void main(String[] args) {
        System.out.println("Testing Vector Implementation:");
        testImplementation(new VectorList<>());

        System.out.println("\nTesting ArrayList Implementation:");
        testImplementation(new ArrayListList<>());
    }

    private static void testImplementation(ListInterface<String> list) {
        // Add initial elements
        list.add("X");
        list.add("Y");
        list.add("C");

        // Remove element and show
        String removed = list.remove(2);
        System.out.println("Removed: " + removed);

        // Clear and show
        list.clear();
        System.out.println("After clear: " + list);

        // Add new elements and replace
        list.add("X");
        list.add("Y");
        list.replace(0, "Z");
        System.out.println("After replace: " + list);

        // Get entry at position 0
        System.out.println("Entry at 0: " + list.getEntry(0));

        // Test contains
        System.out.println("Contains A: " + list.contains("A"));

        // Get length and isEmpty status
        System.out.println("Length: " + list.getLength());
        System.out.println("Is Empty: " + list.isEmpty());

        // Show as array and list
        System.out.println("Array: " + Arrays.toString(list.toArray()));
        System.out.println("List: " + list);
    }
}

 // author Ahmet C Sekerci