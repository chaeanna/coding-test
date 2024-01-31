class Solution {
    public int solution(String s) {
        int answer = 0;
        for (int i = 0; i < s.length(); i++) {
            int count = 0;
            if (i == 0) {
                count = checkString(s);
            } else {
                String str = s.substring(i) + s.substring(0, i);
                count = checkString(str);
            }
            
            if (count == 0) answer++;
        }
        return answer;
    }
    
    public static int checkString(String s) {
        while (s.contains("()") || s.contains("{}") || s.contains("[]")) {
            s = s.replaceAll("\\(\\)", "");
            s = s.replaceAll("\\{\\}", "");
            s = s.replaceAll("\\[\\]", "");
        }
        return s.length();
    }
}