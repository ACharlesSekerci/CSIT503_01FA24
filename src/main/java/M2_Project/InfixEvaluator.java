package M2_Project;

import java.util.Stack;

// Step 1: End

// Step 2: Start - Implement OurStack using java.util.Stack
import java.util.Stack;

// Step 2: End

// Step 3: End

// Step 4: End

// Step 5: Start - Infix Evaluation (Assumes syntactically correct)
public class InfixEvaluator {

    public static int evaluateInfix(String expression) {
        Stack<Integer> values = new Stack<>();
        Stack<Character> operators = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);

            if (Character.isWhitespace(ch)) {
                continue;
            } else if (Character.isDigit(ch)) {
                int value = 0;
                while (i < expression.length() && Character.isDigit(expression.charAt(i))) {
                    value = value * 10 + (expression.charAt(i) - '0');
                    i++;
                }
                values.push(value);
                i--;
            } else if (ch == '(') {
                operators.push(ch);
            } else if (ch == ')') {
                while (operators.peek() != '(') {
                    values.push(applyOperation(operators.pop(), values.pop(), values.pop()));
                }
                operators.pop();
            } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                while (!operators.isEmpty() && precedence(ch) <= precedence(operators.peek())) {
                    values.push(applyOperation(operators.pop(), values.pop(), values.pop()));
                }
                operators.push(ch);
            }
        }

        while (!operators.isEmpty()) {
            values.push(applyOperation(operators.pop(), values.pop(), values.pop()));
        }

        return values.pop();
    }

    private static int precedence(char operator) {
        if (operator == '+' || operator == '-') return 1;
        if (operator == '*' || operator == '/') return 2;
        return -1;
    }

    private static int applyOperation(char operator, int b, int a) {
        switch (operator) {
            case '+': return a + b;
            case '-': return a - b;
            case '*': return a * b;
            case '/': return a / b;
        }
        return 0;
    }

    public static void main(String[] args) {
        String expression = "3 + 5 * ( 2 - 8 )";
        System.out.println("Infix Evaluation Result: " + evaluateInfix(expression));
    }
}
// Step 5: End
// Step 6: End - Add validation for syntax (not implemented here)