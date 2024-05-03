class Solution {
    public String solution(String number, int k) {
        int idx = 0;
        StringBuilder sb = new StringBuilder();
        // 전체 길이에서 k길이를 뺀 문자열에서 큰 수 찾기
        for (int i = 0; i < number.length() - k; i++) {
            int max = 0;
            for (int j = idx; j <= k + i; j++) {
                if (max < number.charAt(j) - '0') {
                    max = number.charAt(j) - '0';
                    idx = j+1;
                }
            }
            sb.append(Character.toString(max+'0'));
        }
        
        return sb.toString();
    }
}