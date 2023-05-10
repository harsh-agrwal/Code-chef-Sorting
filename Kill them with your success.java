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
		Scanner in=new Scanner(System.in);
	    int te=in.nextInt();
	    while(te-->0)
	    {
	        int n=in.nextInt();
	        double ar[]=new double[n];
	        for(int i=0;i<n;i++)
	        {
	            ar[i]=in.nextInt();
	        }
	       
	       double res=0;
	        PriorityQueue<Double> pq=new PriorityQueue<>(Collections.reverseOrder()); // max priority PriorityQueue
	        
	        for(int i=0;i<n;i++)
	        {
	            pq.add(ar[i]);
	        }
	        
	        while(pq.size()!=1)
	        {
	            double a=pq.poll(); // get the value as well as remove the value
	            double b=pq.poll();
	            res=(a+b)/2;
	            pq.add(res);
	        }
	        
	        System.out.printf("%.8f\n",res);
	   }
	}
}
