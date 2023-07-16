/* package codechef; // don't place package name! */

import java.util.*;
    import java.lang.*;
    import java.io.*;
     
    /* Name of the class has to be "Main" only if the class is public. */
    class CHEFHOME
    {
    	public static void main (String[] args) throws java.lang.Exception
    	{
    		// your code goes here
    		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    		int T = Integer.parseInt(br.readLine());
    		for(int p=0;p<T;p++)
    		{
    		    int N = Integer.parseInt(br.readLine());
    		    long[] a = new long[N];
    		    long[] b = new long[N];
    		    for(int i=0;i<N;i++)
    		    {
    		    String line = br.readLine();
    		    String[] h = line.split(" ");
    		    a[i] = Long.parseLong(h[0]);
    		    b[i] = Long.parseLong(h[1]);
    		    
    		    }
    		    Arrays.sort(a);
    		    Arrays.sort(b);
    		    
    		    long ans1 = a[N/2] - a[(N-1)/2] +1;
    		    long ans2 = b[N/2] - b[(N-1)/2] +1;
    		    
    		    System.out.println(ans1*ans2);
    	   }
    	}
    } 
