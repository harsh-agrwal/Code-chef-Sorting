import java.util.Arrays;
import java.util.*;

class SortArraysByDifference {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
  	    int x = sc.nextInt();
  	    int y = sc.nextInt();
		int[] A = new int[m];
			for(int i = 0; i<m; i++) 
			A[i]=sc.nextInt();
			int[] B = new int[m];
			for(int i = 0; i<m; i++) 
			B[i]=sc.nextInt();
        int[] differences = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            differences[i] = Math.abs(A[i] - B[i]);
        }
        Integer[] indices = new Integer[A.length];
        for (int i = 0; i < A.length; i++) {
            indices[i] = i;

        Arrays.sort(indices, new Comparator<Integer>() {
            @Override
            public int compare(Integer i1, Integer i2) {
                return Integer.compare(differences[i1], differences[i2]);
            }
        });
        int[] sortedA = new int[A.length];
        int[] sortedB = new int[B.length];
        for (int i = 0; i < A.length; i++) {
            sortedA[i] = A[indices[i]];
            sortedB[i] = B[indices[i]];
        }
        int ac=0;
        int bc=0;
        int sum=0;
        for (int k=m-1;k>=0 ;k-- ){
           int max= Math.max( sortedA[k], sortedB[k]);
           if(max==sortedA[k]){
               if(ac<x){ sum=sum+max;ac++;}
               else {sum=sum+sortedB[k];bc++;}
           }
           else if(max==sortedB[k]){
              if(bc<y){ sum=sum+max;bc++;}
               else {sum=sum+sortedA[k];ac++;}
           }
        } 
       System.out.println(sum);
    }
}
