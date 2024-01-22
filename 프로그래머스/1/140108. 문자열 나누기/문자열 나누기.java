class Solution {
    public int solution(String s) {
        int answer = 0;
        char x = s.charAt(0);
        int count = 0;
        
        for (int i = 0; i < s.length(); i++) {
            
            // 새롭게 시작할 경우 x 글자 선언
            if (count == 0) {
                x = s.charAt(i);
            }
            
            // 같은 글자일 경우 횟수 증가
            if (x == s.charAt(i)) {
                count++;
            } else {
                // 다른 글자일 경우 횟수 감소
                count--;
            }
            
            // 횟수가 같아지는 순가
            if (count == 0) {
                answer++;
            }
        }
        
        // 만일 마지막 글자가 남아있을 경우 횟수 증가
        if (count > 0) {
            answer++;
        }
        return answer;
    }
}