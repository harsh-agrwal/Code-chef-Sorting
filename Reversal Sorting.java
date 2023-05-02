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
		    int x=s.nextInt();
		    int[] arr=new int[n];
		    for(int i=0;i<n;i++){
		        arr[i]=s.nextInt();
		    }
		    int i;
		    for( i=0;i<n-1;i++){
		        if(arr[i]>arr[i+1]){
		            int temp=arr[i];
		            arr[i]=arr[i+1];
		            arr[i+1]=temp;
		            if(arr[i]+arr[i+1]>x){
		                break;
		            }
		        }
		    }
		    System.out.println((i==n-1)?"YES":"NO");
		}
	}
}
