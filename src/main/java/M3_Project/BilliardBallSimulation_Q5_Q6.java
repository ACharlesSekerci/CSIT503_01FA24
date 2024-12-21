package M3_Project;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BilliardBallSimulation_Q5_Q6 {
    // Question 5: Billiard ball simulation
    public static void main(String[] args) {
        List<Integer> bag = new ArrayList<>();
        Random random = new Random();

        // Initial setup: add a few numbered balls to the bag
        int initialBalls = 10;
        for (int i = 1; i <= initialBalls; i++) {
            bag.add(i);
        }

        // Simulate the process
        while (!bag.isEmpty()) {
            int ballIndex = random.nextInt(bag.size());
            int ballNumber = bag.get(ballIndex);

            // Remove the selected ball
            bag.remove(ballIndex);

            // Replace with n / 2 balls, where n is the value of the removed ball
            int newBallCount = ballNumber / 2;
            for (int i = 0; i < newBallCount; i++) {
                bag.add(newBallCount);
            }

            // Print current state of the bag
            System.out.println("Current bag: " + bag);
        }
    }
}
// Autor: Ahmet C Sekerci for question 5,6