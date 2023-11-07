class Solution {
    boolean solution(String s) {
        boolean answer = true;
        int pcount = 0;
        int ycount = 0;
        
        s = s.toLowerCase();
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'p') pcount++;
            if (c == 'y') ycount++;
        }
        
        if (pcount != ycount) answer = false;

        return answer;
    }
}