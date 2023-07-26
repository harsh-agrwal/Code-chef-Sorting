/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
   
	public static void main (String[] args) throws java.lang.Exception
	{
		PrintWriter out = new PrintWriter(System.out);
		FastReader sc = new FastReader();
		int testCases = sc.nextInt();
		while(testCases-->0){
		    int n=sc.nextInt();
		    int q = sc.nextInt();
		    int dp[][]=new int[n+1][2];
		    for(int i=0;i<n;i++)  dp[i][1]=i;
		    int a[]=new int[n];
		    for(int i=0;i<n;i++) a[i]=sc.nextInt();
		    Arrays.sort(a);
		    for(int i=0;i<q;i++) {
		        int l=sc.nextInt()-1;
		        int r=sc.nextInt()-1;
		        dp[l][0]++;
		        dp[r+1][0]--;
		    }
		    for(int i=1;i<n;i++) dp[i][0]+=dp[i-1][0];
		    dp[n][0]=Integer.MAX_VALUE;
		    Arrays.sort(dp,(x,y)->x[0]-y[0]);
		    int res[]=new int[n];
		    long sum=0;
		    for(int i=n-1;i>=0;i--) {
		        res[dp[i][1]]=a[i];
		        sum+=(long)a[i]*(long)(dp[i][0]);
		    }
		    out.println(sum);
		    for(int i=0;i<n;i++) out.print(res[i]+" ");
		    out.println();
		    
		    
		}
		out.close();
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
