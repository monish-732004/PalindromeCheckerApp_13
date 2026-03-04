import java.util.Scanner;

class PalindromeChecker {
    // Method to check palindrome (case-sensitive, literal check)
    public boolean checkPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false; // mismatch found
            }
            left++;
            right--;
        }
        return true; // no mismatches, it's a palindrome
    }
}
// Application entry point
public class PalindromeCheckerApp {
    public static void main(String[] args) {
        System.out.println("Welcome to the Palindrome Checker Management System");
        System.out.println("Version : 11.0");
        System.out.println("System initialized successfully.");

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = sc.nextLine();

        // Use the PalindromeChecker service class
        PalindromeChecker checker = new PalindromeChecker();

        if (checker.checkPalindrome(str)) {
            System.out.println("The string is a palindrome.");
        } else {
            System.out.println("The string is NOT a palindrome.");
        }
        sc.close();
    }
}
