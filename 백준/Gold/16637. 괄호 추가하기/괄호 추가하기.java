import java.io.*;
import java.util.*;

class Main {
    static List<Character> operation;
    static List<Integer> nums;
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String str = br.readLine();
        operation = new ArrayList<>();
        nums = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            char c = str.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                operation.add(c);
            } else {
                nums.add(Character.getNumericValue(c));
            }
        }
        answer = Integer.MIN_VALUE;
        DFS(nums.get(0), 0);
        System.out.println(answer);
    }

    public static void DFS(int num, int opIdx) {
        if (opIdx >= operation.size()) {
            answer = Math.max(answer, num);
            return;
        }
        //괄호가 없는 경우
        int result = calc(num, operation.get(opIdx), nums.get(opIdx+1));
        DFS(result, opIdx+1);

        //괄호가 있는 경우
        if (opIdx + 1 < operation.size()) {
            int result2 = calc(nums.get(opIdx+1), operation.get(opIdx+1), nums.get(opIdx+2));
            DFS(calc(num, operation.get(opIdx), result2), opIdx+2);
        }
    }

    public static int calc(int num1, char op, int num2) {
        switch (op) {
            case '+': return num1 + num2;
            case '*': return num1 * num2;
            case '-': return num1 - num2;
            default: return -1;
        }
    }
}