package Day6;

import java.io.*;

class TheSmurf{
	  public static void main(String args[])throws IOException
	  {
	      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	      int t = Integer.parseInt(in.readLine());
	      while(t-- > 0){
	          int n = Integer.parseInt(in.readLine());
	          String a[] = in.readLine().trim().split("\\s+");
	          
	          Solution ob = new Solution();
	          System.out.println(ob.minFind(n, a));
	      }
	  }
}

class Solution{
  int minFind(int n, String a[]){
      int r = 0, g = 0, b = 0;
      
      for(int i=0; i<n; i++){
          if(a[i].equals("R")){
              r++;
          }
          else if(a[i].equals("G")){
              g++;
          }
          else{
              b++;
          }
      }
      
      if((r==0 && g==0) || (r==0 && b==0) || (g==0 && b==0)){
          // System.out.println(r + " " + g + " " + b);
          return n;
      }
      else if(g%2==0 && r%2==0 && b%2==0){
          return 2;
      }
      else if(g%2!=0 && r%2!=0 && b%2!=0){
          return 2;
      }
      else{
          return 1;
      }
      
  }
}
