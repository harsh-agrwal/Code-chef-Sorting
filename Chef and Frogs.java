import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
        Scanner kb = new Scanner(System.in);
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = kb.nextInt();
        int k = kb.nextInt();
        int p = kb.nextInt();
        int[] arr = new int[n];
        int[] brr = new int[n];
        for (int i=0; i<n; i++)
        {
            brr[i] = arr[i] = kb.nextInt();
            map.put(arr[i], arr[i]);
        }

        Arrays.sort(brr);

        int last_val = brr[n-1];
        map.put(last_val, map.get(last_val) + k);

        for (int i=n-2; i>-1; i--)
        {
            if((brr[i+1] - brr[i]) <= k)
            {
                map.put(brr[i], map.get(brr[i+1]));
            }
            else 
            {
                map.put(brr[i], brr[i]+k);
            }
        }

        for (int i=0; i<p; i++)
        {
            int a = kb.nextInt();
            int b = kb.nextInt();
            if(map.get(arr[a-1]) == map.get(arr[b-1]))
                System.out.println("Yes");
            else
                System.out.println("No");
        }
		
	}
}
