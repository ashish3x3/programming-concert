import java.util.*;

@SuppressWarnings("serial")
public class StackWithMinMax extends Stack<Integer> {

    private Stack<Integer> minStack;
    private Stack<Integer> maxStack;

    public StackWithMinMax () {
        minStack = new Stack<Integer>();    
        maxStack = new Stack<Integer>();    
    }

    public void print(){

    	System.out.print("super "+super.toString());
    	System.out.println();
        System.out.print("min "+ minStack);
        System.out.println();
        System.out.print("max "+ maxStack);
        System.out.println();
    }

    public void push(int value){
        if (value <= min()) { // Note the '=' sign here
            minStack.push(value);
        }

        if (value >= max()) {
            maxStack.push(value);
        }

        super.push(value);
    }

    public Integer pop() {
        int value = super.pop();

        if (value == min()) {
            minStack.pop();         
        }

        if (value == max()) {
            maxStack.pop();         
        }

        return value;
    }

    public int min() {
        if (minStack.isEmpty()) {
            return Integer.MAX_VALUE;
        } else {
            return minStack.peek();
        }
    }

    public int max() {
        if (maxStack.isEmpty()) {
            return Integer.MIN_VALUE;
        } else {
            return maxStack.peek();
        }
    }

    public static void main(String [] args){

        StackWithMinMax sk=new StackWithMinMax();
        sk.push(5);
         sk.push(4);
          sk.push(3);
           sk.push(2);
            sk.push(1);

            sk.print();
            sk.pop();
            sk.pop();
            sk.print();


    }
}


/*class Stack<Integer>{

    Stack<Integer> st=new Stack<Integer>();

    public void push(int val){

        st.push(val);
    }

    public int pop(){

        return st.pop();
    }
    public void print(){

        System.out.println(" " + st);
    }


}*/