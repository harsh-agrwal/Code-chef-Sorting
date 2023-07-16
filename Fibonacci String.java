import java.util.*;
class Fibonacci_String {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        while (t-- > 0) {
            String str = input.next();
            int arr[] = new int[27];
            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                arr[(int) ch - 96]++;
            }
            Arrays.sort(arr);
            ArrayList<Integer> list = new ArrayList<Integer>();
            for (int i = 0; i < 27; i++) {
                if (arr[i] != 0) {
                    list.add(arr[i]);
                }
            }
            if (list.size() < 3) {
                System.out.println("Dynamic");
            } else {
                boolean cond1 = true, cond2 = true;
                for (int i = 2; i < list.size(); i++) {
                    if (list.get(i) != (list.get(i - 1) + list.get(i - 2))) {
                        cond1 = false;
                        break;
                    }
                }
                int temp0 = list.get(0), temp1 = list.get(1);
                list.set(0, temp1);
                list.set(1, temp0);
                for (int i = 2; i < list.size(); i++) {
                    if (list.get(i) != (list.get(i - 1) + list.get(i - 2))) {
                        cond2 = false;
                        break;
                    }
                }
                if (cond1 || cond2) {
                    System.out.println("Dynamic");
                } else {
                    System.out.println("Not");
                }
            }
        }
        input.close();
    }
}
