class Solution {
    static int[] fibo = new int[100001];
    public int solution(int n) {
        fibonacci(n);
        return fibo[n];
    }
    
    public static void fibonacci(int n) {
        fibo[0] = 0;
        fibo[1] = fibo[2] = 1;
        for (int i = 3; i < 100001; i++) {
            fibo[i] = (fibo[i-2] + fibo[i-1]) % 1234567;
        }
        
    }
}