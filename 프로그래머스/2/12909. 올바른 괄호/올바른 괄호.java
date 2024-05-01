import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true; // 올바른 괄호 true
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < s.length(); i++) {
            //첫번째 괄호가 ')' -> false
            if (s.charAt(0) == ')') {
                return false;
            }
            
            char c = s.charAt(i);
            // '(' 스택에 넣기
            if (c == '(') {
                stack.push(c);
            } else {
                // ')'이면 스택 pop()
                if (!stack.isEmpty()) {
                    stack.pop();
                } else {
                    return false;
                }
                
            }
        }
        
        if (!stack.isEmpty()) {
            return false;
        }

        return answer;
    }
}