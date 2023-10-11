class Solution {
    public int solution(String s) {
        int answer = s.length();
        for (int i = 1; i <= (s.length() / 2); i++) {
            String result = ""; // 압축된 문자열
            String before = s.substring(0, i); // 이전 문자열
            int count = 1; // 반복 횟수
            
            for (int j = i; j < s.length(); j += i) {
                // 현재 문자열의 길이가 남은 부분보다 길면 길이를 조정
                int length = Math.min(i, s.length() - j);
                String str = s.substring(j, j + length);
                
                // 현재 문자열과 이전 문자열이 같으면 count 증가
                if (before.equals(str)) {
                    count++;
                }
                // 다르면 압축 문자열에 추가
                else {
                    if (count > 1) {
                        result += count + before;
                    } else {
                        result += before;
                    }
                    before = str;
                    count = 1;
                }
            }
            
            // 마지막 문자열 처리
            if (count > 1) {
                result += count + before;
            } else {
                result += before;
            }
            
            answer = Math.min(answer, result.length());
        }
        
        return answer;
    }
}