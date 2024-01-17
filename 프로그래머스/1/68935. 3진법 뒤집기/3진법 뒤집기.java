class Solution {
    public int solution(int n) {
        int answer = 0;
        
        // 10진수 -> 3진법
        String n3 = String.valueOf(Integer.toString(n, 3));
        StringBuilder sb = new StringBuilder();
        sb.append(n3);
        
        // 앞뒤 반전 후 10진법으로 표현
        answer = Integer.parseInt(sb.reverse().toString(), 3);
        
        return answer;
    }
}