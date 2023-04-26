/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
    private static Scanner sc = new Scanner(System.in);
	public static void main (String[] args) throws java.lang.Exception
	{
    	long t,s;
    	t = sc.nextLong();
    	while(t-->0){
        	s = sc.nextLong();
    	    long arr[] = new long[(int)s];
    	    for(int i = 0; i < s; i++){
    	        arr[i] = sc.nextLong();
    	    }
            Arrays.sort(arr);
            long k = 0, sum = 0;
            for(int i = 0; i < s; i++){
                if(arr[i]>i+1){
                    k = -1;
                } else{
                    sum += i+1-arr[i];
                }
            }
            if(k==-1){
                System.out.println(-1);
            }else{
                System.out.println(sum);
            }
        }
	}
}
