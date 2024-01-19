class Solution {
    public long solution(int n) {
        long answer = 0;
        
        int[] dp = new int[n+1];
        dp[1] = 1;
        // 1이 들어왔을 경우 발생되는 오류를 처리
        // n=1이고, n+1=2이므로 dp[2]에서 오류가 발생한다.
        if (n == 1) return 1;
        dp[2] = 2;
        
        for (int i = 3; i <= n; i++) {
            // 범위를 벗어날 경우를 대비하여 % 1234567 계산 후 저장
            dp[i] = (dp[i-2] + dp[i-1]) % 1234567;
        }
        
        answer = dp[n];
        return answer;
    }
}