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
               int arr[] = new int[n];
               long sum =0;
               for(int i =0; i<n; i++){
                   arr[i] = in.nextInt();
                   sum += arr[i];
               }
               Arrays.sort(arr);
               int i = n-1;
               
               long avail = 0;
               
               for(i = n-1; i>=0; i--){
                   long req = (long)arr[i]*(i+1)-sum;
                
                   if(req<= avail)break;
                   sum -= arr[i];
                   avail += arr[i];
               }
               out.println(n-i-1);
            }
            out.close();
        } catch (Exception e) {
            return;
        }
    }
}

class Solution{
    
}
