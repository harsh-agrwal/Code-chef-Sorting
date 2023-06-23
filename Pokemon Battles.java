import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(br.readLine()),n,x;
		while(t-->0){
		    n=Integer.parseInt(br.readLine());
		    long a[][]=new long[n][3],b[]=new long[n],y=0;x=0;
		    String s1[]=br.readLine().split(" "),s2[]=br.readLine().split(" ");
		    for(int i=0;i<n;i++){
		        a[i][0]=Long.parseLong(s1[i]);a[i][1]=i;
		        b[i]=Long.parseLong(s2[i]);a[i][2]=b[i];
		    }
		    Arrays.sort(a,new Comparator<long[]>(){
		       public int compare(final long[]a1,final long[]a2){
		           if(a1[0]<a2[0])
		           return 1;
		           return -1;}});
		    Arrays.sort(b);
		    for(int i=0;i<n;i++)
		    {if(a[i][2]>y)x++;if(a[i][2]>y)y=a[i][2];}
		    System.out.println(x);
		}
	}
}
