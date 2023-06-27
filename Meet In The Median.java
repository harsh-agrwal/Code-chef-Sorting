/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        while(tc-->0)
        {
            int n = sc.nextInt();
            int k = sc.nextInt();
            Set<Integer> set = new HashSet<>();
            int[] arr1 = new int[n];
            int i = 0;
            int[] arr = new int[n];
            while(i<n)
            {
                arr[i] = sc.nextInt();
                arr1[i] = arr[i];
                ++i;
            }
            Arrays.sort(arr1);
            long Median = 0;
            int j = 0;
            i = n-1;
            while(j < k)
            {
                if(j==(k/2))
                {
                    Median += arr1[i];
                }
                set.add(arr1[i]);
                --i;
                ++j;
            }
            System.out.println(Median);
            i = 0;
            for(int val : arr)
            {
                if(set.contains(val)) 
                {
                    System.out.print(val+" ");
                }
            }
            System.out.println();            
        }
	}
}
