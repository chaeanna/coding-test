class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int[][] dp = new int[triangle.length][triangle.length];
        dp[0][0] = triangle[0][0];
        
        DP(triangle, dp);
        for (int i = 0; i < dp.length; i++) {
            answer = Math.max(answer, dp[dp.length-1][i]);
        }
        return answer;
    }
    
    public static void DP(int[][] t, int[][] dp) {
        for (int i = 1; i < t.length; i++) {
            // 왼쪽
            dp[i][0] = dp[i-1][0] + t[i][0];
            
            // 가운데
            for (int j = 1; j < i; j++) {
                dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + t[i][j];
            }
            
            // 오른쪽
            dp[i][i] = dp[i-1][i-1] + t[i][i];
        }
    }
}