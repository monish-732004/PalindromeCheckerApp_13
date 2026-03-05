import java.util.*;

// Strategy interface
interface PalindromeStrategy {
    boolean checkPalindrome(String str);
}

// Stack-based strategy
class StackStrategy implements PalindromeStrategy {
    @Override
    public boolean checkPalindrome(String str) {
        Stack<Character> stack = new Stack<>();
        for (char c : str.toCharArray()) {
            stack.push(c);
        }
        for (char c : str.toCharArray()) {
            if (c != stack.pop()) {
                return false;
            }
        }
        return true;
    }
}

// Deque-based strategy
class DequeStrategy implements PalindromeStrategy {
    @Override
    public boolean checkPalindrome(String str) {
        Deque<Character> deque = new LinkedList<>();
        for (char c : str.toCharArray()) {
            deque.addLast(c);
        }
        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) {
                return false;
            }
        }
        return true;
    }
}

// CharArray two-pointer strategy
class CharArrayStrategy implements PalindromeStrategy {
    @Override
    public boolean checkPalindrome(String str) {
        char[] chars = str.toCharArray();
        int left = 0, right = chars.length - 1;
        while (left < right) {
            if (chars[left] != chars[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}

// Recursive strategy
class RecursiveStrategy implements PalindromeStrategy {
    @Override
    public boolean checkPalindrome(String str) {
        return isPalindrome(str, 0, str.length() - 1);
    }

    private boolean isPalindrome(String str, int left, int right) {
        if (left >= right) return true;
        if (str.charAt(left) != str.charAt(right)) return false;
        return isPalindrome(str, left + 1, right - 1);
    }
}

// Context class
class PalindromeChecker {
    private PalindromeStrategy strategy;

    public PalindromeChecker(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean check(String str) {
        return strategy.checkPalindrome(str);
    }
}

// Application entry point
public class PalindromeCheckerApp {
    public static void main(String[] args) {
        System.out.println("Welcome to the Palindrome Checker Management System");
        System.out.println("Version : 13.0");
        System.out.println("System initialized successfully.");

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = sc.nextLine();

        // List of strategies to compare
        List<PalindromeStrategy> strategies = Arrays.asList(
                new StackStrategy(),
                new DequeStrategy(),
                new CharArrayStrategy(),
                new RecursiveStrategy()
        );

        // Run each strategy and measure time
        for (PalindromeStrategy strategy : strategies) {
            PalindromeChecker checker = new PalindromeChecker(strategy);

            long start = System.nanoTime();
            boolean result = checker.check(str);
            long end = System.nanoTime();

            long duration = end - start;

            System.out.println(strategy.getClass().getSimpleName() +
                    " -> Result: " + (result ? "Palindrome" : "Not Palindrome") +
                    ", Time: " + duration + " ns");
        }

        sc.close();
    }
}
