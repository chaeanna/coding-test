class Solution {
    public int solution(int num) {
        int answer = 0;
        long n = (long) num;
        while(n != 1) {
            if (n % 2 == 0) {
                n /= 2;
            } else {
                n *= 3;
                n++;
            }
            answer++;
            if (answer >= 500) return -1;
        }
        return answer;
    }
}