class Solution {
    public static int[] fibo;
    public int solution(int n) {
        int answer = 0;
        fibo = new int[n+1];
        fibo[0] = 0;
        fibo[1] = 1;
        fibonacci(n);
        answer = fibo[n] % 1234567;
        return answer;
    }
    public void fibonacci(int n) {
        for (int i = 2; i <= n; i++) {
            fibo[i] = fibo[i-1] % 1234567 + fibo[i-2] % 1234567;
        }
    }
}