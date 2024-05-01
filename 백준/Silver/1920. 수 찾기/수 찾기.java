import java.util.*;
import java.io.*;

class Main {
    static int[] A;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(A);
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (binarySearch(num) >= 0) {
                sb.append(1).append("\n");
            } else {
                sb.append(0).append("\n");
            }
        }

        System.out.println(sb);

    }

    public static int binarySearch(int key) {
        int le = 0; // 왼쪽 끝
        int re = A.length - 1; // 오른쪽 끝

        // 왼쪽끝이 오른쪽끝보다 커지기전까지 while문 실행
        while (le <= re) {
            int mid = (le+re) / 2;

            // key값이 더 클 경우
            if (key > A[mid]) {
                le = mid+1;
            } // key값이 더 작을 경우
            else if (key < A[mid]) {
                re = mid-1;
            } // key값과 같을 경우
            else {
                return mid;
            }

        }
        return -1;
    }
}