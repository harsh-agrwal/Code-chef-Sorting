import java.io.*;
import java.util.*;

 class Codechef {
	public static void main(String[] args) throws IOException{
// 		file_io();
		
		FastScanner sc = new FastScanner();
		int tt = 1;
		tt = sc.nextInt();
		while(tt-->0) {
			int n = sc.nextInt();
			long[] A = new long[n];
			for(int i=0; i<n; i++)
				A[i] = sc.nextInt();

			Arrays.sort(A);
			long ans1 = A[0]*A[1] + Math.abs(A[0] - A[1]);
			long ans2 = A[n-1]*A[n-2] + Math.abs(A[n-1] - A[n-2]);
			System.out.println(Math.max(ans1, ans2));
		}
	}

	public static int solve() {
		//write your code
		return 0;
	}














    public static int mini(int... A) {
    	return Arrays.stream(A).min().getAsInt();
    }

    public static int maxi(int... A) {
    	return Arrays.stream(A).max().getAsInt();
    }


	public static int[] prefix_function(char[] s) {
	    int n = s.length;
	    int[] pi = new int[n];
	    for (int i = 1; i < n; i++) {
	        int j = pi[i-1];
	        while (j > 0 && s[i] != s[j])
	            j = pi[j-1];
	        if (s[i] == s[j])
	            j++;
	        pi[i] = j;
	    }
	    return pi;
	}


	static class FastScanner {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer("");
		String next() {
			while(!st.hasMoreTokens()) {
				try {
					st = new StringTokenizer(br.readLine());
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		long nextLong() {
			return Long.parseLong(next());
		}

		double nextDouble() {
			return Double.parseDouble(next());
		}
	}

	public static void file_io() {
		try {
			System.setIn(new FileInputStream("input.txt"));
			System.setOut(new PrintStream(new FileOutputStream("output.txt")));
		} catch(Exception e) {
			System.err.println("Error");
		}
	}
}
