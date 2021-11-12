/*
 * using BFS
 */

import java.util.*;

class Solution {
    boolean[][] chk;
    Queue<Integer> q = new LinkedList<>();
    
    public void bfs(int a, int b, int[][] computers){
        chk[a][b] = true;
        q.add(b);
        while(!q.isEmpty()) {
            int target = q.poll();
            for(int i = 0; i < computers.length; i++) {
                if(!chk[target][i] && computers[target][i] == 1) {
                    chk[target][i] = true;
                    q.add(i);
                }
            }
        }
    }
    
    public int solution(int n, int[][] computers) {
        chk = new boolean[n][n];
     
        int answer = 0;
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if (!chk[i][j] && computers[i][j] == 1) {
                    bfs(i, j, computers);
                    answer++;
                }
            }
        }
        
        return answer;
    }
}