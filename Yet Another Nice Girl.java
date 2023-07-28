 /* package codechef; // don't place package name! */
 import java.math.BigInteger;
import java.util.*;
import java.util.Map.Entry;
import java.util.stream.*;
import java.lang.*;
import java.math.*;
import java.text.DecimalFormat;
import java.io.*;
import java.util.Stack;


 class Codechef
{
     
    static BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer ST;
    static PrintWriter out = new PrintWriter(System.out);
    static DecimalFormat df = new DecimalFormat("0.00000");
    final static int MAX = Integer.MAX_VALUE, MIN = Integer.MIN_VALUE, mod = (int) (1e9 + 7);
    final static long LMAX = Long.MAX_VALUE, LMIN = Long.MIN_VALUE;
    final static long INF = (long) 1e18, Neg_INF = (long) -1e18;
    static Random rand = new Random();
     static int PQ;
    static int N = 1000001; 
static long[] factorialNumInverse = new long[N + 1];
static long[] naturalNumInverse = new long[N + 1];
static long[] fact = new long[N + 1];
    public static void main (String[] args) throws java.lang.Exception
    {
       Scanner in = new Scanner(System.in);  
      BigInteger mult;
        int T=1,i,l,j,G,u,z,Z,k;
        int cnt;
        int K,d;
      int N,M,x,y,Q;
    int a,ans;
     int c,g,h,s,r;
        int X,f,e,L;
        long max,min;
        char C;
       int b=0;
        boolean flag=true,fg=true;
        String A,B,D,U="",S="";
       T=readInt();
      for(i=1;i<=T;i++)
      {  
          N=readInt();
          double m[]=new double[N];
          a=0;
          b=0;
          for(j=0;j<N;j++)
          {
              m[j]=readInt();
              m[j]=(double)((double)m[j]/(double)Math.log(m[j]));
          }
          double n[]=new double[N];
          for(j=0;j<N;j++)
          {
              n[j]=readInt();
              n[j]=(double)((double)n[j]/(double)Math.log(n[j]));
          }
          Arrays.sort(m);
          Arrays.sort(n);
          double ansd=0;
          ans=0;
          for(j=0;j<N;j++)
          {
              double aa=m[j];
              l=0;
              r=N-1;
              flag=false;
              while(l<=r)
              {
                  int mid=(l+r)/2;
                  if(aa>=n[mid])
                  {
                      l=mid+1;
                  }
                  else
                  {
                      r=mid-1;
                      ans=mid;
                      flag=true;
                  }
              }
              if(flag){
              ans=N-ans;
              ansd=ansd+(double)((double)(ans)/(double)N);}
          }
          out.println(ansd);
     }
   out.flush();
}

   static int power(int x, int y, int p)
    {
        int res = 1;
        x = x % p;
        while (y > 0) {
            if (y % 2 == 1)
                res = (res * x) % p;
 
            y = y >> 1; // y = y/2
            x = (x * x) % p;
        }
 
        return res;
    }
 
    static int modInverse(int n, int p)
    {
        return power(n, p - 2, p);
    }
    static int nCrModPFermat(int n, int r,
                             int p)
    {
 
          if (n<r)
              return 0;
        if (r == 0)
            return 1;
        int[] fac = new int[n + 1];
        fac[0] = 1;
 
        for (int i = 1; i <= n; i++)
            fac[i] = fac[i - 1] * i % p;
 
        return (fac[n] * modInverse(fac[r], p)
                % p * modInverse(fac[n - r], p)
                % p)
            % p;
    }
  public static Node buildTree(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        Node root = new Node(nums[0]);
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        int i = 1;
        while (i < nums.length) {
            Node curr = q.remove();
            if (i < nums.length) {
                curr.left = new Node(nums[i++]);
                q.add(curr.left);
            }
            if (i < nums.length) {
                curr.right = new Node(nums[i++]);
                q.add(curr.right);
            }
        }
        return root;
    }
 public static void InverseofNumber(int p)
{
    naturalNumInverse[0] = naturalNumInverse[1] = 1;
     
    for(int i = 2; i <= N; i++)
        naturalNumInverse[i] = naturalNumInverse[p % i] *
                                 (long)(p - p / i) % p;
}
 
public static void InverseofFactorial(int p)
{
    factorialNumInverse[0] = factorialNumInverse[1] = 1;
 
    for(int i = 2; i <= N; i++)
        factorialNumInverse[i] = (naturalNumInverse[i] *
                           factorialNumInverse[i - 1]) % p;
}
 
public static void factorial(int p)
{
    fact[0] = 1;
 
    // Precompute factorials
    for(int i = 1; i <= N; i++)
    {
        fact[i] = (fact[i - 1] * (long)i) % p;
    }
}
public static long Binomial(int N, int R, int p)
{
     
    // n C r = n!*inverse(r!)*inverse((n-r)!)
    long ans = ((fact[N] * factorialNumInverse[R]) %
                       p * factorialNumInverse[N - R]) % p;
     
    return ans;
}

public static int binaryToInteger(String binary) {
    char[] numbers = binary.toCharArray();
    int result = 0;
    for(int i=numbers.length - 1; i>=0; i--)
        if(numbers[i]=='1')
            result += Math.pow(2, (numbers.length-i - 1));
    return result;
}

