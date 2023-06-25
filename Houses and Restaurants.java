/* package codechef; // don't place package name! */

import java.io.* ;
import java.util.* ;

class Codeshefcode {
	final static int r = 1000000007 ;
	static FileInputStream in=null ;
	static FileOutputStream out=null ;
	static FasterScanner input = new FasterScanner() ;
	static FasterScanner infile ;
	static PrintWriter outfile  ;
	static PrintWriter output = new PrintWriter(System.out) ;
	static int iD[] ;
	static int N,M ;
	static int R ;
	static char[] C ;
	static ArrayList<Triple> Lists ;
	public static void main(String[] args) throws IOException{
		int T = Rint() ;
		for(int i=0 ; i<T ; i++){
		     N = Rint() ;
		     M = Rint() ;
		     C = Rstring().toCharArray() ;
		     R=0 ;
		     for(int j=0 ; j<N ; j++){
		    	 if(C[j]=='R')
		    		 R++ ;
		     }
		     int A,B,C ;
		     Lists =  new ArrayList<Triple>() ;
		     iD = new int[N+1] ;
		     for(int j=0 ; j<=N ; j++){
			    iD[j]=j ;
		     }
		     for(int j=0 ; j<M ; j++){
			    A = Rint() ;
			    B = Rint() ;
			    C = Rint() ;
			    Lists.add(new Triple(A,B,C)) ;
		     }
		     println(sPMST()) ;
		}
		Finish() ;
		
	}
	
	static long sPMST(){
		Collections.sort(Lists,new TripComp()); 
		int size = Lists.size() ;
		long result=0 ;
		for(int i=0 ; i<size ; i++){
			Triple T = Lists.get(i) ;
			if(T.z<0){
				result+=T.z ;
				union(T.x,T.y) ;
			}
			else{
				if(!connc(T.x,T.y)){
				     result+=T.z ;
				     union(T.x,T.y) ;
				}					
			}
		}
		return result ;
	}
	
	static int root(int x){
		ArrayList<Integer> nodes = new ArrayList<Integer>() ;
		while(iD[x]!=x){
			nodes.add(x) ;
			x=iD[x] ;
		}
		int size = nodes.size() ;
		for(int i=0 ; i<size ; i++){
			iD[nodes.get(i)]=x ;
		}
		return x ;
	}
	static void union(int x , int y){
		int i = root(x) ;
		int j = root(y) ;
		if(C[i-1]=='R')
			iD[j]=i ;
		else{
			if(C[j-1]=='R')
				iD[i]=j ;
			else{
				if(i>j)
					iD[i]=j ;
				else
					iD[j]=i ;
			}
		}
	}
	
	static boolean connc(int x , int y){
	   int i = root(x) ;
	   int j = root(y) ;
	   if(i==j)
		   return true ;
	   else{
		   if(C[i-1]=='R'&& C[j-1]=='R')
			   return true ;
		   else
			   return false ;
	   }
	}
	
	static void Start() throws IOException{
		out = new FileOutputStream("output.txt") ; 
        outfile = new PrintWriter(out) ;	
	    String s = Rstring() ;
	    s+=".in" ;
	    in = new FileInputStream(s) ;
	    infile = new FasterScanner(in) ;
	}
	
	static void Finish(){
		output.flush();
		output.close();
		
	}
	static void FinishF(){
		outfile.flush();
		outfile.close();
	}
	

	static int Rint(){
		return input.nextInt() ;
	}
	static long Rlong(){
		return input.nextLong() ;
	}
	static String Rstring(){
		return input.nextString() ;
	}
	static void print(Object i){
		output.print(i) ;
	}
	static void println(Object i){
		output.println(i) ;
	}
	static int RIntf(){
		return infile.nextInt() ;
	}
	static long RLongf(){
		return infile.nextLong() ;
	}
	static String RStringf(){
		return infile.nextString() ;
	}
	static void printf(Object i){
		outfile.print(i) ;
	}
	static void printlnf(Object i){
		outfile.println(i) ;
	}
	
}	

class TripComp implements Comparator<Triple>{
	public int compare(Triple T1 , Triple T2){
		if(T1.z<T2.z)
			return -1 ;
		if(T1.z==T2.z)
			return 0 ;
		return 1 ;
	}
}


class ModOp{
	static private int k ;
	final static private int r=k ;
	ModOp(int i){
		k= i ;
	}
	static long D(long a , long b){
		return (a*ModInverse(b))%r ;
	}
	static long m(long a , long b){
		return (a*b)%r ;
	}
	static long ModInverse(long a ){
	return FastPowr(a,r-2) ;	
		
	}
	static long FastPowr(long a , long b){
		if(b==0)
		    return 1 ;
		if(b==1)
			return a ;
		long halfpow = FastPowr(a,b/2) ;
		if(b%2==0)
			return (halfpow*halfpow)%r ;
		else
			return (((halfpow*halfpow)%r)*a)%r ;
		
	}
	
}



class Pair<E,F>{
	private E x  ;
	private F y  ;
	public void put(E a , F b){
		x=a ;
		y=b ;
	}
	public E getx(){
		return x ;
	}
	public F gety(){
		return y ;
	}
	Pair(E a ,F b){
		x=a ;
		y=b ;
	}
}
class Triple{
	public int x ;
	public int y ;
	public int z ;
	Triple(int a , int b , int c){
		x=a ;
		y=b ;
		z=c ;
	}	
}


class FasterScanner {

    private InputStream mIs;
    private byte[] buf = new byte[1024];
    private int curChar;
    private int numChars;

    public FasterScanner() {
        this(System.in);
    }

    public FasterScanner(InputStream is) {
        mIs = is;
    }

    public int read() {
        if (numChars == -1) {
            throw new InputMismatchException();
    
    }
        if (curChar >= numChars) {
            curChar = 0;
            try {
                numChars = mIs.read(buf);
            } catch (IOException e) {
                throw new InputMismatchException();
            }
            if (numChars <= 0) {
                return -1;
            }
        }
        return buf[curChar++];
    }

    public String nextLine() {
        int c = read();
        while (isSpaceChar(c)) {
            c = read();
        }
        StringBuilder res = new StringBuilder();
        do {
            res.appendCodePoint(c);
            c = read();
        } while (!isEndOfLine(c));
        return res.toString();
    }

    public String nextString() {
        int c = read();
        while (isSpaceChar(c)) {
            c = read();
        }
        StringBuilder res = new StringBuilder();
        do {
            res.appendCodePoint(c);
            c = read();
        } while (!isSpaceChar(c));
        return res.toString();
    }

    public long nextLong() {
        int c = read();
         while (isSpaceChar(c)) {
            c = read();
        }
        int sgn = 1;
        if (c == '-') {
            sgn = -1;
            c = read();
        }
        long res = 0;
        do {
            if (c < '0' || c > '9') {
                throw new InputMismatchException();
            }
            res *= 10;
            res += c - '0';
            c = read();
        } while (!isSpaceChar(c));
        return res * sgn;
    }

    public int nextInt() {
        int c = read();
        while (isSpaceChar(c)) {
            c = read();
        }
        int sgn = 1;
        if (c == '-') {
            sgn = -1;
            c = read();
        }
        int res = 0;
        do {
            if (c < '0' || c > '9') {
                throw new InputMismatchException();
            }
            res *= 10;
            res += c - '0';
             c = read();
        } while (!isSpaceChar(c));
        return res * sgn;
    }

    public boolean isSpaceChar(int c) {
        return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
    }

    public boolean isEndOfLine(int c) {
        return c == '\n' || c == '\r' || c == -1;
    }

}
