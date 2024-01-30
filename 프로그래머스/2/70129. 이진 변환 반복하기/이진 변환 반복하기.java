class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        int length = s.length();
        
        while (!s.equals("1")) {
            int cnt = countNum(s);
            answer[1] += cnt;
            s = Integer.toBinaryString(length-cnt);
            length = s.length();
            answer[0]++;
        }

        return answer;
    }
    
    public static int countNum(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                count++;
            }
        }
        return count;
    }
}