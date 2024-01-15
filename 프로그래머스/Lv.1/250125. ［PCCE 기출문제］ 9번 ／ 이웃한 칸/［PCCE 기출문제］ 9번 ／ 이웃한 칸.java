class Solution {
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        int[] y = {0, 0, 1, -1};
        int[] x = {-1, 1, 0, 0};
        
        String str = board[h][w];
        
        for (int i = 0; i < 4; i++) {
            int checkh = h + y[i];
            int checkw = w + x[i];
            if (checkh < 0 || checkw < 0 || checkh >= board[0].length || checkw >= board[0].length) continue;
            if (str.equals(board[checkh][checkw])) {
                answer++;
            }
        }
        return answer;
    }
}