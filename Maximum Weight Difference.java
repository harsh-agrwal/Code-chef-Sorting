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
		int T=sc.nextInt();
		while(T-->0){
		    int N=sc.nextInt();
		    int K=sc.nextInt();
		    int W[]=new int[N];
		    for(int i=0;i<N;i++){
		        W[i]=sc.nextInt();
		    }
		    int f=0,l=0;
		    int m=Math.min(K,N-K);
		    Arrays.sort(W);
		   
		    for(int i=0;i<m;i++){
		        f=f+W[i];
		    }
		    for(int i=m;i<N;i++){
		        l=l+W[i];
		    }
		    System.out.println(l-f);
		}
	}
}
