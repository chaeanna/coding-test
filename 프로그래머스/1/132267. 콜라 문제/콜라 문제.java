class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        int remain = 0;
        
        while (n >= a) {
            // 나머지 빈 콜라병
            remain = n % a;
            // 현 빈병 수에서 받을 수 있는 콜라 수
            n = ((n - remain) / a) * b;
            // 받을 수 있는 콜라 합계
            answer += n;
            // 새로운 빈 병
            n += remain;
        }
        return answer;
    }
}