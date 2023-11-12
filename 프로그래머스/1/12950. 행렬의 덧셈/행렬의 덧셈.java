class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr1[0].length];
        for (int i = 0; i < arr1.length; i++) {
            for (int l = 0; l < arr1[i].length; l++) {
                answer[i][l] = arr1[i][l] + arr2[i][l];
            }
        }
        return answer;
    }
}