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
		int t = sc.nextInt();
		while(t > 0){
		    int n = sc.nextInt();
		    int w = sc.nextInt();
		    int nums[] = new int[n];
		    for(int i=0; i<n; i++){
		        nums[i] = sc.nextInt();
		    }
		    Arrays.sort(nums);
		    int wage = 0;
		    int c = 0;
		    for(int i=n-1; i>=0; i--){
		        wage += nums[i];
		        c++;
		        if(wage >= w) break;
		    }
		    System.out.println(n - c);
		    t--;
		}
	}
}
