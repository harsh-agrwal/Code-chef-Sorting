/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		FastReader sc=new FastReader();
		PrintWriter out=new PrintWriter(System.out);
		int test=sc.nextInt();
		while(test-->0){
		   int n=sc.nextInt();
		   int f[]=new int[n];
		   for(int i=0;i<n;i++){
		       f[i]=sc.nextInt();
		   }
		   int c[]=new int[n];
		   for(int i=0;i<n;i++){
		       c[i]=sc.nextInt();
		   }
		   PriorityQueue<int[]>pq=new PriorityQueue<>((a,b)->a[0]-b[0]);
		   for(int i=0;i<n;i++){
		       pq.add(new int[]{c[i],f[i]});
		   }
		   int total=0;
		   long cost=0;
		   while(total<n){
		       int a[]=pq.poll();
		       while(a[1]>0&&total<n){
		           total++;
		           cost+=a[0];
		           a[1]--;
		       }
		   }
		   out.println(cost);
		}
		out.close();
	}
	static class FastReader {
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
}
