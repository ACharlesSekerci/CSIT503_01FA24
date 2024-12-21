package M5_Project;

public class ListTest {
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
// Author: Ahmet Sekerci