import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    static Double[] num;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int k = Integer.parseInt(br.readLine());
        String prefix = br.readLine();
        Stack<Double> stack = new Stack<>();
        num = new Double[k];
        for (int j = 0; j < k; j++) {
            num[j] = Double.parseDouble(br.readLine());
        }
        for (int i = 0; i < prefix.length(); i++) {
            char value = prefix.charAt(i);
            if (value >= 'A' && value <= 'Z') {
                stack.push(num[value - 'A']);
            } else {
                Double second = stack.pop();
                Double first = stack.pop();
                Double result = 0.0;
                switch(value) {
                    case '+':
                        result = first + second;
                        break;
                    case '-':
                        result = first - second;
                        break;
                    case '*':
                        result = first * second;
                        break;
                    case '/':
                        result = first / second;
                        break;
                }
                stack.push(result);
            }
        }
        System.out.printf("%.2f", stack.pop());

    }

}
