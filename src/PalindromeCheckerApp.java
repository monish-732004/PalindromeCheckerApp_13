import java.util.Scanner;

public class PalindromeCheckerApp {
    public static void main(String[] args) {
        System.out.println("Welcome to the Palindrome Checker Management System");
        System.out.println("Version : 9.0");
        System.out.println("System initialized successfully.");

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = sc.nextLine();

        if (isPalindrome(str, 0, str.length() - 1)) {
            System.out.println("The string is a palindrome.");
        } else {
            System.out.println("The string is NOT a palindrome.");
        }
        sc.close();
    }

    // Recursive method to check palindrome
    public static boolean isPalindrome(String str, int left, int right) {
        // Base condition: when pointers cross or meet
        if (left >= right) {
            return true;
        }
        // If mismatch found
        if (str.charAt(left) != str.charAt(right)) {
            return false;
        }

        // Recursive call moving inward
        return isPalindrome(str, left + 1, right - 1);
    }
}
