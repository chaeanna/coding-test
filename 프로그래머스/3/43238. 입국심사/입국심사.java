import java.util.*;

/*
    범위가 크기때문에 완전탐색보단 이분탐색으로 가는 것이 효율적이다.
*/
class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        // 시간을 오름차순으로 정렬한다.
        Arrays.sort(times);
        
        // 0~가장 오래 걸리는 시간
        long le = 0;
        long re = (long)times[times.length -1] * n;
        while (le <= re) {
            long mid = le + ((re - le)/2);
            // 중간값의 시간안에 몇명의 사람이 심사를 받을 수 있는지 계산
            long time = 0;
            for (int i = 0; i < times.length; i++) {
                time += ((long)mid / times[i]);
            }
            if (time < n) {
                // 모든 사람이 심사받을 수 없다면
                le = mid+1;
            } else if (time >= n) {
                // 모든 사람이 심사를 받을 수 있는 충분한 시간일 경우
                answer = mid;
                re = mid-1; // 최솟값을 찾기 위해 범위를 줄인다.
            }
        }
        
        return answer;
    }
}