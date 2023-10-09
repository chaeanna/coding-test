import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> leftStack = new Stack<>();
        Stack<Character> rightStack = new Stack<>();

        String n = br.readLine();
        int num = n.length();
        int m = Integer.parseInt(br.readLine());

        for (int i = 0; i < num; i++) {
            leftStack.push(n.charAt(i));
        }
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            char c = st.nextToken().charAt(0);
            switch(c) {
                case 'L':
                    if (!leftStack.isEmpty()) rightStack.push(leftStack.pop());
                    break;
                case 'B':
                    if (!leftStack.isEmpty()) leftStack.pop();
                    break;
                case 'D':
                    if (!rightStack.isEmpty()) leftStack.push(rightStack.pop());
                    break;
                case 'P':
                    char newChar = st.nextToken().charAt(0);
                    leftStack.push(newChar);
                    break;
            }
        }

        while (!leftStack.isEmpty()) {
            rightStack.push(leftStack.pop());
        }
        StringBuilder sb = new StringBuilder();
        while (!rightStack.isEmpty()) {
            sb.append(rightStack.pop());
        }
        System.out.println(sb);

    }
}
