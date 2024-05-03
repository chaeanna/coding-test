import java.io.*;
import java.util.*;

class Main {
    static int[] stairs;
    static Integer[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        stairs = new int[N+1];
        dp = new Integer[N+1];
        for (int i = 1; i <= N; i++) {
            stairs[i] = Integer.parseInt(br.readLine());
        }

        dp[0] = stairs[0];
        dp[1] = stairs[1];
        if (N >= 2) {
            dp[2] = stairs[1] + stairs[2];
        }

        System.out.println(DP(N));
    }
    // Top-Down : 재귀
    public static int DP(int num) {
        if (dp[num] == null) {
            dp[num] = Math.max(DP(num-2), DP(num-3)+stairs[num-1])+stairs[num];
        }
        return dp[num];
    }
    
}
