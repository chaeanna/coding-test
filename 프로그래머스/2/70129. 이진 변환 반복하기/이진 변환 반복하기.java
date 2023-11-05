class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        while (!s.equals("1")) {
            int length = s.length();
            // 0 제거
            s = s.replaceAll("0", "");
            answer[1] += length - s.length();
            // 길이를 이진 변환
            s = Integer.toBinaryString(s.length());
            answer[0]++;
        }
        return answer;
    }
}