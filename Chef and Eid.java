import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            int[] coins = new int[n];
            for (int i = 0; i < n; i++) {
                coins[i] = scanner.nextInt();
            }
            Arrays.sort(coins);
            int minDiff = Integer.MAX_VALUE;
            for (int i = 0; i < n - 1; i++) {
                int diff = Math.abs(coins[i] - coins[i+1]);
                if (diff < minDiff) {
                    minDiff = diff;
                }
            }
            System.out.println(minDiff);
        }
    }
}
