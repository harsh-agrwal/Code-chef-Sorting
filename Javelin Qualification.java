/* package codechef; // don't place package name! */

import java.util.*;

import javax.lang.model.util.ElementScanner14;

import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef {
    public static boolean isPalandrome(char ch[]) {
        int i = 0, j = ch.length - 1;
        while (i < j) {
            if (ch[i] != ch[j])
                return false;
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) throws java.lang.Exception {
        // your code goes here
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while (test-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int k = sc.nextInt();
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
            HashMap<Integer, Integer> map = new HashMap<>();
            int i;
            for (i = 0; i < n; i++) {
                int x = sc.nextInt();
                map.put(x, i + 1);
                pq.offer(x);
            }
            List<Integer> list = new ArrayList<>();
            while (!pq.isEmpty()) {
                int top = pq.poll();
                if (top >= m) {
                    list.add(map.get(top));
                } else if (list.size() < k) {
                    list.add(map.get(top));
                }
            }
            System.out.print(list.size() + " ");
            Collections.sort(list);
            for (i = 0; i < list.size(); i++) {
                System.out.print(list.get(i) + " ");
            }
            System.out.println();
        }
    }
}
