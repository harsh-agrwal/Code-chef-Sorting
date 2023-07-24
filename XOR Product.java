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
		
		while( t-- > 0 ){
		    int n = sc.nextInt();
		    int a [] = new int[n];
		    
		    for (int i = 0 ; i < n ; i++ ) {
		        a[i] = sc.nextInt();
		    }
		    
		    Arrays.sort( a );
		    
		    int one = 0;
		    
		    for( int ele : a ){
		        if( ele == 1 ) one++;
		        
		        if( ele > 1 ) break;
		    }
		    
		    for( int i = 0 ; i < n && one > 0 ; i++ ){
		        if( (a[i]&1) == 0 ){
		            a[i] = a[i]^1;
		            one--;
		        }
		    }
		    
		    long mod = 998244353;
		    
		    long ans = 1;
		    
		    for( int ele : a ){
		        ans *= ele;
		        ans %= mod;
		    }
		    
		    System.out.println( ans );
		}
	}
}
