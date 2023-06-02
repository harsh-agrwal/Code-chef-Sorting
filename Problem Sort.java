/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	static class Subtask{
	    int SC, NS;
	}
	static class Difficulty{
	    int n, i;
	    Difficulty(int n, int i){
	        this.n = n;
	        this.i = i;
	    }
	}
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		PrintWriter out = new PrintWriter(System.out);
		
		int P, S;
		try{
		    st = new StringTokenizer(br.readLine());
		    P = Integer.parseInt(st.nextToken());
		    S = Integer.parseInt(st.nextToken());
		}
		catch(Exception e){
		    return;
		}
		
		List<Difficulty> diff = new ArrayList<>(P);
		for(int k = 1; k <= P; k++){
		    List<Subtask> tasks = new ArrayList<>(S);
		    for(int i = 0; i < S; i++)
		        tasks.add(new Subtask());
		        
		    st = new StringTokenizer(br.readLine());
		    for(int i = 0; i < S; i++)
		        tasks.get(i).SC = Integer.parseInt(st.nextToken());
		        
		    st = new StringTokenizer(br.readLine());
		    for(int i = 0; i < S; i++)
		        tasks.get(i).NS = Integer.parseInt(st.nextToken());
		        
		    Collections.sort(tasks, (a, b) -> a.SC - b.SC);
		    int n = 0;
		    for(int i = 0; i < S-1; i++){
		        if(tasks.get(i).NS > tasks.get(i+1).NS)
		            n++;
		    }
		    diff.add(new Difficulty(n, k));
		}
		Collections.sort(diff, (a, b) -> {
		    if(a.n != b.n)
		        return a.n - b.n;
		    else
		        return a.i - b.i;
		});
		
		for(Difficulty d : diff)
		    out.println(d.i);
		out.flush();
	}
}
