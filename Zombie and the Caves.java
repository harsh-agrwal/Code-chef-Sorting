/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;
  
        public FastReader()
        {
            br = new BufferedReader(
                new InputStreamReader(System.in));
        }
  
        String next()
        {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
  
        int nextInt() { return Integer.parseInt(next()); }
  
        long nextLong() { return Long.parseLong(next()); }
  
        double nextDouble()
        {
            return Double.parseDouble(next());
        }
  
        String nextLine()
        {
            String str = "";
            try {
                if(st.hasMoreTokens()){
                    str = st.nextToken("\n");
                }
                else{
                    str = br.readLine();
                }
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
	public static void main (String[] args) throws java.lang.Exception
	{
	    FastReader sc = new FastReader();
	    int t=sc.nextInt();
	    while(t-->0)
	    {
	        int n=sc.nextInt();
	        long a[]=new long[n];
	        long b[]=new long[n];
	        long c[]=new long[n];
	        for(int i=0;i<n;i++)
	            a[i]=sc.nextLong();
	        for(int i=0;i<n;i++)
	            b[i]=sc.nextLong();     
	        PriorityQueue<Long> pq=new PriorityQueue<>();
	        for(int i=0;i<n;i++)
	        {
	            pq.add(i+a[i]);
	            c[i]=pq.size();
	            while(pq.peek()==i)
	                pq.poll();
	        }
	        PriorityQueue<Long> p=new PriorityQueue<>(Collections.reverseOrder());
	        for(int i=n-1;i>=0;i--)
	        {
	            c[i]+=p.size();
	            p.add(i-a[i]);
	            while(p.peek()==i)
	                p.poll();
	        }
	        Arrays.sort(c);
	        Arrays.sort(b);
	        int i;
	        for(i=0;i<n;i++)
	        {
	            if(c[i]!=b[i])
	            break;
	        }
	        if(i==n)
	        System.out.println("YES");
	        else
	        System.out.println("NO");
	    }
		// your code goes here
	}
}
