import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Lecture implements Comparable<Lecture> {
    int start, end;
    public Lecture(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Lecture o) {
        if (this.start == o.start) {
            return this.end - o.end;
        } else {
            return this.start - o.start;
        }
    }
}
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st;
        Lecture[] lecture = new Lecture[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            lecture[i] = new Lecture(s, e);
        }
        Arrays.sort(lecture);
        PriorityQueue<Integer> pQ = new PriorityQueue<>();

        pQ.offer(lecture[0].end);
        for (int i = 1; i < n; i++) {
            int start = lecture[i].start;
            int end = lecture[i].end;
            if (pQ.peek() <= start) {
                pQ.poll();
            }
            pQ.offer(end);
        }


        System.out.println(pQ.size());
    }
}