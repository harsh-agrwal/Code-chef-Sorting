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
		// your code goes here
		FastReader sc = new FastReader();
		PrintWriter pw = new PrintWriter(System.out);
		int n=sc.nextInt();
		while(n-->0)
		{
		    int siz=sc.nextInt();
		    int arr[] = new int[siz];
		    for(int i=0;i<siz;i++)
		    {
		        arr[i]=sc.nextInt();
		    }
		    Arrays.sort(arr);
		    if(siz==1)
		    {
		        pw.println(arr[0]);
		    }
		    else
		    {
		        long sum=0,c=0;
		        for(int i=siz-1;i>=1;i--)
		        {
		            if(arr[i]==arr[i-1])
		            {
		                c+=1;
		            }
		            else
		            {
		                if(sum<arr[i]+c)
		                    sum=arr[i]+c;
		                c=0;
		            }
		        }
		        pw.println(sum);
		    }
		    pw.flush();
		}
	}
}
