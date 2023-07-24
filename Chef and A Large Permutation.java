/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.BigInteger;
import java.text.DecimalFormat;
 
class Main
{  
	static class pair{
		long area;int idx;
		pair(){}
		pair(long a,int b)
		{
		 area=a;
		 idx=b;
		}
	 }  

	 private static class Book {
	        int exercises;
	        String name;
	        int index;
	        public Book(){
	            this.index=0;
	        }
	    }
static class Rec
{
String s;
int pri;
}
static class Point  
{ 
    int x; 
    int y; 

    public Point(int x, int y) 
    { 
        this.x = x; 
        this.y = y; 
    } 
}; 

	static StringBuilder sb = new StringBuilder();
	 public static int rootColor=0;
	public static void main (String[] args) throws java.lang.Exception
	{  
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		FastReader in = new FastReader(System.in);
		Scanner sc = new Scanner(System.in);
		PrintWriter out=new PrintWriter(System.out);
		HashSet<Character> h2 = new HashSet<Character>();
		long t= in.nextLong();
		int mod = 1000000007;
		
		int[][] a;
			while(t-- > 0) {
				 long n=in.nextLong();
		            int k=in.nextInt();
		            long sum=0,p=0;
		            long arr[]=new long[k+1];
		            arr[0]=n+1;
		            for(int i=1;i<=k;i++)
		            {
		                arr[i]=in.nextInt();
		            }
		            Arrays.sort(arr);
		            for(int i=0;i<=k;i++)
		            {
		                long num=arr[i]-1;
		                p=1L*num*(num+1);
		                p/=2;
		                p-=sum;
		                if(p<arr[i])
		                {
		                    break;
		                }
		                sum+=arr[i];
		            }
		            p++;
		            if(p%2==0)
		                System.out.println("Mom");
		            else
		                System.out.println("Chef");
					}
	}
	
	public static boolean[] sieve(int n){
		boolean prime[] = new boolean[n+1];
		Arrays.fill(prime,true);
		prime[0] = prime[1] = false;
		
		int m = (int) Math.sqrt(n) + 1;
		for(int i=2;i<=m;i++)
			if(prime[i]) 
				for(int k=i*i;k<=n;k+=i) 
					prime[k] = false;
		
		return prime;
	}   
		 

			
	
	    static class FastReader {
		byte[] buf = new byte[2048];
		int index, total;
		InputStream in;FastReader(InputStream is) {
		    in = is;
		}	int scan() throws IOException {
		    if (index >= total) {
		        index = 0;
		        total = in.read(buf);
		        if (total <= 0) { return -1;
		        }
		    }
		    return buf[index++];
		}

		String next() throws IOException {
		    int c;
		    for (c = scan(); c <= 32; c = scan()) ;
		    StringBuilder sb = new StringBuilder();
		    for (; c > 32; c = scan()) {
		        sb.append((char) c);
		    }
		    return sb.toString();
		}String nextLine() throws IOException {
		    int c;
		    for (c = scan(); c <= 32; c = scan()) ;
		    StringBuilder sb = new StringBuilder();
		    for (; c != 10 && c != 13; c = scan()) {
		        sb.append((char) c);
		    }
		    return sb.toString();
		}char nextChar() throws IOException {
		    int c;
		    for (c = scan(); c <= 32; c = scan()) ;
		    return (char) c;
		}	int nextInt() throws IOException {
		    int c, val = 0;
		    for (c = scan(); c <= 32; c = scan()) ;
		    boolean neg = c == '-';
		    if (c == '-' || c == '+') {
		        c = scan(); }
		    for (; c >= '0' && c <= '9'; c = scan()) {
		        val = (val << 3) + (val << 1) + (c & 15);
		    }
		    return neg ? -val : val;
		}long nextLong() throws IOException {
		    int c;
		    long val = 0;
		    for (c = scan(); c <= 32; c = scan()) ;
		    boolean neg = c == '-';
		    if (c == '-' || c == '+') {
		        c = scan();
		    }
		    for (; c >= '0' && c <= '9'; c = scan()) {
		        val = (val << 3) + (val << 1) + (c & 15);
		    }
		    return neg ? -val : val;
		}
	    }
			}

			    	
