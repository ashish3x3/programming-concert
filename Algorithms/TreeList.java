
public class TreeList {
	
	// Demonstrate tree->CircularDoubleLinklist with the list 1..5
    public static void main(String[] args) {
        // first build the tree shown in the problem document
        TreeNode root = new TreeNode(10);
        
        treeInsert(root, 8);
        treeInsert(root, 30);
        treeInsert(root, 6);
        treeInsert(root, 9);
        treeInsert(root, 15);
        System.out.println("tree:");
        printTree(root);
        // 1 2 3 4 5
        System.out.println();
        System.out.println("list:");
        TreeNode head = treeToList(root);
        printList(head);
        // 1 2 3 4 5
    }
    
    public static void treeInsert(TreeNode root, int newData) {
        if (newData <= root.val) {
            if (root.left != null)
                treeInsert(root.left, newData);
            else
                root.left = new TreeNode(newData);
        } else {
            if (root.right != null)
                treeInsert(root.right, newData);
            else
                root.right = new TreeNode(newData);
        }
    }
    

    // Do an inorder traversal to print a tree
    // Does not print the ending "\n"

    public static void printTree(TreeNode root) {
        if (root == null)
            return;
        printTree(root.left);
        System.out.print(Integer.toString(root.val) + " ");
        printTree(root.right);
    }
    
    /*
     * --Recursion-- Given an ordered binary tree, recursively change it into a
     * circular doubly linked list which is returned.
     */

    public static TreeNode treeToList(TreeNode root) {
        // base case: empty tree -> empty list
        if (root == null)
            return (null);
        // Recursively do the subtrees (leap of faith!)
        TreeNode aList = treeToList(root.left);
        TreeNode bList = treeToList(root.right);
        // Make the single root TreeNode into a list length-1
        // in preparation for the appending
        root.left = root;
        root.right = root;
        // At this point we have three lists, and it's
        // just a matter of appending them together
        // in the right order (aList, root, bList)
        aList = append(aList, root);
        aList = append(aList, bList);
        return (aList);
    }
	
	
	
	
	
public static void join(TreeNode a, TreeNode b) {
        a.right = b;
        b.left = a;
    }

    public static TreeNode append(TreeNode a, TreeNode b) {
        // if either is null, return the other
        if (a == null)
            return (b);
        if (b == null)
            return (a);
        // find the last TreeNode in each using the .previous pointer
        TreeNode aLast = a.left;
        TreeNode bLast = b.left;
        // join the two together to make it connected and circular
        join(aLast, b);
        join(bLast, a);
        return (a);
    }

    

    /*
     * Given a non-empty tree, insert a new TreeNode in the proper place. The tree
     * must be non-empty because Java's lack of reference variables makes that
     * case and this method messier than they should be.
     */

    


    // Do a traversal of the list and print it out
    public static void printList(TreeNode head) {
        TreeNode current = head;
        while (current != null) {
            System.out.print(Integer.toString(current.val) + " ");
            current = current.right;
            if (current == head)
                break;
        }
        System.out.println();
    }

    }
