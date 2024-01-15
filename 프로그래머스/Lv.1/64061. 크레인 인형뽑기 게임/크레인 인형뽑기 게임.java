import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        int[][] doll = new int[board.length][board.length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                doll[i][j] = board[j][i];
            }
        }
        
        for (int i = 0; i < moves.length; i++) {
            int num = moves[i]-1;
            for (int j = 0; j < doll.length; j++) {
                int d = doll[num][j];
                if (d != 0) {
                    if (!stack.isEmpty() && stack.peek() == d) {
                        stack.pop();
                        answer += 2;
                    } else {
                        stack.push(d);
                    }
                    doll[num][j] = 0;
                    break;
                }
            }
        }
        
        return answer;
    }
}