    import java.util.*;
    public class Main{
    public static void main(String args[])
    {
    Stack<Character> st=new Stack<Character>();
    Scanner in=new Scanner(System.in);
    String x=in.next();
    int i, flag=0;
    for(i=0;i<x.length();i++)
    {
    Character current = x.charAt(i);
    if(current=='{'||current=='['||current=='(')
    {
    st.push(current);
    }
    else if(current=='}'||current==']'||current==')')
    {
    if(st.isEmpty()) {flag=1;break;}
    Character to_match = st.pop();
    if(to_match=='{'&&current=='}') {}
    else if(to_match=='('&&current==')') {}
    else if(to_match=='['&&current==']') {}
    else {flag=1; break;}
    }
    }
     
    if(flag==1) System.out.println("Unmatching paranthesis");
    else if(st.contains('{')||st.contains('[')||st.contains('('))
    System.out.println("Unmatching parenthesis");
    else if(st.contains('}')||st.contains(']')||st.contains(')'))
    System.out.println("Unmatching parenthesis");
    else System.out.println("Matching Parenthesis");
    }
     
    }