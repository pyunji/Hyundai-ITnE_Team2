import java.util.*;
class Solution {
    boolean[] chk;
    int[] distance;
    int LEN;
    int maxCount = 0;
    // public void dfs(int start, int end, int[][] edge, int count, String path) {
    public void dfs(int start, int end, int[][] edge, int count) {
        if(distance[end] != 0) {
            if(count >= distance[end]) return;
        }
        if(start == end) {
            if(distance[end] == 0) {
                distance[end] = count;
            } else {
                distance[end] = Math.min(distance[end], count);
            }
            // System.out.println(path);
        }
        for(int i = 0; i < LEN; i++) {
            if(!chk[i] && (edge[i][0] == start||edge[i][1] == start)) {
                chk[i] = true;
                if(edge[i][0] == start) {
                    // dfs(edge[i][1], end, edge, count + 1, path + " " + String.valueOf(edge[i][1]));                   
                    dfs(edge[i][1], end, edge, count + 1);                   
                    
                } else {
                    // dfs(edge[i][0], end, edge, count + 1, path + " " + String.valueOf(edge[i][0]));                   
                    dfs(edge[i][0], end, edge, count + 1);                   
                    
                }
                chk[i] = false;
            }
        }
    }
    public int solution(int n, int[][] edge) {
        int answer = 0;
        LEN = edge.length;
        chk = new boolean[LEN];
        distance = new int[n+1];
        for(int i = 2; i <= n; i++) {
            // dfs(1, i, edge, 0, "1");
            dfs(1, i, edge, 0);
        }
        
        // System.out.println(Arrays.toString(distance));
        for(int i = 0; i < distance.length; i++) {
            maxCount = Math.max(distance[i], maxCount);
        }
        for(int i = 0; i < distance.length; i++) {
            if(distance[i] == maxCount) answer++;
        }
        return answer;
    }
}