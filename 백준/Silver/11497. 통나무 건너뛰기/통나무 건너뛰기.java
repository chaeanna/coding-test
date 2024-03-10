import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringTokenizer st;
        List<Integer> list;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine(), " ");
            list = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                list.add(Integer.parseInt(st.nextToken()));
            }
            Collections.sort(list, Collections.reverseOrder());
            List<Integer> left = new ArrayList<>();
            List<Integer> right = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if (j % 2 != 0) {
                    if (j == 0) {
                        right.add(list.get(j));
                    }
                    left.add(list.get(j));
                } else {
                    right.add(list.get(j));
                }
            }
            right.add(left.get(left.size()-1));

            int answer = Integer.MIN_VALUE;
            for (int j = 0; j < left.size() - 1; j++) {
                int level = left.get(j) - left.get(j+1);
                if (answer < level) {
                    answer = level;
                }
            }
            for (int j = 0; j < right.size() - 1; j++) {
                int level = right.get(j) - right.get(j+1);
                if (answer < level) {
                    answer = level;
                }
            }

            sb.append(answer).append("\n");
        }

        System.out.println(sb);

    }

}