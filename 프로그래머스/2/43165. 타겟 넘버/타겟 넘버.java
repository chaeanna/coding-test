class Solution {
    static int answer = 0;
    public int solution(int[] numbers, int target) {
        DFS(numbers, target, 0, 0);
        return answer;
    }
    public static void DFS(int[] numbers, int target, int start, int result) {
        if (start > numbers.length-1) {
            if (target == result) {
                answer++;
            }
            return;
        }
        DFS(numbers, target, start+1, result+numbers[start]);
        DFS(numbers, target, start+1, result+(-1*numbers[start]));
        
    }
}