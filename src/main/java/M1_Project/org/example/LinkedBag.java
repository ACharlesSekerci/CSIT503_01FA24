package M1_Project.org.example;

import java.util.NoSuchElementException;

public class LinkedBag<T> {
    private Node<T> firstNode; // Head reference to the linked list
    private int numberOfEntries;

    // 2. Listing 3-4 shows the inner class Node with set and get methods.
    // Node class for linked structure
    private static class Node<T> {
        private T data; // Entry in bag
        private Node<T> next; // Link to next node

        private Node(T dataPortion) {
            this(dataPortion, null);
        }

        private Node(T dataPortion, Node<T> nextNode) {
            data = dataPortion;
            next = nextNode;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }
    }

    // 2. Default constructor
    public LinkedBag() {
        firstNode = null;
        numberOfEntries = 0;
    }

    // 3. Adds a new entry to this bag.
    public boolean add(T newEntry) {
        Node<T> newNode = new Node<>(newEntry);
        newNode.setNext(firstNode); // Make new node reference rest of chain
        firstNode = newNode; // New node is at beginning of chain
        numberOfEntries++;
        return true;
    }

    // 3. Removes one unspecified entry from this bag, if possible.
    public T remove() {
        if (isEmpty()) {
            throw new NoSuchElementException("Bag is empty, nothing to remove.");
        }
        T result = firstNode.getData();
        firstNode = firstNode.getNext(); // Remove first node from chain
        numberOfEntries--;
        return result;
    }

    // 3. Removes one occurrence of a given entry from this bag, if possible.
    public boolean remove(T anEntry) {
        Node<T> currentNode = firstNode;
        Node<T> nodeBefore = null;
        while (currentNode != null) {
            if (anEntry.equals(currentNode.getData())) {
                if (nodeBefore == null) {
                    firstNode = currentNode.getNext(); // Remove first node
                } else {
                    nodeBefore.setNext(currentNode.getNext()); // Bypass the current node
                }
                numberOfEntries--;
                return true;
            }
            nodeBefore = currentNode;
            currentNode = currentNode.getNext();
        }
        return false;
    }

    // 3. Removes all entries from this bag.
    public void clear() {
        while (!isEmpty()) {
            remove();
        }
    }

    // 3. Gets the current number of entries in this bag.
    public int getCurrentSize() {
        return numberOfEntries;
    }

    // 3. Counts the number of times a given entry appears in this bag.
    public int getFrequencyOf(T anEntry) {
        int frequency = 0;
        Node<T> currentNode = firstNode;
        while (currentNode != null) {
            if (anEntry.equals(currentNode.getData())) {
                frequency++;
            }
            currentNode = currentNode.getNext();
        }
        return frequency;
    }

    // 3. Tests whether this bag contains a given entry.
    public boolean contains(T anEntry) {
        Node<T> currentNode = firstNode;
        while (currentNode != null) {
            if (anEntry.equals(currentNode.getData())) {
                return true;
            }
            currentNode = currentNode.getNext();
        }
        return false;
    }

    // 3. Checks whether this bag is empty.
    public boolean isEmpty() {
        return numberOfEntries == 0;
    }

    // 3. Creates an array of all entries in this bag.
    public T[] toArray() {
        @SuppressWarnings("unchecked")
        T[] result = (T[]) new Object[numberOfEntries];
        int index = 0;
        Node<T> currentNode = firstNode;
        while (currentNode != null) {
            result[index] = currentNode.getData();
            index++;
            currentNode = currentNode.getNext();
        }
        return result;
    }

    // 1. Write a program that thoroughly tests the class LinkedBag
    // Main method to test LinkedBag functionality
    public static void main(String[] args) {
        LinkedBag<String> bag = new LinkedBag<>();
        System.out.println("Adding elements to the bag...");
        bag.add("Apple");
        bag.add("Banana");
        bag.add("Cherry");
        bag.add("Apple");

        System.out.println("Current bag size: " + bag.getCurrentSize());
        System.out.println("Frequency of 'Apple': " + bag.getFrequencyOf("Apple"));
        System.out.println("Does the bag contain 'Banana'? " + bag.contains("Banana"));

        System.out.println("Removing an 'Apple'...");
        bag.remove("Apple");
        System.out.println("Frequency of 'Apple' after removal: " + bag.getFrequencyOf("Apple"));

        System.out.println("Clearing the bag...");
        bag.clear();
        System.out.println("Current bag size after clearing: " + bag.getCurrentSize());
    }
}

// 3. Listing 3-5 shows Node as a class within a package that also contains LinkedBag.
// 4. Revise Node and LinkedBag as described in Segment 3.29.
// 5. Define a class LinkedSet that represents a set and implements the interface given in Listing 1-5 of Chapter 1.
// 6. Repeat the previous project, but use a chain of linked nodes instead of the class LinkedBag.
// 7. Define a class DoublyLinkedBag that implements the ADT bag by using a doubly linked chain, as shown in Figure 3-11.
// 8. Repeat the previous project, but define set and get methods in the inner class of nodes.
// 9. Use the classes for a set or a bag, as defined in this chapter or described in the previous projects, to create a spell checker.

   // k. Program comments - Author: Ahmet Sekerci
