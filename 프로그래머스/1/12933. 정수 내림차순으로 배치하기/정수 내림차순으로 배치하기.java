import java.util.*;
class Solution {
    public long solution(long n) {
        long answer = 0;
        String str = String.valueOf(n);
        Integer[] num = new Integer[str.length()];
        for (int i = 0; i < str.length(); i++) {
            num[i] = str.charAt(i) - '0';
        }
        Arrays.sort(num, Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();
        long[] result = new long[str.length()];
        for (int i = 0; i < str.length(); i++) {
            result[i] = (long) num[i];
            sb.append(result[i]);
        }
        
        answer = Long.valueOf(sb.toString());
        return answer;
    }
}