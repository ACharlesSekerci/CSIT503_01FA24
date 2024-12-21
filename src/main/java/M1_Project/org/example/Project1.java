package M1_Project.org.example;public class Project1 {	public static void main(String[] args) {		// a. Test getCurrentSize()		LinkedBag<String> bag = new LinkedBag<>();		System.out.println("Initial bag size (should be 0): " + bag.getCurrentSize());		// b. Test isEmpty()		System.out.println("Is the bag empty? (should be true): " + bag.isEmpty());		// c. Test add(T newEntry)		System.out.println("Adding 'Apple', 'Banana', 'Cherry', 'Apple' to the bag...");		bag.add("Apple");		bag.add("Banana");		bag.add("Cherry");		bag.add("Apple");		System.out.println("Bag size after adding items (should be 4): " + bag.getCurrentSize());		// d. Test remove() (unspecified entry)		System.out.println("Removing an unspecified item from the bag...");		String removedItem = bag.remove();		System.out.println("Removed item: " + removedItem);		System.out.println("Bag size after removal (should be 3): " + bag.getCurrentSize());		// e. Test remove(T anEntry) (removing a specific entry)		System.out.println("Removing one occurrence of 'Apple' from the bag...");		boolean isRemoved = bag.remove("Apple");		System.out.println("Was 'Apple' removed? (should be true): " + isRemoved);		System.out.println("Frequency of 'Apple' after removal (should be 1): " + bag.getFrequencyOf("Apple"));		// f. Test clear()		System.out.println("Clearing the bag...");		bag.clear();		System.out.println("Bag size after clearing (should be 0): " + bag.getCurrentSize());		System.out.println("Is the bag empty? (should be true): " + bag.isEmpty());		// g. Test getFrequencyOf(T anEntry)		System.out.println("Adding 'Apple', 'Banana', 'Cherry', 'Apple' to the bag again...");		bag.add("Apple");		bag.add("Banana");		bag.add("Cherry");		bag.add("Apple");		System.out.println("Frequency of 'Apple' (should be 2): " + bag.getFrequencyOf("Apple"));		// h. Test contains(T anEntry)		System.out.println("Does the bag contain 'Banana'? (should be true): " + bag.contains("Banana"));		System.out.println("Does the bag contain 'Grapes'? (should be false): " + bag.contains("Grapes"));		// i. Test toArray()		System.out.println("Retrieving all items in the bag as an array...");		Object[] bagArray = bag.toArray();		System.out.print("Bag contents: ");		for (Object item : bagArray) {			System.out.print(item + " ");		}		System.out.println();		// j. Program doesn't present errors and warnings - ensure code compiles and runs without any issues.		// k. Program comments - Author: Ahmet Sekerci	}}