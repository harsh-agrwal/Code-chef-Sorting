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
		Scanner s=new Scanner(System.in);
		int t=s.nextInt();
		while(t-->0){
		    int n=s.nextInt();
		    int[]a=new int[n];
		    for(int i=0;i<n;i++){
		        a[i]=s.nextInt();
		    }
		    Arrays.sort(a);
		    int cnt=0;
		    for(int i=0;i<n;i++){
		      //  set.add(a);
		      if(i!=0&&a[i-1]==a[i]){
		          cnt++;
		      }
		    }
		    System.out.println(cnt);
		}
	}
}
