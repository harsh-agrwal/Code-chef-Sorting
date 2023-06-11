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
		int t=Integer.parseInt(br.readLine()),n,i,m,p;
		long sum,x;
		
		while(t-->0){
		    n=Integer.parseInt(br.readLine());
		    String s[]=br.readLine().split(" ");sum=0;m=0;
		    long a[]=new long[n];p=0;
		    
		    for(i=0;i<n;i++)
		     {x=Long.parseLong(s[i]);
		     if(x>=0){sum+=x;p++;}
		     else{a[m]=x;m++;}}
		     
		    if(m>0)
		    {Arrays.sort(a,0,m);
		    for(i=m-1;i>=0;i--)
		    {
		        if((sum+a[i])*(p+1)<=sum*p+a[i])
		        break;
		        sum+=a[i];
		        p++;
		    }
	        sum=p*sum;
		    for(i=0;i<n-p;i++)
		    sum+=a[i];
		    }
		    else
		    sum=p*sum;
		    System.out.println(sum);
		}
	}
}
