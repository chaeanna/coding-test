class Solution {
    public int[] solution(int[] arr) {
        if ((arr.length - 1) == 0) {
            int[] result = {-1};
            return result;
        }
        int idx = 0;
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (min > arr[i]) {
                idx = i;
                min = arr[i];
            }
        }
        int[] answer = new int[arr.length - 1];
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (idx == i) {
                continue;
            }
            answer[count] = arr[i];
            count++;
        }
        return answer;
    }
}