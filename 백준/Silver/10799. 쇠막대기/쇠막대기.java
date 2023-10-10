import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        Stack<Character> stack = new Stack<>();
        int count = 0;

        for (int i = 0; i < str.length(); i++) {
            char ps = str.charAt(i);

            if (ps == '(') {
                stack.push(ps);
            } else if (str.charAt(i-1) == '(') {
                stack.pop();
                count += stack.size();
            } else if (str.charAt(i-1) == ')') {
                stack.pop();
                count++;
            }
        }

        System.out.println(count);
    }
}
