import java.util.*;

public class PrintAllAnagramsTogether {
public HashMap<String,ArrayList<String>> words = new HashMap<String, ArrayList<String>>();

public void seqWords(String[] arr) {
for(String word: arr) {
char[] c = word.toCharArray();
Arrays.sort(c);
String Sortedword = new String(c);
if(words.containsKey(Sortedword)) {
words.get(Sortedword).add(word);
}
else {
ArrayList<String> ar = new ArrayList<String>();
ar.add(word);
words.put(Sortedword, ar);
}
}
}
public void printWords() {

for(Map.Entry<String,ArrayList<String>> mp: words.entrySet()) {
for(String word: mp.getValue()) {
System.out.print(word+" ");
}
}

}
public static void main(String[] args) {
String[] words = {"cat", "dog", "tac", "god", "act"};
PrintAllAnagramsTogether pa = new PrintAllAnagramsTogether();
pa.seqWords(words);
pa.printWords();
}

}