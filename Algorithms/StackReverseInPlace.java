import java.util.Stack;


public class StackReverseInPlace {

	public static void main(String[] args) {
	    Stack stack = new Stack();
	    for (int i = 0; i < 10; i++) {
	      stack.push(i);
	    }
	    reverse(stack);
	    while (!stack.isEmpty()) {
	      System.out.println(stack.pop());
	    }
	  }
	
	public static void reverse(Stack stack) {
	    if (false == stack.isEmpty()) {
	      Integer first = (Integer) stack.pop();
	      reverse(stack);
	      insertAtBottom(stack, first);
	    }
	  }

	  private static void insertAtBottom(Stack<Integer> stack, Integer item) {
	    if (stack.isEmpty()) {
	      stack.push(item);
	    } else {
	      int temp = (int) stack.pop();
	      insertAtBottom(stack, item);
	      stack.push(temp);
	    }
	  }

}
