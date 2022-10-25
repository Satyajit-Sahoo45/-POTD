package Day3;

import java.io.*;
import java.util.*;

class Lexicographically_Smallest_String {
 public static void main(String args[]) throws IOException {
     BufferedReader read =
         new BufferedReader(new InputStreamReader(System.in));
     int t = Integer.parseInt(read.readLine());
     while (t-- > 0) {
         String[] input = new String[2]; 
         input = read.readLine().split(" "); 
         String S = input[0];
         int k =  Integer.parseInt(input[1]);
         Solution ob = new Solution();

         System.out.println(ob.lexicographicallySmallest(S, k));
     }
 }
}

class Solution {
	 static String lexicographicallySmallest(String s, int k) {
		 int len = s.length();
		 
		 /* find out if our string length is power of 2 divide by 2
		  * or multiply by 2.
		  */
	        if(isTwoPow(len)){
	            k /= 2;
	        }
	        else{
	            k *=2;
	        }
	        
	     /* if the no. of element which we need to remove from the string
	      * is greater than the length of the string then return -1, 
	      */
	        if(k >= len) {
	        	return "-1";
	        }
	        
	        /* Using stack DS to store the characters
	         * until stack.isNotEmpty && stackTopEle > currentCharacter && noOfRemovedChar < k
	         *       then : pop element from stack and increment the removed pointer
	         * 
	         */
	        int removed = 0;
	        Stack<Character> stk = new Stack<>();
	        for(int i=0; i<len; i++) {
	        	char ch = s.charAt(i);
	        	while(!stk.isEmpty() && removed < k && stk.peek() > ch) {
	        		stk.pop();
	        		removed++;
	        	}
	        	stk.push(s.charAt(i));
	        }
	        
	        /* if there is a such case like str = "abcdef" and k = 2 
	         * we can't pop any element from the string because it's already present 
	         * in lexicographically order, 
	         * to handle this case we need to pop k element from the stack
	         */
	        while(removed < k) {
	        	stk.pop();
	        	removed++;
	        }
	        
	        StringBuilder sb = new StringBuilder();
	        while(stk.size() > 0) {
	        	sb.append(stk.pop());
	        }
	        
	        return sb.reverse().toString();
	        
	 }

 /* This function is used to find the length of the string is a power of 2 or not */
	private static boolean isTwoPow(int len) {
		int count1 = 0;
		
		while(len > 0) {
			count1 += (len&1);
			len >>= 1;
		}
		
		return count1>1?false:true;
	}
}
