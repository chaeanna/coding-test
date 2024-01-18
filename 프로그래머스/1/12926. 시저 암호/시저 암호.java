class Solution {
    public String solution(String s, int n) {
        // char로 분리
        char[] ch = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < ch.length; i++) {
            char c = ch[i];
            // n만큼 민 인덱스 번호
            int idx = c + n;
            
            if ('A' <= c && 'Z' >= c) {
                // 민 인덱스 번호가 'Z'보다 클 경우 -26
                if (idx > 'Z') {
                    idx -= 26;
                }
                
            } else if ('a' <= c && 'z' >= c) {
                // 민 인덱스 번호가 'z'보다 클 경우 -26
                if (idx > 'z') {
                    idx -= 26;
                }
            } else {
                // 공백일 경우
                sb.append(" ");
                continue;
            }
            // 문자 저장
            sb.append(String.valueOf((char) idx));
            
        }
        return sb.toString();
    }
}