package LinkedList;

import static LinkedList.RemoveNthNodeFromList.printList;

public class RotateList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        int k =2;

        System.out.println("Rotate List: ");
        printList(rotateRight(head,k));
    }
    private static ListNode rotateRight(ListNode head, int k) {

        if (head == null || head.next == null || k == 0) {
            return head;
        }

        // Step 1: Find length and tail
        ListNode temp = head;
        int len = 1;
        while (temp.next != null) {
            temp = temp.next;
            len++;
        }

        // Step 2: Make circular list
        temp.next = head;

        // Step 3: Normalize k
        k = k % len;
        int stepsToNewHead = len - k;

        // Step 4: Find new tail
        ListNode newTail = head;
        for (int i = 1; i < stepsToNewHead; i++) {
            newTail = newTail.next;
        }

        // Step 5: Break the circle
        ListNode newHead = newTail.next;
        newTail.next = null;

        return newHead;
    }
}
