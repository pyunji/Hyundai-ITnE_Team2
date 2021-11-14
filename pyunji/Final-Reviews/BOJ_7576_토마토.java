package present.boj_7576_2;

import java.io.*;
import java.util.*;

public class Main {
    static int[][] arr, chk;
    static int[] dRow = {-1, 1, 0, 0};
    static int[] dCol = {0, 0, -1, 1};
    static class Point {
        int row, col;
        public Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    static Queue<Point> q = new LinkedList<>();


    static int row, col, rawTomatoes;
    public static boolean isIn(int nRow, int nCol) {
        return (nRow >= 0 && nCol >= 0 && nRow < row && nCol < col);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        col = Integer.parseInt(st.nextToken());
        row = Integer.parseInt(st.nextToken());

        arr = new int[row][col];
        chk = new int[row][col];

        for (int i = 0; i < row; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < col; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 0) rawTomatoes++;
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (arr[i][j] == 1) {
                    q.add(new Point(i, j));
                    chk[i][j] = 1;
                }
            }
        }

        while (!q.isEmpty()) {
            Point point = q.poll();
            for (int i = 0; i < dRow.length; i++) {
                int nRow = point.row + dRow[i];
                int nCol = point.col + dCol[i];
                int yesterday = chk[point.row][point.col];
                if (isIn(nRow, nCol) && chk[nRow][nCol] == 0 && arr[nRow][nCol] == 0) {
                    q.add(new Point(nRow, nCol));
                    chk[nRow][nCol] = yesterday + 1;
                    rawTomatoes--;
                }
            }
        }

        if (rawTomatoes != 0) {
            System.out.println(-1);
            return;
        }

        int answer = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                answer = Math.max(chk[i][j], answer);
            }
        }
        System.out.println((answer - 1));


    }
}