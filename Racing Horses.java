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
		while(t-- > 0 ){
		    int n = sc.nextInt();
		    int a[] = new int[n];
		    for (int i = 0 ; i < n ; i++ ) a[i] = sc.nextInt();
		    Arrays.sort( a );
		    int min = Integer.MAX_VALUE;
		    for ( int i = 0  ; i < n - 1 ; i++ ) {
		        min = Math.min( min , a[i + 1] - a[i] );
		    }
		    System.out.println( min );
		}
	}
}
