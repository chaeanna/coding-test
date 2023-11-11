class Solution {
    public long solution(int a, int b) {
        long answer = 0;
        if (a == b) return a;
        int max = Math.max(a, b);
        int min = Math.min(a, b);
        for (int i = min; i <= max; i++) {
            answer += (long) i;
        }
        return answer;
    }
}