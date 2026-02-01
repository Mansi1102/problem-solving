package LinkedList;

public class RemoveNthNodeFromList {
    public static void main(String[] args) {

        // ----- Static Input -----
        // Linked list: 1 → 2 → 3 → 4 → 5
        // Remove 2nd node from end → expected: 1 → 2 → 3 → 5
        int n = 2;

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.println("Original List:");
        printList(head);

        // ----- Call Function -----
        ListNode updatedHead = removeNthFromEnd(head, n);

        System.out.println("\nAfter removing " + n + "th node from end:");
        printList(updatedHead);
    }
    // Correct Two-pointer Solution
    public static ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode fast = dummy;
        ListNode slow = dummy;

        // Move fast pointer ahead by n+1 steps
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        // Move both pointers
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // Delete nth node
        slow.next = slow.next.next;

        return dummy.next;
    }

    // Helper to print linked list
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }
}

/*
Time Complexity: O(N), since the fast pointer will traverse the entire linked list, where N is the length of the linked list.
Space Complexity: O(1), constant additional space is used to check unique elements.
 */
