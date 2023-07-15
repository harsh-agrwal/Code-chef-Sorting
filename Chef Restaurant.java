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
		Scanner obj = new Scanner(System.in);
        int T = obj.nextInt();

        while(T-- > 0) {
            int N = obj.nextInt();
            int M = obj.nextInt();
            int[] arr = new int[N];
            int[] brr = new int[N];
            
            int j = 0;
            for(int i = 0; i < N; ++i){
                arr[j] = obj.nextInt();
                brr[j] = obj.nextInt();
                ++j;
            }
            Arrays.sort(arr);
            Arrays.sort(brr);
            for(int i = 0; i < M; ++i){
                int temp = obj.nextInt();
                int ans = helper(arr, brr, N, temp);
                System.out.println(ans);
            }
        }
    }
    public static int helper(int[] arr, int[] brr, int N, int arrivalTime){
        if(arr[N - 1] < arrivalTime && brr[N - 1] > arrivalTime)
            return 0;
        if(brr[N - 1] <= arrivalTime)
            return -1;
        int ans = next(arr, arrivalTime);
        if(ans == 0){
            return arr[ans] - arrivalTime;
        }
        if(brr[ans - 1] > arrivalTime)
            return 0;
        return arr[ans] - arrivalTime;
    }
    public static int next(int[] arr, int target)
    {
        int start = 0, end = arr.length - 1;
        int ans = -1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if(arr[mid] == target)
                return mid;
            if (arr[mid] < target) {
                start = mid + 1;
            }
            else {
                ans = mid;
                end = mid - 1;
            }
        }
        return ans;
    }
}
