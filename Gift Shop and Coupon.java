/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		while(t > 0){
		    int n = scan.nextInt();
		    int k = scan.nextInt();
		    float nums[] = new float[n];
		    for(int i=0; i<n; i++){
		        nums[i] = scan.nextFloat();
		    }
		    Arrays.sort(nums);
		    int count = 0;
		    double sum = 0;
		    boolean flag = true;
		    for(int j=0; j<n; j++){
		        sum += nums[j];
		        if(sum <= k) count++;
		        else{
		            sum -= nums[j];
		            sum += Math.ceil(nums[j]/2);
		            if(sum <= k && flag){
		                count++;
		                flag = false;
		            }
		        }
		    }
		    System.out.println(count);
		    t--;
		}
	}
}
