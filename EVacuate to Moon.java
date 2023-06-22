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
		int T = sc.nextInt();
		while(T > 0){
		  int n = sc.nextInt();
		  int m = sc.nextInt();
		  int h = sc.nextInt();
		  int car[] = new int[n];
		  int power[] = new int[m];
		  
		  for(int i = 0; i < n; i++){
		      car[i] = sc.nextInt();
		  }
		  
		   for(int i = 0; i < m; i++){
		      power[i] = sc.nextInt();
		  }
		  
		  Arrays.sort(car);
          Arrays.sort(power);    
          
          int i = n - 1;
          int j = m - 1;
          long sum = 0;
          while(i >= 0 && j >= 0 ){
              long calc = power[j] * (long)h;
              sum += Math.min(calc, car[i]);
              i--;
              j--;
          }
          System.out.println(sum);
		  T--;
		}
	}
}
