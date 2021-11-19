package present.boj_16236;

import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] arr;
    static List<Point>[] fishPoints;

    static int babySize = 2;
    static int babyEat = 0;
    static int fishCnt;
    static Point babyPoint;
    static Queue<Point> q = new LinkedList<>();

    static int[] dRow = {0, 0, -1, 1};
    static int[] dCol = {-1, 1, 0, 0};

    static boolean isIn(int nRow, int nCol) {
        return (nRow >= 0 && nCol >= 0 && nRow < N && nCol < N);
    }

    static class Point {
        int row, col;

        public Point(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "row=" + row +
                    ", col=" + col +
                    '}';
        }
    }

    public static boolean callMom() {
        if (babySize > 6) return false;
        for (int i = 1; i < babySize; i++) {
            if (fishPoints[i].size() > 0) return false;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        fishPoints = new ArrayList[7];

        for (int i = 0; i < 7; i++) {
            fishPoints[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int fishSize = Integer.parseInt(st.nextToken());
                arr[i][j] = fishSize;
                // 아기 상어의 처음 위치 저장
                if (fishSize == 9) {
                    babyPoint = new Point(i, j);
                }
                // 물고기의 크기를 나타내는 인덱스에 물고기의 좌표 추가
                else if (fishSize != 0) {
                    fishPoints[fishSize].add(new Point(i, j));
                    fishCnt++;
                }
            }
        }

        int answer = 0;
        while (!callMom()) {
            if (fishCnt == 0) break;
            int minDistance = Integer.MAX_VALUE;
            // 먹을 수 있는 물고기들의 좌표를 추가
            List<Point> feedList = new ArrayList();
            if (babySize < 7) {
                for (int i = 0; i < babySize; i++) {
                    List<Point> feeds = fishPoints[i];
                    for (int j = 0; j < feeds.size(); j++) {
                        feedList.add(feeds.get(j));
                    }
                }
            } else {
                for (int i = 0; i < 7; i++) {
                    List<Point> feeds = fishPoints[i];
                    for (int j = 0; j < feeds.size(); j++) {
                        feedList.add(feeds.get(j));
                    }
                }
            }


            int[][] calDistance = new int[N][N];
            boolean[][] chk = new boolean[N][N];

            q.add(babyPoint);
            chk[babyPoint.row][babyPoint.col] = true;
            // 아기상어와 크기가 같거나 작은 곳으로만 이동 가능한걸 고려해서 거리 계산
            while (!q.isEmpty()) {
                Point point = q.poll();
//                System.out.println("test1");
                for (int i = 0; i < 4; i++) {
                    int nRow = point.row + dRow[i];
                    int nCol = point.col + dCol[i];
//                    System.out.println("test2");
                    if (isIn(nRow, nCol) && !chk[nRow][nCol]) {
//                        System.out.println("test3");
                        if (arr[nRow][nCol] <= babySize) {
//                            System.out.println("test4");
                            Point nPoint = new Point(nRow, nCol);
                            q.offer(nPoint);
                            chk[nRow][nCol] = true;
                            calDistance[nRow][nCol] = calDistance[point.row][point.col] + 1;
                            for (Point feed : feedList) {
                                if (nPoint.row == feed.row && nPoint.col == feed.col) {
                                    minDistance = Math.min(calDistance[nRow][nCol], minDistance);
                                }
                            }
                        }
                    }
                }
            }

            Point realFeed = null;
            for (Point feed : feedList) {
                if (calDistance[feed.row][feed.col] == minDistance) {
//                    System.out.println("test1");
                    if (realFeed == null) {
//                        System.out.println("test2");
                        realFeed = feed;
                    }
                    else {
                        int beforeRow = realFeed.row;
                        int curRow = feed.row;
                        if (curRow < beforeRow) realFeed = feed;
                        else if (curRow == beforeRow) {
                            int beforeCol = realFeed.col;
                            int curCol = feed.col;
                            if (curCol < beforeCol) realFeed = feed;
                        }
                    }
                }
            }
//            System.out.println(">> babySize = " + babySize);
//            System.out.println("realFeed = " + realFeed);

            if (realFeed == null) break;
            // 물고기 0으로 만들기
            int fishIdx = arr[realFeed.row][realFeed.col];
            arr[realFeed.row][realFeed.col] = 0;
            // 물고기 좌표 제거
            for (Point fish : fishPoints[fishIdx]) {
                if (fish.row == realFeed.row && fish.col == realFeed.col) {
                    fishPoints[fishIdx].remove(fish);
                    break;
                }
            }
            // 상어 먹은 횟수 증가
            babyEat++;
            fishCnt--;
            // 상어 진화 가능 체크
            if (babySize == babyEat) {
                babySize++;
                babyEat = 0;
            }
            // 상어 위치 이동
            arr[babyPoint.row][babyPoint.col] = 0; // **
            arr[realFeed.row][realFeed.col] = 9; // ***
            babyPoint = realFeed;

            // 시간 증가
            answer += minDistance;
//            System.out.println("minDistance = " + minDistance);
        }
        System.out.println(answer);
//        System.out.println("answer = " + answer);
    }
}