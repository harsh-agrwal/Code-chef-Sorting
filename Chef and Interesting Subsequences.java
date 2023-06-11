/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
	    try {
			Codechef f = new Codechef();
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			int tc = Integer.parseInt(reader.readLine().trim());
			ArrayList<Long> list = new ArrayList<Long>();
			for (int i = 0; i < tc; i++) {
				String[] integersInString1 = reader.readLine().split(" ");
				int n = Integer.parseInt(integersInString1[0]);
				int k = Integer.parseInt(integersInString1[1]);
				int[] a = new int[n];
				String[] integersInString2 = reader.readLine().split(" ");
				for (int j = 0; j < integersInString2.length; j++) {
					a[j] = Integer.parseInt(integersInString2[j]);
				}
				// int value = MaxIncreasingSub(a, n, k);
				a = f.sort(a, 0, n - 1);
				int countZ = f.countZ(a, k);
				int countY = f.countY(a, k);
				long value = f.binomialCoeff(countZ, countY);
				list.add(value);
			}
			for (int i = 0; i < list.size(); i++) {
				System.out.println(list.get(i));
			}
		} catch (Exception e) {
			// TODO: handle exception
			// e.printStackTrace();
		}
	}

long binomialCoeff(int n, int k) {
		long C[][] = new long[n + 1][k + 1];
		int i, j;

		// Calculate value of Binomial Coefficient in bottom up manner
		for (i = 0; i <= n; i++) {
			for (j = 0; j <= Math.min(i, k); j++) {
				// Base Cases
				if (j == 0 || j == i)
				C[i][j] = 1;

				// Calculate value using previously stored values
				else
					C[i][j] = C[i - 1][j - 1] + C[i - 1][j];
			}
		}

		return C[n][k];
	}

	int countZ(int[] a, int k) {
		int count = 0;
		int comparewith = a[k - 1];
		for (int i = 0; i < a.length; i++) {
			if (a[i] == comparewith)
				count++;
		}
		return count;

	}

	int countY(int[] a, int k) {
		int count = 0;
		int comparewith = a[k - 1];
		for (int i = 0; i < k; i++) {
			if (a[i] == comparewith)
				count++;
		}
		return count;

	}
	
	// quicksort
	int[] sort(int[] a, int low, int high) {
		objQS o;
		if (low < high) {
			o = partition(a, low, high);
			sort(o.a, low, o.pivotI - 1);
			sort(o.a, o.pivotI + 1, high);
		}
			return a;
	}

	objQS partition(int[] a, int low, int high) {
		int pivot = a[high];
		int i = low - 1;
		for (int j = low; j <= high - 1; j++) {
			if (a[j] < pivot) {
				i++;
				int temp = a[j];
				a[j] = a[i];
				a[i] = temp;
			}
		}
		int temp = a[i + 1];
		a[i + 1] = a[high];
		a[high] = temp;
		return new objQS(a, i + 1);
	}

	class objQS {
		int[] a;
		int pivotI;

		public objQS(int[] a, int pivotI) {
			super();
			this.a = a;
			this.pivotI = pivotI;
		}
	}
}
