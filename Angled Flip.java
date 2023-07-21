//package kg.my_algorithms.codechef;


import java.io.*;
import java.util.*;

public class Main {
    private static final long MOD = 998244353L;
    public static void main(String[] args) throws IOException {
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        FastReader fr = new FastReader();
        int testCases = fr.nextInt();
        for(int testCase=1;testCase<=testCases;testCase++){
            int rows = fr.nextInt();
            int cols = fr.nextInt();
            Map<Long,Integer> map1 = new HashMap<>();
            Map<Long,Integer> map2 = new HashMap<>();
            List<Long> list1 = new ArrayList<>();
            List<Long> list2 = new ArrayList<>();
            for(int r=0;r<rows;r++){
                for(int c=0;c<cols;c++){
                    long num = fr.nextLong();
                    list1.add(num);
                    if(r%2 == c%2) map1.put(num,map1.getOrDefault(num,0)+1);
                    else map2.put(num,map2.getOrDefault(num,0)+1);
                }
            }
            for(int r=0;r<rows;r++){
                for(int c=0;c<cols;c++){
                    long num = fr.nextLong();
                    list2.add(num);
                    if(r%2 == c%2) map1.put(num,map1.getOrDefault(num,0)-1);
                    else map2.put(num,map2.getOrDefault(num,0)-1);
                }
            }
           if(rows==1 || cols==1) {
                if(list1.equals(list2)) sb.append("YES\n");
                else sb.append("NO\n");
            }
            else if(solve(map1,map2)) sb.append("YES\n");
            else sb.append("NO\n");
        }


        output.write(sb.toString());
        output.flush();
    }
    private static boolean solve(Map<Long,Integer> map1, Map<Long,Integer> map2){
        for(long i: map1.keySet()) if(map1.get(i)!=0) return false;
        for(long i: map2.keySet()) if(map2.get(i)!=0) return false;
        return true;
    }
}
class FastReader {
    BufferedReader br;
    StringTokenizer st;

    public FastReader()
    {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    String next() {
        while (st == null || !st.hasMoreElements()) {
            try {
                st = new StringTokenizer(br.readLine());
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }

    int nextInt() { return Integer.parseInt(next()); }

    long nextLong() { return Long.parseLong(next()); }

    double nextDouble()
    {
        return Double.parseDouble(next());
    }

    String nextLine()
    {
        String str = "";
        try {
            if(st.hasMoreTokens()){
                str = st.nextToken("\n");
            }
            else{
                str = br.readLine();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }
}
