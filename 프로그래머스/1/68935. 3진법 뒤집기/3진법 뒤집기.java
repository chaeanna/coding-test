class Solution {
    public int solution(int n) {
        StringBuilder sb = new StringBuilder();
        String str = Integer.toString(n, 3);
        sb.append(str);
        sb.reverse();
        int answer = Integer.parseInt(sb.toString(), 3);
        return answer;
    }
}