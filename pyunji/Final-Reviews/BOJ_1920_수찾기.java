import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] pool;
    static int N;

    public static int search(int elem) {
        int start = 0;
        int end = N-1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (pool[mid] < elem) {
                start = mid + 1;
            } else if (pool[mid] > elem) {
                end = mid - 1;
            } else {
                return 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        pool = new int[N];
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            pool[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(pool);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            System.out.println(search(Integer.parseInt(st.nextToken())));
        }
    }
}
