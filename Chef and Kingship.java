/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
	    Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while(T-->0){
            int N = sc.nextInt(); //Number of cities
            long arr[]=new long[N];
            for(int i=0;i<N;i++){
                arr[i]=sc.nextLong(); //Population
            }
            Arrays.sort(arr);
            long cost = 0;
            for(int i = 1;i<arr.length;i++){
                cost=cost+arr[0]*arr[i];
            }
            System.out.println(cost);
        }
	}
}
