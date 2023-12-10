class Solution {
    static int[] divisor;
    public int solution(int number, int limit, int power) {
        int answer = 0;
        divisor = new int[number];
        divisors(number);
        for(int i = 0; i < divisor.length; i++) {
            if (divisor[i] <= limit) {
                answer += divisor[i];
            }
            else {
                answer += power;
            }
        }
        return answer;
    }
    public void divisors(int n) {
        for (int i = 1; i <= n; i++) {
            int count = 0;
            for (int j = 1; j <= Math.sqrt(i); j++){
                if(i % j == 0){
                    if (i / j == j) {
                        count++;
                    } else {
                        count += 2;
                    }
                }
            }
            divisor[i-1] = count;
        }
    }
}