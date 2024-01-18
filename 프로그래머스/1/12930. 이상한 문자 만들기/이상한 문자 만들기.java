import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        String[] str = s.toLowerCase().split("");
        int count = 0;
        for (int i = 0; i < str.length; i++) {
            if (!str[i].equals(" ")) {
                count++;
                if (count % 2 != 0) {
                    str[i] = str[i].toUpperCase();
                }
            } else {
                count = 0;
            }
        }
        
        for (String n : str) {
            answer += n;
        }
        return answer;
    }
}