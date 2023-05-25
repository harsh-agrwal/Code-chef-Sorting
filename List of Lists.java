/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner s=new Scanner(System.in);
		int t=s.nextInt();
		while(t-->0){
		    int n=s.nextInt();
		    int []a=new int[n];
		    int mx=Integer.MIN_VALUE;
		    for(int i=0;i<n;i++){
		        a[i]=s.nextInt();
		    //    mx=Math.max(mx,a[i]);
		    }
		    HashMap<Integer,Integer>mp=new HashMap<>();
		    HashSet<Integer>ans=new HashSet<>();
		    for(int j:a){
		        ans.add(j);
		        mp.put(j,mp.getOrDefault(j,0)+1);
		    }
		    for(int m:mp.values()){
		        mx=Math.max(mx,m);
		    }
		    
		    System.out.println((ans.size()==1)?0:(ans.size()==n)?-1:n-mx+1);
		}
	}
}
