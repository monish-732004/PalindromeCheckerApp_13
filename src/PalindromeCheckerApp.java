import java.util.Scanner;

public class PalindromeCheckerApp {
    // Node class for singly linked list
    static class Node {
        char data;
        Node next;

        Node(char data) {
            this.data = data;
            this.next = null;
        }
    }

    // Method to convert string into linked list
    public static Node buildLinkedList(String str) {
        Node head = null, tail = null;
        for (char c : str.toCharArray()) {
            Node newNode = new Node(c);
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }
        return head;
    }

    // Method to check palindrome using linked list
    public static boolean isPalindrome(Node head) {
        if (head == null || head.next == null) return true;

        // Step 1: Find middle using fast & slow pointers
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Reverse second half
        Node secondHalf = reverseList(slow);

        // Step 3: Compare first half and reversed second half
        Node firstHalf = head;
        Node temp = secondHalf;
        while (temp != null) {
            if (firstHalf.data != temp.data) {
                return false; // mismatch found
            }
            firstHalf = firstHalf.next;
            temp = temp.next;
        }
        return true; // no mismatches, it's a palindrome
    }

    // Helper method to reverse a linked list
    public static Node reverseList(Node head) {
        Node prev = null, current = head, next;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev; // new head
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = sc.nextLine();

        Node head = buildLinkedList(str);
        if (isPalindrome(head)) {
            System.out.println("The string is a palindrome.");
        } else {
            System.out.println("The string is NOT a palindrome.");
        }

        sc.close();
    }
}
