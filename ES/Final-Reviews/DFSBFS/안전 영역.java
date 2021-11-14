package algorithm.boj.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class boj2468 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] board = new int[n+2][n+2];
        boolean[][] visited = new boolean[n+2][n+2];
        int[] dx = {1,0,-1,0};
        int[] dy = {0,1,0,-1};
        Queue<Pair> q = new LinkedList<>();
        int max_height = 0;
        for(int i=0;i<n;i++) {
            String[] line = br.readLine().split(" ");
            for(int j=0;j<n;j++) {
                board[i][j] = Integer.parseInt(line[j]);
                if(board[i][j]>max_height) max_height = board[i][j];
            }
        }

        int rain = 0;
        int max_area = 0;
        while(rain<max_height) {
            int cnt_area = 0;

            for(int i=0;i<n;i++) {
                Arrays.fill(visited[i],false);
            }

            for(int i=0;i<n;i++) {
                for(int j=0;j<n;j++) {
                    if(board[i][j]>rain && visited[i][j]==false) {
                        q.add(new Pair(i,j));
                        visited[i][j] = true;
                        cnt_area++;
                    }

                    while(!q.isEmpty()) {
                        Pair cur = q.poll();
                        for(int dir=0;dir<4;dir++) {
                            int nx = dx[dir] + cur.x;
                            int ny = dy[dir] + cur.y;
                            if(nx<0||nx>=n||ny<0||ny>=n) continue;
                            if(board[nx][ny]<=rain || visited[nx][ny] == true) continue;
                            visited[nx][ny] = true;
                            q.add(new Pair(nx,ny));
                        }
                    }
                }
            }

            max_area = Math.max(max_area,cnt_area);
            rain++;
        }
        System.out.println(max_area);
    }

    public static class Pair {
        int x;
        int y;
        public Pair(int x,int y) {
            this.x = x;
            this.y = y;
        }
    }
}
