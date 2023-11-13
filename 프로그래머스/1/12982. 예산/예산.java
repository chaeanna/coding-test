import java.util.*;

class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        int sum = 0;
        for (int i = 0; i < d.length; i++) {
            sum += d[i];
        }
        if (sum <= budget) return d.length;
        Arrays.sort(d);
        sum = 0;
        for (int i = 0; i < d.length; i++) {
            sum += d[i];
            if (sum <= budget) {
                if ((sum + d[i+1]) > budget) {
                    i++;
                    answer = i;
                    break;
                }
            }
        }
        return answer;
    }
}