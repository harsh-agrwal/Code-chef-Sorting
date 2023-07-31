import java.io.*;

import java.util.*;
/*

*/

 
  class A{
	static FastReader sc=null;
	
	public static void main(String[] args) {
		sc=new FastReader();
		int t=sc.nextInt();
		while(t-->0) {
			int n=sc.nextInt(),m=sc.nextInt();
			int r[]=sc.readArray(n);
			
			int c[][]=new int[n][m];
			for(int i=0;i<n;i++)
				c[i]=sc.readArray(m);
			
			Pair bestRank[]=new Pair[n],bestRating[]=new Pair[n];
			for(int i=0;i<n;i++) {
				bestRank[i]=new Pair(n+1,-1);
				bestRating[i]=new Pair(0,-1);
			}
			
			for(int i=0;i<m;i++) {
				Pair p[]=new Pair[n];
				for(int j=0;j<n;j++) {
					r[j]+=c[j][i];
					if(bestRating[j].r<r[j]) {
						bestRating[j].r=r[j];
						bestRating[j].id=i;
					}
					p[j]=new Pair(r[j],j);
				}
				Arrays.sort(p);
				
				int rank=0;
				for(int j=0;j<n;j++) {
					if(bestRank[p[j].id].r>rank) {
						bestRank[p[j].id].r=rank;
						bestRank[p[j].id].id=i;
					}
					if(j+1<n && p[j].r!=p[j+1].r)rank=j+1;
				}
			}
			
			int cnt=0;
			for(int i=0;i<n;i++) {
				if(bestRank[i].id!=bestRating[i].id) {
					cnt++;
				}
			}
			System.out.println(cnt);
			
		}
	}
	static class Pair implements Comparable<Pair>{
		int r,id;
		Pair(int r,int id){
			this.r=r;
			this.id=id;
		}
		
		public int compareTo(Pair o) {
			return o.r-this.r;
		}
	}
	
	static int[] ruffleSort(int a[]) {
		ArrayList<Integer> al=new ArrayList<>();
		for(int i:a)al.add(i);
		Collections.sort(al);
		for(int i=0;i<a.length;i++)a[i]=al.get(i);
		return a;
	}
	
	static void print(int a[]) {
		for(int e:a) {
			System.out.print(e+" ");
		}
		System.out.println();
	}
	
	static class FastReader{
		
		StringTokenizer st=new StringTokenizer("");
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		String next() {
			while(!st.hasMoreTokens()) 
				try {
					st=new StringTokenizer(br.readLine());
				}
			   catch(IOException e){
				   e.printStackTrace();
			   }
			return st.nextToken();
		}
		
		int nextInt() {
			return Integer.parseInt(next());
		}
		
		long nextLong() {
			return Long.parseLong(next());
		}
		
		int[] readArray(int n) {
			int a[]=new int[n];
			for(int i=0;i<n;i++)a[i]=sc.nextInt();
			return a;
		}
	}
	
	
}
