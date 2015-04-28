package sam;

import java.util.ArrayList;
import java.util.List;

public class am {

	public static void main(String[] args) {
		//Generate linked list with 19->20->3->70->4->5
		List<Integer> n = new ArrayList<Integer>();
		n.add(19);
		n.add(20);
		n.add(3);
		n.add(70);
		n.add(4);
		n.add(5);
		LinkedList formed = generateLinkedList(n);
		deleteNode(formed.next.next.next);
		
		
	}
	private static LinkedList generateLinkedList(List<Integer> n) {
		LinkedList end = null;
		for(int i = n.size()-1 ; i >= 0  ; i--) {
			end = new LinkedList(n.get(i), end);
		}
		return end;
	}
	private static void deleteNode(LinkedList m) {
		m.value = m.next.value;
		m.next = m.next.next;
	}
}
class LinkedList {
	int value;
	LinkedList next;
	public LinkedList(int value, LinkedList next) {
		this.value = value;
		this.next = next;
	}
	
}

//=======================================================

public class SinglyLinkedList {

      …

 

      public void removeFirst() {

            if (head == null)

                  return;

            else {

                  if (head == tail) {

                        head = null;

                        tail = null;

                  } else {

                        head = head.next;

                  }

            }

      }

 

      public void removeLast() {

            if (tail == null)

                  return;

            else {

                  if (head == tail) {

                        head = null;

                        tail = null;

                  } else {

                        SinglyLinkedListNode previousToTail = head;

                        while (previousToTail.next != tail)

                             previousToTail = previousToTail.next;

                        tail = previousToTail;

                        tail.next = null;

                  }

            }

      }

 

      public void removeNext(SinglyLinkedListNode previous) {

            if (previous == null)

                  removeFirst();

            else if (previous.next == tail) {

                  tail = previous;

                  tail.next = null;

            } else if (previous == tail)

                  return;

            else {

                  previous.next = previous.next.next;

            }

      }

}