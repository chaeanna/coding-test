class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        
        for (int i = 0; i < n; i++) {
            // OR 연산으로 둘 중 하나가 1이면 1
            answer[i] = Integer.toBinaryString(arr1[i] | arr2[i]);
            // 0은 " "으로 변환
            answer[i] = answer[i].replaceAll("0", " ");
            // 1은 "#"으로 변환
            answer[i] = answer[i].replaceAll("1", "#");
            
            // 자릿수가 n일 때까지 문자열 앞에 공백 더하기
            while (true) {
                if (answer[i].length() >= n) break;
                answer[i] = ' ' + answer[i];
            }
        }
        return answer;
    }
}