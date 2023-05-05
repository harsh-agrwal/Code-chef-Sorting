import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef {
    
	public static void main (String[] args) throws java.lang.Exception {
	    
		Scanner sca = new Scanner(System.in);
		int n = sca.nextInt();
		long d = sca.nextLong();
		long[] arr = new long[n];
		for(int i=0; i<n; i++) {
		    arr[i] = sca.nextLong();
		}
		Arrays.sort(arr);
		int i = 0;
		int count = 0;
		while(i<n-1) {
		    if(arr[i+1]-arr[i] <= d) {
		        count++;
		        i += 2;
		    }
		    else {
		        i++;
		    }
		}
		System.out.println(count);
	}
}
