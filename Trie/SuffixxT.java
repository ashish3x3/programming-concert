import java.util.*;

/*
H:\Computer Science\Java\Eclipse program\Trie\src>java SuffixxT
is: [1, 4]
sip: [6]
sis: [3]
*/

public class SuffixxT {
	public static void main(String[] args) {
		String testString = "mississippi";
		String[] stringList = {"is", "sip", "hi", "sis"};
		SuffixTree tree = new SuffixTree(testString);
		for (String s : stringList) {
			ArrayList<Integer> list = tree.getIndexes(s);
			if (list != null) {
				System.out.println(s + ": " + list.toString());
			}
		}
	}
}

class SuffixTree {
	SuffixTreeNode root = new SuffixTreeNode();

	public SuffixTree(String s) {
		for (int i = 0; i < s.length(); i++) {
			String suffix = s.substring(i);
			root.insertString(suffix, i);
		}
	}

	public ArrayList<Integer> getIndexes(String s) {
		return root.getIndexes(s);
	}
 } //end of class

 class SuffixTreeNode {
 	HashMap<Character, SuffixTreeNode> children = new HashMap<Character, SuffixTreeNode>();
 	char value;
 	ArrayList<Integer> indexes = new ArrayList<Integer>();


 	public SuffixTreeNode() { }

 	public void insertString(String s, int index) {

 	indexes.add(index);   // new index will be stored with new lement not in imediate child
 							// and old(parent) index will be stored with continuation fron parent to child.. 
 						//all elemt from parent continuation will store same index
 						//initail indes will be stored in root arayList as root is calling them from above root.insert(str,i); so it will get added to childern of root.


 	if (s != null && s.length() > 0) {
 		value = s.charAt(0);
 		SuffixTreeNode child = null;
 		// if already exist
 	if (children.containsKey(value)) {    /*only immediate child and not its child also as child 
 										char is created by child valuse node and not bt parent node..i.e children.put(val,TreeNode)
 										now child .get(val); and then child.insert(remaining,index) and it will have its own HashTable and arraylist for index..not parent one..*/
 										
 										child = children.get(value);
 									} else {
 	//new one
 										child = new SuffixTreeNode();
 										children.put(value, child);
 									}
 									String remainder = s.substring(1);
 									child.insertString(remainder, index);
 								}
 							}

 							public ArrayList<Integer> getIndexes(String s) {
 			if (s == null || s.length() == 0) {  // always return the index stored ta the bottom as it will tell the starting point..because last element returns its parent index..
 				return indexes;
 			} else {
 				char first = s.charAt(0);
 				if (children.containsKey(first)) {
 					String remainder = s.substring(1);
 		return children.get(first).getIndexes(remainder);  //we will go till end to find parent 
 															//index
 	}
 }
 return null;
}
}