public class Swap {

    public static class ListNode {
          int val;
          ListNode next;
          ListNode(int x) {
              val = x;
              next = null;
          }
    }
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(6);
        ListNode l7 = new ListNode(7);
        ListNode l8 = new ListNode(8);
        ListNode l9 = new ListNode(9);
        ListNode l10 = new ListNode(10);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6; 
        l7.next = l8;
        l9.next = l10;
        print(l1);
        //reorder(l1);
        System.out.println();
        print(reorder(l1));

    }
    private static void print(ListNode l1) {
        ListNode current = l1;
        while(current != null){
            System.out.print(current.val + " ");
            current = current.next;
        }
    }
    private static ListNode reorder(ListNode l1) {
        if(l1 == null || l1.next == null)
            return l1;
        ListNode rest = l1.next.next;
        //change head
        ListNode newHead = l1.next;
        //change next of second node
        newHead.next = l1;
        l1.next = reorder(rest);
        return newHead;
    }
}


//====================================

public static LinkNode SwapLinks(Link head)
{
    if (head == null || head.Next == null)
        return head;
    Link LastNode = new LinkNode();
    LastNode.Next = head;
    head = head.Next;
    while (LastNode.Next != null && LastNode.Next.Next != null)
    {
        Link trl = LastNode.Next;
        Link fwd = trl.Next;
        LastNode.Next = fwd;
        trl.Next = fwd.Next;
        fwd.Next = trl;
        LastNode = trl;
    }
    return head;
}