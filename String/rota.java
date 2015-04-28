class FindRotation {
 
public static void main(String[] args) {
System.out.println(isRotationWith( "CABAD","ABADC"));
 
}
public static boolean isRotationWith(String input, String input2) {
 
if(input.length() != input2.length()) {
// Two Strings can be a rotation only if they are of same length
return false;
}
else {
int i;
for(i=0;i<input.length();i++) {
if(input.charAt(i) == input2.charAt(0)) {
boolean isRotation = true;
// First character matched. Now check other characters in sequence
for(int j=1;j<input2.length();j++) {
// Traverse the input2 string and check if each character is equal to the character traversal of input string starting from index 'i'
i = (i + 1) % input.length(); // Ensures Circular Traversal
if(input2.charAt(j) != input.charAt(i)){
isRotation = false;
break;
}
}
 
if(isRotation){
System.out.println("rotation found.");
return true;
}
 
// First character matched but other characters did not. So need to check further occurrences of staring character.
// go for next iteration
}
}
return false;
 
}
}
 
}