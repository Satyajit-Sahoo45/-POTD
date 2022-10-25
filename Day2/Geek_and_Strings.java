package Day2;
import java.io.*;
import java.util.*;

class Geek_and_Strings {
		public static void main(String args[])throws IOException
		{
			 BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		        int t = Integer.parseInt(in.readLine());
		        while(t-- > 0){
		            int N = Integer.parseInt(in.readLine());
		            String li[] = new String[N];
		            for(int i=0; i<N; i++)
		                li[i] = in.readLine();
//		            System.out.println(li.length);
		            int Q = Integer.parseInt(in.readLine());
		            String query[] = new String[Q];
		            for(int i=0; i<Q; i++)
		                query[i] = in.readLine();
//		            System.out.println(query.length);
		            
		            Solution ob = new Solution();
		            List<Integer> ans = new ArrayList<Integer>();
		            ans = ob.prefixCount(N, Q, li, query);
		            for(int i = 0;i < ans.size();i++)
		                System.out.println(ans.get(i));
		}
	}
}

class Solution{
	static List<Integer> prefixCount(int N, int Q, String li[], String query[])
	{
		TrieNode root = new TrieNode();
        for(String word : li){
            buildTrie(root, word);
        }
        List<Integer> result = new ArrayList<>();
        for(String qry : query){
            result.add(getPrefixCount(root, qry));
        }
        
        return result;
    }
    
    private static int getPrefixCount(TrieNode root, String query){
        TrieNode node = root;
        for(char ch : query.toCharArray()){
            if(node.childs[ch - 'a'] == null){
                return 0;
            }
            node = node.childs[ch - 'a'];
        }
        return node.prefixCount;
    }
    
    
    private static void buildTrie(TrieNode root, String word){
        TrieNode node = root;
        int n = word.length();
        for(int i=0; i<n; i++){
            char ch = word.charAt(i);
            if(node.childs[ch - 'a'] == null){
                node.childs[ch - 'a'] = new TrieNode();
            }
            node.childs[ch- 'a'].prefixCount++;
            node = node.childs[ch - 'a'];
        }
        node.isEndWord = true;
    }
}

class TrieNode{
    TrieNode[] childs;
    int prefixCount;
    boolean isEndWord;
    
    public TrieNode(){
        childs = new TrieNode[26];
        isEndWord = false;
        prefixCount = 0;
    }
    
}










//5
//abracadabra geeksforgeeks abracadabra geeks geeksthrill
//5
//abr geeks geeksforgeeks ge gar