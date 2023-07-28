import java.io.*;
import java.util.*;

class permsuff {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int z = 1; z <= t; z++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int arr[]=new int[n];
            pair seg[]=new pair[m];
            for(int i=0;i<n;i++){
                arr[i]=sc.nextInt();
            }
            for(int i=0;i<m;i++){
                seg[i]=new pair(sc.nextInt(),sc.nextInt());
            }
            Arrays.sort(seg, new Comparator<pair>() {
                @Override
                public int compare(pair o1, pair o2) {
                    return Integer.compare(o1.st,o2.st);
                }
            });
            int start=-1,end=-1;
            for(int i=0;i<m;i++){
                if(start == -1){
                    start=seg[i].st;
                    end=seg[i].end;
                } else {
                    if(end>=seg[i].st){
                        end=Math.max(end,seg[i].end);
                    } else {
                        //System.out.println(start+" "+end);
                        Arrays.sort(arr,start-1,end);
                        start=seg[i].st;
                        end=seg[i].end;
                    }
                }
            }
            Arrays.sort(arr,start-1,end);
            String ans="Possible";
            for(int i=1;i<=n;i++){
                if(i!=arr[i-1]){
                    ans="Impossible";
                    break;
                }
            }
            System.out.println(ans);
        }
    }
    static class pair {
        int st,end;
        public pair(int s, int e){
            st=s;
            end=e;
        }
    }
}
