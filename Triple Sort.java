/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{    static AnotherReader scn;
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		scn=new AnotherReader();
		int t=scn.nextInt();
		while(t-->0){
		    int N=scn.nextInt();
		    int k=scn.nextInt();
		    int arr[]=new int[N+1];
		    for(int i=1;i<=N;i++){
		        arr[i]=scn.nextInt();
		    }
		    solve(arr,k,N);
		}
	}
	public static void solve(int[]arr,int k,int N) {
		//arr started its indexing at 1 
		ArrayList<Triplet>triplet=new ArrayList<>();
		ArrayList<Pair>doub=new ArrayList<>();
		boolean visited[]=new boolean[arr.length];
		Arrays.fill(visited, false);
		for(int i=1;i<=N;i++) 
		{
			if(visited[i]==false) {
				int j=i;
			     Deque<Integer>cycle=new LinkedList<Integer>();
				while(visited[j]==false) {
					visited[j]=true;
					cycle.add(j);
					j=arr[j];
				}
				while(cycle.size()>2) {
					int z=cycle.pollLast();
					int y=cycle.pollLast();
					int x=cycle.peekLast();
					triplet.add(new Triplet(x,y,z));
					if(cycle.size()==1) {
						cycle.pollLast();
					}
					k=k-1;
				}
				if(cycle.size()==2) {
					doub.add(new Pair(cycle.poll(),cycle.poll()));
				}
			}
		}
		//we can even calculate size of triplet at the end to see if matched with original K then 
		//ans is possible else not 
		// also x is the connecting index if cycle contains elements more than 3 thus peekLast is used here
		
		while(doub.size()>1) {
			Pair one=doub.remove(0);
			Pair two=doub.remove(0);
			triplet.add(new Triplet(one.b,two.a,two.b));
			triplet.add(new Triplet(one.a,one.b,two.a));
			k=k-2;
		}
		if(doub.isEmpty()==false) {
			System.out.println("-1"); return;
		}
		if(k<0) {
			System.out.println("-1");
		}else {
			System.out.println(triplet.size());
			for(Triplet trip:triplet) {
				System.out.println(trip.x+" "+trip.y+" "+trip.z);
			}
		}
	}
	static class Triplet{
		int x;int y;int z;
		Triplet(int x,int y,int z){
			this.x=x;
			this.y=y; this.z=z;
		}
	}
	static class Pair{
		int a;int b;
		Pair(int a,int b){
			this.a=a; this.b=b;
		}
	}
	static class AnotherReader {
		BufferedReader br;
		StringTokenizer st;

		AnotherReader() {
		br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() {
			while (st == null || st.hasMoreElements() == false) {
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

	}
}
//time complexity is O(nlogn)
