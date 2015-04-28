/*
    k-way merge : sort k sorted array of size n into one

    Example:

Input:
k = 3, n =  4
arr[][] = { {1, 3, 5, 7},
            {2, 4, 6, 8},
            {0, 9, 10, 11}} ;

Output: 0 1 2 3 4 5 6 7 8 9 10 11 

A simple solution is to create an output array of size n*k and one by one copy all arrays to it. Finally, sort the output array using any O(nLogn) sorting algorithm. This approach takes O(nkLognk) time.

We can merge arrays in O(nk*Logk) time using Min Heap. Following is detailed algorithm.

1. Create an output array of size n*k.
2. Create a min heap of size k and insert 1st element in all the arrays into a the heap
3. Repeat following steps n*k times.
     a) Get minimum element from heap (minimum is always at root) and store it in output array.
     b) Replace heap root with next element from the array from which the element is extracted. If the array doesn’t have any more elements, then replace root with infinite. After replacing the root, heapify the tree.
*/


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.Set;
 
 
public class MergeArrays {
 private static final int N = 7;
 private static HashMap<Integer, ArrayList<Integer>> arrayMap = new HashMap<Integer, ArrayList<Integer>>();
 private static int TOTAL = 0;
  
 public static void main(String[] args) {
  createArrays();
  System.out.println("Number of arrays: " + N);
  printArrays();
  ArrayList<Integer> mergedList = mergeArrays();
  System.out.println("Final merged lists data: ");
  printMergedList(mergedList);
  System.out.println();
   
 }
  
 public static void printMergedList(ArrayList<Integer> mergedList) {
  if (mergedList == null || mergedList.size() < 1) {
   System.out.println("Merged List is EMPTY!");
  }
  Iterator<Integer> iter = mergedList.iterator();
   
  while (iter.hasNext()) {
   System.out.print(iter.next() + " ");
  }
  System.out.println();
 }
  
 public static ArrayList<Integer> mergeArrays() {
  ArrayList<Integer> mergedList = new ArrayList<Integer>();
  Set<Integer> keySet = arrayMap.keySet();
  Comparator<Node> comparator = new NumericComparator();
  /* 
PriorityQueue(int initialCapacity, Comparator<? super E> comparator)
This creates a PriorityQueue with the specified initial capacity that orders its elements according to the specified comparator..*/
4 
  PriorityQueue<Node> minHeap = new PriorityQueue<Node>(TOTAL, comparator);
   
  Iterator<Integer> iter = keySet.iterator();
  while (iter.hasNext()) {
   int key = iter.next();
   ArrayList<Integer> list = arrayMap.get(key);
   if (list != null) {
    Integer data = list.remove(0);
    Node node = new Node(data, key);
    minHeap.add(node);
   }
  }
   
  while (minHeap.size() > 0) {
   Node node = minHeap.remove();
   //System.out.print(node.data + " ");
   mergedList.add(node.data);
   int id = node.id;
   ArrayList<Integer> list = arrayMap.get(id);
   if (list != null && list.size() > 0) {
    Integer data = list.remove(0);
    Node newNode = new Node(data, id);
    minHeap.add(newNode);
   }
  }
   
  return mergedList;
   
 }
  
 public static void createArrays() {
  Random rand = new Random();
  for (int i=0; i<N; i++) {
   int size = rand.nextInt(5) + 5;
   TOTAL += size;
   ArrayList<Integer> numList = new ArrayList();
   for (int j=0; j<size; j++) {
    int value = rand.nextInt(1000) + 1;
    numList.add(value);
   }
   Collections.sort(numList);
   arrayMap.put(i+1, numList);
  }
 }
  
 public static void printArrays() {
  Iterator it = arrayMap.entrySet().iterator();
   
  while (it.hasNext()) {
   Map.Entry<Integer, ArrayList<Integer>> pair = (Map.Entry<Integer, ArrayList<Integer>>)it.next();
   ArrayList<Integer> list = pair.getValue();
   Iterator liter = list.iterator();
   while (liter.hasNext()) {
    System.out.print(liter.next() + " ");
   }
   System.out.println();
  }
 }
}
 
class Node {
 int data;
 int id;
 Node(int data, int id) {
  this.data = data;
  this.id = id;
 }
}
 
class NumericComparator implements Comparator<Node> {
 
 @Override
 public int compare(Node o1, Node o2) {
  if (o1.data < o2.data) {
   return -1;
  } else if (o1.data > o2.data) {
   return 1;
  } 
  return 0;
 }
  
}