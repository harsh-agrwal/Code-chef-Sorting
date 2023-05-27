/* package codechef; // don't place package name! */
import java.util.*;

class ProblemE1 {
    static class Pair<T1, T2> {
        T1 first;
        T2 second;

        public Pair(T1 first, T2 second) {
            this.first = first;
            this.second = second;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] w = new int[n];
            int[] l = new int[n];
            for (int i = 0; i < n; i++) {
                w[i] = sc.nextInt();
            }
            for (int i = 0; i < n; i++) {
                l[i] = sc.nextInt();
            }
            Map<Integer, Pair<Integer, Integer>> arry = new TreeMap<>();
            for (int i = 0; i < n; i++) {
                arry.put(w[i], new Pair<>(l[i], i));
            }
            int ans = 0, curr = 0, length = 0;
            for (Map.Entry<Integer, Pair<Integer, Integer>> entry : arry.entrySet()) {
                Pair<Integer, Integer> pair = entry.getValue();
                if (entry.getKey() == arry.keySet().iterator().next()) {
                    curr = pair.second;
                } else {
                    length = pair.second;
                    while (curr >= length) {
                        ans++;
                        length += pair.first;
                    }
                    curr = length;
                }
            }
            System.out.println(ans);
        }
    }
}
