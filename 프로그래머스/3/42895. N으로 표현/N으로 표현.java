import java.util.*;

class Solution {
    public int solution(int N, int number) {
        int answer = -1;
        if (N == number) {
            return 1;
        }
        // 결과값 저장
        List<Set<Integer>> dp = new LinkedList<>();
        
        // 최솟값 8까지, 저장할 공간 만들기
        for (int i = 0; i <= 8; i++) {
            dp.add(new HashSet<>()); // 중복값 제거
        }
        
        dp.get(1).add(N); // 첫번째는 N 하나
        
        for (int i = 2; i <= 8; i++) {
            
            // 숫자 붙이기 (사칙연산 외에 ex. 5, 55, 555)
            StringBuilder sb = new StringBuilder().append(N);
            for (int j = 1; j < i; j++) {
                sb.append(N);
            }
            
            dp.get(i).add(Integer.parseInt(sb.toString()));
            
            
            // 사칙연산 값 저장하기
            for (int j = 1; j < i; j++) {
                int k = i-j; // 괄호 계산과 모든 경우의 수 계산
                
                for (int num1 : dp.get(j)) {
                    for (int num2 : dp.get(k)) {
                        dp.get(i).add(num1 - num2);
                        dp.get(i).add(num1 + num2);
                        dp.get(i).add(num1 * num2);
                        if (num2 != 0) {
                            dp.get(i).add(num1 / num2);
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