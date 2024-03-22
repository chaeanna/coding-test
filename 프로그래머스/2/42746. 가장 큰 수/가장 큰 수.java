import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        int len = numbers.length;
        String[] str = new String[len];
        for (int i = 0; i < len; i++) {
            str[i] = String.valueOf(numbers[i]);
        }
        
        Arrays.sort(str, (v2, v1) -> (v1+v2).compareTo(v2+v1));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            sb.append(str[i]);
        }
        
        // 제일 큰 수가 0일 경우
        if (str[0].equals("0")) {
            return "0";
        }
        return sb.toString();
    }
}