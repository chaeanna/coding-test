class Solution {
    public int solution(String dartResult) {
        int[] answer = new int[3];
        char[] input = dartResult.toCharArray();
        int idx = 0;
        
        for (int i = 0; i < input.length; i++) {
            if (input[i] >= '0' && input[i] <= '9') {
                double n = Double.valueOf(input[i]-'0');
                if (input[i+1] == '0') {
                    n = 10;
                    i++;
                }
                char s = input[i+1];
                if(s == 'S') {
                    answer[idx] = (int) n;
                } else if (s == 'D') {
                    answer[idx] = (int) Math.pow(n, 2);
                } else if (s == 'T') {
                    answer[idx] = (int) Math.pow(n, 3);
                }
                idx++;
            } else if (input[i] == '*' || input[i] == '#') {
                char s2 = input[i];
                if (s2 == '*') {
                    if (idx == 1) {
                        answer[0] *= 2;
                    } else {
                        answer[idx-2] *= 2;
                        answer[idx-1] *= 2;
                    }
                } else if (s2 == '#') {
                    answer[idx-1] *= -1;
                }
            }
        }
        return answer[0] + answer[1] + answer[2];
    }
}