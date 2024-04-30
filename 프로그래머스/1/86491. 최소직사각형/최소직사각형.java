import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int maxW = Integer.MIN_VALUE;
        int maxH = Integer.MIN_VALUE;

        for (int i = 0; i < sizes.length; i++) {
            int w = sizes[i][0];
            int h = sizes[i][1];
            
            if (w >= h) {
                maxW = Math.max(w, maxW);
                maxH = Math.max(h, maxH);
            } else {
                maxW = Math.max(h, maxW);
                maxH = Math.max(w, maxH);
            }
            
        }
        int answer = maxW * maxH;
        return answer;
    }
}