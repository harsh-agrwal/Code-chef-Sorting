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
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		while(T-->0){
		    int n=Integer.parseInt(br.readLine());
		    HashMap<Integer,Integer>num=new HashMap<>();
		    HashMap<Integer,String>names=new HashMap<>();
		    for(int i=0;i<n;i++){
		        String[] s=(br.readLine()).split(" ");
		        int un=Integer.parseInt(s[1]);
		        num.put(un,num.getOrDefault(un,0)+1);
		        names.put(un,s[0]);
		    }
		    int ans=Integer.MAX_VALUE;
		    for(int i:num.keySet()){
		        if(num.get(i)==1){
		            if(ans>i){
		                ans=i;
		            }
		        }
		    }
		    if(ans==Integer.MAX_VALUE){
		        System.out.println("Nobody wins.");
		    }
		    else{
		        System.out.println(names.get(ans));
		    }
		}
	}
}
