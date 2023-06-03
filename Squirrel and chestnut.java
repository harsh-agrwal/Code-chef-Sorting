/* package codechef; // don't place package name! */

import java.io.OutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.io.BufferedWriter;
import java.util.InputMismatchException;
import java.io.Writer;
import java.io.InputStream;


public class Main {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InReader in = new InReader(inputStream);
		OutputWriter out = new OutputWriter(outputStream);
		SquirrelAndChestnut solver = new SquirrelAndChestnut();
		solver.solve(1, in, out);
		out.close();
	}
}

class SquirrelAndChestnut {
    int tym[];
    int p[];
    int n, m;

    public void solve(int testNumber, InReader in, OutputWriter out) {
        testNumber = in.readInt();
        while (testNumber-- > 0) {
            m = in.readInt();
            n = in.readInt();
            int k = in.readInt();
            tym = new int[m];
            p = new int[m];

            for (int i = 0; i < m; i++) {
                tym[i] = in.readInt();
            }
            for (int i = 0; i < m; i++) {
                p[i] = in.readInt();
            }
            int lo = 0;
            int hi = 1000000000;
            int ans = lo;
            while (lo <= hi) {
                int mid = lo + hi >> 1;
                if (total(mid) >= k) {
                    ans = mid;
                    hi = mid - 1;
                } else lo = mid + 1;
            }
            out.printLine(ans);
        }
    }

    private long total(int v) {
        int[] nuts = new int[m];
        for (int i = 0; i < m; i++) {
            if (v >= tym[i]) nuts[i] = 1 + (v - tym[i]) / p[i];
        }
        Arrays.sort(nuts);
        int j = n;
        long ret = 0;
        int i = m - 1;
        while (j-- > 0) {
            if (i < 0) break;
            ret += nuts[i--];
        }
        return ret;
    }
}

class InReader {

	private InputStream stream;
	private byte[] buf = new byte[1024];
	private int curChar;
	private int numChars;
	private SpaceCharFilter filter;

	public InReader (InputStream stream) {
		this.stream = stream;
	}

	public int read () {
		if (numChars == -1)
			throw new InputMismatchException ();
		if (curChar >= numChars) {
			curChar = 0;
			try {
				numChars = stream.read (buf);
			} catch (IOException e) {
				throw new InputMismatchException ();
			}
			if (numChars <= 0)
				return -1;
		}
		return buf[curChar++];
	}

	public int readInt () {
		int c = read ();
		while (isSpaceChar (c))
			c = read ();
		int sgn = 1;
		if (c == '-') {
			sgn = -1;
			c = read ();
		}
		int res = 0;
		do {
			if (c < '0' || c > '9')
				throw new InputMismatchException ();
			res *= 10;
			res += c - '0';
			c = read ();
		} while (!isSpaceChar (c));
		return res * sgn;
	}

	public String readString () {
		int c = read ();
		while (isSpaceChar (c))
			c = read ();
		StringBuilder res = new StringBuilder ();
		do {
			res.appendCodePoint (c);
			c = read ();
		} while (!isSpaceChar (c));
		return res.toString ();
	}

	public boolean isSpaceChar (int c) {
		if (filter != null)
			return filter.isSpaceChar (c);
		return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
	}

	public interface SpaceCharFilter {
		public boolean isSpaceChar (int ch);
	}

	}

class OutputWriter {
	private final PrintWriter writer;

	public OutputWriter(OutputStream outputStream) {
		writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
	}

	public OutputWriter(Writer writer) {
		this.writer = new PrintWriter(writer);
	}

	public void print(Object...objects) {
		for (int i = 0; i < objects.length; i++) {
			if (i != 0)
				writer.print(' ');
			writer.print(objects[i]);
		}
	}


    public void printLine(Object...objects) {
		print(objects);
		writer.println();
	}

	public void close() {
		writer.close();
	}

}
