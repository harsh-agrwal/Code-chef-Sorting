/* package codechef; // don't place package name! */

import java.io.*;
import java.util.*;
import java.math.*;
import java.lang.*;

class Point implements Comparable<Point>
{
    int x,y;
    public Point(int x1,int y1)
    {
        x=x1;
        y=y1;
    }
    public int compareTo(Point p)
    {
        if(p.x<x)
            return 1;
        if(p.x>x)
            return -1;
        if(p.y<y)
            return 1;
        if(p.y>y)
            return -1;
        return -1;
    }
}
class Pair
{
    int a,b;
    public Pair(int x,int y)
    {

        a=x;
        b=y;
    }
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pair other = (Pair) obj;
        if (this.a != other.a) {
            return false;
        }
        if (this.b != other.b) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + this.a;
        hash = 23 * hash + this.b;
        return hash;
    }
}
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try
        {
            Parserdoubt pd=new Parserdoubt(System.in);
            while(true)
            {
                int n=pd.nextInt();
                if(n==0)break;
                Point pts[]=new Point[n];
                for(int i=0;i<n;i++)
                    pts[i]=new Point(pd.nextInt(),pd.nextInt());
                Arrays.sort(pts);
                HashMap <Pair,Integer> map=new HashMap<Pair,Integer>();
                long counts[]=new long[100000];
                int c=0;
                for(int i=1;i<pts.length;i++)
                {
                    if(pts[i].x==pts[i-1].x)
                    {
                        int tmp1=pts[i-1].y;
                        int tmp2=pts[i].y;
                        Pair tmp=new Pair(tmp1,tmp2);
                        if(map.containsKey(tmp))
                        {
                            counts[map.get(tmp)]++;
                        }
                        else
                        {
                            map.put(tmp, c++);
                        }
                    }
                }
                long sum=0;
                for(int i=0;i<c;i++)
                {
                    long temp=counts[i]*(counts[i]+1);
                    temp/=2;
                    sum+=temp;
                }
                System.out.println(sum);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}


class Parserdoubt
	{
	   final private int BUFFER_SIZE = 1 << 17;

	   private DataInputStream din;
	   private byte[] buffer;
	   private int bufferPointer, bytesRead;

	   public Parserdoubt(InputStream in)
	   {
	      din = new DataInputStream(in);
	      buffer = new byte[BUFFER_SIZE];
	      bufferPointer = bytesRead = 0;
	   }
	   public String nextString() throws Exception
	   {
		   StringBuffer sb=new StringBuffer("");
		   byte c = read();
		   while (c <= ' ') c = read();
		   do
		   {
			   sb.append((char)c);
			   c=read();
		   }while(c>' ');
		   return sb.toString();
	   }
	   public char nextChar() throws Exception
	   {
		   byte c=read();
		   while(c<=' ') c= read();
		   return (char)c;
	   }
	   public int nextInt() throws Exception
	   {
	      int ret = 0;
	      byte c = read();
	      while (c <= ' ') c = read();
	      boolean neg = c == '-';
	      if (neg) c = read();
	      do
	      {
	    	  ret = ret * 10 + c - '0';
	         c = read();
	      } while (c > ' ');
	      if (neg) return -ret;
	      return ret;
	   }
	   public long nextLong() throws Exception
	   {
	      long ret = 0;
	      byte c = read();
	      while (c <= ' ') c = read();
	      boolean neg = c == '-';
	      if (neg) c = read();
	      do
	      {
	    	  ret = ret * 10 + c - '0';
	         c = read();
	      } while (c > ' ');
	      if (neg) return -ret;
	      return ret;
	   }
	   private void fillBuffer() throws Exception
	   {
	      bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
	      if (bytesRead == -1) buffer[0] = -1;
	   }

	   private byte read() throws Exception
	   {
	      if (bufferPointer == bytesRead) fillBuffer();
	      return buffer[bufferPointer++];
	   }
	}
