/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
    public static int upperbound(int[] arr, int n, int key){
        int lo=0;
        int hi=n-1;
        
        while(lo<=hi){
            int mid=lo+(hi-lo)/2;
            if(arr[mid]<=key){
                lo=mid+1;
            }
            else{
                hi=mid-1;
            }
        }
        
        return lo;
    }
    
    public static int getNumOfStudentBoasting(int[] arr){
        int n=arr.length;
        Arrays.sort(arr);
        int cnt=0;
        for(int i=0; i<n; i++){
            int ubi=upperbound(arr, n, arr[i]);
            int lessOrEq=ubi;
            int more=n-ubi;
            if(lessOrEq>more){
                cnt++;
            }
        }
        return cnt;
    }
    
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc=new Scanner(System.in);
		int q=sc.nextInt();
		while(q-->0){
		    int n=sc.nextInt();
		    int[] arr=new int[n];
		    for(int i=0; i<n; i++){
		        arr[i]=sc.nextInt();
		    }
		    int res=getNumOfStudentBoasting(arr);
		    System.out.println(res);
		}
	}
}
