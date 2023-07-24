import java.util.ArrayList;
import java.util.List;
import java.util.InputMismatchException;
import java.math.BigInteger;
import java.util.Iterator;
import java.util.Comparator;
import java.io.*;
import java.util.Arrays;
import java.util.Collection;

/**
 * Generated by Contest helper plug-in
 * Actual solution is at the bottom
 */
public class Main {
	public static void main(String[] args) {
		InputReader in = new StreamInputReader(System.in);
		PrintWriter out = new PrintWriter(System.out);
		run(in, out);
	}

	public static void run(InputReader in, PrintWriter out) {
		Solver solver = new MaximalScorePath();
		solver.solve(1, in, out);
		Exit.exit(in, out);
	}
}

abstract class InputReader {
	private boolean finished = false;

	public abstract int read();

	public int readInt() {
		int c = read();
		while (isSpaceChar(c))
			c = read();
		int sgn = 1;
		if (c == '-') {
			sgn = -1;
			c = read();
		}
		int res = 0;
		do {
			if (c < '0' || c > '9')
				throw new InputMismatchException();
			res *= 10;
			res += c - '0';
			c = read();
		} while (!isSpaceChar(c));
		return res * sgn;
	}

	public String readString() {
		int c = read();
		while (isSpaceChar(c))
			c = read();
		StringBuffer res = new StringBuffer();
		do {
			res.appendCodePoint(c);
			c = read();
		} while (!isSpaceChar(c));
		return res.toString();
	}

	private boolean isSpaceChar(int c) {
		return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
	}

	public void setFinished(boolean finished) {
		this.finished = finished;
	}

	public abstract void close();
}

class StreamInputReader extends InputReader {
	private InputStream stream;
	private byte[] buf = new byte[1024];
	private int curChar, numChars;

	public StreamInputReader(InputStream stream) {
		this.stream = stream;
	}

	public int read() {
		if (numChars == -1)
			throw new InputMismatchException();
		if (curChar >= numChars) {
			curChar = 0;
			try {
				numChars = stream.read(buf);
			} catch (IOException e) {
				throw new InputMismatchException();
			}
			if (numChars <= 0)
				return -1;
		}
		return buf[curChar++];
	}

	public void close() {
		try {
			stream.close();
		} catch (IOException ignored) {
		}
	}
}

interface Solver {
	public void solve(int testNumber, InputReader in, PrintWriter out);
}

class Exit {
	private Exit() {
	}

	public static void exit(InputReader in, PrintWriter out) {
		in.setFinished(true);
		in.close();
		out.close();
	}
}

class IOUtils {
	public static void printArray(int[] array, PrintWriter out) {
		if (array.length == 0) {
			out.println();
			return;
		}
		out.print(array[0]);
		for (int i = 1; i < array.length; i++)
			out.print(" " + array[i]);
		out.println();
	}

	public static void readIntArrays(InputReader in, int[]... arrays) {
		for (int i = 0; i < arrays[0].length; i++) {
			for (int j = 0; j < arrays.length; j++)
				arrays[j][i] = in.readInt();
		}
	}

	}

class MaximalScorePath implements Solver {
	public void solve(int testNumber, InputReader in, PrintWriter out) {
		int vertexCount = in.readInt();
		int edgeCount = in.readInt();
		int[] from = new int[edgeCount];
		int[] to = new int[edgeCount];
		int[] weight = new int[edgeCount];
		IOUtils.readIntArrays(in, from, to, weight);
		long[] key = new long[edgeCount];
		for (int i = 0; i < edgeCount; i++)
			key[i] = -(long)weight[i] * edgeCount - i;
		Arrays.sort(key);
		int[][] result = new int[vertexCount][vertexCount];
		boolean[][] connected = new boolean[vertexCount][vertexCount];
		for (int i = 0; i < vertexCount; i++)
			connected[i][i] = true;
		int[] first = new int[vertexCount];
		int[] second = new int[vertexCount];
		for (long x : key) {
			int i = (int) (Math.abs(x) % edgeCount);
			if (!connected[from[i]][to[i]]) {
				int firstSize = 0;
				int secondSize = 0;
				for (int j = 0; j < vertexCount; j++) {
					if (connected[from[i]][j])
						first[firstSize++] = j;
					else if (connected[to[i]][j])
						second[secondSize++] = j;
				}
				for (int j = 0; j < firstSize; j++) {
					for (int k = 0; k < secondSize; k++) {
						connected[first[j]][second[k]] = true;
						result[first[j]][second[k]] = weight[i];
					}
				}
				for (int k = 0; k < secondSize; k++) {
					for (int j = 0; j < firstSize; j++) {
						connected[second[k]][first[j]] = true;
						result[second[k]][first[j]] = weight[i];
					}
				}
			}
		}
		for (int[] row : result)
			IOUtils.printArray(row, out);
	}
}