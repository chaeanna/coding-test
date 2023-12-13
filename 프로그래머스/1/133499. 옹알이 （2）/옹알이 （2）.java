class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] list = {"aya", "ye", "woo", "ma"};
        for(int i = 0; i < babbling.length; i++) {
            String str = babbling[i];
            if (str.contains("ayaaya") || str.contains("yeye") ||
               str.contains("woowoo") || str.contains("mama")) {
                continue;
            }
            
            for (int j = 0; j < 4; j++) {
                if (str.contains(list[j])) {
                    str = str.replaceAll(list[j], " ");
                }
            }
            while (str.contains(" ")) {
                str = str.replaceAll(" ", "");
            }
            if (str.equals("")) {
                answer++;
            }
        }
        return answer;
    }
}