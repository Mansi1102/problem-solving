package LinkedList;

public class CopyListwithRandomPointer {

    // Node definition
    static class Node {
        int val;
        Node next;
        Node random;

        Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    // Solution class
    static class Solution {

        public Node copyRandomList(Node head) {
            if (head == null) return null;

            // STEP 1: Insert copy nodes after original nodes
            Node temp = head;
            while (temp != null) {
                Node copy = new Node(temp.val);
                copy.next = temp.next;
                temp.next = copy;
                temp = copy.next;
            }

            // STEP 2: Assign random pointers to copied nodes
            temp = head;
            while (temp != null) {
                if (temp.random != null) {
                    temp.next.random = temp.random.next;
                }
                temp = temp.next.next;
            }

            // STEP 3: Separate original and copied list
            Node dummy = new Node(-1);
            Node curr = dummy;
            temp = head;

            while (temp != null) {
                curr.next = temp.next;
                curr = curr.next;

                temp.next = temp.next.next;
                temp = temp.next;
            }

            return dummy.next;
        }
    }

    // Print list (value + random)
    static void printList(Node head) {
        while (head != null) {
            int randomVal = (head.random != null) ? head.random.val : -1;
            System.out.print("[" + head.val + ", random=" + randomVal + "] -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    // Main method with static input
    public static void main(String[] args) {

        /*
            Static Input:

            1 -> 2 -> 3
            |    |    |
            ↓    ↓    ↓
            3    1   null
        */

        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);

        n1.next = n2;
        n2.next = n3;

        n1.random = n3;
        n2.random = n1;
        n3.random = null;

        System.out.println("Original List:");
        printList(n1);

        Solution sol = new Solution();
        Node copiedHead = sol.copyRandomList(n1);

        System.out.println("\nCopied List:");
        printList(copiedHead);
    }
}

/*
T.C - O(n)
S.C - O(1)
 */

