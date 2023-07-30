/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.BigInteger;
import java.text.DecimalFormat;
 
class Main
{  
	static class box implements Comparable<box>
	{
	int balls;
	int color;
	public box(int balls, int color)
	{	this.balls = balls;
	this.color = color;
}
@Override
public int compareTo (box ob)
{	
	 return(Integer.compare(this.balls, ob.balls));
}
}
static class Color implements Comparable {
    Integer color;
    Integer value;

    public Color(Integer color, Integer value) {
        this.color = color;
        this.value = value;
    }

    @Override
    public int compareTo(Object o) {
        return Integer.compare(this.value, ((Color)o).value);
    }
}
static	class PairComparator implements Comparator<Pair>{
	public int compare(Pair p1, Pair p2) {
		return Integer.compare(p2.x, p1.x);}
}
static		class Pair {
int i,j,x;
public Pair(int i,int j, int x){
	this.i= i;
	this.j=j;
	this.x=x;
}
}
static class Triplet
{
int x[]=new int[3];
Triplet(int a,int b,int c)
{
 this.x[0]=a;
 this.x[1] =b;
 this.x[2] = c;
}
}
static class Rec
{
String s;
int pri;
}static class Point  
{ 
int x; 
int y; 
public Point(int x, int y) 
{ 
this.x = x; 
this.y = y; } 
}; 
static long phi[]=new long[1000001];
static long ans[]=new long[1000001];
static int tree[],sum[];
public static long mod = 1000000007;
public static long [][] tempMatrix;
public static long max = (long) Math.pow(10, 9) + 7;
	static StringBuilder sb = new StringBuilder();
	 public static int rootColor=0;
	 static boolean primes[]=new boolean[10000001];
	public static void main (String[] args) throws java.lang.Exception
	{  
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		FastReader in = new FastReader(System.in);
		Scanner sc = new Scanner(System.in);
		PrintWriter out=new PrintWriter(System.out);
		long mod = 1000000007;
int t=in.nextInt();
		 while(t-->0)
		{
				int n = in.nextInt();
				int[] a1 = new int[n];
				int[] a2 = new int[n];
				for(int i=0;i<n;i++)
				{
					int x = in.nextInt();
					int y = in.nextInt();
					a1[i] = x-y;
					a2[i] = x+y;
				}
				Arrays.sort(a1);
				Arrays.sort(a2);
				int min = Integer.MAX_VALUE;
				for(int i=0;i<n-1;i++)
				{
					min = Math.min(min, a1[i+1]-a1[i]);
					min = Math.min(min, a2[i+1]-a2[i]);
						
				}
					System.out.println(min/2.0);
				 }
}
 static long power(long x, long y, long p) 
    { 
        
        long res = 1;      
         
    
        x = x % p;  
  
       if (x == 0) return 0;     
  
        while (y > 0) 
        { 
           
            if((y & 1)==1) 
                res = (res * x) % p; 
       
            y = y >> 1;  
            x = (x * x) % p;  
        }   return res; 
    } static int gcd(int n, int m) {
	    if(m == 0) return n;
	    return gcd(m, n % m);
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
	    int c;for (c = scan(); c <= 32; c = scan()) ;
	    StringBuilder sb = new StringBuilder();
	    for (; c != 10 && c != 13; c = scan()) {
	        sb.append((char) c);
	    } return sb.toString();
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
