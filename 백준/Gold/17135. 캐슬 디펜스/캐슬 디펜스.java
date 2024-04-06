import java.io.*;
import java.util.*;

public class Main {
    static int N,M,D;
    static int[] pickList = new int[3];
    static int[][] graph;
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        graph = new int[N][M];
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        pick(0,0);
        System.out.println(max);
    }

    public static void pick(int count, int start){
        if(count == 3){
            max = Math.max(max,attack());
            return;
        }
        for(int i = start; i < M; i++){
            pickList[count] = i;
            pick(count+1, i+1);
        }
    }

    public static int attack(){
        int count = 0;
        int[][] status = new int[N][M];

        for(int i = N; i > 0; i--){
            for(int pick : pickList){
                for(int d = 1; d <= D; d++){
                    int cnt = validDis(i, pick, d, status);
                    if(cnt<0) continue;
                    count+=cnt;
                    break;
                }
            }
        }

        return count;
    }

    public static int validDis(int x, int pick, int d, int[][] status){
        int nn;
        for(int nm=pick-d;nm<=pick+d;nm++){
            nn = x-(d-Math.abs(nm-pick));
            if(nn<0 || nn >= x || nm <0 || nm >= M) continue;
            if(graph[nn][nm] == 0) continue;
            if(status[nn][nm] == 0){
                status[nn][nm] = x;
                return 1;
            }else if(status[nn][nm] == x) return 0;
        }

        return -1;
    }

}