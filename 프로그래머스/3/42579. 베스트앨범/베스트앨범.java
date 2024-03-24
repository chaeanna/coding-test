import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        HashMap<Integer, Integer> playsMap = new HashMap<>();
        HashMap<String, Integer> genresMap = new HashMap<>();
        // 장르별 노래
        for (int i = 0; i < genres.length; i++) {
            // key : 고유번호, value : 재생횟수
            playsMap.put(i, plays[i]);
            // key : 장르, value : 재생횟수 합계
            genresMap.put(genres[i], genresMap.getOrDefault(genres[i], 0) + plays[i]);
        }
        
        List<Map.Entry<String, Integer>> genreRank = new LinkedList<>(genresMap.entrySet());
        List<Map.Entry<Integer, Integer>> playRank = new LinkedList<>(playsMap.entrySet());
        // 재생횟수 합계가 제일 높은 순으로 장르 정렬
        genreRank.sort((o2, o1) -> genresMap.get(o1.getKey()) - genresMap.get(o2.getKey()));
        // 재생횟수가 제일 높은 순으로 노래 정렬
        playRank.sort((o2, o1) -> playsMap.get(o1.getKey()) - playsMap.get(o2.getKey()));
        
        /*
            1. 재생횟수가 많은 장르 찾기
            2. 장르에서 최대 2개씩 수록
            3. 다음으로 많은 장르에서 최대 2개씩 수록
        */
        List<Integer> list = new ArrayList<>();
        for (Map.Entry<String,Integer> entry : genreRank) {
            String genre = entry.getKey();
            int count = 0;
            for (Map.Entry<Integer, Integer> play : playRank) {
                if (genre.equals(genres[play.getKey()])) {
                    count++;
                    list.add(play.getKey());
                }
                if(count == 2) {
                    break;
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