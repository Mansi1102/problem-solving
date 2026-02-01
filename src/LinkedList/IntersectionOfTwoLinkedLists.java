package LinkedList;

import static LinkedList.RemoveNthNodeFromList.printList;

public class IntersectionOfTwoLinkedLists {
    public static void main(String[] args) {
        ListNode intersect = new ListNode(8);
        intersect.next = new ListNode(4);
        intersect.next.next = new ListNode(5);

// List A: 4 → 1 → (8 → 4 → 5)
        ListNode headA = new ListNode(4);
        headA.next = new ListNode(1);
        headA.next.next = intersect;

// List B: 5 → 6 → 1 → (8 → 4 → 5)
        ListNode headB = new ListNode(5);
        headB.next = new ListNode(6);
        headB.next.next = new ListNode(1);
        headB.next.next.next = intersect;

        System.out.println("Intersection Node in List: ");
       printList(getIntersectionNode(headA, headB));
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null || headB==null)return null;
        ListNode temp1=headA;
        ListNode temp2=headB;
        while(temp1!=temp2){
            if(temp1==null){
                temp1=headB;
            }
            else{
                temp1=temp1.next;
            }
            if(temp2==null){
                temp2=headA;
            }
            else{
                temp2=temp2.next;
            }
        }
        return temp1;
    }
}

/*
T.C - 0(n)
 */
