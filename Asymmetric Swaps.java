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
		Scanner RR=new Scanner(System.in);
		int T=RR.nextInt();
		while(T-->0){
		    int len=RR.nextInt();
		    
		    int arr[]=new int[2*len];
		    
		    for(int l=0;l<2*len;l++){
		        arr[l]=RR.nextInt();
		    }
		    
		    Arrays.sort(arr);
		    
		    int min_val=Integer.MAX_VALUE;
		    
		    for(int k=2*len-1;k>=len-1;k--){
		        
		        min_val=Math.min(min_val,(arr[k]-arr[k-len+1]));
		    }
		    System.out.println(min_val);
		    
		}
		
	}
}
