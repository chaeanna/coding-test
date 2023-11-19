import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;

        List<Integer> maxlist = new ArrayList<>();
        List<Integer> minlist = new ArrayList<>();
        for (int i = 0; i < sizes.length; i++) {
            maxlist.add(Math.max(sizes[i][0], sizes[i][1]));
            minlist.add(Math.min(sizes[i][0], sizes[i][1]));
        }
        answer = Collections.max(maxlist) * Collections.max(minlist);
        return answer;
    }
}