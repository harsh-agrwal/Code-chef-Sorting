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
		Scanner sc  = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0)
		{
		    int n = sc.nextInt();
		    int k = sc.nextInt();
		    int a[] = new int[n];
		   HashSet<Integer> hs = new HashSet<>();
		    for(int i=0;i<n;i++)
		    {
		        a[i] = sc.nextInt();
		        hs.add(a[i]);
		    }
		    for(int i =0;i<Integer.MAX_VALUE;i++)
		    {
		        if(!hs.contains(i) )
		        {  
		            hs.add(i);
		            k--;
		            if(k==-1)
		            {
		                System.out.println(i);
		                break;
		            }
		        }
		    }
		}
	}
}
