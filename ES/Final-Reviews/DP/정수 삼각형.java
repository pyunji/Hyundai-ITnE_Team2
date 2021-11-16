import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        
        int[][] dp =  new int[502][502];
        
        dp[0][0] = triangle[0][0];
        
        int k=2;
        for(int i=1;i<triangle.length;i++) {
            for(int j=0;j<k;j++) {
                if(j==0) dp[i][j] = triangle[i][j] + dp[i-1][0];
                else if(j==k-1) dp[i][j] = triangle[i][j] + dp[i-1][k-2];
                else dp[i][j] = triangle[i][j] + Math.max(dp[i-1][j-1],dp[i-1][j]);
            }
            k++;
        }
        
        for(int i=0;i<triangle.length;i++) {
            answer = Math.max(answer, dp[triangle.length-1][i]);
        }
        
        return answer;
    }
}