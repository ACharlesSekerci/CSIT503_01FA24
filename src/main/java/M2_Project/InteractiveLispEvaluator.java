package M2_Project;

import java.util.Scanner;

public class InteractiveLispEvaluator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a Lisp-style expression to evaluate (or 'exit' to quit):");
        while (true) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("exit")) {
                break;
            }
            Lisp_style_Prefix_Evalution_and_LispValidator LispValidator = null;
            if (LispValidator.isValidLispExpression(input)) {
                double result = Lisp_style_Prefix_Evalution_and_LispValidator.LispEvaluator.evaluateLisp(input);
                System.out.println("Evaluation Result: " + result);
            } else {
                System.out.println("Invalid Lisp expression. Please try again.");
            }
        }
        scanner.close();
    }
}
// example input for ( + ( - 6 4 ) ( * 2 3 ) )
// Evaluation Result: 8.0

// Step 9 & 10: End