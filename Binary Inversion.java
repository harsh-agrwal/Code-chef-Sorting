/* package codechef; // don't place package name! */
import java.util.*;
import java.io.*;

public class Main{
    static class FastReader{
        BufferedReader br;
        StringTokenizer st;
        public FastReader(){
            br=new BufferedReader(new InputStreamReader(System.in));
        }
        String next(){
            while(st==null || !st.hasMoreTokens()){
                try {
                    st=new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
        int nextInt(){
            return Integer.parseInt(next());
        }
        long nextLong(){
            return Long.parseLong(next());
        }
        double nextDouble(){
            return Double.parseDouble(next());
        }
        String nextLine(){
            String str="";
            try {
                str=br.readLine().trim();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return str;
        }
    }
    static class FastWriter {
		private final BufferedWriter bw;

		public FastWriter() {
			this.bw = new BufferedWriter(new OutputStreamWriter(System.out));
		}

		public void print(Object object) throws IOException {
			bw.append("" + object);
		}

		public void println(Object object) throws IOException {
			print(object);
			bw.append("\n");
		}

		public void close() throws IOException {
			bw.close();
		}
	}
    public static void main(String[] args) {
        try {
            FastReader in=new FastReader();
            FastWriter out = new FastWriter();
            int testCases=in.nextInt();
            while(testCases-- > 0){
                int n = in.nextInt();
                int arr[][] = new int[n][2];
                int m = in.nextInt();
                int total = 0;
                for(int i = 0; i<n; i++){
                    String s = in.nextLine();
                    int prev = 0,res = 0;
                    for(int j = m-1; j>=0; j--){
                        if(s.charAt(j)=='0')prev++;
                        else res += prev;
                    }
                    arr[i][0] = res;
                    arr[i][1] = prev;
                    total+= prev;
                }
                Arrays.sort(arr,(a,b)->a[1]==b[1]?a[0]-b[0]:b[1]-a[1]);
                Solution obj = new Solution();
                
                out.println(obj.fun(arr,n,m,total));
            }
            out.close();
        } catch (Exception e) {
            return;
        }
    }
}


class Solution{
    public long fun(int arr[][] , int n , int m , int total){
        long res = 0;
        
        for(int i = 0; i<n; i++){
            total-= arr[i][1];
            res += arr[i][0];
            res += total*(m-arr[i][1]);
        }
        
        return res;
    }
}
