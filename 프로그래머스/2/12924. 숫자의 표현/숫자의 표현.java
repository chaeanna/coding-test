class Solution {
    public int solution(int n) {
        int count = 0;
        for (int i = 1; i <= Math.floor(n / 2); i++) {
            int sum = 0;
            for (int k = i; k <= Math.floor(n/2)+1; k++) {
                sum += k;
                if (sum > n) break;
                
                if (sum == n) {
                    count++;
                    break;
                }
            }
        }
        
        return count+1;
    }
}