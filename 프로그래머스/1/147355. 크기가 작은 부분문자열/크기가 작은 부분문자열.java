import java.util.*;
class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        int len = p.length();
        Long pnum = Long.parseLong(p);
        for (int i = 0; i <= t.length() - len; i++) {
            Long result = Long.parseLong(t.substring(i,i+len));
            if (result <= pnum) {
                answer++;
            }
        }
        return answer;
    }
}