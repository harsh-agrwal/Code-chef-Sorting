/* package codechef; // don't place package name! */

import java.io.*;
import java.util.*;
class colarr 
{
    int pts,lead,ind;
    public colarr(int p,int l,int i)
    {
        this.pts=p;
        //this.rept=r;
        this.ind=i;
        this.lead=l;
    }
    public static void main(String args[])throws IOException
    {
        Reader sc=new Reader();
        PrintWriter pw=new PrintWriter(System.out);
        int t=sc.nextInt();
        for(int z=1;z<=t;z++)
        {
            int n=sc.nextInt();
            int m=sc.nextInt();
            int k=sc.nextInt();
            Integer org[]=new Integer[n+1];
            Integer gain[][]=new Integer[n+1][m+1];
            for(int i=1;i<=n;i++)
            {
                org[i]=sc.nextInt();
            }
            for(int i=1;i<=n;i++)
            {
                for(int j=1;j<=m;j++)
                {
                    gain[i][j]=sc.nextInt();
                }
            }
             List<colarr> list=new ArrayList<>();int res=0;
            boolean vis[]=new boolean[n+1];
            for(int i=1;i<=n;i++)
            {
                int max=0;
                for(int j=1;j<=m;j++)
                {
                    int num=sc.nextInt();
                    if(j!=org[i])
                    {
                        gain[i][j]-=num;
                    }
                    //System.out.print(gain[i][j]+" ");
                    max=Math.max(max,gain[i][j]);
                }
                //System.out.println();;
                if(max>gain[i][org[i]])
                    list.add(new colarr(max,max-gain[i][org[i]],i));
                else
                {
                    vis[i]=true;
                    //System.out.println(i);
                    res+=max;
                }
            }
            Collections.sort(list,new Comparator<colarr>(){
               public int compare(colarr ob1,colarr ob2)
               {
                   return Integer.compare(ob1.lead,ob2.lead);
               }
            });
            Collections.reverse(list);
            int p=0;
            while(k>0 && p<list.size())
            {
                
                colarr ob=list.get(p);
                res+=ob.pts;
                //System.out.println(ob.ind+" "+ob.lead+" "+ob.pts);
                vis[ob.ind]=true;
                k--;p++;
            }
            for(int i=1;i<=n;i++)
            {
                if(!vis[i])
                    res+=gain[i][org[i]];
            }
            pw.println(res);
        }
        pw.close();
    }
}
class Reader {
		final private int BUFFER_SIZE = 1 << 16;
		private DataInputStream din;
		private byte [] buffer;
		private int bufferPointer, bytesRead;
		
		public Reader () {
			din = new DataInputStream (System.in);
			buffer = new byte[BUFFER_SIZE];
			bufferPointer = bytesRead = 0;
		}
		
		public Reader (String file_name) throws IOException {
			din = new DataInputStream (new FileInputStream (file_name));
			buffer = new byte[BUFFER_SIZE];
			bufferPointer = bytesRead = 0;
		}
		
		public String readLine () throws IOException {
			byte [] buf = new byte[1024];
			int cnt = 0, c;
			while ((c = read ()) != -1) {
				if (c == '\n')
					break;
				buf[cnt++] = (byte) c;
			}
			return new String (buf, 0, cnt);
		}
		
		public int nextInt () throws IOException {
			int ret = 0;
			byte c = read ();
			while (c <= ' ')
				c = read ();
			boolean neg = (c == '-');
			if (neg)
				c = read ();
			do {
				ret = ret * 10 + c - '0';
			} while ((c = read ()) >= '0' && c <= '9');
			if (neg)
				return -ret;
			return ret;
		}
		
		public long nextLong () throws IOException {
			long ret = 0;
			byte c = read ();
			while (c <= ' ')
				c = read ();
			boolean neg = (c == '-');
				if (neg)
				c = read ();
			do {
				ret = ret * 10 + c - '0';
			} while ((c = read ()) >= '0' && c <= '9');
			if (neg)
				return -ret;
			return ret;
		}
		
		public double nextDouble () throws IOException {
			double ret = 0, div = 1;
			byte c = read ();
			while (c <= ' ')
				c = read ();
			boolean neg = (c == '-');
			if (neg)
				c = read ();
			do {
				ret = ret * 10 + c - '0';
			} while ((c = read ()) >= '0' && c <= '9');
			if (c == '.')
				while ((c = read ()) >= '0' && c <= '9')
					ret += (c - '0') / (div *= 10);
			if (neg)
				return -ret;
			return ret;
		}
		
		private void fillBuffer () throws IOException {
			bytesRead = din.read (buffer, bufferPointer = 0, BUFFER_SIZE);
			if (bytesRead == -1)
				buffer[0] = -1;
		}
		
		private byte read () throws IOException {
		    	if (bufferPointer == bytesRead)
				fillBuffer ();
			return buffer[bufferPointer++];
		}
		
		public void close () throws IOException {
			if (din == null)
				return;
			din.close ();
		}
	}
