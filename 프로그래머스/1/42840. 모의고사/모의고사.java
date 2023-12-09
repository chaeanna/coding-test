import java.util.*;

class Solution {
    public List<Integer> solution(int[] answers) {
        int[][] supo = new int[3][10];
        supo[0] = new int[]{1, 2, 3, 4, 5};
        supo[1] = new int[]{2, 1, 2, 3, 2, 4, 2, 5};
        supo[2] = new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int[] count = new int[3];

        for (int i = 0; i < answers.length; i++) {
            // 1번 수포자
            int idx1 = i % 5;
            if (answers[i] == supo[0][idx1]) {
                count[0]++;
            }
            // 2번 수포자
            int idx2 = i % 8;
            if (answers[i] == supo[1][idx2]) {
                count[1]++;
            }
            // 3번 수포자
            int idx3 = i % 10;
            if (answers[i] == supo[2][idx3]) {
                count[2]++;
            }
        }

        // 정답을 저장할 리스트
        List<Integer> resultList = new ArrayList<>();

        // 최대 정답 개수 계산
        int maxCount = Math.max(count[0], Math.max(count[1], count[2]));

        // 최대 정답 개수에 해당하는 수포자들을 리스트에 추가
        for (int i = 0; i < count.length; i++) {
            if (count[i] == maxCount) {
                resultList.add(i + 1);
            }
        }

        return resultList;
    }
}
