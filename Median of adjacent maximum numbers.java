/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc=new Scanner(System.in);
		int test=sc.nextInt();
		while(test>0)
		{
		    int n=sc.nextInt();
		    int a[]=new int[2*n];
		    int i;
		    for(i=0;i<2*n;i++)
		    {
		        a[i]=sc.nextInt();
		    }
		    Arrays.sort(a);
		    System.out.println(a[n+n/2]);
		    for(i=0;i<n;i++)
		    System.out.print(a[i]+" "+a[n+i]+" ");
		    System.out.print("\n");
		    test--;
		}	// your code goes here
	}
}
