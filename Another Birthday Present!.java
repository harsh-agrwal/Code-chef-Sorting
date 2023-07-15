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
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
		   int info[]=new int[2];
		  
		   info[0]=sc.nextInt();
		   info[1]=sc.nextInt();
		   int n=info[0];
		   int k=info[1];
		    int a[]=new int[n];
		    for(int i=0;i<n;i++)a[i]=sc.nextInt();
		    
		   for(int i=0;i<n;i++)
    	   {
    		   for(int j=i+k;j<n;j=j+k)
    			{
    			    int temp = 0;
    				if(a[i]>a[j])
    				{
    					temp = a[i];
    					a[i] = a[j];
    					a[j] = temp;
    				}
    			}
    	   }
    	   int flag = 0;
    	   for(int i=0;i<n-1;i++)
    	   {
    		   if(a[i]>a[i+1])
    		   {
    		    flag = 1;
    		    break;
    		   }
    	   }
    	   if(flag==0)
    		   System.out.println("yes");
    	   else
    		   System.out.println("no");
    	 }
	}
}
