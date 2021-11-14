import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
// 40m 소요
public class Main {

    static int N, maxHeight;
    static int[][] arr, chk;
    static Queue<Point> q = new LinkedList<>();
    static int[] dRow = {-1, 1, 0, 0};
    static int[] dCol = {0, 0, -1, 1};
    static class Point {
        int row, col;

        public Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public static boolean isIn(int nRow, int nCol) {
        return (nRow >= 0 && nCol >= 0 && nRow < N  && nCol < N);
    }

    public static void bfs(int height, int a, int b) {
        q.add(new Point(a, b));
        chk[a][b] = height;
        while (!q.isEmpty()) {
            Point point = q.poll();
            for (int i = 0; i < dRow.length; i++) {
                int nRow = point.row + dRow[i];
                int nCol = point.col + dCol[i];
                if (isIn(nRow, nCol) && chk[nRow][nCol] < height && arr[nRow][nCol] > height) {
                    q.add(new Point(nRow, nCol));
                    chk[nRow][nCol] = height;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        chk = new int[N][N];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                maxHeight = Math.max(maxHeight, arr[i][j]);
            }
        }

        // 비는.. 0부터 maxHeight까지..
        int answer = 1; // 비가 아예 안오는 경우 (h == 0);
        for (int h = 1; h < maxHeight; h++) {
            int countArea = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (chk[i][j] < h && arr[i][j] > h) {
                        bfs(h, i, j);
                        countArea++;
                    }
                }
            }
            answer = Math.max(answer, countArea);
        }
        System.out.println(answer);
    }
}
