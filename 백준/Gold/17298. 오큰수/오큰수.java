import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] input = new int[n];
        for (int i = 0; i < n; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer> stack = new Stack<>();
        for (int j = 0; j < n; j++) {
            while (!stack.empty() && input[stack.peek()] < input[j]) {
                input[stack.pop()] = input[j];
            }
            stack.push(j);
        }

        while (!stack.empty()) {
            input[stack.pop()] = -1;
        }

        StringBuilder sb = new StringBuilder();
        for (int r : input) {
            sb.append(r).append(" ");
        }

        System.out.println(sb);
    }
}
