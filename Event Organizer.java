import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main
{
	public static class event implements Comparable<event>
	{
		int S, E, C;
		event(int s, int e, int c)
		{
			this.S = s;
			this.E = e;
			this.C = c;
		}
		@Override
		public int compareTo(event event) 
		{
			return this.E - event.E;
		}
	}

	public static void main(String[] args) throws IOException 
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		
		while(T-- > 0)
		{
			int N = Integer.parseInt(in.readLine());
			event[] events = new event[N];
			for(int i = 0; i < N; i++)
			{
				String[] input = in.readLine().split(" ");
				events[i] = new event(Integer.parseInt(input[0]), Integer.parseInt(input[1]), Integer.parseInt(input[2]));
			}
			Arrays.sort(events);
			
			/*for(int i = 0; i < N; i++)
			{
				System.out.println(events[i].S +" "+events[i].E+" "+events[i].C);
			}*/
			int[] hourMax = new int[49];
			//hourMax[events[0].E] = events[0].C;
			int k = 1;
			for(int i = 0; i < N; i++)
			{
				while(k <= events[i].E)
				{
					hourMax[k] = Math.max(hourMax[k], hourMax[k-1]);
					k++;
				}
				hourMax[events[i].E] = Math.max(hourMax[events[i].E], hourMax[events[i].S] + events[i].C);
			}
			System.out.println(hourMax[k-1]);
		}
	}

}
