import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dRow = {0, 0, -1, 1};
    static int[] dCol = {-1, 1, 0, 0};
    static int[][] arr;
    static boolean[][] chk;

    static int row, col, plant;

    static Queue<Point> q = new LinkedList<>();
    static class Point {
        int row, col;

        public Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public static void bfs(int a, int b) {
        chk[a][b] = true;
        q.add(new Point(a, b));
        while (!q.isEmpty()) {
            Point point = q.poll();
            for (int i = 0; i < 4; i++) {
                int nRow = point.row + dRow[i];
                int nCol = point.col + dCol[i];
                if (nRow >= 0 && nCol >= 0 && nRow < row && nCol < col
                        &&!chk[nRow][nCol] && arr[nRow][nCol] == 1) {
                    chk[nRow][nCol] = true;
                    q.add(new Point(nRow, nCol));
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            int answer = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            col = Integer.parseInt(st.nextToken());
            row = Integer.parseInt(st.nextToken());
            plant = Integer.parseInt(st.nextToken());
            arr = new int[row][col];
            chk = new boolean[row][col];
            for (int j = 0; j < plant; j++) {
                st = new StringTokenizer(br.readLine());
                    int tmpCol = Integer.parseInt(st.nextToken());
                    int tmpRow = Integer.parseInt(st.nextToken());
                    arr[tmpRow][tmpCol] = 1;
            }

            for (int r = 0; r < row; r++) {
                for (int c = 0; c < col; c++) {
                    if (!chk[r][c] && arr[r][c] == 1) {
                        bfs(r, c);
                        answer++;
                    }
                }
            }

            System.out.println(answer);
        }
    }
}
