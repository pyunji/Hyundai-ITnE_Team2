import java.io.*;
import java.util.*;

public class Main {
    static int row, col;
    static int[][] arr, distances;
    static boolean[][] chk;

    static Queue<Point> q = new LinkedList<>();
    static int[] dRow = {0, 0, -1, 1};
    static int[] dCol = {-1, 1, 0, 0};

    static class Point {
        int row, col;

        public Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public static boolean isIn(int nRow, int nCol) {
        return (nRow >= 0 && nCol >= 0 && nRow < row && nCol < col);
    }

    public static void bfs() {
        while (!q.isEmpty()) {
            Point point = q.poll();
            int distance = distances[point.row][point.col];
            for (int i = 0; i < 4; i++) {
                int nRow = point.row + dRow[i];
                int nCol = point.col + dCol[i];
                if (isIn(nRow, nCol) && arr[nRow][nCol] == 1 && !chk[nRow][nCol]) {
                    chk[nRow][nCol] = true;
                    distances[nRow][nCol] = distance + 1;
                    q.add(new Point(nRow, nCol));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        arr = new int[row][col];
        distances = new int[row][col];
        chk = new boolean[row][col];
        // 데이터 입력
        for (int i = 0; i < row; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < col; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 2) {
                    // Queue에 목표지점 좌표 add
                    q.add(new Point(i, j));
                    chk[i][j] = true;
                }
            }
        }

        // bfs
        bfs();

        // 원래 갈 수 있는 땅인데 도달할 수 없는 곳 찾기
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (!chk[i][j] && arr[i][j] == 1) {
                    distances[i][j] = -1;
                }
            }
        }

        // print
        for (int i = 0; i < row; i++) {
            int[] row = distances[i];
            for (int j = 0; j < col; j++) {
                System.out.print(row[j] + " ");
            }
            System.out.println();
        }
    }
}