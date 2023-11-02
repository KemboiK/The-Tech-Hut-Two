import java.util.Scanner;
import java.util.Stack;

public class BracketValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a sequence of brackets:");
        String input = scanner.nextLine();

        if (isValidBracketSequence(input)) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }

        // Close the scanner
        scanner.close();
    }

    public static boolean isValidBracketSequence(String input) {
        Stack<Character> stack = new Stack<>();

        for (char bracket : input.toCharArray()) {
            if (bracket == '(' || bracket == '{' || bracket == '[') {
                stack.push(bracket);
            } else if (bracket == ')' || bracket == '}' || bracket == ']') {
                if (stack.isEmpty()) {
                    return false; // No matching opening bracket found
                }
                char openingBracket = stack.pop();
                if (!isMatching(openingBracket, bracket)) {
                    return false; // Mismatch of brackets
                }
            } else {
                return false; // Invalid character
            }
        }

        return stack.isEmpty(); // If the stack is empty all brackets have a match
    }

    public static boolean isMatching(char open, char close) {
        return (open == '(' && close == ')') ||
                (open == '{' && close == '}') ||
                (open == '[' && close == ']');
    }
}
