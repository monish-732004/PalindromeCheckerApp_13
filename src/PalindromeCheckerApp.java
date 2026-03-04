import java.util.Scanner;

public class PalindromeCheckerApp {
    public static void main(String[] args){
        System.out.println("Welcome to the Palindrome Checker Management System");
        System.out.println("Version : 4.0");
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
    // Method to check palindrome using char[] and two-pointer approach
    public static boolean isPalindrome(String str) {
        // Convert string to character array
        char[] chars = str.toCharArray();

        int left = 0; // pointer at start
        int right = chars.length - 1; // pointer at end

        while (left < right) {
            if (chars[left] != chars[right]) {
                return false; // mismatch found
            }
            left++;
            right--;
        }
        return true; // no mismatches, it's a palindrome
    }
}
