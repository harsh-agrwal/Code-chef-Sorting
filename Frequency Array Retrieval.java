/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Item{
    int value;
    int count;
    
    Item(int value,int count){
        this.count=count;
        this.value = value;
    }
}
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Scanner sc = new Scanner(System.in);
		int t=sc.nextInt();
		StringBuilder op=new StringBuilder("");
		
		while(t-->0){
		      int n = sc.nextInt();
		      int[] arr = new int[n];
		      
		      for(int i=0;i<n;i++){
		          arr[i]=sc.nextInt();
		      }
		      
		      HashMap<Integer,Item> hmp = new HashMap<Integer,Item>();
		      
		      int cntr = 1;
		      StringBuilder res = new StringBuilder("");
		      for(int i=0;i<n;i++){
		          if(hmp.containsKey(arr[i])){
		              Item val = hmp.get(arr[i]);
		              
		              if(arr[i] == val.count){
		                  hmp.put(arr[i],new Item(cntr,1));
		                  cntr++;
		              }
		              else{
		                  hmp.put(arr[i],new Item(val.value,val.count+1));
		              }
		              res.append(hmp.get(arr[i]).value+" ");
		          }
		          else{
		              hmp.put(arr[i],new Item(cntr,1));
		              res.append(hmp.get(arr[i]).value+" ");
		              cntr++;
		          }
		      }
		      
		      for(Map.Entry<Integer,Item> item:hmp.entrySet()){
		          if(item.getKey()!=item.getValue().count){
		              res=new StringBuilder("-1");
		          }
		      }
		      
		      res.append("\n");
		      op.append(res);
		    
		}
		
		System.out.print(op.toString());
		
	}
}
