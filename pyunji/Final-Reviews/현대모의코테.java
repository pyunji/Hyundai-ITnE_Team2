import java.util.*;
import java.io.*;
class Solution {
    static int AnswerN;
    static char[][] arr;
    static boolean[][] chk;
    static int N;
    static Queue<Point> q = new LinkedList<>();
    static int[] dARow = {0, 0, 1, -1};
    static int[] dACol = {1, -1, 0, 0};
    static int[] dBRow = {0, 0, 1, -1, 0, 0, 2, -2};
    static int[] dBCol = {1, -1, 0, 0, 2, -2, 0, 0};
    static int[] dCRow = {0, 0, 1, -1, 0, 0, 2, -2, 0, 0, 3, -3};
    static int[] dCCol = {1, -1, 0, 0, 2, -2, 0, 0, 3, -3, 0, 0};
    static class Point {
        int row;
        int col;
        Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
        @Override
        public String toString() {
            return "(" + row + ", " + col + ")";
        }
    }
    private static void bfs(int a, int b) {
        chk[a][b] = true;
        q.add(new Point(a, b));
        while(!q.isEmpty()) {
            Point point = q.poll();
            // A인 경우, B인 경우, C인 경우
            int row = point.row;
            int col = point.col;
            char tower = arr[row][col];
            if (tower == 'A') {
                for (int i = 0; i < 4; i++) {
                    int nRow = row + dARow[i];
                    int nCol = col + dACol[i];
                    if (nRow >= 0 && nCol >= 0 && nRow < N && nCol < N
                            && arr[nRow][nCol] == 'H' && !chk[nRow][nCol]) {
                        chk[nRow][nCol] = true;
                        q.add(new Point(nRow, nCol));
                    }
                }
            } else if (tower == 'B') {
                for (int i = 0; i < 8; i++) {
                    int nRow = row + dBRow[i];
                    int nCol = col + dBCol[i];
                    if (nRow >= 0 && nCol >= 0 && nRow < N && nCol < N
                            && arr[nRow][nCol] == 'H' && !chk[nRow][nCol]) {
                        chk[nRow][nCol] = true;
                        q.add(new Point(nRow, nCol));
                    }
                }
            } else if (tower == 'C') {
                for (int i = 0; i < 12; i++) {
                    int nRow = row + dCRow[i];
                    int nCol = col + dCCol[i];
                    if (nRow >= 0 && nCol >= 0 && nRow < N && nCol < N
                            && arr[nRow][nCol] == 'H' && !chk[nRow][nCol]) {
                        chk[nRow][nCol] = true;
                        q.add(new Point(nRow, nCol));
                    }
                }
            } else if (tower == 'H') {
                AnswerN--;
            }
        }
    }
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int caseLen = Integer.parseInt(br.readLine());
        for(int test_case = 1; test_case <= caseLen; test_case++) {
            AnswerN = 0;
            N = Integer.parseInt(br.readLine());
            arr = new char[N][N];
            chk = new boolean[N][N];
            int countHouse = 0;
            /* 데이터 초기화 */
            for (int i = 0; i < N; i++) {
                String[] tmp = br.readLine().split(" ");
                for (int j = 0; j < N; j++) {
                    arr[i][j] = tmp[j].charAt(0);
                    if (arr[i][j] == 'H') countHouse++;
                }
            }
            AnswerN = countHouse;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if ((arr[i][j] == 'A' || arr[i][j] == 'B' || arr[i][j] == 'C')
                            && !chk[i][j]) {
                        // answer 처리 필요
                        bfs(i, j);
                    }
                }
            }
            System.out.println("#"+test_case+" "+AnswerN);
        }
    }
}