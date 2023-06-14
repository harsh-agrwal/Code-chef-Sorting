/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int t = Integer.parseInt(br.readLine());
        while(t--!=0){
            StringTokenizer st = new StringTokenizer(br.readLine());
             int n=Integer.parseInt(st.nextToken());
             int m=Integer.parseInt(st.nextToken());
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            
                int[] f = new int[n];
                int[] c = new int[m];
            
            for(int i=0;i<n;i++){
                f[i]=Integer.parseInt(st1.nextToken());
            }
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for(int i=0;i<m;i++){
                c[i]=Integer.parseInt(st2.nextToken());
            }
            
            int i=0;
            int j=0;
            int switches=0;
            //o is football and 1 is cricket
            int flag=0;
            while(i<n && j<m){
                if(f[i]<c[j]){
                    if(flag!=0){
                     switches++;   
                     flag=1-flag;
                    }
                    i++;
                    
                }
                else{
                    if(flag!=1){
                        switches++;
                        flag=1-flag;
                    }
                    j++;
                }  
            }
            if(i>=n && j<m && flag==0) switches++;
            if(j>=m && i<n && flag==1) switches++;
            out.write(switches+"\n");
        }
        out.flush();
	}
}
