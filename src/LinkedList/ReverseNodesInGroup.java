package LinkedList;

import static LinkedList.RemoveNthNodeFromList.printList;

public class ReverseNodesInGroup {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        int k = 2;

        System.out.println("Reverse List: ");
        printList(reverseKGroup(head,k));
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        head= reverseK(head, k);
        return head;

    }

    public static ListNode reverseK(ListNode head, int k){
        if(head==null)
            return null;
        ListNode temp = head;
        int extra = 0;
        for(int i=1;i<=k && temp!=null;i++){
            extra++;
            temp=temp.next;
        }

        if(temp==null && extra!=k){
            return head;
        }
        ListNode prev = reverseK(temp, k);
        ListNode curr = head;
        while(curr!=temp){
            ListNode ahead=  curr.next;
            curr.next= prev;
            prev= curr;
            curr= ahead;
        }
        return prev;
    }
}
