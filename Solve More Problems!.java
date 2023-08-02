/* package codechef; // don't place package name! */
import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
 class CodeChef
{
 public static class FastReader {

		BufferedReader b;
		StringTokenizer s;
		public FastReader() {
			b=new BufferedReader(new InputStreamReader(System.in));
		}
		String next() {
			while(s==null ||!s.hasMoreElements()) {
				try {
					s=new StringTokenizer(b.readLine());
				}
				catch(IOException e) {
					e.printStackTrace();
				}
			}
			return s.nextToken();
		}
		public int nextInt() {
			return Integer.parseInt(next());
		}
		public long nextLong() {
			return Long.parseLong(next());
		}
		public double nextDouble() {
			return Double.parseDouble(next());
		}
		String nextLine() {
			String str="";
			try {
				str=b.readLine();
			}
			catch(IOException e) {
				e.printStackTrace();
			}
			return str;
		}
		boolean hasNext() {
		    if (s != null && s.hasMoreTokens()) {
		        return true;
		    }
		    String tmp;
		    try {
		        b.mark(1000);
		        tmp = b.readLine();
		        if (tmp == null) {
		            return false;
		        }
		        b.reset();
		    } catch (IOException e) {
		        return false;
		    }
		    return true;
		}
}
public static int md=(int)(998244353);
public static boolean fg;
//public static int dp[][][];
static int pre[];
static final int MAXN = 1000001;
static int x[]= {0,0,1,-1,1,1,-1,-1};
static int y[]= {-1,1,0,0,1,-1,1,-1};
static long ans[];
static HashMap<Integer,HashMap<Integer,Integer>> hm;  
static int r,c;
static class Trie{
    Trie a[];
    public Trie() {
    	this.a=new Trie[2];
    }
}
static int suf1[];
static int suf2[];
static int dp[][];
	public static void main (String[] args) throws java.lang.Exception
	{
	FastReader sc=new FastReader();
	BufferedWriter log = new BufferedWriter(new OutputStreamWriter(System.out));
	if(sc.hasNext()){
		  int t=sc.nextInt();
		  while(t--!=0) {
			   int n=sc.nextInt();
			   int k=sc.nextInt();
			   ArrayList<pair> ar=new ArrayList<>();
			   int a[][]=new int[2][n];
			   for(int i=0;i<n;i++) {
				  a[0][i]=sc.nextInt();
			   }
			   for(int i=0;i<n;i++)a[1][i]=sc.nextInt();
			   for(int i=0;i<n;i++)ar.add(new pair(a[0][i],a[1][i]));
			   Collections.sort(ar,(aa,bb)->(aa.a+aa.b)-(bb.a+bb.b));
			   long pre[]=new long[ar.size()];
			   for(int i=0;i<ar.size();i++)pre[i]=pre[max(i-1,0)]+(ar.get(i).a+ar.get(i).b);
			   int ct=0;
			   for(int i=0;i<ar.size();i++) {
				    int s=0;
				    int e=ar.size()-1;
				    long val=k-ar.get(i).a;
				    while(s<=e) {
				    	int m=s+(e-s)/2;
				    	long sum=m>=i?pre[m]-(ar.get(i).a+ar.get(i).b):pre[m];
				    	if(sum<=val)s=m+1;
				    	else e=m-1;
				    }
				    if(e>=0){
				    	if(e>=i)ct=Math.max(ct, e+1);
				    	else ct=Math.max(ct, e+2);
				    }
				    else if(val>=0)ct=Math.max(ct, 1);
			   }
			   log.write(ct+"\n");
		  }
		  log.flush(); 
		  }
	}
	static void update(long f[],long upd,int ind) {
		int vl=ind;
		while(vl<f.length) {
			f[vl]+=upd;
			int tp=~vl;
			tp++;
			tp&=vl;
			vl+=tp;
		}
	}	
	static long ser(long f[],int ind) {
		int vl=ind;
		long sm=0;
		while(vl!=0) {
			sm+=f[vl];
			int tp=~vl;
			tp++;
			tp&=vl;
			vl-=tp;
		}
		return sm;
	}	
	static int max(int a,int b) {return a>=b?a:b;}			
	static int min(int a,int b) {return a>=b?b:a;}	
	static long max(long a,long b) {return a>=b?a:b;}	
	static long min(long a,long b) {return a>=b?b:a;}	
static void euler(ArrayList<ArrayList<Integer>> ar,int src,int pr,ArrayList<Integer> an) {
	an.add(src);
	for(int el:ar.get(src)) {
		if(el==pr)continue;
		euler(ar,el,src,an);
	}
	an.add(src);
}					     	

