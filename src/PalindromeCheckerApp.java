import java.util.Scanner;
import java.util.Stack;

public class PalindromeCheckerApp {
    public static void main(String[] args){
        System.out.println("Welcome to the Palindrome Checker Management System");
        System.out.println("Version : 5.0");
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
    // Method to check palindrome using Stack
    public static boolean isPalindrome(String str) {
        Stack<Character> stack = new Stack<>();

        // Push all characters into stack
        for (char c : str.toCharArray()) {
            stack.push(c);
        }

        // Compare original string with reversed (via stack pops)
        for (char c : str.toCharArray()) {
            if (c != stack.pop()) {
                return false; // mismatch found
            }
        }
        return true; // no mismatches, it's a palindrome
    }
}
