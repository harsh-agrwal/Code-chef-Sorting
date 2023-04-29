import java.util.*;
import java.lang.*;
import java.io.*;


class Codechef
{
    public static void main (String[] args) throws java.lang.Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t-->0){
            int n = Integer.parseInt(br.readLine());
            HashMap<String, Integer> map = new HashMap<>();
            String arr[] = br.readLine().split(" ");
            for(int i = 0; i < n; ++i){
              map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            }
            long sum = 0L;

            for (String key : map.keySet()) {
                int freq = map.get(key);
                sum += (1L*(freq-1)*freq)/2;
            }
            System.out.println(sum);
        }
    }
}
