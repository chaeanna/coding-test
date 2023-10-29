class Solution {
    public int solution(int n) {
        int result = 0;
        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                result += i;
                if ((n/i) != i) result += (n/i);
            }
        }
        return result;
        
    }
}