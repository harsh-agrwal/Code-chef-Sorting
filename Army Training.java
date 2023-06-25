/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(br.readLine()),n;long x,y,m;
		while(t-->0){
		    n=Integer.parseInt(br.readLine());x=0L;y=0L;m=0L;
		    String s[]=br.readLine().split(" ");int a[]=new int[n];
		    for(int i=0;i<n;i++)
		    {a[i]=Integer.parseInt(s[i]);x+=a[i];}
		    Arrays.sort(a);
		    for(int i=0;i<n;i++)
		    {x-=a[i];y+=1000-a[i];
	        if(x*y>m)m=x*y;}
		    System.out.println(m);
		}
	}
}
