class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int total = brown + yellow;
        
        for (int i = 1; i <= Math.sqrt(yellow); i++) {
            if (yellow % i == 0 && i < brown) {
                int quotient = yellow / i;
                int multi = (i+2) * (quotient+2);
                if (multi == total && quotient < brown) {
                    answer[0] = quotient+2;
                    answer[1] = i+2;
                    break;
                }
            }
        }
        return answer;
    }
}