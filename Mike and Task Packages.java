import java.io.*;
import java.util.*;
class q {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        long x = Long.parseLong(st.nextToken());
        int v[] = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            v[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(v);
        int s = 0, f = n, i;
        for (i = 0; i < n; i++) {
            long val = v[i] / 2 + v[i] % 2;
            if (x >= val) {
                x -= val;
                f--;
                v[i] -= val;
            }
        }
        for (int j = 0; j < n; j++) {
            if (x >= v[j]) {
                s++;
                x -= v[j];
            }
        }
        System.out.println(f + " " + s);
    }

}
