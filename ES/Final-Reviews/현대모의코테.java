import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class test {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int test = Integer.parseInt(br.readLine());
        int[] dx = {1,0,-1,0};
        int[] dy = {0,1,0,-1};
        char[][] board = new char[52][52];
        boolean[][] visited = new boolean[52][52];

        for(int t=1;t<=test;t++) {
            int n = Integer.parseInt(br.readLine());

            //input
            for(int i=0;i<n;i++) {
                String[] line = br.readLine().split(" ");
                for (int j = 0; j < n; j++) {
                    board[i][j] = line[j].charAt(0);
                }
            }

            //init
            int ans = 0;
            for(int i=0;i<n;i++) {
                for (int j = 0; j < n; j++) {
                    visited[i][j] = false;
                }
            }

            for(int i=0;i<n;i++) {
                for(int j=0;j<n;j++) {
                    if(board[i][j]=='X' || board[i][j]=='H') continue;
                    if(board[i][j]=='A') {
                        for(int dir = 0;dir<4;dir++) {
                            int nx = i+dx[dir];
                            int ny = j+dy[dir];
                            if(nx<0||nx>=n||ny<0||ny>=n) continue;
                            if(board[nx][ny]=='H'&& visited[nx][ny]==false) {
                                visited[nx][ny] = true;
                            }
                        }
                    }else if(board[i][j]=='B'){
                        for(int k=1;k<=2;k++) {
                            for (int dir = 0; dir < 4; dir++) {
                                int nx = i + (dx[dir]*k);
                                int ny = j + (dy[dir]*k);
                                if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                                if (board[nx][ny] == 'H' && visited[nx][ny] == false) {
                                    visited[nx][ny] = true;
                                }
                            }
                        }
                    }else if(board[i][j]=='C') {
                        for(int k=1;k<=3;k++) {
                            for (int dir = 0; dir < 4; dir++) {
                                int nx = i + (dx[dir]*k);
                                int ny = j + (dy[dir]*k);
                                if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                                if (board[nx][ny] == 'H' && visited[nx][ny] == false) {
                                    visited[nx][ny] = true;
                                }
                            }
                        }
                    }
                }
            }
            for(int i=0;i<n;i++) {
                for(int j=0;j<n;j++) {
                    if(!visited[i][j] && board[i][j]=='H') ans++;
                }
            }

            sb.append("#"+t+" "+ans+"\n");
        }
        System.out.println(sb.toString());
    }
}
