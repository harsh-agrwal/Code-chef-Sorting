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
		    char c[]=sc.next().toCharArray();
		    int dp[][]=new int[n][4];
		    for(int i=0;i<4;i++) dp[n-1][i]=i;
		    
		    for(int i=n-2;i>=0;i--){
		        for(int j=0;j<4;j++){
		            if(j==1) continue;
		            int next=c[i+1]-'P';
		            int win=winner(j,next);
		            dp[i][j]=dp[i+1][win];
		        }
		    }
		    for(int i=0;i<n;i++){
		        int p='P';
		        out.print((char)(p+dp[i][c[i]-'P']));
		    }
		    out.println();
		}
		out.close();
	}
	public static int winner(int a,int b){
	    int min=Math.min(a,b);
	    int max=Math.max(a,b);
	    if(a==b) return a;
	    else if(min==0){
	        if(max==2) return 0;
	        else return 3;
	    } else return 2;
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
