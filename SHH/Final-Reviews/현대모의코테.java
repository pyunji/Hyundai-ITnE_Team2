package Test;

import java.awt.Point;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class test {
   static int AnswerN;
   static int N = 10;
   static String[][] map;
   static boolean[][] covered;

   public static void main(String args[]) throws Exception {
      // System.setIn(new FileInputStream("C:\sample_input.txt"));
      Scanner input = new Scanner(System.in);
      // 테스트 케이스 숫자
      int T = input.nextInt();
      Queue<Point> queue = new LinkedList<>();
      for (int test_case = 1; test_case <= T; test_case++) {
         N = input.nextInt();
         map = new String[N][N];
         covered = new boolean[N][N];

         for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
               String str = input.next();
               map[i][j] = str;
               if (str.equals("A") || str.equals("B") || str.equals("C")) {
                  Point a = new Point();
                  a.x = i;
                  a.y = j;
                  queue.offer(a);
               }
            }
         }

         while (!queue.isEmpty()) {
            Point b = queue.poll();
            if (map[b.x][b.y].equals("A")) {
               if (b.x + 1 < N) {
                  if (map[b.x + 1][b.y].equals("H")) {
                     covered[b.x + 1][b.y] = true;
                  }
               }
               if (b.y - 1 >= 0) {
                  if (map[b.x][b.y - 1].equals("H")) {
                     covered[b.x][b.y - 1] = true;
                  }
               }
               if (b.x - 1 >= 0) {
                  if (map[b.x - 1][b.y].equals("H")) {
                     covered[b.x - 1][b.y] = true;
                  }
               }
               if (b.y + 1 < N) {
                  if (map[b.x][b.y + 1].equals("H")) {
                     covered[b.x][b.y + 1] = true;
                  }
               }
            } else if (map[b.x][b.y].equals("B")) {
               if (b.x + 1 < N) {
                  if (map[b.x + 1][b.y].equals("H")) {
                     covered[b.x + 1][b.y] = true;
                  }
               }
               if (b.y - 1 >= 0) {
                  if (map[b.x][b.y - 1].equals("H")) {
                     covered[b.x][b.y - 1] = true;
                  }
               }
               if (b.x - 1 >= 0) {
                  if (map[b.x - 1][b.y].equals("H")) {
                     covered[b.x - 1][b.y] = true;
                  }
               }
               if (b.y + 1 < N) {
                  if (map[b.x][b.y + 1].equals("H")) {
                     covered[b.x][b.y + 1] = true;
                  }
               }

               if (b.x + 2 < N) {
                  if (map[b.x + 2][b.y].equals("H")) {
                     covered[b.x + 2][b.y] = true;
                  }
               }
               if (b.y - 2 >= 0) {
                  if (map[b.x][b.y - 2].equals("H")) {
                     covered[b.x][b.y - 2] = true;
                  }
               }
               if (b.x - 2 >= 0) {
                  if (map[b.x - 2][b.y].equals("H")) {
                     covered[b.x - 2][b.y] = true;
                  }
               }
               if (b.y + 2 < N) {
                  if (map[b.x][b.y + 2].equals("H")) {
                     covered[b.x][b.y + 2] = true;
                  }
               }
            } else if (map[b.x][b.y].equals("C")) {
               if (b.x + 1 < N) {
                  if (map[b.x + 1][b.y].equals("H")) {
                     covered[b.x + 1][b.y] = true;
                  }
               }
               if (b.y - 1 >= 0) {
                  if (map[b.x][b.y - 1].equals("H")) {
                     covered[b.x][b.y - 1] = true;
                  }
               }
               if (b.x - 1 >= 0) {
                  if (map[b.x - 1][b.y].equals("H")) {
                     covered[b.x - 1][b.y] = true;
                  }
               }
               if (b.y + 1 < N) {
                  if (map[b.x][b.y + 1].equals("H")) {
                     covered[b.x][b.y + 1] = true;
                  }
               }

               if (b.x + 2 < N) {
                  if (map[b.x + 2][b.y].equals("H")) {
                     covered[b.x + 2][b.y] = true;
                  }
               }
               if (b.y - 2 >= 0) {
                  if (map[b.x][b.y - 2].equals("H")) {
                     covered[b.x][b.y - 2] = true;
                  }
               }
               if (b.x - 2 >= 0) {
                  if (map[b.x - 2][b.y].equals("H")) {
                     covered[b.x - 2][b.y] = true;
                  }
               }
               if (b.y + 2 < N) {
                  if (map[b.x][b.y + 2].equals("H")) {
                     covered[b.x][b.y + 2] = true;
                  }
               }

               if (b.x + 3 < N) {
                  if (map[b.x + 3][b.y].equals("H")) {
                     covered[b.x + 3][b.y] = true;
                  }
               }
               if (b.y - 3 >= 0) {
                  if (map[b.x][b.y - 3].equals("H")) {
                     covered[b.x][b.y - 3] = true;
                  }
               }
               if (b.x - 3 >= 0) {
                  if (map[b.x - 3][b.y].equals("H")) {
                     covered[b.x - 3][b.y] = true;
                  }
               }
               if (b.y + 3 < N) {
                  if (map[b.x][b.y + 3].equals("H")) {
                     covered[b.x][b.y + 3] = true;
                  }
               }
            }
         }

         for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
               if (covered[i][j] == false && map[i][j].equals("H")) {
                  AnswerN++;
               }

            }

         }
         
          System.out.println("#"+test_case+" "+AnswerN);
          AnswerN = 0;
      }
   }
}
