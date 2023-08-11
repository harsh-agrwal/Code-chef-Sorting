/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
    Input1 aa;
    public void calc() throws Exception 
    {
        int n=ni();
        int f=ni();
        int ar[]=new int[n];
        long ans=0L;
        int i,b;
        for(i=0;i<n;i++)
        {
            ar[i]=ni();
        }
        Arrays.sort(ar);
        Map<Integer,Integer> hm=new HashMap<>();
        for(i=0;i<n;i++)
        {
             if(hm.containsKey(ar[i]))
                {
                    ans=ans+(long)hm.get(ar[i]);
                    hm.put(ar[i],hm.get(ar[i])+1);
                }
                else 
                hm.put(ar[i],1);
                b=ar[i];
                while(b>=f && b%f==0)
                {
                    b=b/f;
                    if(hm.containsKey(b))
                    ans = ans + (long)hm.get(b);
                }
            
        }
        System.out.println(ans);
    }
    public void run() throws Exception 
    {
        aa=new Input1();
        int t=ni();
        while(t-->0)
        {
            calc();
        }
    }
	public static void main (String[] args) throws java.lang.Exception
	{
		try{
		    new Codechef().run();
		}
		catch(Exception ee)
		{
		    
		}
	}
	public int ni() throws Exception 
	{
	    return Integer.parseInt(aa.next());
	}
	class Input1 
	{
	    BufferedReader br;
	    StringTokenizer str;
	    public Input1()
	    {
	        br=new BufferedReader(new InputStreamReader(System.in));
	    }
	    public String next() throws Exception 
	    {
	        while(str==null || !str.hasMoreTokens())
	        {
	            str=new StringTokenizer(br.readLine());
	        }
	        return str.nextToken();
	    }
	}
}
