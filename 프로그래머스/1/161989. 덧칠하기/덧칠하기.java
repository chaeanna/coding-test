class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        int max = section[section.length - 1];
        int idx = 0;
        for (int i = 0; i < section.length; i++) {
            if(idx < max) {
                if (idx >= section[i]) {
                    if ((section[i] + m) - 1 < max) continue;
                }
                idx = (section[i] + m) - 1;
                answer++;    
            } else if(idx >= max) {
                break;
            }
        }
        return answer;
    }
}