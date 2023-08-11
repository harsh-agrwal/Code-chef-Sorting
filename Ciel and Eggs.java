import java.util.*;
import java.math.*;

public class Main{
   public static void main(String[] args){
      new Main();
   }
   final long inf = 1L << 40;
   class pt{
      long x, y;
      public pt(long a, long b){
         x = a; 
         y = b;
      }
      pt minus(pt q){
         return new pt(x - q.x, y - q.y);
      }
      long cross(pt q){
         return x * q.y - y * q.x;
      }
   }

   long[] A;
   long[][] G = new long[505][505];
   pt[] T = new pt[505];
   int n, sz;

   void add(long x, long y){
      pt p = new pt(x, y);
      while(sz >= 2 && p.minus(T[sz - 1]).cross(p.minus(T[sz - 2])) <= 0)
         sz--;
      T[sz++] = p;
      if(sz >= 2 && T[sz - 1].x == T[sz - 2].x) sz--;
   }

   long eval(int i, long x){
      return T[i].x * x + T[i].y;
   }

   public Main(){
      Scanner in = new Scanner(System.in);
      int t = in.nextInt();
      
      while(t-- > 0){
         int K;
         n = in.nextInt(); K = in.nextInt();
         A = new long[n];
         for(int i = 0; i < n; i++) A[i] = in.nextLong();
         Arrays.sort(A);

         for(int k = 0; k <= K; k++){
            sz = 0;
            for(int pos = n; pos >= 0; pos--)
               if(pos == n) G[pos][k] = k == 0 ? 0L : inf;
               else{
                  if(k > 0 && G[pos + 1][k - 1] != inf)
                     add(pos + 1, G[pos + 1][k - 1]);
                  long res = inf;

                  int le = 0, ri = sz - 1;
                  while(ri - le >= 4){
                     int a = le + (ri - le) / 3;
                     int b = le + (ri - le) * 2 / 3;
                     if(eval(a, A[pos]) < eval(b, A[pos])) ri = b;
                     else le = a;
                  }
                  for(int it = le; it <= ri; it++)
                     res = Math.min(res, eval(it, A[pos]) - A[pos] * pos);
                  G[pos][k] = res;
               }
         }
         long ret = inf;
         for(int i = 0; i < n; i++) 
            ret = Math.min(ret, G[i][K]);
         System.out.println(ret);
      }
   }

}