	static void build(int seg[],int a[],int l,int h,int pos) {
		if(l==h) {
			seg[pos]=a[l];
			return;
		}
		int mid=l+(h-l)/2;
		build(seg,a,l,mid,2*pos+1);
		build(seg,a,mid+1,h,2*pos+2);
		seg[pos]=seg[2*pos+1]&seg[2*pos+2];
	}	
	static int query(int seg[],int l,int h,int nl,int nh,int pos) {
		if(nl<=l && h<=nh)return seg[pos];
		if(nh<l || nl>h)return 3;
		int mid=l+(h-l)/2;
		return query(seg,l,mid,nl,nh,2*pos+1)&query(seg,mid+1,h,nl,nh,2*pos+2);
	}
	static void update(int seg[],int l,int h,int ind,int val,int pos) {
		if(l==h) {
			seg[pos]=val;
			return;
		}
		int mid=l+(h-l)/2;
		if(l<=ind && ind<=mid)update(seg,l,mid,ind,val,2*pos+1);
		else update(seg,mid+1,h,ind,val,2*pos+2);
		seg[pos]=seg[2*pos+1]&seg[2*pos+2];
	}		
static void prime(HashSet<Long> ar,long num) {
	while(num%2==0) {
		num/=2;
		ar.add(2L);
	}
	for(long i=3;i*i<=num;i+=2) {
		while(num%i==0) {
			num/=i;
			ar.add(i);
		}
	}
	if(num>1)ar.add(num);
}	
static int index(int a[],int i) {
	return a[(1+2*i)%(a.length|1)];
}	
static void set(int a[],int i,int val) {
	a[(1+2*i)%(a.length|1)]=val;
}
	
static void insert(Trie proot,String s) {
	Trie root=proot;
	for(int i=0;i<s.length();i++) {
		if(root.a[s.charAt(i)-'0']==null) {
			root.a[s.charAt(i)-'0']=new Trie();
		}
		root=root.a[s.charAt(i)-'0'];
	}
}
static long ser(Trie proot,String s) {
	Trie root=proot;
	long ans=0;
	long tw=2;
	for(int i=0;i<s.length();i++) {
		int el=s.charAt(i)-'0';
		if(root.a[1-el]!=null) {
			root=root.a[1-el];
		}
		else root=root.a[el];	
	}
	return ans;
}
static String substring(String s,int i,int j) {
	char tp[]=new char[j-i];
	int ptr=0;
	for(int k=i;k<j;k++) {
		tp[ptr++]=s.charAt(k);
	}
	return String.valueOf(tp);
}	
static int[] manacher_odd(String ss) {
    int n = ss.length();
    ss = "$" + ss + "^";
    char s[]=ss.toCharArray();
    int p[]=new int[n+2];
    int l = 1, r = 1;
    for(int i = 1; i <= n; i++) {
        p[i] = Math.max(0, Math.min(r - i, p[l + (r - i)]));
        while(s[i - p[i]] == s[i + p[i]]) {
            p[i]++;
        }
        if(i + p[i] > r) {
            l = i - p[i]; r = i + p[i];
        }
    }
    return p;
}
			
			static void update(int f[],int upd,int ind) {
				int vl=ind;
				while(vl<f.length) {
					f[vl]+=upd;
					int tp=~vl;
					tp++;
					tp&=vl;
					vl+=tp;
				}
			}	
			static int ser(int f[],int ind) {
				int vl=ind;
				int sm=0;
				while(vl!=0) {
					sm+=f[vl];
					int tp=~vl;
					tp++;
					tp&=vl;
					vl-=tp;
				}
				return sm;
			}	
		public static class pair{
			int a;
			int b;
			public pair(int a,int b) {
				this.a=a;
				this.b=b;
			}
		}
			public static class trip{
				int a,b;
				int c;
				int d;
				public trip(int a,int b,int c,int d) {
					this.a=a;
					this.b=b;
					this.c=c;
					this.d=d;
				}
				public int compareTo(trip q) {
					return  this.b-q.b;
				}
			}
				
			
	public static long mm=(long)(1e9+7);
	static long mul(long a,long b) {
		return ((a%m)*(b%m))%m;
	}	

	static long sub(long a,long b) {
		return ((a%mm)-(b%mm)+mm+mm+mm)%mm;
	}
		
		static int fact(int n) {
			for(int i=2;i*i<=n;i++) {
				if(n%i==0)return i;
			}
			return 1;
		}
			public static <E> void p(E[][] a,String s) {
				   System.out.println(s);
				   for(int i=0;i<a.length;i++) {
					   for(int j=0;j<a[0].length;j++) {
						   System.out.print(a[i][j]+" ");
			   }
			   
			   System.out.println();
		   }
		  
	}
	public static <E> void p(char a[],String s) {
		System.out.print(s+"=");
		for(int i=0;i<a.length;i++)System.out.print(a[i]+" ");
		System.out.println();
	}
	public static <E> void p(ArrayList<E> a,String s){
		System.out.println(s+"="+a);
	}
	public static <E> void p(LinkedList<E> a,String s){
		System.out.println(s+"="+a);
	}
	public static <E> void p(Stack<E> a,String s){
	  System.out.println(s+"="+a);
	}
	public static <E> void p(Queue<E> a,String s){
		System.out.println(s+"="+a);
	}
	
