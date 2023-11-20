class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        int[] str = new int[26];
        boolean[] visited = new boolean[26];
        for (int i = 0; i < s.length(); i++) {
            // 처음인경우
            if (str[s.charAt(i) - 97] == 0 && !visited[s.charAt(i) - 97]) {
                answer[i] = -1;
                visited[s.charAt(i) - 97] = true;
            }
            // 반복된 경우
            else if (str[s.charAt(i) - 97] != i) {
                int num = str[s.charAt(i) - 97];
                answer[i] = i - num;
            }
            str[s.charAt(i) - 97] = i;
        }
        
        return answer;
    }
}