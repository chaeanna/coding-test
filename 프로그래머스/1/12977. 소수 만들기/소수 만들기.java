import java.util.*;

class Solution {
    static boolean[] prime = new boolean[3001];
    public int solution(int[] nums) {
        int answer = 0;

        isPrime();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                for (int k = j+1; k < nums.length; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    if (!prime[sum]) {
                        answer++;
                    }
                }
            }
        }

        return answer;
    }
    
    public void isPrime() {
        prime[0] = prime[1] = true;
        for (int i = 2; i <= 3000; i++) {
            if (prime[i]) continue;
            for (int k = i + i; k < 3000; k += i) {
                prime[k] = true;
            }
        }
    }
}