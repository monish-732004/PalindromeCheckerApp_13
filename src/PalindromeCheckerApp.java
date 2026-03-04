import java.util.Scanner;
import java.util.LinkedList;
import java.util.Deque;

public class PalindromeCheckerApp {
    public static void main(String[] args){
        System.out.println("Welcome to the Palindrome Checker Management System");
        System.out.println("Version : 7.0");
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
    // Method to check palindrome using Deque
    public static boolean isPalindrome(String str) {
        Deque<Character> deque = new LinkedList<>();

        // Insert all characters into deque
        for (char c : str.toCharArray()) {
            deque.addLast(c);
        }

        // Compare front and rear until empty or mismatch
        while (deque.size() > 1) {
            char front = deque.removeFirst();
            char rear = deque.removeLast();

            if (front != rear) {
                return false; // mismatch found
            }
        }

        return true; // no mismatches, it's a palindrome
    }
}
