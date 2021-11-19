import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;

    static boolean[] chk;
    public static void dfs(int start, int count, String path) {
        if (count == M) {
            System.out.println(path);
        }
        for (int i = start + 1; i < N + 1; i++) {
            if (!chk[i]) {
                chk[i] = true;
                dfs(i, count + 1, path + i + " ");
                chk[i] = false;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        chk = new boolean[N + 1];
        for (int i = 1; i < N + 1; i++) {
            chk[i] = true;
            dfs(i, 1,  i + " ");
            chk[i] = false;
        }
    }
}