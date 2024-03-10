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
            int left = 0;
            int right = n-1;
            int[] order = new int[n+1];

            for (int j = 0; j < n; j++) {
                if (j % 2 != 0) {
                    order[left] = list.get(j);
                    left++;
                } else {
                    order[right] = list.get(j);
                    right--;
                }
            }
            // 원형
            order[n] = list.get(0);

            int answer = Integer.MIN_VALUE;
            for (int j = 0; j < n; j++) {
                answer = Math.max(answer, Math.abs(order[j] - order[j+1]));
            }

            sb.append(answer).append("\n");
        }

        System.out.println(sb);

    }

}