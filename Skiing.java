/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
	    int T = Integer.parseInt(st.nextToken());
	    for ( int t = 0; t < T; t++){
	        st = new StringTokenizer(br.readLine());
	        int N= Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
	        ArrayList<int[]> list = new ArrayList<>();
	        int[][] grid = new int[N][M];
	        for ( int i=0; i < N; i++){
	            st =new StringTokenizer(br.readLine());
	            for ( int j =0; j < M; j++){
	                grid[i][j] = Integer.parseInt(st.nextToken());
	                list.add(new int[]{i,j});
	            }
	        }
	        list.sort( (int[] a, int[] b) -> {
	            int ax = a[0], ay= a[1], bx = b[0], by = b[1];
	            if ( grid[ax][ay] > grid[bx][by]){
	                return -1;
	            }
	            else if ( grid[ax][ay] == grid[bx][by]){
	                return 0;
	            }
	            return 1;
	        });
	        boolean[][] traversed = new boolean[N][M];
	        int count  = 0;
	        for ( int i=0; i < list.size(); i++){
	            int cx = list.get(i)[0], cy = list.get(i)[1];
	            if ( traversed[cx][cy] ){
	                continue;
	            }
	            count ++;
	            Queue<Integer> rq = new LinkedList<>();
	            Queue<Integer> cq = new LinkedList<>();
	            rq.add(cx);
	            cq.add(cy);
	            traversed[cx][cy] = true;
	            while ( !rq.isEmpty()){
	                cx = rq.remove();
	                cy = cq.remove();
	                if ( cx -1 >=0 && grid[cx-1][cy] <= grid[cx][cy] && !traversed[cx-1][cy]){
	                    rq.add(cx-1);
	                    cq.add(cy);
	                    traversed[cx-1][cy] = true;
	                }
	                if ( cx+1 < N && grid[cx+1][cy] <= grid[cx][cy] && !traversed[cx+1][cy]){
	                    rq.add(cx+1);
	                    cq.add(cy);
	                    traversed[cx+1][cy]= true;
	                }
	                if ( cy-1 >= 0 && grid[cx][cy-1] <= grid[cx][cy] && !traversed[cx][cy-1]){
	                    rq.add(cx);
	                    cq.add(cy-1);
	                    traversed[cx][cy-1] = true;
	                }
	                if( cy+1 < M && grid[cx][cy+1] <= grid[cx][cy] && !traversed[cx][cy+1]){
	                    rq.add(cx);
	                    cq.add(cy+1);
	                    traversed[cx][cy+1] = true;
	                }
	            }
	        }
	        System.out.println(count);
	    }
	}
}
