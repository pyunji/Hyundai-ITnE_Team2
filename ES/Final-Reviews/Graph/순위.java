import java.util.*;

class Solution {
    static final int INF = 987654321;
    static int[][] dist = new int[102][102];
    static int[][] r_dist = new int[102][102];
    
    public int solution(int n, int[][] results) {
        int answer = 0;
        
        for(int i=0;i<=n;i++) {
            Arrays.fill(dist[i],INF);
            Arrays.fill(r_dist[i],INF);
        }
        
        //입력
        for(int i=0;i<results.length;i++) {
            int u = results[i][0];
            int v = results[i][1];

            dist[u][v] = 1;
            r_dist[v][u] = 1;
        }
        
        for(int i=1;i<=n;i++) {
            dist[i][i] = 0;
            r_dist[i][i] = 0;
        }
        
        //정방향
        for(int k=1;k<=n;k++) {
            for(int i=1;i<=n;i++) {
                for(int j=1;j<=n;j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }
        
        //역방향
        for(int k=1;k<=n;k++) {
            for(int i=1;i<=n;i++) {
                for(int j=1;j<=n;j++) {
                    r_dist[i][j] = Math.min(r_dist[i][j], r_dist[i][k] + r_dist[k][j]);
                }
            }
        }
        
        for(int i=1;i<=n;i++) {
            int cnt = 0;
            for(int j=1;j<=n;j++) {
                if(i==j) continue;
                if(dist[i][j]!=INF) cnt++;
            }
            for(int j=1;j<=n;j++) {
                if(i==j) continue;
                if(r_dist[i][j]!=INF) cnt++;
            }
            
            if(cnt==n-1) answer++;
        }
        
        
        return answer;
    }
}