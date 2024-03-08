import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            int a = Integer.parseInt(st.nextToken());
            list.add(a);
        }

        Set<Integer> set = new HashSet<>();
        int count = 0;
        for (int i = 0; i < k; i++) {
            int num = list.get(i);
            //중복 체크
            if (set.contains(num)) {
                continue;
            }
            //꽂을 때
            if (set.size() < n) {
                set.add(num);
                continue;
            }

            //빼고 꽂을 때
            //가장 나중에 사용되거나 사용되지 않는 플러그를 빼야함.
            int max = -1;
            int idx = -1;
            for (Integer s : set) {
                int target = 0;
                List<Integer> sub = list.subList(i+1, k);
                //꽂혀있는 플러그가 있을 때
                if (sub.contains(s)) {
                    target = sub.indexOf(s) + 1;
                } else {
                    //꽂혀있지 않을 때
                    //현재 시점에서 남은 전기용품의 개수 = 현재 시점 이후에 사용되지 않을 플러그의 개수
                    target = k-i-1;
                }

                if (target > max) {
                    max = target;
                    idx = s;
                }
            }

            set.remove(idx);
            set.add(num);
            count++;
        }

        System.out.println(count);

    }
}