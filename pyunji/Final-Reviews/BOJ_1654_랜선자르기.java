import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int K, N;
    static long[] arr;

    public static long getCount(long mid) {
        int count = 0;
        for (long elem : arr) {
            count += elem / mid;
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        arr = new long[K];
        long max = 0;



        for (int i = 0; i < K; i++) {
            arr[i] = Long.parseLong(br.readLine());
            max = Math.max(max, arr[i]);
        }

        // 나머지 버림 -> 몫만 사용
        // K <= N (등호 포함)의 범위임 -> min 까지만 순회
        // 랜선의 최대 길이

        // 1<=answer<=min
        // 랜선의 개수 >= K 동안 순회
        long start = 1;
        long end = max;
        long answer = 0;
        while (start <= end) {
            long mid = (start + end) / 2;
            long lanCount = getCount(mid);
            if (lanCount >= N) {

                answer = Math.max(answer, mid);
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }
        System.out.println(answer);
    }
}
