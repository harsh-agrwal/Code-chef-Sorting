import java.util.*;
import java.io.*;
class Codechef
{
    public static long max(long a,long b){return a>b?a:b;}
    public static long min(long a,long b){return a>b?b:a;}
    public static int max(int a,int b){return a>b?a:b;}
    public static int min(int a,int b){return a>b?b:a;}
    public static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
    public static int[] inputArray(int n)throws Exception{
        int array[]=new int[n];
        StringTokenizer st=new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++)array[i]=Integer.parseInt(st.nextToken());
		return array;
    }
	public static void main (String[] args) throws Exception
	{
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		int one[]=inputArray(n);
		int two[]=inputArray(m);
		int max,index=max=Integer.MIN_VALUE,min,minindex=min=Integer.MAX_VALUE;
		for(int i=0;i<m;i++)if(two[i]>max)max=two[index=i];
		for(int i=0;i<n;i++)if(one[i]<min)min=one[minindex=i];
		for(int i=0;i<n;i++)bw.write(i+" "+index+"\n");
	    for(int j=0;j<m;j++)if(j!=index)bw.write(minindex+" "+j+"\n");
		bw.flush();
	}
}
