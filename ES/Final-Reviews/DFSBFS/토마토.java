package algorithm.boj.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class boj7576 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int n = Integer.parseInt(line[1]);
        int m = Integer.parseInt(line[0]);

        int[][] board = new int[n+2][m+2];
        int[][] dist = new int[n+2][m+2];
        Queue<Pair> q = new LinkedList<>();
        int[] dx = {1,0,-1,0};
        int[] dy = {0,1,0,-1};
        int ans = 0;

        for(int i=0;i<n;i++) {
            Arrays.fill(dist[i],-1);
        }

        for(int i=0;i<n;i++) {
            line = br.readLine().split(" ");
            for(int j=0;j<m;j++) {
                board[i][j] = Integer.parseInt(line[j]);
                if(board[i][j]==1) {
                    q.add(new Pair(i, j));
                    dist[i][j] = 0;
                }
            }
        }

        boolean flag = true;

        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++ ) {
                if(board[i][j]==0) flag = false;
            }
        }
        if(flag) {
            System.out.println(0);
            System.exit(0);
        }


        while (!q.isEmpty()) {
            Pair cur = q.poll();

            for(int dir = 0;dir<4;dir++) {
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];
                if(nx<0||nx>=n||ny<0||ny>=m) continue;
                if( board[nx][ny]==-1 || board[nx][ny]==1) continue;
                dist[nx][ny] = dist[cur.x][cur.y] +1;
                ans = Math.max(ans,dist[nx][ny]);
                board[nx][ny] = 1;
                q.add(new Pair(nx,ny));
            }
        }

        flag = true;
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(board[i][j]==0) flag = false;
            }
        }


        if(flag) {
            System.out.println(ans);
        }else {
            System.out.println(-1);
        }
    }
}

class Pair {
    int x;
    int y;
    public Pair(int x,int y) {
        this.x = x;
        this.y = y;
    }
}