	public static class pairr{
		String a;int b;
		public pairr(String a,int b) {
			this.a=a;
			this.b=b;
		}
	}
	public static class num{
		long v;
	}
static long inv(long a) {
	return pow(a,m-2);
}
static long div(long a,long b) {
	long val=inv(b);
	return (val%m*a%m)%m;
}	
static long ncr(int n, int r){
	    if(r>n-r)r=n-r;
	    long ans=1;
	    for(int i=0;i<r;i++){
	          ans=(ans%mm*(n-i)%mm)%mm;
	          ans=div(ans,i+1);
	    }
	    return ans;
} 		
	static long pow(long a, long pw) {
		long temp;
		if(pw==0)return 1;
		temp=pow(a,pw/2);
		if(pw%2==0)return mul(temp,temp);
		return mul(a,mul(temp,temp));
		
	}	
	static int pow(int a, int pw) {
		int temp;
		if(pw==0)return 1;
		temp=pow(a,pw/2);
		if(pw%2==0)return temp*temp;
		return a*temp*temp;
		
	}	
	public static int m=(int)(998244353);
public static int add(int a,int b) {
	return ((a%m)+(b%m))%m;
}

public static int mul(int a,int b) {
	long p=a;
	long q=b;
	long ans=((p%m)*(q%m))%m;
	return (int)(ans);
}
static ArrayList<Long> primeDivisor(long n){
	ArrayList<Long> ar=new ArrayList<>();
	int cnt=0;
	boolean pr=false;
	while(n%2==0) {
		pr=true;
		ar.add(2L);
		n/=2;
		
	}
	for(long i=3;i*i<=n;i+=2) {
		pr=false;
		while(n%i==0) {
			n/=i;
			ar.add(i);
			pr=true;
		}
	
	}
	if(n>2) ar.add(n);
	return ar;
	
}
static ArrayList<Integer> prime(int n){
	boolean vis[]=new boolean[n+1];
	Arrays.fill(vis, true);
	vis[0]=vis[1]=false;
	for(int i=2;i*i<=n;i++) {
		if(vis[i]) {
		for(int j=2*i;j<=n;j+=i) {
			vis[j]=false;
		}
		}
	}
	ArrayList<Integer> ar=new ArrayList<>();
	for(int i=0;i<=n;i++) {
		if(vis[i])ar.add(i);
	}
	return ar;
}
static int gcd(int a,int b) {
	if(b==0)return a;
	return gcd(b,a%b);
}		
static void mergesort(int[] a,int start,int end) {
	if(start>=end)return;
	int mid=start+(end-start)/2;
	mergesort(a,start,mid);
	mergesort(a,mid+1,end);
	merge(a,start,mid,end);
}
static void merge(int []a, int start,int mid,int end) {
	int ptr1=start;
	int ptr2=mid+1;
	int b[]=new int[end-start+1];
	int i=0;
	while(ptr1<=mid && ptr2<=end) {
		if(a[ptr1]<=a[ptr2]) {
			b[i]=a[ptr1];
			ptr1++;
			i++;
		}
		else {
			b[i]=a[ptr2];
			ptr2++;
			i++;
		}
	}
	while(ptr1<=mid) {
		b[i]=a[ptr1];
		ptr1++;
		i++;
	}
	while(ptr2<=end) {
		b[i]=a[ptr2];
		ptr2++;
		i++;
	}
	for(int j=start;j<=end;j++) {
		a[j]=b[j-start];
	}
}
static void mergesort(ArrayList<pair> a,int start,int end) {
	if(start>=end)return;
	int mid=start+(end-start)/2;
	mergesort(a,start,mid);
	mergesort(a,mid+1,end);
	merge(a,start,mid,end);
}
static void merge(ArrayList<pair> ar, int start,int mid,int end) {
	int ptr1=start;
	int ptr2=mid+1;
	ArrayList<pair> b=new ArrayList<>();
	int i=0;
	while(ptr1<=mid && ptr2<=end) 
	{
		long n1=ar.get(ptr1).a*(long)(ar.get(ptr2).b);
		long n2=ar.get(ptr1).b*(long)(ar.get(ptr2).a);
		if(n1>n2) {
			b.add(new pair(ar.get(ptr1).a,ar.get(ptr1).b));
			ptr1++;
			i++;
		}
		else {
			b.add(new pair(ar.get(ptr2).a,ar.get(ptr2).b));
			ptr2++;
			i++;
		}
	}
	while(ptr1<=mid) {
		b.add(new pair(ar.get(ptr1).a,ar.get(ptr1).b));
		ptr1++;
		i++;
	}
	while(ptr2<=end) {
		b.add(new pair(ar.get(ptr2).a,ar.get(ptr2).b));
		ptr2++;
		i++;
	}
	for(int j=start;j<=end;j++) {
		ar.set(j, b.get(j-start));
	}
}
}
