import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
	BufferedReader in;
	StringTokenizer str;
	PrintWriter out;

	String next() throws IOException {
		while ((str == null) || (!str.hasMoreTokens())) {
			str = new StringTokenizer(in.readLine());
		}
		return str.nextToken();
	};

	int nextInt() throws IOException {
		return Integer.parseInt(next());
	};

	double nextDouble() throws IOException {
		return Double.parseDouble(next());
	};

	double nextLong() throws IOException {
		return Long.parseLong(next());
	};

	class group implements Comparable<group> {
		int x, num;

		public group(int x1, int num1) {
			x = x1;
			num = num1;
		}

		public int compareTo(group arg0) {
			return x - arg0.x;
		}
	};

	void solve() throws IOException {
		int n = nextInt();
		int k = nextInt();
		int m = n / k;
		int[] a = new int[n];
		group[] b = new group[n];
		int[] last = new int[n];
		int[] pos = new int[n + 1];
		int[] ls = new int[n + 1];
		int[] nx = new int[n + 1];
		Arrays.fill(last, -1);
		Arrays.fill(pos, -1);
		int ngr = 0;
		int t = 0;
		for (int i = 0; i < n; i++)
			a[i] = nextInt();
		Arrays.sort(a);
		for (int i = 0; i < n; i++) {
			if ((i > 0) && (a[i] == a[i - 1])) {
				t++;
				b[ngr - 1].num++;
			} else {
				t = 1;
				ngr++;
				b[ngr - 1] = new group(a[i], 1);
			}
			if (t > m) {
				out.println(-1);
				return;
			}
		}
		Arrays.sort(b, 1, ngr);
		for (int i = 0; i < ngr; i++) {
			last[i] = pos[b[i].num];
			pos[b[i].num] = i;
			ls[i] = i - 1;
			nx[i] = i + 1;
			if (i > 0)
				nx[i - 1] = i;
			;
			if (i < ngr - 1)
				ls[i + 1] = i;
			;

		}
		int rs[] = new int[n];
		int v;
		int st = 0;
		int buv[] = new int[n];
		for (int l = 1; l <= m; l++) {
			int p = 0;
			while (pos[m - l + 1] >= 0) {
				v = pos[m - l + 1];
				pos[m - l + 1] = last[pos[m - l + 1]];
				if (b[v].num == m - l + 1) {
					b[v].num--;
					buv[v] = l;
					rs[p] = b[v].x;
					p++;
				}
				last[v] = pos[b[v].num];
				pos[b[v].num] = v;
			}
			while ((st < ngr) && (b[st].num == 0))
				st++;
			v = st;
			while (p < k) {
				if (buv[v] == l) {
					v = nx[v];
					continue;
				}
				rs[p] = b[v].x;
				b[v].num--;
				if (b[v].num == 0) {
					if (ls[v] >= 0)
						nx[ls[v]] = nx[v];
					if (nx[v] < ngr)
						ls[nx[v]] = ls[v];
				}
				p++;
				v = nx[v];

			}
			if (l != 1)
				out.print(" ");
			Arrays.sort(rs, 0, k);
			for (int i = 0; i < k - 1; i++)
				out.print(rs[i] + " ");
			out.print(rs[k - 1]);
		}
		out.println();
	};

	void run() throws IOException {

		in = new BufferedReader(new InputStreamReader(System.in));
		out = new PrintWriter(System.out);
		// in = new BufferedReader(new FileReader("input.txt"));
		// out.println("output.txt");
		int t = nextInt();
		for (int i = 0; i < t; i++)
			solve();
		out.close();
	}

	public static void main(String[] args) throws IOException {
		new Main().run();
	}

}
