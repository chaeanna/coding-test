import java.util.*;

class Solution {
    public int solution(int N, int number) {
        int answer = -1;
        if (N == number) {
            return 1;
        }
        List<Set<Integer>> dp = new ArrayList<>();
        for (int i = 0; i <= 8; i++) {
            dp.add(new HashSet<Integer>());
        }
        
        dp.get(1).add(N);
        
        for (int i = 2; i <= 8; i++) {
            StringBuilder sb = new StringBuilder().append(N);
            // 숫자 이어붙이기
            for (int j = 1; j < i; j++) {
                sb.append(N);
            }
            
            dp.get(i).add(Integer.parseInt(sb.toString()));
            
            // 사칙연산 계산
            for (int j = 1; j < i; j++) {
                int k = i-j;
                for (Integer a : dp.get(j)) {
                    for (Integer b : dp.get(k)) {
                        dp.get(i).add(a-b);
                        dp.get(i).add(a+b);
                        dp.get(i).add(a*b);
                        // 0 나누기 방지
                        if (b != 0) {
                            dp.get(i).add(a/b);
                        }
                    }
                }
            }
            
            if (dp.get(i).contains(number)) {
                return i;
            }
        }
        
        return answer;
    }
}