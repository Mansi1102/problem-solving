package LinkedList;

public class OddEvenLinkedList {

    public static void main(String[] args) {

        // Creating linked list: 17 -> 15 -> 8 -> 12 -> 10 -> 5 -> 4
        ListNode head = new ListNode(17);
        head.next = new ListNode(15);
        head.next.next = new ListNode(8);
        head.next.next.next = new ListNode(12);
        head.next.next.next.next = new ListNode(10);
        head.next.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next.next = new ListNode(4);

        // Call segregation function
        ListNode newHead = oddEvenList(head);

        // Print result
        while (newHead != null) {
            System.out.print(newHead.val + " ");
            newHead = newHead.next;
        }
    }

    public static ListNode oddEvenList(ListNode head) {
        if (head == null) return null;
        ListNode odd = head, even = head.next, evenHead = even;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;

    }
}

/*
Time Complexity: O(n), We traverse the entire linked list only once to rearrange the nodes. Each node is visited exactly once. No nested traversal or re-traversal occurs. Hence, linear time in terms of the number of nodes n.
Space Complexity: O(1), We do not use any extra data structures
 */

