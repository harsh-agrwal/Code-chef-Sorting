/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(br.readLine()),n;String s[]=new String[2];
		while(t-->0){
		    n=Integer.parseInt(br.readLine());int a[][]=new int[n][2];
		    TreeMap<Integer,Integer> tm=new TreeMap<>();tm.put(-1,0);
		    tm.put(0,0);
		    for(int i=0;i<n;i++)
		    {s=br.readLine().split(" ");a[i][0]=Integer.parseInt(s[0]);
		    a[i][1]=Integer.parseInt(s[1]);
		    }
		    Arrays.sort(a,new Comparator<int[]>(){
		        public int compare(final int[] a1,final int[] b){
		            if(a1[1]<b[1])
		            return -1;
		            return 1;}});
		    for(int i=0;i<n;i++)
		    if(tm.floorEntry(a[i][0]-1).getValue()+1>
		    tm.floorEntry(a[i][1]).getValue())
		    tm.put(a[i][1],tm.floorEntry(a[i][0]-1).getValue()+1);
		    System.out.println(tm.lastEntry().getValue());
	}}
}
