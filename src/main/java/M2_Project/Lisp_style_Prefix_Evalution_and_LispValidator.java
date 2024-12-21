package M2_Project;

import java.util.Stack;

public class Lisp_style_Prefix_Evalution_and_LispValidator {

//JDK18 update need for static double (String expression)
    // Step 7: Start - Lisp-style Prefix Evaluation


    public class LispEvaluator {

        public static double evaluateLisp(String expression) {
            String[] tokens = expression.split(" ");
            Stack<Object> stack = new Stack<>();

            for (int i = tokens.length - 1; i >= 0; i--) {
                String token = tokens[i];

                if (token.equals("(")) {
                    double result = 0;
                    String operator = (String) stack.pop();

                    if (operator.equals("+")) {
                        result = 0;
                        while (!stack.isEmpty() && stack.peek() instanceof Double) {
                            result += (double) stack.pop();
                        }
                    } else if (operator.equals("-")) {
                        result = (double) stack.pop();
                        while (!stack.isEmpty() && stack.peek() instanceof Double) {
                            result -= (double) stack.pop();
                        }
                    } else if (operator.equals("*")) {
                        result = 1;
                        while (!stack.isEmpty() && stack.peek() instanceof Double) {
                            result *= (double) stack.pop();
                        }
                    } else if (operator.equals("/")) {
                        result = (double) stack.pop();
                        while (!stack.isEmpty() && stack.peek() instanceof Double) {
                            result /= (double) stack.pop();
                        }
                    }
                    stack.pop(); // Pop the closing parenthesis
                    stack.push(result);
                } else if (token.matches("-?\\d+(\\.\\d+)?")) {
                    stack.push(Double.parseDouble(token));
                } else if (token.equals(")") || token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                    stack.push(token);
                }
            }

            return (double) stack.pop();
        }

        public static void main(String[] args) {
            String expression = "( + ( - 6 ( * 2 3 4 ) ( / ( + 3 ) ( * -2 3 1 ) ) ) )";
            System.out.println("Lisp Evaluation Result: " + evaluateLisp(expression));
        }
    }
// Step 7: End

// LispValidator
    public static boolean isValidLispExpression(String expression) {
        Stack<String> stack = new Stack<>();
        String[] tokens = expression.split(" ");

        for (String token : tokens) {
            if (token.equals("(")) {
                stack.push(token);
            } else if (token.equals(")")) {
                if (stack.isEmpty() || !stack.pop().equals("(")) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String expression = "( + ( - height (* 3 3 4) (/ 3 width length) (* radius radius) ) )";
        System.out.println("Is valid Lisp expression? " + isValidLispExpression(expression));
    }
}

