import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Stack;

public class Main {
    static Stack<Integer> stack = new Stack<>();
    static int result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int k = Integer.parseInt(br.readLine());
        for (int i = 0; i < k; i++) {
            int n = Integer.parseInt(br.readLine());
            if (n != 0) stack.push(n);
            else stack.pop();
        }
        while (!stack.empty()) {
            result += stack.pop();
        }
        System.out.println(result);
    }
}
