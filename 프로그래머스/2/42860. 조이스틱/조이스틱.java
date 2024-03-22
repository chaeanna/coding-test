class Solution {
    public int solution(String name) {
        // 상하동작 횟수
        int answer = 0;
        // 좌우동작 횟수
        int move = name.length() - 1; //계속 오른쪽으로 움직였을 경우
        
        for (int i = 0; i < name.length(); i++) {
            answer += Math.min(name.charAt(i) - 'A', 26 - (name.charAt(i) - 'A')); // 위로 조작, 아래조작 = 26 - 위로조작
            if (i < name.length() - 1 && name.charAt(i+1) == 'A') {
                // 연속된 'A' 존재
                int endA = i+1; // A가 끝나는 지점 찾기
                while (endA < name.length() && name.charAt(endA) == 'A') {
                    endA++;
                }
                
                // 오른쪽으로 움직였다가 다시 0으로 온 후, 왼쪽으로 움직인 경우
                move = Math.min(move, i * 2 + name.length() - endA); 
                // 왼쪽으로 움직였다 다시 0으로 온 후, 오른쪽으로 움직인 경우
                move = Math.min(move, i + (name.length() - endA) * 2); 
            }
        }
        
        return answer + move;
    }
}