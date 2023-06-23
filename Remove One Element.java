// /* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef {
    static Scanner scn = new Scanner(System.in);
	public static void main (String[] args) throws java.lang.Exception {
	    int t = scn.nextInt();
	    for(int tests = 0; tests < t; tests++) {
            int n = scn.nextInt();
            int[] a = new int[n], b = new int[n - 1];
            for(int i = 0; i < n; i++) a[i] = scn.nextInt();
            for(int i = 0; i < n - 1; i++) b[i] = scn.nextInt();
            Arrays.sort(a); Arrays.sort(b);
            int cand1 = b[0] - a[0], cand2 = b[0] - a[1];
            boolean c1 = check(a, b, cand1), c2 = check(a, b, cand2); 
            if(c1 && c2) {
                System.out.println(Math.min(cand2, cand1));
            }else if(c1) {
                System.out.println(cand1);
            }else {
                System.out.println(cand2);
            }
	    }
	}
	
	public static boolean check(int[] a, int[] b, int x) {
	    if(x <= 0) return false;
	    int n = a.length, m = b.length;
	    int i = 0, j = 0;
	    int count = 0;
	    while(i < n && j < m) {
	        if(b[j] - a[i] == x) {
	            i++; j++;
	        }else {
	            count++;
	            i++;
	        }
	    }
	    while(i < n) {
	        count++;
	        i++;
	    }
	    return i == n && j == m && count == 1;
	}
}
