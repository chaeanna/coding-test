class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        
        for (int i = 0; i < targets.length; i++) {
            // 비교를 위해 타깃 문자열의 문자 담기
            String[] str = targets[i].split("");
            // 타깃 문자의 문자 하나씩 비교
            for (int j = 0; j < str.length; j++) {
                // 인덱스 비교
                int min = 101;
                // 키맵 문자열 하나씩 비교
                for (int k = 0; k < keymap.length; k++) {
                    // 키맵 문자열 포함 여부
                    if (keymap[k].contains(str[j])) {
                        // 키맵 문자열의 문자 비교
                        for (int t = 0; t < keymap[k].length(); t++) {
                            if (str[j].equals(String.valueOf(keymap[k].charAt(t)))) {
                                // 가장 작은 인덱스 찾기
                                min = Math.min(min, t+1);
                                break;
                            }
                        }
                    }
                }
                if (min == 101) {
                    answer[i] = -1;
                    break;
                } else {
                    answer[i] += min;
                }
            }
            
        }
        return answer;
    }
}