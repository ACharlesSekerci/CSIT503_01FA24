// M5_Project.java
package M5_Project;

class M5_Project<T> {
    private Node firstNode;
    private int numberOfEntries;

    private class Node {
        private T data;
        private Node next;

        private Node(T dataPortion) {
            data = dataPortion;
            next = null;
        }
    }

    public M5_Project() {
        firstNode = null;
        numberOfEntries = 0;
    }

    public void add(T newEntry) {
        Node newNode = new Node(newEntry);

        if (isEmpty()) {
            // Adding first node
            firstNode = newNode;
        } else {
            // Add to end of non-empty list
            Node currentNode = firstNode;
            while (currentNode.next != null) {
                currentNode = currentNode.next;
            }
            currentNode.next = newNode;
        }
        numberOfEntries++;
    }

    public void add(int position, T newEntry) {
        if ((position >= 0) && (position <= numberOfEntries)) {
            Node newNode = new Node(newEntry);

            if (position == 0) {
                newNode.next = firstNode;
                firstNode = newNode;
            } else {
                Node nodeBefore = getNodeAt(position - 1);
                Node nodeAfter = nodeBefore.next;
                newNode.next = nodeAfter;
                nodeBefore.next = newNode;
            }
            numberOfEntries++;
        }
    }

    public T remove(int givenPosition) {
        T result = null;

        if ((givenPosition >= 0) && (givenPosition < numberOfEntries)) {
            if (givenPosition == 0) {
                result = firstNode.data;
                firstNode = firstNode.next;
            } else {
                Node nodeBefore = getNodeAt(givenPosition - 1);
                Node nodeToRemove = nodeBefore.next;
                Node nodeAfter = nodeToRemove.next;
                nodeBefore.next = nodeAfter;
                result = nodeToRemove.data;
            }
            numberOfEntries--;
        }
        return result;
    }

    public void clear() {
        firstNode = null;
        numberOfEntries = 0;
    }

    public T replace(int givenPosition, T newEntry) {
        T result = null;

        if ((givenPosition >= 0) && (givenPosition < numberOfEntries)) {
            Node desiredNode = getNodeAt(givenPosition);
            result = desiredNode.data;
            desiredNode.data = newEntry;
        }
        return result;
    }

    public T getEntry(int givenPosition) {
        T result = null;

        if ((givenPosition >= 0) && (givenPosition < numberOfEntries)) {
            result = getNodeAt(givenPosition).data;
        }
        return result;
    }

    @SuppressWarnings("unchecked")
    public T[] toArray() {
        T[] result = (T[])new Object[numberOfEntries];

        int index = 0;
        Node currentNode = firstNode;
        while (currentNode != null) {
            result[index] = currentNode.data;
            currentNode = currentNode.next;
            index++;
        }
        return result;
    }

    public boolean contains(T anEntry) {
        boolean found = false;
        Node currentNode = firstNode;

        while (!found && (currentNode != null)) {
            if (anEntry.equals(currentNode.data))
                found = true;
            else
                currentNode = currentNode.next;
        }
        return found;
    }

    public int getLength() {
        return numberOfEntries;
    }

    public boolean isEmpty() {
        return numberOfEntries == 0;
    }

    private Node getNodeAt(int givenPosition) {
        Node currentNode = firstNode;

        for (int counter = 0; counter < givenPosition; counter++)
            currentNode = currentNode.next;

        return currentNode;
    }
}

// ListTest.java


public class Radix_Sort {
    public static void main(String[] args) {
        System.out.println("Testing add(T newEntry):");
        M5_Project<String> list = new M5_Project<String>();

        // Test adding entries
        list.add("First");
        list.add("Second");
        list.add("Third");

        // Display the list
        displayList(list);
    }

    private static void displayList(M5_Project<String> list) {
        System.out.println("List contents:");
        Object[] array = list.toArray();
        for (Object item : array) {
            System.out.print(item + " ");
        }
        System.out.println("\nLength: " + list.getLength());
    }
}

// Author : Ahmet C Sekerci