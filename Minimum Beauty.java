/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
   static int mod = (int)1e9+7;
	public static void main (String[] args) throws java.lang.Exception
	{
		PrintWriter out = new PrintWriter(System.out);
		FastReader sc = new FastReader();
		int testCases = sc.nextInt();
		while(testCases-->0){
		    int n=sc.nextInt();
		    int a[][]=new int[n][2];
		    for(int i=0;i<n;i++) {
		        a[i][1]=sc.nextInt();
		        a[i][0]=i;
		    }
		    Arrays.sort(a,(x,y)->x[1]-y[1]);
		    int min=Integer.MAX_VALUE;
		    for(int i=1;i<n;i++){
		        int target = 2*a[i][1];
		        int l=0,h=n-1;
		        while(l<i && h>i){
		            int sum=a[l][1]+a[h][1];
		            min = Math.min(min,Math.abs(target-sum));
		            if(sum>target) h--;
		            else l++;
		        }
		    }
		    out.println(min);
		    
		    
		}
		out.close();
	}
	public static long pow(long a,long b){
	    long prd=1;
	    while(b>0){
	        if(b%2==0){
	            b/=2;
	            a = (a*a)%mod;
	        } else {
	            b--;
	            prd = (prd*a)%mod;
	        }
	    }
	    return prd;
	}
}


class FastReader {
	BufferedReader br;
	StringTokenizer st;

	public FastReader() {
		br = new BufferedReader(
				new InputStreamReader(System.in));
	}

	String next() {
		while (st == null || !st.hasMoreElements()) {
			try {
				st = new StringTokenizer(br.readLine());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return st.nextToken();
	}

	int nextInt() {
		return Integer.parseInt(next());
	}

	long nextLong() {
		return Long.parseLong(next());
	}

	double nextDouble() {
		return Double.parseDouble(next());
	}

	String nextLine() {
		String str = "";
		try {
			str = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return str;
	}
}
