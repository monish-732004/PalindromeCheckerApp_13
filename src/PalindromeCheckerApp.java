import java.util.Scanner;
import java.util.Stack;
import java.util.LinkedList;
import java.util.Queue;

public class PalindromeCheckerApp {
    public static void main(String[] args){
        System.out.println("Welcome to the Palindrome Checker Management System");
        System.out.println("Version : 6.0");
        System.out.println("System initialized Successfully.");

        Scanner sc = new Scanner(System.in);
        System.out.println("\nInput text:");
        String str = sc.nextLine();

        if (isPalindrome(str)) {
            System.out.println("The string is a palindrome.");
        } else {
            System.out.println("The string is NOT a palindrome.");
        }
        sc.close();
    }
    // Method to check palindrome using both Queue and Stack
    public static boolean isPalindrome(String str) {
        Queue<Character> queue = new LinkedList<>();
        Stack<Character> stack = new Stack<>();

        // Enqueue and push all characters
        for (char c : str.toCharArray()) {
            queue.add(c); // enqueue
            stack.push(c); // push
        }

        // Compare dequeue vs pop
        while (!queue.isEmpty() && !stack.isEmpty()) {
            if (queue.remove() != stack.pop()) {
                return false; // mismatch found
            }
        }
        return true; // no mismatches, it's a palindrome
    }
}
