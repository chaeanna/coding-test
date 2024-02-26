import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        List<String> list = new ArrayList<>();
        
        for (int i = 0; i < cities.length; i++) {
            String str = cities[i].toLowerCase();
            if (list.contains(str)) {
                //cache hit
                for (int j = 0; j < cacheSize; j++) {
                    if (list.get(j).equals(str)) {
                        list.remove(j);
                        list.add(str);
                        break;
                    }
                }
                answer++;
            } else {
                if (cacheSize > 0) {
                    if (list.size() == cacheSize && list.size() > 0) {
                        list.remove(0);
                    }
                    list.add(str);
                }
                
                answer += 5;
            }
            
        }
        return answer;
    }
}