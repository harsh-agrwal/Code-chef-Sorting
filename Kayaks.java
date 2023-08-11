import java.io.*;
import java.util.*;
import java.awt.*;
public class Main
{
    static double eps=1e-8;
    static double[] dist=new double[100000];
    static double[][] ar=new double[100000][2];
    static int n;
    public static boolean ok(double m){
        double temp=Math.sqrt(1.0+m*m);        
        for(int i=0;i<n;i++){
            dist[i]=(-ar[i][1]+m*ar[i][0])/temp;
        }
        Arrays.sort(dist,0,n);
        for(int i=0;i+i<n;i++) if((dist[i]+dist[n-1-i]) > 0){ 
            return false;
        }
        return true;
    }
    public static void main(String args[])throws Exception
    {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer ss;
        PrintWriter out=new PrintWriter(System.out);
        n=Integer.parseInt(in.readLine());        
        for(int i=0;i<n;i++)
        {
            ss=new StringTokenizer(in.readLine());
            ar[i][0]=Double.parseDouble(ss.nextToken())+10.0;
            ar[i][1]=Double.parseDouble(ss.nextToken());            
        }
        double low=0.4,high=1.7,mid=0.0;        
        while(high-low>eps){
            mid=(low+high)/2.0;
            if(ok(mid)) low=mid;
            else high=mid;
        }
        out.printf("%.6f\n",(low+high)/2.0);
        out.flush();
    }
}
