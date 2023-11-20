class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        for (int i = 0; i < n; i++) {
            String str1 = String.format("%0"+n+"d", Long.parseLong(Integer.toBinaryString(arr1[i])));
            String str2 = String.format("%0"+n+"d", Long.parseLong(Integer.toBinaryString(arr2[i])));
            String result = "";
            for (int j = 0; j < n; j++) {
                if (str1.charAt(j) == '0' && str2.charAt(j) == '0') {
                    result += " ";
                } else {
                    result += "#";
                }
            }
            answer[i] = result;
        }
        return answer;
    }
}