/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0)
		{
		    int n = sc.nextInt();
		    long p=sc.nextLong(), q=sc.nextLong();
		    long[] arr = new long[n];
		    int ans=0;
		    for(int i=0;i<n;i++){
		    arr[i]=sc.nextLong();
		    }
		    Arrays.sort(arr);
		    
		    for(int i=0;i<n;i++)
		    {
		        if(arr[i]==1)
		        {
		            if(p>=1)
		            {
		                ans++;
		                p--;
		            }
		        }
		        else if(arr[i]==2)
		        {
		            if(q>=1)
		            {
		                q--;
		                ans++;
		            }
		            else if(p>=2)
		            {
		                p-=2;
		                ans++;
		            }
		        }
		        else
		        {
		            if(arr[i]%2==0)
		            {
		                     if(q>=(arr[i]/2))
		                     {
		                        q-=(arr[i]/2);
		                        ans++;
		                     }
		                     else if(((q*2)+(p*1))>=arr[i])
		                     {
		                         arr[i]-=(q*2);
		                         q=0;
		                         p-=arr[i];
		                         ans++;
		                     }
		                     else if((p>=arr[i]))
		                     {
		                             p-=arr[i];
		                             ans++;
		                         
		                     }
		            }
		            else 
		            {
		               if(q>=((arr[i]-1)/2))
		               {
		                   if(p>=1)
		                   {
		                      q-=((arr[i]-1)/2);
		                      p--;
		                      ans++;
		                   }
		               }
		               else if(((q*2)+(p*1))>=arr[i])
		               {
		                     arr[i]-=(q*2);
		                     q=0;
		                     p-=arr[i];
		                     ans++;
		               }
		               else
		               {
		                   if(p>=arr[i])
		                   {
		                       p-=arr[i];
		                       ans++;
		                   }
		               }
		            }
		        }
		    }
		    System.out.println(ans);
		}
	}
}
