import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    static boolean[][] chk;

    static int row, col;

    static Queue<Point> q = new LinkedList<>();

    static int[] dRow = {-1, 0, 0, 1, -1, -1, 1, 1};
    static int[] dCol = {0, -1, 1, 0, 1, -1, 1, -1};

    static class Point {
        int row;
        int col;

        public Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
    public static boolean isIn(int nRow, int nCol) {
        return (nRow >= 0 && nCol >= 0 && nRow < row && nCol < col);
    }

    public static void bfs(int a, int b) {
        q.add(new Point(a, b));
        chk[a][b] = true;

        while (!q.isEmpty()) {
            Point point = q.poll();
            for (int i = 0; i < dRow.length; i++) {
                int nRow = point.row + dRow[i];
                int nCol = point.col + dCol[i];
                if (isIn(nRow, nCol) && !chk[nRow][nCol] && arr[nRow][nCol] == 1) {
                    q.add(new Point(nRow, nCol));
                    chk[nRow][nCol] = true;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st;
            String firstLine = br.readLine();
            if (firstLine.equals("0 0")) break;
            st = new StringTokenizer(firstLine);
            col = Integer.parseInt(st.nextToken());
            row = Integer.parseInt(st.nextToken());
            int answer = 0;
            arr = new int[row][col];
            chk = new boolean[row][col];

            for (int i = 0; i < row; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < col; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (!chk[i][j] && arr[i][j] == 1) {
                        bfs(i, j);
                        answer++;
                    }
                }
            }

            System.out.println(answer);

        }

    }
}