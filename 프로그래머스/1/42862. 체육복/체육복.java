class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int[] check = new int[n+1];
        // 잃어버린 학생
        for (int l = 0; l < lost.length; l++) {
            check[lost[l]]--;
        }
        // 여분이 있는 학생
        for (int r = 0; r < reserve.length; r++) {
            check[reserve[r]]++;
        }
        
        boolean[] lend = new boolean[n+1];
        for (int i = 1; i <= n; i++) {
            if (check[i] < 0) {
                if (check[i-1] > 0 && !lend[i-1]) {
                    lend[i-1] = true;
                    check[i]++;
                } else if (i+1 <= n && check[i+1] > 0 && !lend[i+1]) {
                    lend[i+1] = true;
                    check[i]++;
                }
            }
        }
        
        for (int i = 1; i <= n; i++) {
            if (check[i] >= 0) {
                answer++;
            }
        }
        
        
        return answer;
    }
}