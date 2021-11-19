import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] arr;
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
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];


        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }




        int year = 0;
        int answer = 0;
        // 블럭
        while (answer < 2) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (arr[i][j] == 0) {
                        q.add(new Point(i, j));
                    }
                }
            }
            while (!q.isEmpty()) {
                Point point = q.poll();
                for (int i = 0; i < 4; i++) {
                    int nRow = point.row + dRow[i];
                    int nCol = point.col + dCol[i];
                    if (isIn(nRow, nCol) && arr[nRow][nCol] > 0) {
                        arr[nRow][nCol]--;
                    }
                }
            }

            // 영역의 개수 세기
            int area = 0;
            chk = new boolean[N][M];
            int flag = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (!chk[i][j] && arr[i][j] != 0) {
//                        System.out.println("i = " + i);
//                        System.out.println("j = " + j);
                        q.add(new Point(i, j));
                        chk[i][j] = true;
                        while (!q.isEmpty()) {
                            Point point = q.poll();
                            for (int k = 0; k < 4; k++) {
                                int nRow = point.row + dRow[k];
                                int nCol = point.col + dCol[k];
                                if (isIn(nRow, nCol) && !chk[nRow][nCol] && arr[nRow][nCol] > 0) {
                                    q.add(new Point(nRow, nCol));
                                    chk[nRow][nCol] = true;
                                }
                            }
                        }
                        area++;
                        answer = area;
//                        System.out.println("area = " + area);
                        flag++;
                    }

                }
            }
            if (flag==0) {
                System.out.println(0);
                return;
            }

            year++;
//            System.out.println("Arrays.deepToString(arr) = " + Arrays.deepToString(arr));

        }
        System.out.println(year);
    }

    private static boolean isIn(int nRow, int nCol) {
        return nRow >= 0 && nCol >= 0 && nRow < N && nCol < M;
    }
}