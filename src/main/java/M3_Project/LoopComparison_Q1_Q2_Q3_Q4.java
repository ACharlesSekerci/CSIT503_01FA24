package M3_Project;

import java.util.Arrays;
import java.util.Date;

public class LoopComparison_Q1_Q2_Q3_Q4 {
    // Question 2: Main method to run the comparison
    public static void main(String[] args) {
        int n = 1;
        long timeLoopA, timeLoopB;

        while (true) {
            // Time Loop A
            Date current = new Date();
            long startTime = current.getTime();
            loopA(n);
            current = new Date();
            long stopTime = current.getTime();
            timeLoopA = stopTime - startTime;

            // Time Loop B
            current = new Date();
            startTime = current.getTime();
            loopB(n);
            current = new Date();
            stopTime = current.getTime();
            timeLoopB = stopTime - startTime;

            // Print results for the current value of n
            System.out.println("n: " + n + ", Loop A Time: " + timeLoopA + " ms, Loop B Time: " + timeLoopB + " ms");

            // Check if Loop B is faster than Loop A
            if (timeLoopB < timeLoopA) {
                System.out.println("Loop B is faster for n = " + n);
                break;
            }

            n++;
        }
    }

    // Loop A implementation
    public static void loopA(int n) {
        long sum = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= 10000; j++) {
                sum = sum + j;
            }
        }
    }

    // Question 3: Updated Loop B implementation
    public static void loopB(int n) {
        long sum = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= n; k++) {
                    sum = sum + k;
                }
            }
        }
    }

    // Question 4: toArray method using manual array copy
    public static <T> T[] toArrayManual(T[] bag, int numberOfEntries) {
        @SuppressWarnings("unchecked")
        T[] result = (T[]) new Object[numberOfEntries];
        for (int index = 0; index < numberOfEntries; index++) {
            result[index] = bag[index];
        }
        return result;
    }

    // Question 4: toArray method using Arrays.copyOf
    public static <T> T[] toArrayCopyOf(T[] bag) {
        return Arrays.copyOf(bag, bag.length);
    }
}
        // Autor Ahmet C Sekerci for Question 1,2,3,4