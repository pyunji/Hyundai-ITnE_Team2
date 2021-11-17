import java.io.*;
import java.util.*;

public class Main {
    static char[][] arr;
    static boolean[] chk = new boolean[90 + 1];

    static int maxCount;

    static Queue<Point> q = new LinkedList<>();

    static int[] dRow = {0, 0, -1, 1};
    static int[] dCol = {-1, 1, 0, 0};

    static int r, c;

    static class Point {
        int row, col;

        public Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public static boolean isIn(int nRow, int nCol) {
        return (nRow >= 0 && nCol >= 0 && nRow < r & nCol < c);
    }

    public static void dfs(int _r, int _c,  int cnt) {
        maxCount = Math.max(cnt, maxCount);
        for (int i = 0; i < 4; i++) {
            int nRow = _r + dRow[i];
            int nCol = _c + dCol[i];
            if (isIn(nRow, nCol) && !chk[arr[nRow][nCol]]) {
                chk[arr[nRow][nCol]] = true;
                dfs(nRow, nCol, cnt + 1);
                chk[arr[nRow][nCol]] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());


        arr = new char[r][c];

        for (int i = 0; i < r; i++) {
            String str = br.readLine();
            for (int j = 0; j < c; j++) {
                arr[i][j] = str.charAt(j);
            }
        }
        chk[arr[0][0]] = true;
        dfs(0, 0, 1);

        System.out.println(maxCount);
    }
}