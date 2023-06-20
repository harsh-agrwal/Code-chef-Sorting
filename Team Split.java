import java.util.*;
import java.io.*;

class CodeChef{
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
	static class Pair implements Comparable<Pair>{
	    
	    Pair(){
	        
	    }
	    public int compareTo(Pair that){
	        return 0;
	    }
	}
	static long gcd(long a, long b){return (b==0)?a:gcd(b,a%b);}
    static int gcd(int a, int b){return (b==0)?a:gcd(b,a%b);}
    public static void main(String[] args) {
        try {
            FastReader in=new FastReader();
            FastWriter out = new FastWriter();
            int testCases=in.nextInt();
            while(testCases-- > 0){
                int n = in.nextInt();
                long a = in.nextLong();
                long b = in.nextLong();
                long c = in.nextLong();
                long d = in.nextLong();
                long[] s = new long[n];
                s[0] = d;
                for(int i = 1 ; i < n ; i++){
                    s[i] = ((a*(long)Math.pow(s[i - 1],2) + b*s[i - 1] + c)%1000000);
                }
                Arrays.sort(s);
                long suma = 0, sumb = 0;
                for(int i = 0 ; i < n ; i++){
                    if(i%2 == 0) suma += s[i];
                    else sumb += s[i];
                }
                out.println(Math.abs(suma - sumb));
            }
            out.close();
    } catch (Exception e) {
            for(int i = 0 ; i < e.getStackTrace().length ; i++){
                System.out.println(e + " at line " + e.getStackTrace()[i].getLineNumber());
            }
            return;
        }
    }
}
