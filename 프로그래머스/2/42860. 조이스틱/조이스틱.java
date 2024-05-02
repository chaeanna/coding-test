class Solution {
    public int solution(String name) {
        int answer = 0;
        int len = name.length();
        int move = len - 1; // 계속 오른쪽으로만 이동했을 경우
        for (int i = 0; i < len; i++) {
            char c = name.charAt(i);
            answer += Math.min(c - 'A', 26 - (c-'A'));
            
            // 커서 이동 결정
            if (i < len-1 && name.charAt(i+1) == 'A') {
                int end = i+1;
                while (end < len && name.charAt(end) == 'A') {
                    end++;
                }
                // end는 A가 아닐때 멈춘 상태의 idx
                // 0에서 현위치까지 왔다가 다시 0으로 돌아간 후, 왼쪽으로 더 움직여 end까지 이동
                move = Math.min(move, (i * 2) + (len - end));
                // 0에서 왼쪽으로 움직였다 다시 0으로 온 후, 오른쪽으로 움직인 경우
                move = Math.min(move, (len-end) * 2 + i);
            }
            
        }
        return answer+move;
    }
}