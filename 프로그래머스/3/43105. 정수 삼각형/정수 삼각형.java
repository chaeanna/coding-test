class Solution {
    public int solution(int[][] triangle) {
        int[][] dp = new int[triangle.length][triangle.length];
        dp[0][0] = triangle[0][0];
        for (int i = 1; i < triangle.length; i++) {
            // 왼쪽
            dp[i][0] = dp[i-1][0] + triangle[i][0];
            
            // 나머지
            for (int k = 1; k <= i; k++) {
                dp[i][k] = Math.max(dp[i-1][k-1], dp[i-1][k]) + triangle[i][k];
            }
            
            // 오른쪽
            dp[i][i] = dp[i-1][i-1] + triangle[i][i];
        }
        
        int answer = 0;
        for (int i = 0; i < triangle.length; i++) {
            answer = Math.max(dp[triangle.length - 1][i], answer);
        }
        
        return answer;
    }
}