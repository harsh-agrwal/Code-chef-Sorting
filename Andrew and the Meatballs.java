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
        while (t-- > 0) {
            int n = sc.nextInt();
            long m = sc.nextLong();
            long[] p = new long[n];
            for (int i = 0; i < n; i++) {
                p[i] = sc.nextLong();
            }
            Arrays.sort(p); // sort the plates in ascending order of meatballs
            int ans = 0;
            long sum = 0;
            for (int i = n - 1; i >= 0; i--) {
                sum += p[i];
                ans++;
                if (sum >= m) {
                    System.out.println(ans);
                    break;
                }
            }
            if (sum < m) {
                System.out.println(-1);
            }
        }
		// your code goes here
	}
}
