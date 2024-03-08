import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        List<Integer> list = new ArrayList<>();
        boolean check = false;
        int sum = 0;
        for (int i = 0; i < str.length(); i++) {
            int num = str.charAt(i) - '0';
            sum += num;
            if (num == 0) {
                check = true;
            }
            list.add(num);
        }

        //내림차순 정렬
        Collections.sort(list, Collections.reverseOrder());

        // 0이 있는가
        //3의 배수인가
        if (check && sum % 3 == 0) {
            //출력
            for (Integer i : list) {
                System.out.print(i);
            }
        } else {
            System.out.println(-1);
        }
    }
}