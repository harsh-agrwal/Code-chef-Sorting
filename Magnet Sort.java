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
		    int a[]=new int[n];
		    int b=0;
		    for(int i=0;i<n;i++){
		        a[i]=sc.nextInt();
		        if(i>0){
		            if(a[i]<a[i-1]){
		                b=1;
		            }
		        }
		    }
		    String s=sc.next();int c=0;
		    for(int i=0;i<n-1;i++){
		         if(s.charAt(i)!=s.charAt(i+1)){
		                c=1;
		            }
		    }
		    if(b==0){
		        System.out.println(0);
		    }
		    else if(c==0){
		        System.out.println(-1);
		    }
		    else if(s.charAt(0)!=s.charAt(n-1)){
		        System.out.println(1);
		    }
		    else{
		        int x=0;int max=0;int d=0;
		        int y=-1;
		        for(int i=0;i<n;i++){
		            if(s.charAt(i)!=s.charAt(0)){
		                if(y==-1){
		                    y=i;
		                }
		                x=i;
		            }
		        }
		        for(int i=0;i<=x;i++){
		            max=Math.max(a[i],max);
		        }
		        for(int j=x+1;j<n;j++){
		            if(a[j]<max){
		                d=1;
		            }
		            if(j<n-1){
		                if(a[j]>a[j+1]){
		                    d=1;
		                }
		            }
		        }
		        if(d==0){
		            System.out.println(1);continue;
		        }
		        int min=Integer.MAX_VALUE;
		        for(int j=n-1;j>=y;j--){
		            min=Math.min(a[j],min);
		        }
		        d=0;
		        for(int i=0;i<y;i++){
		            if(a[i]>min)
		            d=1;
		            if(i<y-1){
		                if(a[i]>a[i+1])
		                d=1;
		            }
		        }
		        if(d==0){
		            System.out.println(1);//;
		        }
		        else{
		            System.out.println(2);
		        }
		        
		    }
		}
	}
}
