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
		    int arr[]=new int[n];
		    for(int i=0;i<n;i++){
		        arr[i]=sc.nextInt();
		    }
		    List<Integer>index=new ArrayList<>();
		    for(int i=0;i<n;i++) index.add(i);
		    Collections.sort(index,(i,j)->arr[i]-arr[j]);
		    int max=Integer.MIN_VALUE;
		    int min=Integer.MAX_VALUE;
		    long cost=0;
		    int curr=0;
		    for(int i=0;i<n;i++){
		        curr=Math.max(curr,index.get(i));
		        max=Math.max(max,arr[i]);
		        min=Math.min(min,arr[i]);
		        if(i==curr){
		            cost+=max-min;
		            max=Integer.MIN_VALUE;
		            min=Integer.MAX_VALUE;
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
	 static class DSU{
        int n;
        int parent[];
        int rank[];
        int size[];
        public DSU(int n){
            this.n=n;
            parent=new int[n];
            rank=new int[n];
            size=new int[n];
            for(int i=0;i<n;i++) parent[i]=i;
            for(int i=0;i<n;i++) size[i]=1;
        }
        public int find(int v){
            if(parent[v]==v) return v;
            return parent[v]=find(parent[v]);
        }
        public void union(int v1,int v2){
            int p1=find(v1);
            int p2=find(v2);
            if(p1==p2) return ;
            if(rank[p1]>rank[p2]){
                parent[p2]=p1;
                size[p1]+=size[p2];
            }
            else if(rank[p2]>rank[p1]){
                parent[p1]=p2;
                size[p2]+=size[p1];
            }
            else {
                rank[p1]++;
                parent[p2]=p1;
                size[p1]+=size[p2];
            }
        }
    }
}
