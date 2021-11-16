import java.util.*;

class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        
        long[][] dp = new long[102][102];
        for(int i=0;i<=n;i++){
            Arrays.fill(dp[i],-1);
        }
        
        for(int i=0;i<puddles.length;i++) {
            int a = puddles[i][0];
            int b = puddles[i][1];
            dp[b][a] = 0;
        }
        
        dp[1][1] = 1;
        for(int i=1;i<=n;i++) {
            for(int j=1;j<=m;j++) {
                if(i==1 && j==1) continue;
                if(dp[i][j]==0) continue;
                if(i==1) dp[i][j] = dp[i][j-1];
                else if(j==1) dp[i][j] = dp[i-1][j];
                else dp[i][j] = (dp[i][j-1] + dp[i-1][j])%1000000007;
            }
        }
        
        answer = (int)(dp[n][m] % 1000000007);  

        return answer;
    }
}