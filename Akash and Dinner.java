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
        while(t-- > 0){
            int n  =sc.nextInt();
            int k = sc.nextInt();
            int [] cats = new int [n];
            int [] time = new int [n];
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for(int i = 0; i<n; i++){
                cats[i] = sc.nextInt();
                min = Math.min(min, cats[i]);
                max = Math.max(max, cats[i]);
            }
            for(int  i= 0; i<n; i++)time[i] = sc.nextInt();
            int [] optTime = new int [max+1];
            Arrays.fill(optTime, Integer.MAX_VALUE);
            for(int i = 0; i<n; i++){
                optTime[cats[i]] = Math.min(optTime[cats[i]], time[i]);
            }
            long res = 0;
            int distCat = 0;
            Arrays.sort(optTime);
            for(int i = 0; i<=max && distCat<k; i++){
                if(optTime[i] < Integer.MAX_VALUE){
                    res += optTime[i];
                    distCat++;
                }
            }
            if(distCat==k) System.out.println(res);
            else System.out.println(-1);
        }
	}
}
