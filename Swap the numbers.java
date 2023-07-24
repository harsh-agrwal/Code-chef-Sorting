import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

class SWAPNUM31 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pw = new PrintWriter(new BufferedOutputStream(System.out));
	static StringTokenizer st;

	private static String nextLine() throws IOException {
		if (st == null || !st.hasMoreElements())
			st = new StringTokenizer(br.readLine());
		return st.nextToken();
	}

	private static int nextInt() throws IOException {
		return Integer.parseInt(nextLine());
	}

	private static long nextLong() throws IOException {
		return Long.parseLong(nextLine());
	}

	public static void main(String[] args) throws IOException {
		int t = nextInt();
		do {
			int n, k;
			n = nextInt();
			k = nextInt();
			int[] a = new int[n];
			for (int i = 0; i < n; i++) {
				a[i] = nextInt();
			}
			if (n >= 2 * k) {
				Arrays.sort(a);
			} else if (k < n) {
				int l = n - k;
				int[] temp = new int[2 * l];
				for (int i = 0; i < l; i++) {
					temp[i] = a[i];
					temp[i + l] = a[n - l + i];
				}
				Arrays.sort(temp);
				for (int i = 0; i < l; i++) {
					a[i] = temp[i];
					a[n - l + i] = temp[i + l];
				}
			}
			for (int elem : a)
				System.out.print(elem + " ");
			System.out.println();
		} while (--t > 0);
		br.close();
		pw.close();
	}

}
