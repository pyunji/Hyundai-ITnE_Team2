/*
 * using DFS
 * 13m 소요
 */

class Solution {
    boolean[][] chk;
    
    public void dfs(int a, int b, int[][] computers) {
        chk[a][b] = true;
        for(int i = 0; i < computers.length; i++) {
            if(!chk[b][i] && computers[b][i] == 1) {
                dfs(b, i, computers);
            }
        }
    }
    
    public int solution(int n, int[][] computers) {
        chk = new boolean[n][n];
        int answer = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(!chk[i][j] && computers[i][j] == 1) {
                    dfs(i, j, computers);
                    answer++;
                }
            }
        }
        return answer;
    }
}