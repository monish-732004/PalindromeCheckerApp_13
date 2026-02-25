import java.util.Scanner;

public class PalindromeCheckerApp {
    public static void main(String[] args){
        System.out.println("Welcome to the Palindrome Checker Management System");
        System.out.println("Version : 2.0");
        System.out.println("System initialized Successfully.");

        Scanner sc = new Scanner(System.in);
        System.out.println("\nInput text:");
        String str = sc.nextLine();

        boolean isPalindrome = true;
        int n = str.length();

        // Compare characters from start and end moving towards the center
        for (int i = 0; i < n / 2; i++) {
            if (str.charAt(i) != str.charAt(n - 1 - i)) {
                isPalindrome = false;
                break;
            }
        }

        System.out.print("Is it a Palindrome? : ");
        if (isPalindrome) {
            System.out.print("True");
        } else {
            System.out.print("False");
        }

        sc.close();

    }
}