    static String next() throws IOException {
        while (ST == null || !ST.hasMoreTokens())
            ST = new StringTokenizer(readLine());
        return ST.nextToken();
    }
 
    static long readLong() throws IOException {
        return Long.parseLong(next());
    }
 
    static int readInt() throws IOException {
        return Integer.parseInt(next());
    }
 
    static double readDouble() throws IOException {
        return Double.parseDouble(next());
    }
 
    static char readCharacter() throws IOException {
        return next().charAt(0);
    }
 
    static String readString() throws IOException {
        return next();
    }
    static String readLine() throws IOException {
        return BR.readLine().trim();
    }
 
    static int[] readIntArray(int n) throws IOException {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = readInt();
        return arr;
    }
 
    static int[][] read2DIntArray(int n, int m) throws IOException {
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++)
            arr[i] = readIntArray(m);
        return arr;
    }
 
    static List<Integer> readIntList(int n) throws IOException {
        List<Integer> list = new ArrayList<>(n);
        for (int i = 0; i < n; i++)
            list.add(readInt());
        return list;
    }
 
    static long[] readLongArray(int n) throws IOException {
        long[] arr = new long[n];
        for (int i = 0; i < n; i++)
            arr[i] = readLong();
        return arr;
    }
 
    static long[][] read2DLongArray(int n, int m) throws IOException {
        long[][] arr = new long[n][m];
        for (int i = 0; i < n; i++)
            arr[i] = readLongArray(m);
        return arr;
    }
 
    static List<Long> readLongList(int n) throws IOException {
        List<Long> list = new ArrayList<>(n);
        for (int i = 0; i < n; i++)
            list.add(readLong());
        return list;
    }
    static char[] readCharArray() throws IOException {
        return readString().toCharArray();
    }
 
    static char[][] readMatrix(int n, int m) throws IOException {
        char[][] mat = new char[n][m];
        for (int i = 0; i < n; i++)
            mat[i] = readCharArray();
        return mat;
    }
    private static void printIList(List<Integer> list) {
        for (int i = 0; i < list.size(); i++)
            out.print(list.get(i) + " ");
        out.println(" ");
    }
 
    private static void printLList(List<Long> list) {
        for (int i = 0; i < list.size(); i++)
            out.print(list.get(i) + " ");
        out.println(" ");
    }
 
    private static void printIArray(int[] arr) {
        for (int i = 0; i < arr.length; i++)
            out.print(arr[i] + " ");
        out.println(" ");
    }
 
    private static void print2DIArray(int[][] arr) {
        for (int i = 0; i < arr.length; i++)
            printIArray(arr[i]);
    }
 
    private static void printLArray(long[] arr) {
        for (int i = 0; i < arr.length; i++)
            out.print(arr[i] + " ");
        out.println(" ");
    }
     private static void print2DLArray(long[][] arr) {
        for (int i = 0; i < arr.length; i++)
            printLArray(arr[i]);
    }
 
    private static void yes() {
        out.println("YES");
    }
 
    private static void no() {
        out.println("NO");
    }
    private static void sort(int[] arr) {
        int n = arr.length;
        List<Integer> list = new ArrayList<>(n);
        for (int i = 0; i < n; i++)
            list.add(arr[i]);
        Collections.sort(list);
        for (int i = 0; i < n; i++)
            arr[i] = list.get(i);
    }
 
    private static void reverseSort(int[] arr) {
        int n = arr.length;
        List<Integer> list = new ArrayList<>(n);
        for (int i = 0; i < n; i++)
            list.add(arr[i]);
        Collections.sort(list, Collections.reverseOrder());
        for (int i = 0; i < n; i++)
            arr[i] = list.get(i);
    }
    private static void sort(long[] arr) {
        int n = arr.length;
        List<Long> list = new ArrayList<>(n);
        for (int i = 0; i < n; i++)
            list.add(arr[i]);
        Collections.sort(list);
        for (int i = 0; i < n; i++)
            arr[i] = list.get(i);
    }
    private static void reverseSort(long[] arr) {
        int n = arr.length;
        List<Long> list = new ArrayList<>(n);
        for (int i = 0; i < n; i++)
            list.add(arr[i]);
        Collections.sort(list, Collections.reverseOrder());
        for (int i = 0; i < n; i++)
            arr[i] = list.get(i);
    }
    private static int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }
 
    private static long gcd(long a, long b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }
 
    private static int lcm(int a, int b) {
        return (a / gcd(a, b)) * b;
    }
 
    private static long lcm(long a, long b) {
        return (a / gcd(a, b)) * b;
    }
 
    private static int mod_pow(long a, long b, int mod) {
        if (b == 0)
            return 1;
        int temp = mod_pow(a, b >> 1, mod);
        temp %= mod;
        temp = (int) ((1L * temp * temp) % mod);
        if ((b & 1) == 1)
            temp = (int) ((1L * temp * a) % mod);
        return temp;
    }
 
    private static int multiply(int a, int b) {
        return (int) ((((1L * a) % mod) * ((1L * b) % mod)) % mod);
    }
     private static int divide(int a, int b) {
        return multiply(a, mod_pow(b, mod - 2, mod));
    }
 
    private static boolean isPrime(long n) {
        for (long i = 2; i * i <= n; i++)
            if (n % i == 0)
                return false;
        return true;
    }
 
    private static long nCr(long n, long r) {
        if (n - r > r)
            r = n - r;
        long num = 1L, den = 1L;
        for (long i = r + 1; i <= n; i++) {
            num *= i;
            num %= mod;
        }
        for (long i = 2; i <= n - r; i++) {
            den *= i;
            den %= mod;
        }
        return divide((int) num, (int) den);
    }
 
    private static List<Integer> factors(int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; 1L * i * i <= n; i++)
            if (n % i == 0) {
                list.add(i);
                if (i != n / i)
                    list.add(n / i);
            }
        return list;
    }
     private static List<Long> factors(long n) {
        List<Long> list = new ArrayList<>();
        for (long i = 1; i * i <= n; i++)
            if (n % i == 0) {
                list.add(i);
                if (i != n / i)
                    list.add(n / i);
            }
        return list;
    }
    private static boolean isPalindrome(String str) {
        int i = 0, j = str.length() - 1;
        while (i < j)
            if (str.charAt(i++) != str.charAt(j--))
                return false;
        return true;
    }
    private static boolean isSubsequence(String a, String b) {
        int idx = 0;
        for (int i = 0; i < b.length() && idx < a.length(); i++)
            if (a.charAt(idx) == b.charAt(i))
                idx++;
        return idx == a.length();
    }
 
    private static String reverseString(String str) {
        StringBuilder sb = new StringBuilder(str);
        return sb.reverse().toString();
    }
 
    private static String sortString(String str) {
        int[] arr = new int[256];
        for (char ch : str.toCharArray())
            arr[ch]++;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 256; i++)
            while (arr[i]-- > 0)
                sb.append((char) i);
        return sb.toString();
    }
}
class Node
{
    int data;
    Node left, right;
    Node(int data)
    {
        this.data = data;
        left = right = null;
    }
}
