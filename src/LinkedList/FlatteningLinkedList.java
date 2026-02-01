package LinkedList;

public class FlatteningLinkedList {

    // Node definition
    static class Node {
        int data;
        Node next;
        Node bottom;

        Node(int data) {
            this.data = data;
            this.next = null;
            this.bottom = null;
        }
    }

    // Flatten function
    static Node flatten(Node root) {
        // Base case
        if (root == null || root.next == null) {
            return root;
        }

        // Flatten the next list
        root.next = flatten(root.next);

        // Merge current list with flattened next list
        root = merge(root, root.next);

        return root;
    }

    // Merge two sorted lists using bottom pointer
    static Node merge(Node a, Node b) {
        Node dummy = new Node(-1);
        Node temp = dummy;

        while (a != null && b != null) {
            if (a.data <= b.data) {
                temp.bottom = a;
                a = a.bottom;
            } else {
                temp.bottom = b;
                b = b.bottom;
            }
            temp = temp.bottom;
        }

        if (a != null) temp.bottom = a;
        else temp.bottom = b;

        return dummy.bottom;
    }

    // Print flattened list
    static void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.bottom;
        }
        System.out.println();
    }

    // Main method with static input
    public static void main(String[] args) {

        /*
            Static Input Representation:

            5 → 10 → 19 → 28
            |    |     |     |
            7    20    22    35
            |          |     |
            8          50    40
            |                |
            30               45
        */

        Node head = new Node(5);
        head.bottom = new Node(7);
        head.bottom.bottom = new Node(8);
        head.bottom.bottom.bottom = new Node(30);

        head.next = new Node(10);
        head.next.bottom = new Node(20);

        head.next.next = new Node(19);
        head.next.next.bottom = new Node(22);
        head.next.next.bottom.bottom = new Node(50);

        head.next.next.next = new Node(28);
        head.next.next.next.bottom = new Node(35);
        head.next.next.next.bottom.bottom = new Node(40);
        head.next.next.next.bottom.bottom.bottom = new Node(45);

        // Flatten the list
        Node flatHead = flatten(head);

        // Print result
        System.out.println("Flattened Linked List:");
        printList(flatHead);
    }
}
/*
T.C = O(n)
S.C = O(n)
 */

