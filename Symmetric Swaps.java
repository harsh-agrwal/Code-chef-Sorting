/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Hat{
    int d;
    int pos;
    public Hat(int a,int b){
        d=a;
        pos=b;
    }
}
class Hello implements Comparator<Hat>{
    public int compare(Hat h1,Hat h2){
        if(h1.d>h2.d)
        return 1;
        else 
        return -1;
    }
}
class Codechef
{
    InputRead1 rr;
    public void calc() throws Exception{
        int n=ni();
        List<Hat> lis=new ArrayList<>();
        int i,f,j;
        for(i=0;i<n;i++){
            f=ni();
            lis.add(new Hat(f,i));
        }
        for(i=0;i<n;i++){
            f=ni();
            lis.add(new Hat(f,i));
        }
        Collections.sort(lis,new Hello());
        
        Map<Integer,Integer> vis=new HashMap<>();
        i=j=0;
        Hat temp,templ;
        int nIt=2*n;
        int ans=Integer.MAX_VALUE;
        while(j<nIt){
            
            while(j<nIt && vis.size()<n){
                temp=lis.get(j);
                if(vis.containsKey(temp.pos)){
                    vis.put(temp.pos,2);
                }else{
                    vis.put(temp.pos,1);
                }
                j++;
            }
            if(vis.size()==n){
                f=j-1;
                temp=lis.get(f);
                templ=lis.get(i);
                ans=Math.min(ans,temp.d-templ.d);
                
                while(i<j && vis.size()==n){
                    templ=lis.get(i);
                    ans=Math.min(ans,temp.d-templ.d);
                    if(vis.get(templ.pos)==2){
                        vis.put(templ.pos,1);
                    }else 
                      vis.remove(templ.pos);
                      i++;
                }
            }
            
        }
        if(ans==Integer.MAX_VALUE)
        ans=0;
        System.out.println(ans);
        }
    public void run() throws Exception{
        rr=new InputRead1();
        int t=ni();
        while(t-->0){
            calc();
        }
    }
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		try{
		    new Codechef().run();
		}
		catch(Exception ee){
		    
		}
	}
	public int ni() throws Exception{
	    return Integer.parseInt(rr.next());
	}
	class InputRead1{
	    BufferedReader br;
	    StringTokenizer str;
	    public InputRead1(){
	        br=new BufferedReader(new InputStreamReader(System.in));
	    }
	    public String next() throws Exception{
	        while(str==null || !str.hasMoreTokens()){
	            str=new StringTokenizer(br.readLine());
	        }
	        return str.nextToken();
	    }
	}
}
