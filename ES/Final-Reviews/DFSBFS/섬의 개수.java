package algorithm.boj.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class boj4963 {
    static int n=0;
    static int m = 0;
    static int[][] board = new int[52][52];
    static boolean[][] visited = new boolean[52][52];
    static int[] dx = { 1,1,0,-1,-1,-1,0,1 };
    static int[] dy = { 0,1,1,1,0,-1,-1,-1};
    static Queue<Pair> q = new LinkedList<>();
    static String[] line= new String[52];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            line = br.readLine().split(" ");
            n = Integer.parseInt(line[1]);
            m = Integer.parseInt(line[0]);
            if(n==0 && m==0) break;

            for(int i=0;i<n;i++) {
                Arrays.fill(board[i],0);
                Arrays.fill(visited[i],false);
            }

            for(int i=0;i<n;i++) {
                line = br.readLine().split(" ");
                for(int j=0;j<m;j++) {
                    board[i][j] = Integer.parseInt(line[j]);
                }
            }

            int cnt = 0;

            for(int i=0;i<n;i++) {
                for(int j=0;j<m;j++) {
                    if(board[i][j]==1 && visited[i][j]==false) {
                        visited[i][j] = true;
                        q.add(new Pair(i,j));
                        cnt++;
                    }

                    while(!q.isEmpty()) {
                        Pair cur = q.poll();

                        for(int dir = 0;dir<8;dir++) {
                            int nx = cur.x + dx[dir];
                            int ny = cur.y + dy[dir];
                            if(nx<0||nx>=n||ny<0||ny>=m) continue;
                            if(board[nx][ny]==0 || visited[nx][ny]==true) continue;
                            visited[nx][ny] = true;
                            q.add(new Pair(nx,ny));
                        }
                    }
                }
            }
            System.out.println(cnt);
        }
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
