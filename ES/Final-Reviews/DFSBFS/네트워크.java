import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[202];
        Queue<Integer> q = new LinkedList<>();
        
        for(int i=0;i<n;i++) {
            if(visited[i]==true) continue;
            
            visited[i] = true;
            q.add(i);
            answer++;
            
            while(!q.isEmpty()) {
                int cur = q.poll();
                for(int j=0;j<n;j++) {
                    if(computers[cur][j]==0) continue;
                    if(visited[j]==true) continue;
                    visited[j] = true;
                    q.add(j);
                }
            }
        }
        
        return answer;
    }
}