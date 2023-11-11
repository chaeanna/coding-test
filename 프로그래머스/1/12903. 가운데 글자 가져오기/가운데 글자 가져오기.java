class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        char[] str = s.toCharArray();
        if (str.length % 2 == 0) {
            int n = str.length / 2;
            answer.append(String.valueOf(str[n-1])).append(String.valueOf(str[n]));
        } else {
            int n = str.length / 2;
            answer.append(String.valueOf(str[n]));
        }
        return answer.toString();
    }
}