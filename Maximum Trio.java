/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		while(t > 0){
		    int n = scan.nextInt();
		    long nums[] = new long[n];
		    for(int i=0; i<n; i++){
		        nums[i] = scan.nextLong();
		    }
		    Arrays.sort(nums);
		    long res = (nums[n-1] - nums[0])*nums[n-2];
		    System.out.println(res);
		    t--;
		}
	}
}
