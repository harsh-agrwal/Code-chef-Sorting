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
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
		    int n=sc.nextInt();
		    int []arr=new int[n];
		    for(int x=0;x<n;x++){
		        arr[x]=sc.nextInt();
		    }
		    HashMap<Integer,Integer>mymap=new HashMap<>();
		    for(int i:arr){
		        if(mymap.containsKey(i)){
		            mymap.put(i,mymap.get(i)+1);
		        }
		        else{
		            mymap.put(i,1);
		        }
		    }
		    ArrayList<Integer>mylist=new ArrayList<>();
		    for(int key:mymap.keySet()){
		        mylist.add(mymap.get(key));
		    }
		    long ans=1;
		    int mod=(int)1e9+7;
		    for(int i=0;i<mylist.size();i++){
		        ans=(ans*(mylist.get(i)+1))%mod;
		        ans%=mod;
		    }
		    System.out.println(ans-1);
		}
	}
}
