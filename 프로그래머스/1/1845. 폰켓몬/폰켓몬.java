import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        //폰켓몬의 종류
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }
        int result = nums.length / 2;
        answer = result >= map.size() ? map.size() : result;
        return answer;
    }
}