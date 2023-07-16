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
		    int n=sc.nextInt();
		    int a[]=new int[n];
		    int min=Integer.MAX_VALUE;
		    int x=0;
		    for(int i=0;i<n;i++){
		        a[i]=sc.nextInt();
		        if(a[i]<min){
		            x=i;min=a[i];
		        }
		    }
		    int max=0;int y=(x+1)%n;int count=0;
		    for(int i=0;i<n;i++){
		        if(a[i]==min){
		            count++;
		        }
		    }
	//	    System.out.println(max+"A");
		    long ans=0;
		    ans=(long)((long)(min+1)*(long)n);
		    ans=ans-count;
		    System.out.println(ans);
		}
	}
}
