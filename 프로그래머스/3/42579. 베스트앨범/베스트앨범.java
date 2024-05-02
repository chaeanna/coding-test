import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        // 노래별 장르
        HashMap<Integer, String> mapG = new HashMap<>();
        // 장르별 재생횟수
        HashMap<String, Integer> mapP = new HashMap<>();
        // 노래별 재생횟수
        HashMap<Integer, Integer> mapC = new HashMap<>();
        
        for (int i = 0; i < genres.length; i++) {
            String g = genres[i];
            int count = plays[i];
            mapG.put(i, g);
            mapP.put(g, mapP.getOrDefault(g, 0) + count);
            mapC.put(i, count);
        }
        
        // 장르별 재생횟수 많은 순으로 정렬 리스트
        List<String> gen = new ArrayList<>(mapP.keySet());
        Collections.sort(gen, (o2, o1) -> mapP.get(o1) - mapP.get(o2));
        // 고유번호별 재생횟수 많은순으로 정렬 리스트
        List<Integer> cnt = new ArrayList<>(mapC.keySet());
        Collections.sort(cnt, (o2, o1) -> mapC.get(o1) - mapC.get(o2));
        // 수록될 고유번호 리스트
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < gen.size(); i++) {
            String g = gen.get(i);
            int count = 0;
            for (int j = 0; j < cnt.size(); j++) {
                int idx = cnt.get(j);
                if (count == 2) break;
                if (mapG.get(idx).equals(g)) {
                    count++;
                    list.add(idx);
                }
            }
        }
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}