class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        answer[0] = gcd(Math.max(n, m), Math.min(n, m));
        answer[1] = answer[0] * (n / answer[0]) * (m / answer[0]);
        return answer;
    }
    public int gcd(int a, int b) {
        int r = 0;
        while (b != 0) {
            r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
}