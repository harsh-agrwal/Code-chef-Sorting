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
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0){
		    int n = sc.nextInt();
		    int[] a = new int[n];
		    for(int i=0;i<n;i++){
		        a[i] = sc.nextInt();
		    }
		    int ans = 0;
		    if(n<=2){
		        System.out.println(ans);
		    }else{
		        Map<Integer,Integer> map = new HashMap<>();
		        int max = 0;
		         for(int i = 0; i < n; i++) {
		            map.put(a[i], map.getOrDefault(a[i],0)+1);
		            max = Math.max(max, map.get(a[i]));
		        }
		        System.out.println(n-Math.max(max, 2));
		    }
		    
		}
	}
}
