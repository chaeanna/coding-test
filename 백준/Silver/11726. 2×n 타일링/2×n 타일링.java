import java.io.*;
public class Main {

    static long[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        dp = new long[n+1];
        if (n == 0) {
            dp[0] = 0;
            System.out.println(0);
        } else if(n ==1) {
            dp[1] = 1;
            System.out.println(1);
        } else {
            tile(n);
            System.out.println(dp[n]);
        }



    }

    public static void tile(int n) {
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i-1] + dp[i-2]) % 10007;
        }
    }

}
