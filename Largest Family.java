/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		while(T-->0){
		    int n=Integer.parseInt(br.readLine());
		    String[] s=(br.readLine()).split(" ");
		    int[] arr=new int[n];
		    for(int i=0;i<n;i++){
		        arr[i]=Integer.parseInt(s[i]);
		    }
		    Arrays.sort(arr);
		    long sum=0;
		    int i=0,count=0;
		    while(i<n&&sum<n){
		        sum+=1L*arr[i];
		        i++;
		        if(sum<n){
		            count++;
		        }
		    }
		    System.out.println(count);
		}
		// your code goes here
	}
}
