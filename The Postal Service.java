
import java.util.Arrays;
import java.util.Scanner;

public class Main
{
	static final char ND = '0';
	static final char SD = '1';
	
	static final int MBT = 24;
	static final int MBPN = 12;
	
	static final int QIMSK = 0xFFF;
	static final int PNMSK = 0xFFF000;
	
	void fm()
	{
		Scanner sc = new Scanner(System.in);
		int t = Integer.parseInt(sc.nextLine());
		StringBuffer sb = new StringBuffer();
		while (t-- > 0)
		{
			int n = Integer.parseInt(sc.nextLine());
			
			long[] p = new long[n];
			char[] pd = new char[n];
			String[] sp = sc.nextLine().split(" ");
			String[] spd = sc.nextLine().split(" ");
			for (int i = 0; i < n; ++i)
			{
				p[i] = Integer.parseInt(sp[i]) << 1;
				pd[i] = spd[i].charAt(0);
			}
			
			int q = Integer.parseInt(sc.nextLine());
			if (q == 0)
				continue;
			long[] qa = new long[q];
			for (int i = 0; i < q; ++i)
			{
				String[] s = sc.nextLine().split(" ");
				qa[i] = (Long.parseLong(s[1]) << MBT+1);
				qa[i] += (Integer.parseInt(s[0]) << MBPN);
				qa[i] += i;
			}
			Arrays.sort(qa);
			
			long[] qp = new long[q];
			int[] qmts = new int[q];
			fc(n, p, pd, q, qa, qp, qmts);
			
			for (int i = 0; i < q; ++i)
			{
				sb.append(qp[i]/2);
				sb.append(" ");
				sb.append(qmts[i]);
				sb.append("\n");
			}
		}
		System.out.println(sb.toString());
	}
	
	void fc(int n, long[] p, char[] pd, int q, long[] qa, long[] qp, int[] qmts)
	{
		int[] mts = new int[n];
		long ct = 0;
		int qc = 0;
		long qt = (qa[qc] >> MBT);
		while (qt == ct)
		{
			int pi = (int)((qa[qc] & PNMSK) >> MBPN);
			int qi = (int)(qa[qc] & QIMSK);
			qp[qi] = (long)p[pi];
			
			qc++;
			if (qc == q)
				return;
			qt = (qa[qc] >> MBT);
		}

		int[] ia = new int[n/2];
		int ic = 0;
		while (qc < q)
		{
			long tmi = Long.MAX_VALUE;
			for (int i = 1; i < n; ++i)
			{
				if (pd[i] == ND && pd[i-1] == SD)
				{
					long ts = (p[i]-p[i-1])/2;
					if (tmi > ts)
					{
						tmi = ts;
						ic = 0;
						ia[ic++] = i;
					}
					else if (tmi == ts)
						ia[ic++] = i;
				}
			}
			
			if (ic == 0)
				break;
			
			qt = (qa[qc] >> MBT);
			while (qt <= ct+tmi)
			{
				int pi = (int)((qa[qc] & PNMSK) >> MBPN);
				int qi = (int)(qa[qc] & QIMSK);
				if (pd[pi] == ND)
					qp[qi] = p[pi]-(qt-ct);
				else
					qp[qi] = p[pi]+(qt-ct);
				
				qmts[qi] = mts[pi];
				if (qt == ct+tmi)
				{
					for (int id : ia)
						if (id == pi)
						{
							qmts[qi]++;
							break;
						}
				}
					
				qc++;
				if (qc == q)
					return;
				qt = (qa[qc] >> MBT);
			}
			
			fp(n, p, pd, ia, ic, mts, tmi);
			ct += tmi;
			ic = 0;
		}
		
		while (qc < q)
		{
			qt = (qa[qc] >> MBT);
			int pi = (int)((qa[qc] & PNMSK) >> MBPN);
			int qi = (int)(qa[qc] & QIMSK);
			
			if (pd[pi] == ND)
				qp[qi] = p[pi]-(qt-ct);
			else
				qp[qi] = p[pi]+(qt-ct);
			
			qmts[qi] = mts[pi];
			qc++;
		}
	}
	
	void fp(int n, long[] p, char[] pd, int[] ia, int ic, int[] mts, long tmi)
	{
		for (int i = 0; i < n; ++i)
		{
			if (pd[i] == ND)
				p[i] = p[i]-tmi;
			else
				p[i] = p[i]+tmi;
		}
		
		for (int j = 0; j < ic; ++j)
		{
			int i = ia[j];
			mts[i]++;
			mts[i-1]++;
			
			pd[i] = SD;
			pd[i-1] = ND;
		}
	}
	
	public static void main(String[] args)
	{
		new Main().fm();
	}
}
