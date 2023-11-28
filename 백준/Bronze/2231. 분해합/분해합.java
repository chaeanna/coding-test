import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = n;

        int result;

        List<Integer> list = new ArrayList<>();

        while(true) {
            m--;
            String num = Integer.toString(m);
            result = 0;
            for (int i = 0; i < num.length(); i++) {
                result += num.charAt(i) - '0';
            }
            result += m;
            if (result == n) list.add(m);
            if (m < n - (String.valueOf(n).length()*9)) {
                break;
            }
        }

        if(list.size() == 0) System.out.println(0);
        else System.out.println(list.get(list.size()-1));
    }
}
