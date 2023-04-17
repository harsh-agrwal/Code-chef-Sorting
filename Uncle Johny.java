/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
		while (t-- > 0) {
            int n = scanner.nextInt();
            int[] songs = new int[n];
            for (int i = 0; i < n; i++) {
                songs[i] = scanner.nextInt();
            }
            int k = scanner.nextInt();

            int uncleJohnyLength = songs[k - 1];
            Arrays.sort(songs);

            int uncleJohnyIndex = 1;
            for (int i = 0; i < n; i++) {
                if (songs[i] == uncleJohnyLength) {
                    uncleJohnyIndex = i + 1;
                    break;
                }
            }

            System.out.println(uncleJohnyIndex);
        }
// your code goes here
	}
}
