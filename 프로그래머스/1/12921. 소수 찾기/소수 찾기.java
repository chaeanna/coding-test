
class Solution {
    static boolean[] prime;
    public int solution(int n) {
        int answer = 0;
        prime = new boolean[n+1];
        isPrime(n);
        for (int i = 1; i <= n; i++) {
            if(!prime[i]) {
                answer++;
            }
        }
        return answer;
    }
    public void isPrime(int n) {
        prime[0] = prime[1] = true;
        for(int i = 2; i <= n; i++) {
            if(prime[i]) continue;
            for(int k = i + i; k <= n; k += i) {
                prime[k] = true;
            }
        }
    }
}