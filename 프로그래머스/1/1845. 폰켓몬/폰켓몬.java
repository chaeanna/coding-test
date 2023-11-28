import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int getCnt = nums.length / 2;
        List<Integer> type = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (type.contains(nums[i])) continue;
            type.add(nums[i]);
        }
        // 종류가 가질 수 있는 폰켓몬 마리수보다 같거나 작으면 종류 수 출력
        if (type.size() <= getCnt) {
            return type.size();
        } else {
            return getCnt;
        }
    }
}