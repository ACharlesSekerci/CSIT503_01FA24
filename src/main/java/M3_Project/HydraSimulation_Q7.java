package M3_Project;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HydraSimulation_Q7 {
    // Question 7: Hydra simulation
    public static void main(String[] args) {
        List<String> bag = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        // Initial setup: read one word from keyboard
        System.out.print("Enter the initial word to represent the Hydra: ");
        String initialWord = scanner.nextLine();
        bag.add(initialWord);

        // Simulate the process
        while (!bag.isEmpty()) {
            String currentWord = bag.remove(0);

            // If the word has only one letter, it is not replaced
            if (currentWord.length() > 1) {
                String newWord = currentWord.substring(1); // Remove the first letter
                bag.add(newWord);
                bag.add(newWord);
            }

            // Print current state of the bag
            System.out.println("Current bag: " + bag);
        }

        System.out.println("The Hydra is dead!");
    }
}

// Author Ahmet C Sekerci for Question 7
