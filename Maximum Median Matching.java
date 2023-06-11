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
		Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while(T-->0){
            int N = sc.nextInt();
            int arr1[] = new int[N];
            int arr2[] = new int[N];
            for(int i=0;i<N;i++){
                arr1[i] = sc.nextInt();
            }
            for(int i=0;i<N;i++){
                arr2[i] = sc.nextInt();
            }
            if(N==1){
                System.out.println(arr1[0]+arr2[0]);
                continue;
            }
            Arrays.sort(arr1);
            Arrays.sort(arr2);
            ArrayList<Long>arrlist1 = new ArrayList<Long>();

            for(int i=N/2,j=N-1;i<N;i++,j--){
                arrlist1.add((long)arr1[i]+arr2[j]);
            }
            Collections.sort(arrlist1);
            System.out.println(arrlist1.get(0));
        }
	}
}
