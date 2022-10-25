package Day1;
import java.io.BufferedReader;
import java.io.*;
import java.io.InputStreamReader;
import java.util.*;

public class Count_all_possible_paths_from_top_left_to_bottom_right {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		while(T-->0) {
			
			String[] input = new String[2];
			input = br.readLine().split(" "); 
			int m = Integer.parseInt(input[0]); 
			int n = Integer.parseInt(input[1]);
			Solution ob = new Solution();
			System.out.println(ob.numberOfPaths (m, n));
			
		}

	}

}

class Solution{
	static int mod = 1000000007;
    long numberOfPaths(int m, int n)
    {
        int[][] dp = new int[m][n];
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(i == 0 && j == 0){ 
                     dp[0][0] = 1;
                 }
                 else{
                     int up = 0;
                     int left = 0;
                     
                     if(i > 0) up = dp[i-1][j];
                     if(j > 0) left = dp[i][j-1];
                     dp[i][j] = (up+left)%mod;
                 }
            }
        }
        return dp[m-1][n-1];
    }
}