/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{Scanner sc = new Scanner(System.in);
		int tcs  = sc.nextInt();
		while(tcs-- > 0){
		    int n = sc.nextInt();
		    sc.nextLine();
		    String s = sc.nextLine();
		    char [] arr = new char [n];
		    int plus = 0;
		    int minus = 0;
		    for(int i = 0, j=0; i<n; i++){
		        if(s.charAt(i) == '+') plus++;
		        else if(s.charAt(i) == '-') minus++;
		        else{
		            arr[j] = s.charAt(i);
		            j++;
		        }
		    }
		    Arrays.sort(arr);
		    String res = "";
		    for(int i = plus+minus; i<n; i++){
		        if(minus>0){
		            res = "-"+arr[i]+res;
		            minus--;
		        } else if(minus == 0 && plus>0){
		            res = "+"+arr[i]+res;
		            plus--;
		        }
		        else res = arr[i]+res;
		    }
		    System.out.println(res);
		}
		// your code goes here
	}
}
