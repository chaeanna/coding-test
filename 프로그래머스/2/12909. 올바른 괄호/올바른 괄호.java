class Solution {
    boolean solution(String s) {
        boolean answer = false;
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            if (count < 0) return answer;
            if (s.charAt(i) == '(') count++;
            else if (s.charAt(i) == ')') count--;
        }

        if (count == 0) answer = true;
        return answer;
    }
}