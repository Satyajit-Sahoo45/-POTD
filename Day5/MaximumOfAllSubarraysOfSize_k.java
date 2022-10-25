package Day5;
import java.util.*;

class MaximumOfAllSubarraysOfSize_k {

	public static void main(String[] args) {
		        Scanner sc = new Scanner(System.in);
		        
		        //taking total count of testcases
		        int t = sc.nextInt();
		        
		        while(t-- > 0)
		        {
		            //taking total number of elements
		            int n = sc.nextInt();
		            
		            //taking size of subArrays 
		            int k = sc.nextInt();
		            
		            //Declaring and Intializing an array of size n
		            int arr[] = new int[n];
		            
		            //adding all the elements to the array 
		            for(int i = 0; i <n; i++)
		            {
		                arr[i] =sc.nextInt();
		            }
		            
		            //Calling the method max_of_subarrays of class solve
		            //and storing the result in an ArrayList
		            ArrayList <Integer> res = new Solution().max_of_subarrays(arr, n, k);
		            
		            //printing the elements of the ArrayList
		            for (int i = 0; i < res.size(); i++)
		                System.out.print (res.get(i) + " ");
		            System.out.println();
		    }
     }

}

	
class Solution
{
    //Function to find maximum of each subarray of size k.
    ArrayList<Integer> max_of_subarrays(int arr[], int n, int k)
    {
        ArrayList<Integer> arlist = new ArrayList<>(); 

        for(int i=0; i<=(n-k); i++){

            int count = arr[i];

            for(int j=i+1; j<=(i+k-1); j++){

                int max = Math.max(count, arr[j]);

                count = max;

            }

            arlist.add(count);

        }

        return arlist;
    }
}
